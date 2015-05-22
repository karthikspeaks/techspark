package com.cisco.trails.engine.taskhandlers;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.TaskContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.engine.util.TaskConstants;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/3/14
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyTaskHandler implements ITaskHandler {

    @Autowired
    ApplicationContext webApplicationContext;

    @Override
    public TaskContext execute(Message<?> inMessage) {

        TaskContext taskContext = (TaskContext) inMessage.getPayload();
        System.out.println("Inside the Property task handler");

        System.out.println("webApplicationContext->" + webApplicationContext);
        Component component = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getComponent(taskContext.getComponentName());
        Task task = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getTask(taskContext.getTaskKey());

        String strComponentName = component.getComponentName();
        String strInvocationId = taskContext.getInvocationId();
        String taskKey = taskContext.getTaskKey();

        System.out.println("strComponentName->" + strComponentName);
        System.out.println("strInvocationId->" + strInvocationId);
        System.out.println("taskKey->" + taskKey);

        String propFilePath = task.getTaskParam(TaskConstants.PROPERTY_FILE_PATH).getValue();
        String propFileName = task.getTaskParam(TaskConstants.PROPERTY_FILE_NAME).getValue();

        System.out.println("propFilePath->" + propFilePath);
        String strWorkingDir = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME) + File.separator + webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);

        System.out.println("Pth - >" + strWorkingDir);

        StringBuilder strDestPropertyTaskDir = new StringBuilder();
        strDestPropertyTaskDir.append(strWorkingDir).append(File.separator).append(strComponentName).append(File.separator)
                .append(strInvocationId).append(File.separator).append(taskKey);

        String strCompBaseDir = component.getComponentBaseDir();
        System.out.println("strCompBaseDir->" + strCompBaseDir);
        //Source Path and File Handle
        StringBuilder strSourceAbsPropertyPath = new StringBuilder();
        strSourceAbsPropertyPath.append(strCompBaseDir).append(File.separator).append(propFilePath).append(File.separator).append(propFileName);

        File sourceAbsPropertyDir = new File(strSourceAbsPropertyPath.toString());

        //Dest Path and File Handle

        //Need to create the Dest Directory First
        File destPropertyTaskDirFirst = new File(strDestPropertyTaskDir.toString());
        destPropertyTaskDirFirst.mkdirs();

        //Handle for the Dest file from the newly created dir
        File destPropertyTaskDir = new File(destPropertyTaskDirFirst.getAbsolutePath() + File.separator + propFileName);

        try {
            FileCopyUtils.copy(sourceAbsPropertyDir, destPropertyTaskDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        taskContext.setTaskOutputFile(destPropertyTaskDir.getAbsolutePath());
        System.out.println("Done Property Task");
        return taskContext;
    }
}