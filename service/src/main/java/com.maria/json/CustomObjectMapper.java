package com.maria.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


import java.util.Date;

/**
 * Created by msimion on 9/1/2015.
 */
public class CustomObjectMapper extends ObjectMapper{

    public CustomObjectMapper (){
        SimpleModule javaUtilDateModule = new SimpleModule("JavaUtilDateModule", Version.unknownVersion());
        javaUtilDateModule.addSerializer(Date.class, new JavaUtilDateSerializer());
        javaUtilDateModule.addDeserializer(Date.class, new JavaUtilDateDeserializer());
        registerModule(javaUtilDateModule);
    }

}
