package com.intelehealth.tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.HomePage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.SearchPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SearchPageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	VisitSummaryPage visitSummaryPage;
	DashboardPage dashboardPage;
	Credentials credentials;
	String testEnum = null;

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();

		driver = basePage.init_driver1(prop, testEnum);
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		homePage = new HomePage(driver);
		visitSummaryPage = new VisitSummaryPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
	}

	@Test(priority = 1, description = "IDA4-1488,verify search patient by name test", enabled = true)
	@Description("verify search patient by name test")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1488_Search() throws Exception {
		try {
			String patientName = homePage.getPatientName().split("[(]")[0];
			// System.out.println(patientName);
			homePage.setPatientNameInSearch(patientName);
			homePage.clickOnSearchicon();
			boolean a = homePage.isDisplayedPatientViewPopup();
			Assert.assertTrue(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, description = "IDA4-1489, Search using patient OpenMRS-ID", enabled = true)
	@Description("Search using patient OpenMRS-ID")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1489_Search() throws InterruptedException {
		try {
			searchPage.getAwaitingVisitPatientName();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing user to search using patient OpenMRSID " + e.getMessage());
		}
	}

	@Test(priority = 3, description = "IDA4-1491,verify view button", enabled = true)
	@Description("verify view button")
	@Severity(SeverityLevel.BLOCKER)

	public void IDA4_1491_Search() throws InterruptedException {
		searchPage.clickOnSearchfield();
		String patientName = searchPage.getPatientName();
		searchPage.setPatientNameInSearch(patientName);
		searchPage.clickOnSearchicon();
		Assert.assertTrue(searchPage.isDisplayedPatientPOPUp());
		searchPage.getPatientOpenMRSid();
		searchPage.ClickedOnViewButton();
		Assert.assertTrue(searchPage.isDisplayedVisitSummaryPage());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		basePage.quitDriver(testEnum);
		System.gc();
	}
}