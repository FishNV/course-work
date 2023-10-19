package org.example.automation;

import com.codeborne.selenide.WebDriverRunner;
import org.example.Config;
import org.example.Session;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseGUITest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
            System.out.println("BEFORE METHOD");
            this.wd().get(String.format("http://%s:%s",
                    Config.HTTP_BASE_HOST.value,
                    Config.HTTP_BASE_PORT.value
            ));
            WebDriverRunner.setWebDriver(this.wd());
    }

    @AfterMethod
    public void afterMethod() {
        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
