package com.cisco.trails.engine;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.context.TaskContext;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Profile;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/9/14
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArtifactZipper {

    @Autowired
    ApplicationContext webApplicationContext;

    public Message<ProfileContext> createArchive(Message<?> message) throws IOException {

        System.out.println("I am done now.");

        System.out.println("Headers ->" + message.getHeaders());

        ProfileContext profileContext = (ProfileContext) message.getPayload();
        System.out.println(profileContext.getProfileKey());
        System.out.println(profileContext.getInvocationId());
        System.out.println(profileContext.getTaskContexts().size());

        Profile profile = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getProfile(profileContext.getProfileKey());

        System.out.println("Zipping file...");
        String zipFileName = "";
        try {

            String strWorkingDir = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.TRAILS_HOME) + File.separator + webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class).getConfigProperty(CacheConstants.WORKING_DIR);

            System.out.println("az - >" + strWorkingDir);

            StringBuilder strDestZipDir = new StringBuilder();
            strDestZipDir.append(strWorkingDir).append(File.separator).append(profileContext.getComponentName()).
                    append(File.separator).append(profileContext.getInvocationId()).append(".zip");

            // Initiate ZipFile object with the path/name of the zip file.
            ZipFile zipFile = new ZipFile(strDestZipDir.toString());

            // Build the list of files to be added in the array list
            // Objects of type File have to be added to the ArrayList
            ArrayList filesToAdd = new ArrayList();
            for (TaskContext taskContext : profileContext.getTaskContexts()) {
                filesToAdd.add(new File(taskContext.getTaskOutputFile()));
            }

            // Initiate Zip Parameters which define various properties such
            // as compression method, etc.
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to store compression

            // Set the compression level
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            // Set the encryption flag to true
            // If this is set to false, then the rest of encryption properties are ignored
            parameters.setEncryptFiles(true);

            // Set the encryption method to Standard Zip Encryption
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);

            String password = profileContext.getSafeWord();
            if (null == password) {
                password = "vision123!";
            }
            // Set password
            parameters.setPassword(password);

            // Now add files to the zip file
            // Note: To add a single file, the method addFile can be used
            // Note: If the zip file already exists and if this zip file is a split file
            // then this method throws an exception as Zip Format Specification does not
            // allow updating split zip files
            zipFile.addFiles(filesToAdd, parameters);

            zipFileName = strDestZipDir.toString();
            System.out.println("zip->" + zipFileName);

        } catch (ZipException e) {
            e.printStackTrace();
        }
        //Send this to correct Transport gateway
        System.out.println("Zipper setting transport to ->" + profile.getTransport());
        Message<ProfileContext> profileContextMessage = MessageBuilder.withPayload(profileContext).setHeader("transport", profile.getTransport()).setHeader("archive", zipFileName).build();


        return profileContextMessage;
    }
}
