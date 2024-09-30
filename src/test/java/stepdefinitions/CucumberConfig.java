package stepdefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.cy_gb.Ond;

import java.lang.reflect.Type;
import java.util.Map;

public class CucumberConfig {

    //java objects can transform java objects to JSON & back
    // can also transform cucumber datatables to java objects
    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultDataTableEntryTransformer
    public Object defaultTransformer(Map<String, String> entry, Type type){
        //datatables are naturally in Map<String,String> format
        //this converts it to an object in java
        return objectMapper.convertValue(entry, objectMapper.constructType(type));
    }
}
