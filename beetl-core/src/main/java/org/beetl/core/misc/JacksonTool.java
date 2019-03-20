package org.beetl.core.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTool implements  JsonTool{
    static ObjectMapper mapper = new ObjectMapper();
    @Override
    public String render(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw  new RuntimeException(e);
        }
    }
}
