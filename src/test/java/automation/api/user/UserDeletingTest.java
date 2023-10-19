package automation.api.user;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.example.automation.api.JSONRPCClass;
import org.testng.annotations.Test;

public class UserDeletingTest extends BaseApiTest {

    @Test
    public void testUserDelete() {
        String payload = jsonRpcPayload.userDelete.deleteUser(2).toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete("/jsonrpc.php")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();

        System.out.println(response);
    }
}
