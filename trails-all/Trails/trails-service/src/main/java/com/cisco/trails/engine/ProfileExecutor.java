package com.cisco.trails.engine;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.context.TaskContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.Profile;
import com.cisco.trails.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileExecutor implements IProfileExecutor {

    @Autowired
    ApplicationContext webApplicationContext;

    @Override
    public ProfileContext executeProfile(ProfileContext profileContext) {

        System.out.println("Inside ProfileExecutor");

        System.out.println("Invocation Id ->" + profileContext.getInvocationId());
        System.out.println("Profile Key ->" + profileContext.getProfileKey());

        System.out.println("Loading profile..." + profileContext.getProfileKey());

        Component component = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getComponent(profileContext.getComponentName());
        Profile profile = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getProfile(profileContext.getProfileKey());

        for (Task task : profile.getTasks()) {

            String taskKey = profileContext.getComponentName() + "." + task.getId();
            TaskContext taskContext = new TaskContext();

            taskContext.setInvocationId(profileContext.getInvocationId());
            taskContext.setProfileKey(profileContext.getProfileKey());
            taskContext.setTaskKey(taskKey);
            taskContext.setTaskType(task.getType());
            taskContext.setComponentName(profileContext.getComponentName());

            profileContext.addTaskContext(taskContext);
        }

        String workingDir = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME) + File.separator + webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);


        System.out.println("Pfe - >" + workingDir);
        System.out.println("Creating the directory for the transaction...with invocation id->" + profileContext.getInvocationId());

        File targetDir = new File(workingDir + File.separator + component.getComponentName() + File.separator + profileContext.getInvocationId());

        targetDir.mkdir();
        System.out.println("Done with the folder  ->" + targetDir.getAbsolutePath());

        return profileContext;
    }
}
