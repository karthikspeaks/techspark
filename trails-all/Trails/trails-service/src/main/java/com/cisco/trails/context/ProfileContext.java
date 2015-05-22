package com.cisco.trails.context;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileContext {

    private String componentName;

    private String invocationId;

    private String profileKey;

    private String hint;

    private String description;

    private String safeWord;

    private Collection<TaskContext> taskContexts = new ArrayList<TaskContext>();

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

    public void addTaskContext(TaskContext taskContext) {
        taskContexts.add(taskContext);
    }

    public Collection<TaskContext> getTaskContexts() {
        return taskContexts;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
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
