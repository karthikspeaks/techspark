package com.cisco.trails.engine;

import com.cisco.trails.context.ProfileContext;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IProfileExecutor {

    public ProfileContext executeProfile(ProfileContext profileContext);
}
