package com.cisco.trails.rest.json.view;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Map;


public class ExtendedMappingJacksonJsonView extends MappingJacksonJsonView {

    @SuppressWarnings({"rawtypes"})
    @Override
    protected Object filterModel(Map<String, Object> model) {
        Object result = super.filterModel(model);
        if (!(result instanceof Map)) {
            return result;
        }

        Map map = (Map) result;
        if (map.size() == 1) {
            return map.values().toArray()[0];
        }
        return map;
    }
}


