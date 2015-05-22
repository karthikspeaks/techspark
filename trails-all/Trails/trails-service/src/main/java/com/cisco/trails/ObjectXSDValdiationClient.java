package com.cisco.trails;

import com.cisco.trails.model.request.ExecuteProfileRequest;
import com.cisco.trails.model.request.Trails;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/25/14
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectXSDValdiationClient {

    public static void main(String[] args) throws JAXBException, SAXException {

        JAXBContext jc = JAXBContext.newInstance(Trails.class);
        Trails trails = new Trails();
        trails.setExecuteProfileRequest(new ExecuteProfileRequest());
        JAXBSource source = new JAXBSource(jc, trails);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream isXSD = ObjectXSDValdiationClient.class.getClassLoader().getResourceAsStream("trailsRequest.xsd");
        Schema schema = sf.newSchema(new StreamSource(isXSD));

        Validator validator = schema.newValidator();
        //validator.setErrorHandler(new Handler());
        try {
            validator.validate(source);
        } catch (IOException e) {
            System.out.println(e.getCause().getMessage());
        }

    }


}
