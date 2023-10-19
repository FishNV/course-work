package org.example.automation.site;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.automation.site.my_dashboard.OverviewPage;
import org.testng.Assert;

public class LoginPage {

    private final SelenideElement usernameField = Selenide.$x("//input[@id='form-username']");
    private final SelenideElement passwordField = Selenide.$x("//input[@id='form-password']");
    private final SelenideElement signInButton = Selenide.$x("//button[@type='submit']");
    private final SelenideElement wrongCredentialsAlert = Selenide.$x("//p[contains(@class, 'alert')]");

    public OverviewPage successfulLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        return new OverviewPage();
    }

    public void unsuccessfulLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        Assert.assertTrue(wrongCredentialsAlert.isDisplayed());
    }
}
