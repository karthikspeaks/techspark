package com.cisco.trails;

import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.engine.transport.MailTransport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import javax.mail.MessagingException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class MailClient {

    public static void main(String[] args) throws MessagingException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MailTransport transport = (MailTransport) applicationContext.getBean("mailTransport");
        ProfileContext profileContext = new ProfileContext();
        profileContext.setInvocationId("Hhah");
        Message<ProfileContext> profileContextMessage = MessageBuilder.withPayload(profileContext).build();

        transport.send(profileContextMessage);


        MessageChannel channel = (MessageChannel) applicationContext.getBean("ftpChannel");
        channel.send(profileContextMessage);
    }
}
