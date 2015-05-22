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
 * Date: 1/14/14
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "componentsList"}
)
public class Components {

    @XmlElement(name = "component", required = false)
    private List<Component> componentsList = new ArrayList<Component>();

    public List<Component> getComponentsList() {
        return componentsList;
    }

    public void setComponentsList(List<Component> componentsList) {
        this.componentsList = componentsList;
    }
}
