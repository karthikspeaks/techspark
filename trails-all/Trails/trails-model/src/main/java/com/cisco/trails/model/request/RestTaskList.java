package com.cisco.trails.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "restTaskList"
})
public class RestTaskList {

    @XmlElement(name = "task", required = true)
    private List<RestTask> restTaskList = new ArrayList<RestTask>();

    public List<RestTask> getRestTaskList() {
        return restTaskList;
    }

    public void setRestTaskList(List<RestTask> restTaskList) {
        this.restTaskList = restTaskList;
    }

    @Override
    public String toString() {
        return "RestTaskList{" +
                "restTaskList=" + restTaskList +
                '}';
    }
}
