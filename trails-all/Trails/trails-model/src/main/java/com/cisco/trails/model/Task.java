package com.cisco.trails.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/3/14
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    private String id;
    private String type;
    private String description;

    private List<TaskParam> taskParams = new ArrayList<TaskParam>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskParam> getTaskParams() {
        return taskParams;
    }

    public void setTaskParams(List<TaskParam> taskParams) {
        this.taskParams = taskParams;
    }

    public TaskParam getTaskParam(String taskParamKey) {

        for (TaskParam localTaskParam : getTaskParams()) {

            if (taskParamKey.equalsIgnoreCase(localTaskParam.getName())) {
                return localTaskParam;
            }
        }
        return null;
    }

    public void addTaskParam(TaskParam taskParam) {
        taskParams.add(taskParam);
    }
}