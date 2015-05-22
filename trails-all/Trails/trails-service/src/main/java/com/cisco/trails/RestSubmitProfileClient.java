package com.cisco.trails;

import com.cisco.trails.model.request.ExecuteProfileRequest;
import com.cisco.trails.model.request.Trails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestSubmitProfileClient {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageChannel channel = (MessageChannel) applicationContext.getBean("serviceRequestInChannel");
        Trails trailsRequest = new Trails();
        ExecuteProfileRequest executeProfileRequest = new ExecuteProfileRequest();
        executeProfileRequest.setComponentName("VCM");
        executeProfileRequest.setProfile("SomeFiles");
        trailsRequest.setExecuteProfileRequest(executeProfileRequest);
        channel.send(new GenericMessage<Trails>(trailsRequest));


    }
}
