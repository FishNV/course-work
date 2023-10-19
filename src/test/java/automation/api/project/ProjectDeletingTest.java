package automation.api.project;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.annotations.Test;

public class ProjectDeletingTest extends BaseApiTest {

    @Test
    public void testProjectDelete() {
        String projectCreatePayload = jsonRpcPayload.projectCreate.createProject("for delete",
                null, null, null, null, null).toString();

        int projectIdForDelete = this.request().contentType(ContentType.JSON).body(projectCreatePayload)
                .post("/jsonrpc.php").then().extract().body().path("result");

        String projectDeletePayload = jsonRpcPayload.projectDelete.deleteProject(projectIdForDelete).toString();

        String response = this.request()
                .contentType(ContentType.JSON)
                .body(projectDeletePayload)
                .delete("/jsonrpc.php")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();

        System.out.println(response);
    }
}
