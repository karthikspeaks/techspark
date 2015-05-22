package com.cisco.trails.context;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaskContext {

    private String componentName;

    private String invocationId;

    private String profileKey;

    private String taskKey;

    private String taskType;

    private String taskOutputFile;

    private String hint;

    private String description;

    private String safeWord;

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(String invocationId) {
        this.invocationId = invocationId;
    }

    public String getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(String profileKey) {
        this.profileKey = profileKey;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getTaskOutputFile() {
        return taskOutputFile;
    }

    public void setTaskOutputFile(String taskOutputFile) {
        this.taskOutputFile = taskOutputFile;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSafeWord() {
        return safeWord;
    }

    public void setSafeWord(String safeWord) {
        this.safeWord = safeWord;
    }
}
