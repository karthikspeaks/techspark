package com.cisco.trails.engine.taskhandlers;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.TaskContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/3/14
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnvTaskHandler implements ITaskHandler {

    @Autowired
    ApplicationContext webApplicationContext;

    @Override
    public TaskContext execute(Message<?> inMessage) {

        System.out.println("Inside the Environment task handler");

        TaskContext taskContext = (TaskContext) inMessage.getPayload();
        String strInvocationId = taskContext.getInvocationId();
        String taskKey = taskContext.getTaskKey();

        Component component = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getComponent(taskContext.getComponentName());
        Task task = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getTask(taskContext.getTaskKey());

        String strComponentName = component.getComponentName();

        String strWorkingDir = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME) + File.separator + webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);
        StringBuilder strDestEnvTaskDir = new StringBuilder();
        strDestEnvTaskDir.append(strWorkingDir).append(File.separator).append(strComponentName).append(File.separator)
                .append(strInvocationId).append(File.separator).append(taskKey);

        //Dest Path and File Handle

        //Need to create the Dest Directory First
        File destEnvTaskDirFirst = new File(strDestEnvTaskDir.toString());
        destEnvTaskDirFirst.mkdirs();

        //Handle for the Dest file from the newly created dir
        File destEnvTaskDir = new File(destEnvTaskDirFirst.getAbsolutePath() + File.separator + "EnvReport.txt");


        String[] installedOrgSoftware = {
                "/bin/sh",
                "-c",
                "rpm -qa | grep nds "
        };

        String s;
        Process p;
        boolean linux = false;
        try {

            FileWriter fw = null;
            BufferedWriter bw = null;
            BufferedReader br = null;
            try {
                fw = new FileWriter(destEnvTaskDir.getAbsoluteFile());
                bw = new BufferedWriter(fw);


                bw.write("******************START OF REPORT********************************\n");

                bw.write("\nThe environment variables are as below...\n");
                Map<String, String> env = System.getenv();
                for (String key : env.keySet()) {
                    bw.write("\n");
                    bw.write(key + "=" + env.get(key));

                }


                bw.write("\n\nThe System variables are as below...\n\n");

                Properties sys = System.getProperties();
                for (String key : sys.stringPropertyNames()) {
                    bw.write("\n");
                    bw.write(key + "=" + sys.get(key));

                }

                String osName = sys.getProperty("os.name");
                if (osName.equalsIgnoreCase("linux")) {
                    linux = true;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            if (linux) {
                bw.write("\n\nThe following software version were detected...\n\n");

                p = Runtime.getRuntime().exec(installedOrgSoftware);
                br = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));
                while ((s = br.readLine()) != null) {
                    bw.write("\n");
                    bw.write(s);

                }
                p.waitFor();


                p.destroy();

            }

            bw.write("\n\n******************END OF REPORT********************************\n\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        taskContext.setTaskOutputFile(destEnvTaskDir.getAbsolutePath());
        System.out.println("Done Env Task");

        return taskContext;
    }
}
