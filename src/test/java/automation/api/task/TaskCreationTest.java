package automation.api.task;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.annotations.Test;

public class TaskCreationTest extends BaseApiTest {

    @Test
    public void testCreateUser() {
        String projectCreatePayload = jsonRpcPayload.projectCreate.createProject("for delete",
                null, null, null, null, null).toString();

        int projectIdForTaskCreation = this.request().contentType(ContentType.JSON).body(projectCreatePayload)
                .post("/jsonrpc.php").then().extract().body().path("result");

        String payload = jsonRpcPayload.taskCreate.createTask("test_user", projectIdForTaskCreation).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();

        System.out.println(response);
    }
}
