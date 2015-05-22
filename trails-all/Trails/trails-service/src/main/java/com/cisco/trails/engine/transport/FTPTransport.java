package com.cisco.trails.engine.transport;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPTransport implements ITransport {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    ApplicationContext webApplicationContext;

    @Override
    public Message send(Message<?> inMessage) throws MessagingException {

        System.out.println("Invoked FTP transport handler");

        String zipFileName = (String) inMessage.getHeaders().get("archive");

        ProfileContext profileContext = (ProfileContext) inMessage.getPayload();

        CacheManager cacheManager = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class);
        Component component = cacheManager.getComponent(profileContext.getComponentName());


        System.out.println("FTPing file... ->" + zipFileName);
        File fileToSend = new File(zipFileName);

        Message<File> messageFile = MessageBuilder.withPayload(fileToSend).build();

        System.out.println("FTP initiated");


        //Notification Mail

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

        message.setFrom("Trails@cisco.com");
        message.setReplyTo("trails-admin@cisco.com");
        message.setTo(component.getEmail());
        message.setSubject("Component Profile : " + profileContext.getProfileKey() + " , Execution Hint : " + profileContext.getHint());
        message.setSentDate(new Date());
        String descText = profileContext.getDescription();

        String ftpHost = cacheManager.getConfigProperty(CacheConstants.FTP_HOST);
        String ftpUser = cacheManager.getConfigProperty(CacheConstants.FTP_USER);
        String ftpFolder = cacheManager.getConfigProperty(CacheConstants.FTP_FOLDER);

        String url = "ftp://" + ftpUser + "@" + ftpHost + "/" + ftpFolder + "/" + fileToSend.getName();

        String urlText = "The Artifacts are available for analysis @ URL " + url;

        String mailText = "";

        if (null != descText) {
            mailText = descText;
        }
        mailText += "\n\n" + urlText;

        message.setText(mailText);

        mailSender.send(mimeMessage);

        System.out.println("Notification Sent");


        return messageFile;
    }

}
