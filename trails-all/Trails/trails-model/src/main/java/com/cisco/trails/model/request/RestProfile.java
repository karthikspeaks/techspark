package com.cisco.trails.model.request;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id", "description", "transport", "restTaskList"
})
public class RestProfile {

    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlElement(name = "description", required = true)
    private String description;

    @XmlElement(name = "transport", required = true)
    private String transport;

    @XmlElement(name = "taskList", required = true)
    private RestTaskList restTaskList = new RestTaskList();

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

    public RestTaskList getRestTaskList() {
        return restTaskList;
    }

    public void setRestTaskList(RestTaskList restTaskList) {
        this.restTaskList = restTaskList;
    }

    @Override
    public String toString() {
        return "RestProfile{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", transport='" + transport + '\'' +
                ", restTaskList=" + restTaskList +
                '}';
    }
}
