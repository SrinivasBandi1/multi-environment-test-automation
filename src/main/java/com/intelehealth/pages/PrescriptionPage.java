package com.intelehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.AppConstants;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class PrescriptionPage {

	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By lnkPrescription = By.xpath("//*[@data-test-id='labelPrescription']");
	By completedTab = By.xpath("//*[@data-test-id='chipCompletedInfo']");
	By completedPatient = By.xpath("//*[@data-test-id='compAge1']");
	By lblVisitSummary = By.xpath("//li[@class='breadcrumb-item ng-star-inserted']//following-sibling::li");
	By lblCompletedCount = By.xpath("//*[@data-test-id='lblCompletedVisit']");
	By countOfRecords = By
			.xpath("\n"
					+ "//*[@data-test-id='matPaginatorSent']");
	By countOfRecordsInCompletedVisit = By
			.xpath("//*[@data-test-id='matPaginatorCompleted']");

	
			
			;
	By lblPrescriptionIcon = By.xpath("//*[@data-test-id='labelPrescription']");
	By prescriptionSentBox = By.xpath("//*[@data-test-id='chipSentLabel']");
	By lblPrescriptionCount = By.xpath("\n"
			+ "//*[@data-test-id='lblSentVisit']");

	public PrescriptionPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	@Step("getting the page title")
	public String getPageTitle() {
		extentReport.logToExtentReport("Get the page title");
		return elementActions.doGetPageTitle(AppConstants.PRESCRIPTION_COUNT_PAGE_TITLE);
	}

	@Step("IsDisplayed on prescription sent box")
	public boolean isDisplayedPrescriptionBox() {
		extentReport.logToExtentReport("Prescription sent box is displayed");
		return elementActions.doIsDisplayed(prescriptionSentBox);
	}

	public int getCountOfPrescriptionVisits() {
		String s = elementActions.doGetText(lblPrescriptionCount).split("[(]")[1];// 4 0)
		extentReport.logToExtentReport("Get text of Prescription count");
		System.out.println(Integer.parseInt(s.substring(0, s.length() - 1)));
		return Integer.parseInt(s.substring(0, s.length() - 1));
	}

	public int getCountOfRecordInPrescriptionVisits() {
		extentReport.logToExtentReport("Get count of record in Prescription visit");
		System.out.println(Integer.parseInt(elementActions.doGetText(countOfRecords).split(" ")[4]));
		return Integer.parseInt(elementActions.doGetText(countOfRecords).split(" ")[4]);
	}

	@Step("Isdisplayed count of completed visit records")
	public boolean isDisplayedCountOfCompletedVisitRecords() {
		extentReport.logToExtentReport("Count of completed visit records is displayed");
		return elementActions.doIsDisplayed(countOfRecordsInCompletedVisit);
	}

	@Step("Click on Prescription link")
	public void clickOnPrescription() {
		elementActions.doClick(lnkPrescription);
		extentReport.logToExtentReport("Clicked on Prescription link");
	}

	@Step("Click on Completed visits tab")
	public void clickOnCompletedVisitsTab() throws InterruptedException {
		//Thread.sleep(3000);
		extentReport.logToExtentReport("Click on Completed visits tab");
		elementActions.doClick(completedTab);
	}

	@Step("Click on Completed Patient Visit")
	public void clickOnCompletedPatientVisit() throws InterruptedException {
		//Thread.sleep(3000);
		extentReport.logToExtentReport("Click on Completed Patient Visit");
		elementActions.doClick(completedPatient);
	}

	@Step("Get Visit Summary Text")
	public String getVisitSummaryText() throws InterruptedException {
		//Thread.sleep(3000);
		extentReport.logToExtentReport("Get Visit Summary Text");
		return elementActions.doGetText(lblVisitSummary);
	}

	@Step("Get Count Of CompletedVists")
	public int getCountOfCompletedVists() {
		String s = elementActions.doGetText(lblCompletedCount).split("[(]")[1];// 4 0)
		extentReport.logToExtentReport("Get Count Of CompletedVists");
		return Integer.parseInt(s.substring(0, s.length() - 1));
	}

	@Step("Get Count Of Records In CompletedVists")
	public int getCountOfRecordsInCompletedVists() {
		extentReport.logToExtentReport("Get Count Of Records In CompletedVists");
		return Integer.parseInt(elementActions.doGetText(countOfRecordsInCompletedVisit).split(" ")[4]);
	}

	@Step("Get CompletedVisits Tab Color")
	public String getCompletedVisitsTabColor() {
		String colorString = elementActions.getElement(completedTab).getCssValue("background-color");
		//System.out.println(colorString);
		extentReport.logToExtentReport("Get CompletedVisits Tab Color");
		String hex = Color.fromString(colorString).asHex();
		extentReport.logToExtentReport("Get CompletedVisits Tab Color");
		return hex;
	}

}
