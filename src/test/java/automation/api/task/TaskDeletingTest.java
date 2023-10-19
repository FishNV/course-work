package automation.api.task;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.annotations.Test;

public class TaskDeletingTest extends BaseApiTest {

    @Test
    public void testUserDelete() {
        String projectCreatePayload = jsonRpcPayload.projectCreate.createProject("for delete",
                null, null, null, null, null).toString();

        int projectIdForTaskCreation = this.request().contentType(ContentType.JSON).body(projectCreatePayload)
                .post("/jsonrpc.php").then().extract().body().path("result");

        String taskCreatePayload = jsonRpcPayload.taskCreate.createTask("test_task", projectIdForTaskCreation).toString();

        int taskIdForDelete = this.request().contentType(ContentType.JSON).body(taskCreatePayload)
                .post("/jsonrpc.php").then().statusCode(200).extract().body().path("result");

        String taskDeletePayload = jsonRpcPayload.taskDelete.deleteTask(taskIdForDelete).toString();

        String response = this.request()
                .contentType(ContentType.JSON)
                .body(taskDeletePayload)
                .delete("/jsonrpc.php")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();

        System.out.println(response);
    }
}
