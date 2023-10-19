package org.example.automation.api.project;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class getProjectByName {
    public JsonObject getProjectByName(String projectName) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", projectName);
        return JSONRPCClass.baseRequest("getProjectByName", params);
    }
}
