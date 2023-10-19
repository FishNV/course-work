package org.example.automation.site.my_dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

public class OverviewPage extends DashboardCommon {

    final private SelenideElement title = Selenide.$x("//span[@class='title']");

    public void titleIsShown() {
        Assert.assertTrue(title.isDisplayed());
    }


}
