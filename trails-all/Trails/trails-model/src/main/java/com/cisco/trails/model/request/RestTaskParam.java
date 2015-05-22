package com.cisco.trails.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name", "required", "value", "taskId"
})
public class RestTaskParam {

    @XmlElement(name = "name", required = true)
    private String name;

    @XmlElement(name = "required", required = false)
    private boolean required = true;

    @XmlElement(name = "taskId", required = false)
    private String taskId;

    @XmlElement(name = "value", required = false)
    private String value;

    public RestTaskParam(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    public RestTaskParam() {
    }

    public RestTaskParam(String name, String taskId, String value) {
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

    @Override
    public String toString() {
        return "RestTaskParam{" +
                "name='" + name + '\'' +
                ", required=" + required +
                ", taskId='" + taskId + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
