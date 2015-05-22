package com.cisco.trails.rest;

import com.cisco.trails.model.Component;
import com.cisco.trails.model.Profile;
import com.cisco.trails.model.Task;
import com.cisco.trails.model.TaskParam;
import com.cisco.trails.model.request.*;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/13/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestServiceHelper {

    public static RestComponent getRestComponent(Component component) {

        RestComponent restComponent = new RestComponent();

        restComponent.setComponentName(component.getComponentName());
        restComponent.setSupportMail(component.getEmail());

        RestProfileList restProfileList = restComponent.getRestProfileList();
        for (Profile profile : component.getProfiles().getProfiles()) {
            restProfileList.getRestProfiles().add(getRestProfile(profile));
        }

        return restComponent;
    }

    public static RestProfile getRestProfile(Profile profile) {

        RestProfile restProfile = new RestProfile();

        restProfile.setId(profile.getId());
        restProfile.setDescription(profile.getDescription());
        restProfile.setTransport(profile.getTransport());

        RestTaskList restTaskList = restProfile.getRestTaskList();
        for (Task task : profile.getTasks()) {
            restTaskList.getRestTaskList().add(getRestTask(task));
        }

        return restProfile;
    }

    public static RestTask getRestTask(Task task) {

        RestTask restTask = new RestTask();

        restTask.setDescription(task.getDescription());
        restTask.setId(task.getId());
        restTask.setType(task.getType());

        RestInputParams restInputParams = restTask.getRestInputParams();

        for (TaskParam taskParam : task.getTaskParams()) {


            restInputParams.addTaskParam(getTaskParam(taskParam));
        }

        return restTask;

    }

    public static RestTaskParam getTaskParam(TaskParam taskParam) {

        RestTaskParam restTaskParam = new RestTaskParam();

        restTaskParam.setName(taskParam.getName());
        restTaskParam.setRequired(taskParam.isRequired());
        restTaskParam.setTaskId(taskParam.getTaskId());
        restTaskParam.setValue(taskParam.getValue());

        return restTaskParam;
    }
}