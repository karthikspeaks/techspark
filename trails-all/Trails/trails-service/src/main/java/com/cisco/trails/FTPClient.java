package com.cisco.trails;

import com.cisco.trails.context.ProfileContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import javax.mail.MessagingException;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class FTPClient {

    public static void main(String[] args) throws MessagingException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProfileContext profileContext = new ProfileContext();
        profileContext.setInvocationId("FTP Karthik");
        Message<ProfileContext> profileContextMessage = MessageBuilder.withPayload(profileContext).build();

        File fileToSend = new File("E:\\trails-home\\working-dir\\vam\\52bdf1a5-45b1-4d88-a260-3a0d76c92aac\\vam.configurationFile", "vam.properties");
        MessageChannel channel = (MessageChannel) applicationContext.getBean("ftpChannel");

        Message<File> message = MessageBuilder.withPayload(fileToSend).build();
        channel.send(message);
    }
}
