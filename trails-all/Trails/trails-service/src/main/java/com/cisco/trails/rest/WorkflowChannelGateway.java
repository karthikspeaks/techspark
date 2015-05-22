package com.cisco.trails.rest;

import com.cisco.trails.model.request.Trails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/15/14
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkflowChannelGateway {

    @Autowired
    ApplicationContext webApplicationContext;

    public void submitExecuteProfile(Trails trails, String invocationId) {

        MessageChannel messageChannel = (MessageChannel) webApplicationContext.getBean("serviceRequestInChannel");

        Message<Trails> trailsMessage = MessageBuilder.withPayload(trails).setHeader("invocationId", invocationId).build();
        System.out.println("Request is being Sent");

        messageChannel.send(trailsMessage);

        System.out.println("Request is Sent");
    }

}
