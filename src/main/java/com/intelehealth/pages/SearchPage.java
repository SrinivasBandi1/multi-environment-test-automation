package com.intelehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.AppConstants;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class SearchPage extends BasePage {
    WebDriver driver;
    ElementActions elementActions;
    WebDriverWait wait;
    ExtentReportListener extentReport = new ExtentReportListener();
    
    By dashboard = By.xpath("//a[@data-test-id='linkDashboard']");
    By textpatientName = By.xpath("//div[@data-test-id='td-patient_name-Awaiting-0']");
    By awaitingPatient = By.xpath("//div[@data-test-id='td-patient_name-Awaiting-0']");
    By searchField = By.xpath("//input[@data-test-id='etSearchPatient']");
    By searchIcon = By.xpath("//span[@data-test-id='btnSearchPatient']");
    By popupPatientList = By.xpath("//div[@data-test-id='searchedPatientsModalTitle']/parent::app-searched-patients");
    By openMRSIDText = By.xpath("//p[@data-test-id='etPatienOpenMRSId']");
    By openMRSID = By.xpath("//span[@data-test-id='patientIdentifierValue']");
    By btnView = By.xpath("//button[@data-test-id='btnViewSearchedPatient0']");
    By lblVisitSummary = By.xpath("//li[@data-test-id='breadcrumbCurrent']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        elementActions = new ElementActions(this.driver);
    }

    // 3. page actions/methods:
    @Step("getting the page title")
    public String getPageTitle() {
        return elementActions.doGetPageTitle(AppConstants.SEARCH_PAGE_TITLE);
    }

    @Step("Enter patient name in search field")
    public DashboardPage setPatientNameInSearch(String searchName) {
        elementActions.doClick(searchField);
        extentReport.logToExtentReport("Clicked on Search field");
        elementActions.doActionsSendKeys(searchField, searchName);
        extentReport.logToExtentReport("Enter patient name in search field");
        return new DashboardPage(driver);
    }
    
    @Step("Enter patient name in search field")
    public DashboardPage getAwaitingVisitPatientName() throws InterruptedException {
        Thread.sleep(10000);
    	elementActions.doClick(awaitingPatient);
    	extentReport.logToExtentReport("Clicked on Awaiting Visit Patient");
    	String openMRSIDValue = elementActions.doGetText(openMRSIDText);
    	extentReport.logToExtentReport("Fetched text of OpenMRSID");
    	Thread.sleep(4000);
    	elementActions.doClick(dashboard);
    	extentReport.logToExtentReport("clicked on dashboard");
    	Thread.sleep(10000);
        elementActions.doActionsSendKeys(searchField, openMRSIDValue);
        extentReport.logToExtentReport("Entered OpenMRSID fetched in search field");
        elementActions.doSendKeysEnter(searchField);
		/*
		 * Thread.sleep(7000); elementActions.doSendKeysEnter(searchIcon);
		 * Thread.sleep(7000);
		 */
        return new DashboardPage(driver);
    }

    @Step("Click on patient name")
    public String getPatientName() {
    	extentReport.logToExtentReport("Click on patient name");
       return elementActions.doGetText(textpatientName).split("[(]")[0];}

    @Step("Enter patient name in search icon")
    public DashboardPage clickOnSearchicon() {
        elementActions.doClick(searchIcon);
        extentReport.logToExtentReport("Click on search icon");
        return new DashboardPage(driver);
    }

    @Step("Click on search field")
    public DashboardPage clickOnSearchfield() {
        elementActions.doClick(searchField);
        extentReport.logToExtentReport("Click on search field");
        return new DashboardPage(driver);
    }

    @Step("IsDisplayed patient PopUp")
    public boolean isDisplayedPatientPOPUp() {
        return elementActions.doIsDisplayed(popupPatientList);
    }

    @Step("IsDisplayed Patient OpenMRS ID text")
    public String getPatientOpenMRSid() {
    	extentReport.logToExtentReport("Patient OpenMRS ID text is displayed");
        return elementActions.doGetText(openMRSID);
    }


    @Step("Clicked On View Button")
    public void ClickedOnViewButton() {
        elementActions.doClick(btnView);
        extentReport.logToExtentReport("Clicked On View Button");
    }

    @Step("IsDisplayed On Visit Summary")
    public boolean isDisplayedVisitSummaryPage(){
        return elementActions.doIsDisplayed(lblVisitSummary);
    }

}