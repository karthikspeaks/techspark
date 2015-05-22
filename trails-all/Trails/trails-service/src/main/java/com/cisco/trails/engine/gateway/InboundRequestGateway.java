package com.cisco.trails.engine.gateway;

import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.model.request.ExecuteProfileRequest;
import com.cisco.trails.model.request.Trails;
import org.springframework.integration.Message;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class InboundRequestGateway {

    public ProfileContext process(Message<?> inMessage) {

        System.out.println("Inside InboundRequestAdaptor");

        Trails trails = (Trails) inMessage.getPayload();
        String invocationId = (String) inMessage.getHeaders().get("invocationId");

        System.out.println("received invocation Id ->" + invocationId);
        ExecuteProfileRequest executeProfileRequest = trails.getExecuteProfileRequest();

        System.out.println(executeProfileRequest.getComponentName() + " " + executeProfileRequest.getProfile());

        System.out.println("Generating context..");

        System.out.println("Forwarding to executor..");

        ProfileContext profileContext = new ProfileContext();
        profileContext.setComponentName(executeProfileRequest.getComponentName());
        profileContext.setInvocationId(invocationId);

        profileContext.setHint(executeProfileRequest.getHint());
        profileContext.setDescription(executeProfileRequest.getDescription());
        profileContext.setSafeWord(executeProfileRequest.getSafeWord());

        profileContext.setProfileKey(executeProfileRequest.getComponentName() + "." + executeProfileRequest.getProfile());

        return profileContext;
    }
}
