package automation.api.category;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.annotations.Test;

public class CreateCategoryTest extends BaseApiTest {
    @Test
    public void testCreateCategory() {
        String payload = jsonRpcPayload.category.createCategory("Test new cat 3",6).toString();
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
