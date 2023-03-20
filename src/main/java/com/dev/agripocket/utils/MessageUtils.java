package com.dev.agripocket.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;


@Component
public class MessageUtils {
    public String composeBodyMessage(String obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode mapperNode = mapper.createObjectNode();
        mapperNode.put("messsage", obj);

        return (String) mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(mapperNode);
    }
}
