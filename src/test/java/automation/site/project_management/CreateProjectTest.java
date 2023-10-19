package automation.site.project_management;

import org.example.Config;
import org.example.automation.BaseGUITest;
import org.example.automation.site.LoginPage;
import org.example.automation.site.my_dashboard.OverviewPage;
import org.example.automation.site.project.EditProject;
import org.example.automation.site.project.Summary;
import org.example.helper.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseGUITest {

    @Test
    public void successfulProjectCreationTest() {
        LoginPage loginPage = new LoginPage();
        OverviewPage overviewPage = loginPage.successfulLogin(Config.SITE_USER_EMAIL.value, Config.SITE_USER_PASSWORD.value);
        Summary summary = overviewPage.createProject(new Project.ProjectBuilder()
                                                .projectName("Test project")
                                                .taskLimitsApply(false)
                                                .taskLimit(5)
                                                .build());
        EditProject editProject = summary.editProjectButtonClick();
        Assert.assertEquals(editProject.getProjectName(), "Test project");
    }
}
