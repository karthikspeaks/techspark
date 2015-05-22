package com.cisco.trails;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.engine.util.TaskConstants;
import com.cisco.trails.model.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/23/14
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CacheManager cm = (CacheManager) applicationContext.getBean("cacheMgr", CacheManager.class);

        //cm.addComponents(trailsDefinition.getComponents());

        Task t = cm.getTask("merchandiser.configurationFile");

        int y = 10;
        System.out.println(t.getTaskParam(TaskConstants.PROPERTY_FILE_PATH).getValue());
        System.out.println(t.getTaskParam(TaskConstants.PROPERTY_FILE_NAME).getValue());


        String homeDir = applicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME);

        String workingDir = applicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);

        System.out.println(homeDir);
        System.out.println(workingDir);


        System.out.println(System.getProperties());

    }
}
