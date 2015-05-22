package com.cisco.trails.validator;

import com.cisco.trails.model.request.Error;
import com.cisco.trails.model.request.Errors;
import com.cisco.trails.model.request.ExecuteProfileRequest;
import com.cisco.trails.model.request.Trails;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/4/14
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestValidator {

    public void validate(Trails trails, Errors errors) {

        ExecuteProfileRequest executeProfileRequest = trails.getExecuteProfileRequest();
        System.out.println("Validating..");
        if (executeProfileRequest.getComponentName() != null && executeProfileRequest.getProfile() != null) {

            //XSD validation
            validateXMLSchema(trails, errors);
            //Check if valid profile and valid - task
            //Check if the profile is enabled.

            //Check if all necessary task parameters are available for all tasks.


        }

    }

    private boolean validateXMLSchema(Trails trails, Errors errors) {

        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream isXSD = this.getClass().getClassLoader().getResourceAsStream("trailsRequest.xsd");
            Schema schema = sf.newSchema(new StreamSource(isXSD));

            javax.xml.validation.Validator validator = schema.newValidator();
            JAXBContext jc = JAXBContext.newInstance(Trails.class);
            JAXBSource source = new JAXBSource(jc, trails);
            validator.validate(source);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause());
            errors.addError(new Error("ValidationFailure", e.getMessage()));

            return false;
        }
        return true;


    }
}


