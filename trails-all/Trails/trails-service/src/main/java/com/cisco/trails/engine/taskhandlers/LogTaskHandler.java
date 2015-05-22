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
public class LogTaskHandler implements ITaskHandler {

    @Autowired
    ApplicationContext webApplicationContext;

    @Override
    public TaskContext execute(Message<?> inMessage) {

        TaskContext taskContext = (TaskContext) inMessage.getPayload();
        System.out.println("Inside the Log task handler");

        Component component = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getComponent(taskContext.getComponentName());
        Task task = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getTask(taskContext.getTaskKey());

        String strComponentName = component.getComponentName();
        String strInvocationId = taskContext.getInvocationId();
        String taskKey = taskContext.getTaskKey();

        String logFilePath = task.getTaskParam(TaskConstants.LOG_FILE_PATH).getValue();
        String logFileName = task.getTaskParam(TaskConstants.LOG_FILE_NAME).getValue();

        String strWorkingDir = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME) + File.separator + webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);
        StringBuilder strDestLogTaskDir = new StringBuilder();
        strDestLogTaskDir.append(strWorkingDir).append(File.separator).append(strComponentName).append(File.separator)
                .append(strInvocationId).append(File.separator).append(taskKey);

        String strCompBaseDir = component.getComponentBaseDir();

        //Source Path and File Handle
        StringBuilder strSourceAbsLogPath = new StringBuilder();
        strSourceAbsLogPath.append(strCompBaseDir).append(File.separator).append(logFilePath).append(File.separator).append(logFileName);

        File sourceAbsLogDir = new File(strSourceAbsLogPath.toString());

        //Dest Path and File Handle

        //Need to create the Dest Directory First
        File destLogTaskDirFirst = new File(strDestLogTaskDir.toString());
        destLogTaskDirFirst.mkdirs();

        //Handle for the Dest file from the newly created dir
        File destLogTaskDir = new File(destLogTaskDirFirst.getAbsolutePath() + File.separator + logFileName);

        try {
            FileCopyUtils.copy(sourceAbsLogDir, destLogTaskDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        taskContext.setTaskOutputFile(destLogTaskDir.getAbsolutePath());
        System.out.println("Done Log Task");
        return taskContext;
    }
}
