package com.cisco.trails.model;

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
        "components"
}
)
@XmlRootElement(name = "trailsDefinition")
public class TrailsDefinition {

    @XmlElement(name = "components", required = true)
    private Components components;

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}


