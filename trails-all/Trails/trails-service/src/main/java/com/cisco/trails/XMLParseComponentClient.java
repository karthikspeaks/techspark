package com.cisco.trails;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.model.TrailsDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLParseComponentClient {

    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        FileInputStream is = new FileInputStream("e:/c.xml");
        Unmarshaller marshaller = applicationContext.getBean("componentMarshaller", Unmarshaller.class);
        TrailsDefinition trailsDefinition = (TrailsDefinition) marshaller.unmarshal(new StreamSource(is));

        int x = 3;
        System.out.println(trailsDefinition.getComponents());

        CacheManager cm = (CacheManager) applicationContext.getBean("cacheMgr", CacheManager.class);

        //cm.addComponents(trailsDefinition.getComponents());


        int y = 10;

        FileOutputStream fs = new FileOutputStream("e:/out.xml");
        Marshaller marshaller2 = applicationContext.getBean("componentMarshaller", Marshaller.class);
        marshaller2.marshal(trailsDefinition, new StreamResult(fs));

        System.out.println(cm.getConfigProperty("trails.working.dir"));

        int z = 3;
    }
}
