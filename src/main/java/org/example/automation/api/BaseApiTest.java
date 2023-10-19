package org.example.automation.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.example.Config;

public class BaseApiTest {

    final protected JSONRPCClass jsonRpcPayload = new JSONRPCClass();

    public RequestSpecification request() {
        return this.request(null, null);
    }

    public RequestSpecification request(String username, String password) {
        username = username != null ? username : Config.API_USER_NAME.value;
        password = password != null ? password : Config.API_USER_PASSWORD.value;

        return RestAssured.given()
                .baseUri(Config.getApiBaseURL().toString())
                .auth()
                .basic(username, password);
    }
}
