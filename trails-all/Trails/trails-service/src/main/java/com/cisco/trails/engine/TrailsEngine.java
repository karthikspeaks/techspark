package com.cisco.trails.engine;

import com.cisco.trails.cache.CacheConstants;
import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.model.TrailsDefinition;
import com.cisco.trails.validator.ComponentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/6/14
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrailsEngine {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    ComponentValidator componentValidator;

    @Autowired
    @Qualifier("componentMarshaller")
    Unmarshaller unmarshaller;

    public void startup() throws IOException {

        initHandlers();

        initComponents();


    }

    public void initComponents() throws IOException {

        String dir = cacheManager.getConfigProperty(CacheConstants.COMPONENTS_DIR);

        System.out.println("Scanning for components...");
        int count = 0;
        int invalid = 0;

        File componentDir = new File(dir);

        if (componentDir.isDirectory()) {

            for (File componentXML : componentDir.listFiles()) {

                ++count;
                System.out.println("Trails definition being validated " + ">" + componentXML.getName());

                boolean validXML = componentValidator.validateXML(componentXML);
                boolean validIds = false;
                if (validXML) {
                    TrailsDefinition trailsDefinition = (TrailsDefinition) unmarshaller.unmarshal(new StreamSource(componentXML));

                    validIds = componentValidator.validateIds(trailsDefinition);

                    //Also check dir and write access.

                    if (validIds) {
                        cacheManager.addComponents(trailsDefinition.getComponents());
                    }


                }
                if (!(validXML && validIds)) {
                    ++invalid;

                    System.out.println("Component Definition will not be exposed for > " + componentXML.getName());


                }
                System.out.println("Trails definition validated.");

            }

        }

        System.out.println("Found " + count + " component(s) of which " + invalid + " components had Invalid component definition(s)");
        System.out.println("Completed Scanning components...");
    }

    public void initHandlers() {

    }

}
