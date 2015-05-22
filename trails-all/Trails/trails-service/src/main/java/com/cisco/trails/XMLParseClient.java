package com.cisco.trails;

import com.cisco.trails.model.request.ExecuteProfileRequest;
import com.cisco.trails.model.request.Trails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;

import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLParseClient {

    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-http-rest-copy.xml");

        Trails trailsRequest = new Trails();
        ExecuteProfileRequest executeProfileRequest = new ExecuteProfileRequest();
        executeProfileRequest.setComponentName("VCM");
        executeProfileRequest.setProfile("SomeFiles");


        trailsRequest.setExecuteProfileRequest(executeProfileRequest);

        Marshaller marshaller = applicationContext.getBean("marshaller", Marshaller.class);
        marshaller.marshal(trailsRequest, new StreamResult(new FileOutputStream("request.xml")));


    }
}
