package com.cisco.trails.engine.transport;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.integration.Message;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MailTransport implements ITransport {

    @Autowired
    ApplicationContext webApplicationContext;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public Message send(Message<?> inMessage) throws MessagingException {

        System.out.println("Invoked mail transport handler");

        String zipFileName = (String) inMessage.getHeaders().get("archive");
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        ProfileContext profileContext = (ProfileContext) inMessage.getPayload();

        Component component = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getComponent(profileContext.getComponentName());

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

        message.setFrom("Trails@cisco.com");
        message.setReplyTo("trails-admin@cisco.com");
        message.setTo(component.getEmail());
        message.setSubject("Component Profile : " + profileContext.getProfileKey() + " , Execution Hint : " + profileContext.getHint());
        message.setSentDate(new Date());
        String text = profileContext.getDescription();
        if (null == text) {
            text = "The Artifacts are attached for analysis.";
        }

        message.setText(text);

        System.out.println("Attaching file ->" + zipFileName);
        FileSystemResource file = new FileSystemResource(zipFileName);
        message.addAttachment(file.getFilename(), file);

        System.out.println("Prepared mail and ready to send");

        mailSender.send(mimeMessage);

        System.out.println("Mail Sent");
        return inMessage;
    }

}
