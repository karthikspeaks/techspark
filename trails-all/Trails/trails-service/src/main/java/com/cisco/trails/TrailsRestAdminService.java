package com.cisco.trails;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.engine.util.BeanConstants;
import com.cisco.trails.model.Component;
import com.cisco.trails.model.TrailsDefinition;
import com.cisco.trails.model.request.Components;
import com.cisco.trails.model.request.RestComponent;
import com.cisco.trails.model.request.Trails;
import com.cisco.trails.rest.RestServiceHelper;
import com.cisco.trails.rest.WorkflowChannelGateway;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/11/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
//@Controller
public class TrailsRestAdminService {

    //@Autowired
    WebApplicationContext webApplicationContext;

    //@Autowired
    private WorkflowChannelGateway gateway;

    //@Secured("ROLE_TRAILS_USER")
    //@RequestMapping(value = "/trails-rest/components", method = RequestMethod.GET)
    public Trails listComponents() {

        System.out.println("In service method listComponents");

        //validator.validate(trailsRequest);

        CacheManager c = webApplicationContext.getBean(BeanConstants.CACHE_MANAGER, CacheManager.class);

        Trails response = new Trails();
        for (Component component : c.getComponents()) {
            RestComponent restComponent = RestServiceHelper.getRestComponent(component);
            Components components = new Components();
            components.getComponentsList().add(restComponent);
            response.setComponents(components);
        }
        System.out.println("Executed service method listComponents");

        return response;
    }

    //@RequestMapping(value = "/trails-rest/admin/trailsDefinition", method = RequestMethod.POST)
    public void registerTrailsDefinition(@RequestBody TrailsDefinition trailsDefinition) {

        System.out.println("In Admin service method registerTrailsDefinition");

        //validator.validate(trailsRequest);

        //Udpate cache with new definition.

        System.out.println("Executed Admin service method registerTrailsDefinition");

        //     return response;
    }

    //@Secured("ROLE_TRAILS_USER")
    //@RequestMapping(value = "/trails-rest/components/refresh", method = RequestMethod.GET)
    public void refreshComponents() {

    }
}