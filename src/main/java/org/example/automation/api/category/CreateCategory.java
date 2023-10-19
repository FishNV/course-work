package org.example.automation.api.category;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class CreateCategory {

    public JsonObject createCategory(String categoryName, Integer projectId) {
        Map<String, Object> params = new HashMap<>();
        params.put("name",       categoryName);
        params.put("project_id", projectId);
        return JSONRPCClass.baseRequest("createCategory", params);
    }
}
