package org.example.automation.api.user;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class UserDeleting {

    public JsonObject deleteUser(Integer userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        return JSONRPCClass.baseRequest("removeUser", params);
    }
}
