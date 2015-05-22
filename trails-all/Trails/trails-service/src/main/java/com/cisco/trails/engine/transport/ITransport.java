package com.cisco.trails.engine.transport;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Gateway;

import javax.mail.MessagingException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ITransport {

    @Gateway
    public Message send(Message<?> inMessage) throws MessagingException;

}
