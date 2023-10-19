package automation.api.project;

import io.restassured.http.ContentType;
import org.example.automation.api.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectCreationTest extends BaseApiTest {

    @Test(dataProvider = "createProjectDetails")
    public void testCreateProject(String projectName, String projectDescription, Integer ownerId,
                                  String projectIdentifier, String startDate, String endDate) {
        String payload = jsonRpcPayload.projectCreate
                .createProject(projectName,
                            projectDescription,
                            ownerId,
                            projectIdentifier,
                            startDate,
                            endDate)
                .toString();
        String response = this.request()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/jsonrpc.php")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();



        System.out.println(response);
    }

    @DataProvider
    public Object[][] createProjectDetails() {
        return new Object[][] {
                {"Test project name", "Test project description", 16, "Test project identifier", LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(), LocalDateTime.parse(LocalDateTime.now().plusDays(5).toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString()},
                {"Test project name with null fields", null, null, null, null, null},
                {"Test project with null dates", "Project test description", 18, "Some identifier", null, null}
        };
    }
}
