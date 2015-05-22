package com.cisco.trails.model;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "value",
        "required",
        "taskId"
}
)
public class TaskParam {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlAttribute(name = "value", required = true)
    private String value;

    @XmlElement(name = "required", required = false)
    private boolean required = true;

    @XmlElement(name = "taskId", required = false)
    private String taskId;


    public TaskParam(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    public TaskParam() {
    }

    public TaskParam(String name, String value, String taskId) {
        this.name = name;
        this.taskId = taskId;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
