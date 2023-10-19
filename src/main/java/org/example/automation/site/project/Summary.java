package org.example.automation.site.project;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Summary {

    final private SelenideElement editProjectButton = Selenide.$x("//a[text()='Edit project']");

    public EditProject editProjectButtonClick() {
        editProjectButton.click();
        return new EditProject();
    }
}
