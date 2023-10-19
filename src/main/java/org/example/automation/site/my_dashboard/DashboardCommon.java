package org.example.automation.site.my_dashboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.automation.site.project.Summary;
import org.example.helper.Project;

public class DashboardCommon {
    final private String pageHeaderXPath = "//div[@class='page-header']";
    final private SelenideElement pageHeader = Selenide.$x(pageHeaderXPath);
    final private SelenideElement newProjectButton = Selenide.$x(pageHeaderXPath + "//a[@href='/project/create']");
    final private SelenideElement newPersonalProjectButton = Selenide.$x(pageHeaderXPath +"//a[@href='/project/create/personal']");
    final private SelenideElement projectManagementButton = Selenide.$x(pageHeaderXPath +"//a[@href='/projects']");
    final private SelenideElement myActivityStreamButton = Selenide.$x(pageHeaderXPath +"//a[@href='/my-activity']");
    final private SelenideElement newProjectNameField = Selenide.$x("//input[@id='form-name']");
    final private SelenideElement newProjectIdentifierField = Selenide.$x("//input[@id='form-identifier']");
    final private SelenideElement columnTaskLimitsApplyCheckbox = Selenide.$x("//input[@name='per_swimlane_task_limits']");
    final private SelenideElement taskLimitField = Selenide.$x("//input[@id='form-task_limit']");
    final private SelenideElement submitButton = Selenide.$x("//button[@type='submit']");
//    public void createProject(String projectName, String projectIdentifier, boolean taskLimitsApply, int taskLimit) {
//        newProjectButton.click();
//        newProjectNameField.sendKeys(projectName);
//        newProjectIdentifierField.sendKeys(projectIdentifier);
//        if (taskLimitsApply)
//            columnTaskLimitsApplyCheckbox.click();
//        taskLimitField.sendKeys(Integer.toString(taskLimit));
//        submitButton.click();
//    }
//
//    public void createProject(String projectName, String projectIdentifier, boolean taskLimitsApply) {
//        newProjectButton.click();
//        newProjectNameField.sendKeys(projectName);
//        newProjectIdentifierField.sendKeys(projectIdentifier);
//        if (taskLimitsApply)
//            columnTaskLimitsApplyCheckbox.click();
//        submitButton.click();
//    }

    public Summary createProject(Project project) {
        newProjectButton.click();
        newProjectNameField.sendKeys(project.getProjectName());
        if (project.getProjectIdentifier() != null){
            newProjectIdentifierField.sendKeys(project.getProjectIdentifier());
        }
        if (project.isTaskLimitsApply()){
            columnTaskLimitsApplyCheckbox.click();
        }
        if (project.getTaskLimit() != 0){
            taskLimitField.sendKeys(Integer.toString(project.getTaskLimit()));
        }
        submitButton.click();
        return new Summary();
    }
}
