package com.cisco.trails.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/20/14
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "type",
        "description",
        "taskParams"
}
)
public class TaskDef {

    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlAttribute(name = "type", required = true)
    private String type;

    @XmlElement(name = "description", required = false)
    private String description;

    @XmlElement(name = "param", required = false)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
