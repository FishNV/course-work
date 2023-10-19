package automation.api.user;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.annotations.Test;

public class UserCreationTest extends BaseApiTest {

    @Test
    public void testCreateUser() {
        String payload = jsonRpcPayload.userCreate.createUser("test_user", "123456").toString();
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
