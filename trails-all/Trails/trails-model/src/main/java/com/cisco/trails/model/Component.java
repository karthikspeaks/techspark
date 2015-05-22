package com.cisco.trails.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/3/14
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "componentName",
        "componentBaseDir",
        "email",
        "profiles",
        "taskDefs"
}
)
public class Component {

    @XmlElement(name = "componentName", required = true)
    private String componentName;

    @XmlElement(name = "baseDirectory", required = true)
    private String componentBaseDir;

    @XmlElement(name = "email", required = true)
    private String email;

    @XmlElement(name = "profiles", required = true)
    private Profiles profiles = new Profiles();

    @XmlElement(name = "taskDef", required = false)
    private List<TaskDef> taskDefs = new ArrayList<TaskDef>();

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentBaseDir() {
        return componentBaseDir;
    }

    public void setComponentBaseDir(String componentBaseDir) {
        this.componentBaseDir = componentBaseDir;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
    }

    public List<TaskDef> getTaskDefs() {
        return taskDefs;
    }

    public void setTaskDefs(List<TaskDef> taskDefs) {
        this.taskDefs = taskDefs;
    }
}
