package com.cisco.trails.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "componentName", "supportMail", "restProfileList"
})
public class RestComponent {

    @XmlElement(name = "componentName", required = true)
    private String componentName;

    @XmlElement(name = "supportMail", required = true)
    private String supportMail;

    @XmlElement(name = "profileList", required = true)
    private RestProfileList restProfileList = new RestProfileList();

    public String getSupportMail() {
        return supportMail;
    }

    public void setSupportMail(String supportMail) {
        this.supportMail = supportMail;
    }

    public RestProfileList getRestProfileList() {
        return restProfileList;
    }

    public void setRestProfileList(RestProfileList restProfileList) {
        this.restProfileList = restProfileList;
    }

    @Override
    public String toString() {
        return "RestComponent{" +
                "supportMail='" + supportMail + '\'' +
                ", restProfileList=" + restProfileList +
                '}';
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}
