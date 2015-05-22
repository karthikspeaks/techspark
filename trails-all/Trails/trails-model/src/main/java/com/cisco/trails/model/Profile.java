package com.cisco.trails.model;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/3/14
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "description",
        "transport",
        "enabled",
        "taskRef"
}
)
public class Profile {

    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlElement(name = "description", required = true)
    private String description;

    @XmlElement(name = "transport", required = true)
    private String transport;

    @XmlElement(name = "enabled", required = true)
    private boolean enabled = true;

    @XmlElement(name = "task", required = true)
    private List<TaskRef> taskRef = new ArrayList<TaskRef>();

    @XmlTransient
    private Map<String, Task> tasks = new HashMap<String, Task>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public Collection<Task> getTasks() {
        return tasks.values();
    }

    public Task getTaskById(String id) {
        return tasks.get(id);
    }

    public List<TaskRef> getTaskRef() {
        return taskRef;
    }

    public void setTaskRef(List<TaskRef> taskRef) {
        this.taskRef = taskRef;
    }
}
