package com.cisco.trails.engine.aggregator;

import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.context.TaskContext;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/9/14
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileTaskAggregator {

    public ProfileContext aggregate(Collection<TaskContext> taskContexts) {

        ProfileContext profileContext = new ProfileContext();
        TaskContext taskContext;
        if (null != taskContexts && !taskContexts.isEmpty()) {
            taskContext = taskContexts.iterator().next();
            profileContext.setComponentName(taskContext.getComponentName());
            profileContext.setProfileKey(taskContext.getProfileKey());
            profileContext.setInvocationId(taskContext.getInvocationId());

            profileContext.setDescription(taskContext.getDescription());
            profileContext.setHint(taskContext.getHint());
            profileContext.setSafeWord(taskContext.getSafeWord());
        }

        profileContext.getTaskContexts().addAll(taskContexts);
        return profileContext;
    }

}
