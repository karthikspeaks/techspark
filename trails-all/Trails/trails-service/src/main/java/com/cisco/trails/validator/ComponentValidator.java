package com.cisco.trails.validator;

import com.cisco.trails.cache.CacheManager;
import com.cisco.trails.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ComponentValidator {

    @Autowired
    CacheManager cacheManager;

    public boolean validateXML(File trailsDefinitionXML) {

        System.out.println("Validating XML..." + trailsDefinitionXML);

        boolean valid = validateXMLSchema(trailsDefinitionXML);

        System.out.println("Validation of XML " + trailsDefinitionXML + " is :" + valid + " per trails schema.");

        //Check if paths exist

        return valid;

    }

    private boolean validateXMLSchema(File xml) {

        try {
            String xsdPath = "trailsDefinition.xsd";
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream isXSD = this.getClass().getClassLoader().getResourceAsStream(xsdPath);
            Schema schema = factory.newSchema(new StreamSource(isXSD));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean validateIds(TrailsDefinition trailsDefinition) {

        System.out.println("Validating Ids...");
        boolean markError = false;
        for (Component component : trailsDefinition.getComponents().getComponentsList()) {

            boolean valid = validateIdsFromCache(component);

            System.out.println("Validation of Ids for " + component.getComponentName() + "is :" + valid);
            if (valid) {


                markError = false;


            } else {
                //Set error flag on definition.

                markError = true;

            }
        }

        return !(markError);

    }

    private boolean validateIdsFromCache(Component component) {

        boolean componentValid = cacheManager.checkUniqueComponentId(component.getComponentName());

        System.out.println("Component " + component.getComponentName() + " is : " + componentValid);

        Map<String, Profile> profileDefs = new HashMap<String, Profile>();
        Map<String, TaskDef> taskDefs = new HashMap<String, TaskDef>();
        for (TaskDef taskDef : component.getTaskDefs()) {

            if (!taskDefs.containsKey(taskDef.getId())) {

                System.out.println("Task Definition valid ->" + taskDef.getId());
                taskDefs.put(taskDef.getId(), taskDef);

                componentValid = componentValid && true;
            } else {
                System.out.println("Duplicate task definition > " + taskDef.getId());

                componentValid = componentValid && false;
            }

        }


        String compPrefix = component.getComponentName() + ".";
        boolean markProfileStat = true;

        for (Profile profile : component.getProfiles().getProfiles()) {
            boolean profileValid = !profileDefs.containsKey(compPrefix.concat(profile.getId()));

            if (profileValid) {
                profileDefs.put(compPrefix.concat(profile.getId()), profile);
            }
            System.out.println("Profile " + compPrefix.concat(profile.getId()) + " is " + profileValid);
            markProfileStat = markProfileStat && profileValid;

            for (TaskRef taskRef : profile.getTaskRef()) {

                if (taskDefs.containsKey(taskRef.getRef())) {

                    System.out.println("Task Reference valid ->" + taskRef.getRef());

                    markProfileStat = markProfileStat && true;
                } else {
                    System.out.println("Task Reference invalid > " + taskRef.getRef());

                    markProfileStat = markProfileStat && false;
                }

            }


        }

        return componentValid && markProfileStat;

    }
}
