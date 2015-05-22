package com.cisco.trails.rest.json;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;


public class JaxbJacksonObjectMapper extends ObjectMapper {

    public JaxbJacksonObjectMapper() {
        final AnnotationIntrospector introspector
                = new JacksonAnnotationIntrospector();
        super.getDeserializationConfig()
                .withAnnotationIntrospector(introspector);
        super.getSerializationConfig()
                .withAnnotationIntrospector(introspector);

    }
}
