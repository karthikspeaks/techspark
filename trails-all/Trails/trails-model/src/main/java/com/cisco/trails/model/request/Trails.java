package com.cisco.trails.model.request;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/8/14
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "components",
        "executeProfileRequest",
        "executeProfileResponse",
        "errors"
}
)
@XmlRootElement(name = "trails")
public class Trails {

    @XmlElement(name = "components", required = false)
    private Components components;

    @XmlElement(name = "executeProfileRequest", required = false)
    private ExecuteProfileRequest executeProfileRequest;

    @XmlElement(name = "executeProfileResponse", required = false)
    private ExecuteProfileResponse executeProfileResponse;

    @XmlElement(name = "errors", required = false)
    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public ExecuteProfileRequest getExecuteProfileRequest() {
        return executeProfileRequest;
    }

    public void setExecuteProfileRequest(ExecuteProfileRequest executeProfileRequest) {
        this.executeProfileRequest = executeProfileRequest;
    }

    public ExecuteProfileResponse getExecuteProfileResponse() {
        return executeProfileResponse;
    }

    public void setExecuteProfileResponse(ExecuteProfileResponse executeProfileResponse) {
        this.executeProfileResponse = executeProfileResponse;
    }
}
