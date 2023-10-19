package org.example.automation.api.user;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class UserCreation {

        public JsonObject createUser(String username, String password) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            return JSONRPCClass.baseRequest("createUser", params);
        }
}
