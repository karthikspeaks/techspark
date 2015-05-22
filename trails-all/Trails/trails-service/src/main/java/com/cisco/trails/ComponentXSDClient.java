package com.cisco.trails;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/25/14
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComponentXSDClient {

    public static void main(String[] args) {

        String xsd = "trailsDefinition.xsd";
        String xml = "E:\\Work\\Persitent\\Projects\\Trails\\samples\\component-def\\component-defintion.xml";

        System.out.println(validateXMLSchema(xsd, xml));


    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream is = ComponentXSDClient.class.getClassLoader().getResourceAsStream(xsdPath);
            Schema schema = factory.newSchema(new StreamSource(is));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
