package com.cisco.trails;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.model.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/14/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestHelperClient {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CacheManager c = applicationContext.getBean("cacheMgr", CacheManager.class);

        Component component = c.getComponent("VAM");

        // RestComponent restComponent = RestServiceHelper.getRestComponent(component);

        //System.out.println(restComponent);


    }
}
