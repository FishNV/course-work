package automation.site.authorization;

import org.example.Config;
import org.example.automation.BaseGUITest;
import org.example.automation.site.LoginPage;
import org.example.automation.site.my_dashboard.OverviewPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LoginTest extends BaseGUITest {


    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        OverviewPage overviewPage = loginPage.successfulLogin(Config.SITE_USER_EMAIL.value, Config.SITE_USER_PASSWORD.value);
        overviewPage.titleIsShown();
    }

    @Test(dataProvider = "incorrectLoginDetails")
    public void unsuccessfulLogin(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.unsuccessfulLogin(username, password);
    }

    @DataProvider
    public Object[][] incorrectLoginDetails() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        return new Object[][] {
                {generatedString, "123"},
                {"notadmin", null},
                {"", "wrong"}
        };
    }
}
