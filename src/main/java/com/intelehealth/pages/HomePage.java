package com.intelehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.AppConstants;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By patientName = By.xpath("//td[@data-test-id='apPatient0']");
	By lblpatientName = By.xpath("//h6[@data-test-id='etPatientName']");
	By lblpatientOpenMRSID = By.xpath("//p[@data-test-id='etPatienOpenMRSId']");
	By lblDashBoard = By.xpath("//li[@class='breadcrumb-item ng-star-inserted']//a");
	By searchField = By.xpath("//input[@placeholder='Search patient']");
	By searchIcon = By.xpath("//span[@class='input-group-text click']");
	By lstPatients = By.xpath("//tr[@class='ng-star-inserted']/td/preceding-sibling::td");
	By lstOpenMRSId = By.xpath("//*[@id=\"mat-dialog-0\"]//tr/th/div/text()");
	By btnView = By.xpath(
			"//button[contains(@data-test-id,'btnViewSearchedPatients')]//span/preceding-sibling::span/preceding-sibling::span");
	By btnClose = By.xpath(
			"//button[@data-test-id='btnCloseSearchedPatients']//preceding-sibling::span//preceding-sibling::span");
	By lblPatientName = By.xpath("//div[@class='identifier']/../following-sibling::td/preceding-sibling::td");
	By lblOpenMRSID = By.xpath("//div[@class='identifier']");
	By patientViewPopup = By.xpath("//*[@id='mat-dialog-0']//tr[1]/td[1]");
	By lblPatientNameInAppointmentsSection = By.xpath("//td[@data-test-id='apPatient0']");
	By lblPatientNameInAwaitingVisitsSection = By
			.xpath("//tr[@data-test-id='aw0']//span[contains(@class,'font-bold')]");
	public static String lblFirstPatientNameUnderSections = "//tr[@data-test-id='{$patientName}']//span[contains(@class,'font-bold')]";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	@Step("getting the page title")
	public String getPageTitle() {
		extentReport.logToExtentReport("get the page title");
		return elementActions.doGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}
//
//	@Step("Click on patient name")
//	public DashboardPage clickOnPatientName() {
//		elementActions.doClick(patientName);
//		extentReport.logToExtentReport("Click on patient name");
//		return new DashboardPage(driver);
//	}

	@Step("Get patient name")
	public String getPatientName() {
		try {
//		elementActions.doClick(patientName);
		return elementActions.doGetText(patientName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Step("Click on Dashboard")
	public void clickOnDashboard() {
		extentReport.logToExtentReport("Click on Dashboard");
		elementActions.doClick(lblDashBoard);
	}

	@Step("Get patient names list")
	public boolean getListOfPatients(String name) {
//		extentReport.logToExtentReport("Get patient names list");
		return elementActions.getTextFromElements(lstPatients, name);
	}

	@Step("Get view text")
	public boolean getViewText(String view) {
		extentReport.logToExtentReport("Get view text");
		return elementActions.checkAllElementsWithText(btnView, view);
	}

	@Step("Click on close button")
	public void clickOnCloseButton() {
		elementActions.doClick(btnClose);
		extentReport.logToExtentReport("Click on close button");
	}

	@Step("Click on close button")
	public boolean getPatientNae( String name) {
		extentReport.logToExtentReport("Click on close button");
		return elementActions.getTextFromElements(patientName, name);
	}



	@Step("Is Displayed Patient Name In Appointments Section")
	public boolean isDisplayedPatientName() {
		try {
			extentReport.logToExtentReport("Patient Name In Appointments Section is displayed");
			return elementActions.doIsDisplayed(lblPatientNameInAppointmentsSection);
		} catch (Exception e) {
			return false;
		}
	}
	
	@Step("Click on patient name in appointments section")
	public void clickOnPatientNameInAppointmentsSection() {
		elementActions.doClick(lblPatientNameInAppointmentsSection);
		extentReport.logToExtentReport("Click on patient name in appointments section");
	}

	@Step("Is displayed patient view popup")
	public boolean isDisplayedPatientViewPopup() {

		try {
			Thread.sleep(5000);
			extentReport.logToExtentReport("patient view popup is displayed");
			return elementActions.doIsDisplayed(patientViewPopup);
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Enter patient name in search field")
	public DashboardPage setPatientNameInSearch(String searchName) throws InterruptedException {
		Thread.sleep(2000);
		elementActions.waitForElementVisible(searchField);
		extentReport.logToExtentReport("wait for search field visible");
		elementActions.doClick(searchField);
		extentReport.logToExtentReport("click on search field");
		elementActions.doActionsSendKeys(searchField, searchName);
		extentReport.logToExtentReport("Enter name in search filed");
		return new DashboardPage(driver);
	}

	@Step("Click on search icon")
	public DashboardPage clickOnSearchicon() {
		elementActions.doClick(searchIcon);
		extentReport.logToExtentReport("Click on search icon");
		return new DashboardPage(driver);
	}

	@Step("Get close text")
	public String getCloseText() {
		extentReport.logToExtentReport("Get close text");
		return elementActions.doGetText(btnClose);
	}

	@Step("Get view text")
	public String getViewText() {
		extentReport.logToExtentReport("Get view text");
		return elementActions.doGetText(btnView);
	}

	@Step("get patient name text")
	public String getPatientNameText() {
		extentReport.logToExtentReport("get patient name text");
		return elementActions.doGetText(lblPatientName);
	}

	@Step("get Patient OpenMRSID text")
	public String getPatientOpenMRSIDText() {
		extentReport.logToExtentReport("get Patient OpenMRSID text");
		return elementActions.doGetText(lstOpenMRSId);
	}
	
	   @Step("Enter patient Open MRS ID in search field")
	    public DashboardPage setPatientOpenMRSIDInSearch(String searchMRSID) {
	        elementActions.doClick(searchField);
	        extentReport.logToExtentReport("Clicked on Search field");
	        elementActions.doActionsSendKeys(searchField, searchMRSID);
	        extentReport.logToExtentReport("Enter patient name in search field");
	        return new DashboardPage(driver);
	    }

	/*
	 * @Step("Get openMRSID of patient") public String getOpenMRSIDOfPatient() {
	 * elementActions.doClick(btnClose);
	 * return null; }
	 */
	@Step("Click on patient name in awaiting visits section")
	public void clickOnPatientNameInAwaitingVisitsSection() {
		elementActions.doClick(lblPatientNameInAwaitingVisitsSection);
		extentReport.logToExtentReport("Click on patient name in awaiting visits section");
	}

	@Step("Click on patient name in awaiting visits section")
	public void clickOnPatientName(String section) {
		elementActions.doClick(By.xpath(lblFirstPatientNameUnderSections.replace("{$patientName}", section)));
		extentReport.logToExtentReport("Click on patient name in awaiting visits section");
	}
}