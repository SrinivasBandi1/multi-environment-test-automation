package com.intelehealth.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.PrescriptionPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PrescriptionPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PrescriptionPage prescriptionPage;
	Credentials credentials;
	ExtentReportListener extentReport = new ExtentReportListener();

	@BeforeMethod
	public void setUp() throws Exception {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		prescriptionPage = new PrescriptionPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4-1631, Verify clicking on any of the completed visit record from the table", enabled = true)
	@Description("Verify clicking on any of the completed visit record from the table")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1631_Prescription() throws Exception {
		try {
			prescriptionPage.clickOnPrescription();
			Thread.sleep(3000);
			prescriptionPage.clickOnCompletedVisitsTab();
			prescriptionPage.clickOnCompletedPatientVisit();
			Assert.assertEquals(prescriptionPage.getVisitSummaryText(), "Visit Summary");
		} catch (Exception e) {

		}
	}

	@Test(priority = 2, description = "IDA4-1619, Verify clicking on Completed Visits tab on prescription page", enabled = true)
	@Description("Verify clicking on Completed Visits tab on prescription page")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1619_Prescription() throws Exception {

		prescriptionPage.clickOnPrescription();
		prescriptionPage.clickOnCompletedVisitsTab();
	}

	@Test(priority = 3, description = "IDA4_1629, Verify the count of records shown at the bottom is correct", enabled = true)
	@Description("Verify the count of records shown at the bottom is correct")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1629_Prescription() throws Exception {

		prescriptionPage.clickOnPrescription();
		prescriptionPage.clickOnCompletedVisitsTab();
		Assert.assertTrue(prescriptionPage.isDisplayedCountOfCompletedVisitRecords());
		// count of records
		int lblCompletedVisitsCount = prescriptionPage.getCountOfCompletedVists();
		int countOfCompletedVisits = prescriptionPage.getCountOfRecordsInCompletedVists();
		Assert.assertEquals(lblCompletedVisitsCount, countOfCompletedVisits);

	}

	@Test(priority = 4, description = "Verify the count of records shown at the bottom is correct", enabled = true)
	@Description("Verify the count of records shown at the bottom is correct")
	@Severity(SeverityLevel.BLOCKER)

	public void IDA4_1615_Prescription() throws InterruptedException {
		prescriptionPage.clickOnPrescription();
		Assert.assertTrue(prescriptionPage.isDisplayedPrescriptionBox());
		Thread.sleep(2000);
		int lblPrescriptionCount = prescriptionPage.getCountOfPrescriptionVisits();
		int countOfRecords = prescriptionPage.getCountOfRecordInPrescriptionVisits();
		Assert.assertEquals(lblPrescriptionCount, countOfRecords);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		System.gc();
	}

}
