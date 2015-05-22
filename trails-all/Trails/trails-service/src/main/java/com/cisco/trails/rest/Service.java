package com.cisco.trails.rest;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/2/14
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Service {

    public String[] getComponents(String filter);

    public String[] getProfiles(String strComponentId);

    public String[] getProfile(String strComponentId);

    public String submitRequest(String strComponentId, String strProfileId, Map<String, String> params);

}
