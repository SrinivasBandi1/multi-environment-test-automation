package com.intelehealth.pages;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage extends BasePage {

    WebDriver driver;
    ElementActions elementActions;
    WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

    By nofificationIcon = By.xpath("//button[@data-test-id='btnNotification']");
    By threedots = By.xpath("//button[@data-test-id=\"btnProfileDropdown\"]");
    By profile = By.xpath("//button[@data-test-id=\"btnProfileMain\"]");


    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        elementActions = new ElementActions(this.driver);
    }

    @Step("Clicked On NotificationIcon")
    public void ClickedOnNotificationIcon() {
    	elementActions.doClick(nofificationIcon);
    	extentReport.logToExtentReport("Clicked On NotificationIcon");	
    }

    @Step("Click on 3 dots")
    public void Clickonthreedots() {
    	elementActions.doClick(threedots);
    	extentReport.logToExtentReport("Click on 3 dots");
    }

    @Step("Click on profile")
    public void Clickonprofile() {
    	elementActions.doClick(profile);
    	extentReport.logToExtentReport("Click on profile");
    	System.out.println("in profile method ");
    }

}



