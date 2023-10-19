package org.example.automation.site.project;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class EditProject {

    final private SelenideElement nameField = Selenide.$x("//input[@id='form-name']");

    public String getProjectName() {
        return nameField.getValue();
    }
}
