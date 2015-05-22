package com.cisco.trails.rest;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.idgen.UUIDGenerator;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.request.Components;
import com.cisco.trails.model.request.ExecuteProfileResponse;
import com.cisco.trails.model.request.RestComponent;
import com.cisco.trails.model.request.Trails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/11/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TrailsRestService {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private WorkflowChannelGateway gateway;

    @Secured("ROLE_TRAILS_USER")
    @RequestMapping(value = "/trails-rest/components/{componentName}", method = RequestMethod.GET)
    public Trails listComponent(@PathVariable String componentName) {

        System.out.println("In service method listComponent with " + componentName);

        //validator.validate(trailsRequest);

        CacheManager c = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class);
        Component component = c.getComponent(componentName);

        Trails response = new Trails();
        RestComponent restComponent = RestServiceHelper.getRestComponent(component);
        Components components = new Components();
        components.getComponentsList().add(restComponent);
        response.setComponents(components);

        System.out.println("Executed service method listComponent");

        return response;
    }

    @Secured("ROLE_TRAILS_USER")
    @RequestMapping(value = "/trails-rest/components", method = RequestMethod.GET)
    public Trails listComponents() {

        System.out.println("In service method listComponents");

        //validator.validate(trailsRequest);

        CacheManager c = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class);

        Trails response = new Trails();
        Components components = new Components();
        for (Component component : c.getComponents()) {
            RestComponent restComponent = RestServiceHelper.getRestComponent(component);
            components.getComponentsList().add(restComponent);

        }
        response.setComponents(components);
        System.out.println("Executed service method listComponents");

        return response;
    }

    @Secured("ROLE_TRAILS_USER")
    @RequestMapping(value = "/trails-rest/submit/workflow/execute-profile", method = RequestMethod.POST)
    public Trails executeProfile(@RequestBody Trails trailsRequest) {

        System.out.println("In service method executeProfile");

        //validator.validate(trailsRequest);

        String invocationId = UUIDGenerator.getUuid();

        gateway.submitExecuteProfile(trailsRequest, invocationId);

        Trails response = new Trails();
        ExecuteProfileResponse executeProfileResponse = new ExecuteProfileResponse();
        executeProfileResponse.setInvocationId(invocationId);
        response.setExecuteProfileResponse(executeProfileResponse);


        System.out.println("Executed service method executeProfile");

        return response;
    }

}