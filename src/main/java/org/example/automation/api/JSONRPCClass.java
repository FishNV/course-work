package org.example.automation.api;

import com.google.gson.JsonObject;
import org.example.automation.api.category.CreateCategory;
import org.example.automation.api.project.ProjectCreation;
import org.example.automation.api.project.ProjectDeleting;
import org.example.automation.api.task.TaskCreation;
import org.example.automation.api.task.TaskDeleting;
import org.example.automation.api.user.UserCreation;
import org.example.automation.api.user.UserDeleting;

import java.util.Map;

public class JSONRPCClass {
    static private long rpcIdCounter = 1;

    final public CreateCategory category = new CreateCategory();
    final public UserCreation userCreate = new UserCreation();
    final public UserDeleting userDelete = new UserDeleting();
    final public ProjectCreation projectCreate = new ProjectCreation();
    final public ProjectDeleting projectDelete = new ProjectDeleting();
    final public TaskCreation taskCreate = new TaskCreation();
    final public TaskDeleting taskDelete = new TaskDeleting();

    static public JsonObject baseRequest(String method, Map<String, Object> parameters) {
        JsonObject requestPayload = new JsonObject();
        requestPayload.addProperty("jsonrpc",   "2.0");
        requestPayload.addProperty("method",    method);
        requestPayload.addProperty("id",        rpcIdCounter ++);

        JsonObject params = new JsonObject();
        for (String param : parameters.keySet()) {
            Object value = parameters.get(param);
            if (value.getClass() == String.class)
                params.addProperty(param, (String) value);
            else if (value.getClass() == Integer.class)
                params.addProperty(param, (Integer) value);
            else if (value.getClass() == Boolean.class)
                params.addProperty(param, (Boolean) value);
            else
                throw new RuntimeException("Unsupported value " + value.getClass().getSimpleName());
        }

        requestPayload.add("params", params);

        return requestPayload;
    }
}
