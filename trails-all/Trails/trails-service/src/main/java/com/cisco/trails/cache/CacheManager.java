package com.cisco.trails.cache;

import com.cisco.trails.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/6/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
final public class CacheManager {

    private static CacheManager cacheManager = new CacheManager();

    @Autowired
    @Qualifier("trailsProperties")
    private Properties generalConfig = new Properties();

    public Cache<String, Component> componentCache = new Cache<String, Component>();

    public Cache<String, Profile> profileCache = new Cache<String, Profile>();

    public Cache<String, Task> taskCache = new Cache<String, Task>();

    private CacheManager() {

    }

    public static CacheManager getInstance() {
        return cacheManager;
    }

    public void addComponents(Components components) {

        for (Component component : components.getComponentsList()) {
            addComponent(component);
        }

    }

    public void addConfigProperty(String propKey, String propValue) {

        generalConfig.put(propKey, propValue);
    }

    public boolean checkUniqueComponentId(String componentName) {

        return !(componentCache.getKeys().contains(componentName));
    }

    public void addComponent(Component component) {

        String componentName = component.getComponentName().toLowerCase();
        componentCache.add(componentName, component);

        for (Profile profile : component.getProfiles().getProfiles()) {

            String compProfileKey = (componentName + "." + profile.getId()).toLowerCase();

            profileCache.add(compProfileKey, profile);

            for (TaskRef taskRef : profile.getTaskRef()) {

                Task task = getTaskForTaskRef(taskRef, componentName);
                String compTaskKey = (componentName + "." + task.getId()).toLowerCase();

                taskCache.add(compTaskKey, task);

                profile.addTask(task);
            }

        }

    }

    private Task getTaskForTaskRef(TaskRef taskRef, String compName) {

        Task task = new Task();
        String refId = taskRef.getRef();

        task.setId(refId);

        Component component = componentCache.get(compName);

        for (TaskDef taskDef : component.getTaskDefs()) {

            if (taskDef.getId().equalsIgnoreCase(taskRef.getRef())) {

                task.setDescription(taskDef.getDescription());
                task.setType(taskDef.getType());

                task.setTaskParams(taskDef.getTaskParams());

                break;
            }
        }

        return task;
    }

    public Collection<Component> getComponents() {
        return componentCache.getValues();
    }

    public Component getComponent(String componentName) {
        return componentCache.get(componentName.toLowerCase());
    }

    public Profile getProfile(String profileKey) {
        return profileCache.get(profileKey.toLowerCase());
    }

    public Task getTask(String taskKey) {
        return taskCache.get(taskKey.toLowerCase());
    }

    public String getConfigProperty(String strPropKey) {
        return generalConfig.getProperty(strPropKey);
    }


    public static void main(String[] args) {


    }
}
