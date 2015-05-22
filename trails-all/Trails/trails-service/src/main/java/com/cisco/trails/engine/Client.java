package com.cisco.trails.engine;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.Profile;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String[] args) {

        Component component = new Component();
        component.setComponentName("VCM");
        component.setComponentBaseDir("E:/Sample/vcm/");
        component.setEmail("vcmsupport@cisco.com");

        Profile p = new Profile();
        p.setDescription("Export property Files");
        p.setEnabled(true);
        p.setId("PropertyFilesOnly");
        p.setTransport("file");

        component.getProfiles().addProfile(p);


        CacheManager.getInstance().addComponent(component);


//        IProfileExecutor profileExecutor = new ProfileExecutor();
//
//        ProfileContext context = new ProfileContext();
//        context.setInvocationId("ABC12345");
//
//        profileExecutor.executeProfile(context);


    }
}
