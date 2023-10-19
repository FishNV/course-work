package org.example.automation.api.project;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class ProjectDeleting {

    public JsonObject deleteProject(Integer projectId) {
        Map<String, Object> params = new HashMap<>();
        params.put("project_id", projectId);
        return JSONRPCClass.baseRequest("removeProject", params);
    }
}
