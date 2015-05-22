package com.cisco.trails.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "componentName", "profile", "hint", "description", "safeWord", "restInputParams"
})
public class ExecuteProfileRequest {

    @XmlElement(name = "componentName", required = true)
    private String componentName;

    @XmlElement(name = "profile", required = true)
    private String profile;

    @XmlElement(name = "hint", required = true)
    private String hint;

    @XmlElement(name = "description", required = false)
    private String description;

    @XmlElement(name = "safeWord", required = true)
    private String safeWord;

    @XmlElement(name = "taskInputParams", required = false)
    private RestInputParams restInputParams;

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public RestInputParams getRestInputParams() {
        return restInputParams;
    }

    public void setRestInputParams(RestInputParams restInputParams) {
        this.restInputParams = restInputParams;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSafeWord() {
        return safeWord;
    }

    public void setSafeWord(String safeWord) {
        this.safeWord = safeWord;
    }
}
