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
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "taskParams"
})
public class RestInputParams {
    public RestInputParams() {
    }

    @XmlElement(name = "taskParams", required = true)
    private List<RestTaskParam> taskParams = new ArrayList<RestTaskParam>();


    public void addTaskParam(RestTaskParam restTaskParam) {
        taskParams.add(restTaskParam);
    }

    public List<RestTaskParam> getTaskParams() {
        return taskParams;
    }

    public void setTaskParams(List<RestTaskParam> taskParams) {
        this.taskParams = taskParams;
    }

    @Override
    public String toString() {
        return "RestInputParams{" +
                "taskParams=" + taskParams +
                '}';
    }
}
