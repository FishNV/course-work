package org.example.automation.api.task;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class TaskDeleting {

    public JsonObject deleteTask(Integer taskId) {
        Map<String, Object> params = new HashMap<>();
        params.put("task_id", taskId);
        return JSONRPCClass.baseRequest("removeTask", params);
    }
}
