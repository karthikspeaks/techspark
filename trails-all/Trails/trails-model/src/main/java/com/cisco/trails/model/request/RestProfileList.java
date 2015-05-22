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
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "restProfiles"
})
public class RestProfileList {

    @XmlElement(name = "profile", required = true)
    private List<RestProfile> restProfiles = new ArrayList<RestProfile>();

    public List<RestProfile> getRestProfiles() {
        return restProfiles;
    }

    public void setRestProfiles(List<RestProfile> restProfiles) {
        this.restProfiles = restProfiles;
    }

    @Override
    public String toString() {
        return "RestProfileList{" +
                "restProfiles=" + restProfiles +
                '}';
    }
}
