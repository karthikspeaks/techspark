package com.cisco.trails.model.request;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id", "type", "description", "restInputParams"
})
public class RestTask {

    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlAttribute(name = "type", required = true)
    private String type;

    @XmlElement(name = "description", required = true)
    private String description;

    @XmlElement(name = "taskInputParams", required = false)
    private RestInputParams restInputParams = new RestInputParams();


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

    public RestInputParams getRestInputParams() {
        return restInputParams;
    }

    public void setRestInputParams(RestInputParams restInputParams) {
        this.restInputParams = restInputParams;
    }

    @Override
    public String toString() {
        return "RestTask{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", restInputParams=" + restInputParams +
                '}';
    }
}
