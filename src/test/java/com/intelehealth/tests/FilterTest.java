package com.intelehealth.tests;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class FilterTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	// ChatPage chatPage;
	// AwaitPriortyInProgress awaitPriortyInProgress;
	Credentials credentials;
	VisitSummaryPage visitSummaryPage;
	String testEnum;

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();
		driver = basePage.init_driver1(prop, testEnum);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);

		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "Verify Filter popup opens on clicking Filter icon", enabled = true)
	@Description("Verify Filter popup opens on clicking Filter icon")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyFilterPopupOpensonClickingFilterIcon() {

		Assert.assertTrue(dashboardPage.verifyFilterPopup());
	}

	@Test(priority = 2, description = "Verify Filtering Appointments Using Single Date", enabled = true)
	@Description("Verify Filtering Appointments Using Single Date")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyFilteringAppointmentsUsingSingleDate() {
		// dashboardPage.VerifyFilteringVisitsBySingleDate();
		Assert.assertTrue(
				dashboardPage.verifyFilteringVisitsBySingleDate(prop.getProperty("no.awaiting.visits.found.text")));
	}

	@Test(priority = 3, description = "Verify Filtering Visits By Range", enabled = true)
	@Description("Verify Filtering Visits By Range")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyFilteringVisitsByRange() {
		// dashboardPage.VerifyFilteringVisitsBySingleDate();
		dashboardPage.verifyFilteringVisitsByRange(prop.getProperty("no.awaiting.visits.found.text"));
	}

	@Test(priority = 4, description = "Verify Reset Button Functionality", enabled = true)
	@Description("Verify Reset Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyResetButtonFunctionality() {
		Assert.assertEquals(dashboardPage.verifyResetButtonFunctionalityAfterApplyingFilterInDate(),
				prop.getProperty("select.date.text"));
		Assert.assertEquals(dashboardPage.verifyResetButtonFunctionality(), prop.getProperty("select.date.text"));
		Assert.assertEquals(dashboardPage.verifyResetButtonFunctionalityInRangeAfterApplyingFilter(),
				Arrays.asList(prop.getProperty("select.startdate.text"), prop.getProperty("select.enddate.text")));
		Assert.assertEquals(dashboardPage.verifyResetButtonFunctionalityInRange(),
				Arrays.asList(prop.getProperty("select.startdate.text"), prop.getProperty("select.enddate.text")));
	}

	@Test(priority = 5, description = "Verify Apply button without selecting Date ", enabled = true)
	@Description("Verify Apply button without selecting Date ")
	@Severity(SeverityLevel.NORMAL)
	public void verifyApplyButtonWithoutSelectingDate() {
		// dashboardPage.VerifyFilteringVisitsBySingleDate();

		Assert.assertEquals(dashboardPage.verifyApplyButtonFunctionalityWithoutSelectingDate(),
				prop.getProperty("error.message.select.date"));
		// add asservtion for validation
	}

	@Test(priority = 6, description = "Verify Apply button without selecting Range ", enabled = true)
	@Description("Verify Apply button without selecting Date or Range ")
	@Severity(SeverityLevel.NORMAL)
	public void verifyApplyButtonWithoutSelectingRange() {

		Assert.assertEquals(dashboardPage.verifyApplyButtonFunctionalityWithoutSelectingRange(), Arrays
				.asList(prop.getProperty("error.message.start.date"), prop.getProperty("error.message.end.date")));

		// add asservtion for validation
	}

	@Test(priority = 7, description = "Verify behavior when no vists exist for selected Date", enabled = true)
	@Description("Verify behavior when no vists exist for selected Date")
	@Severity(SeverityLevel.NORMAL)
	public void verifyBehaviorWhenNoVistsExistForSelectedDate() {

		dashboardPage.verifyFilterDateWhenNoVisits();

		// add asservtion for validation
	}

	@Test(priority = 8, description = "Verify behavior when no vists exist for selected Range", enabled = true)
	@Description("Verify behavior when no vists exist for selected Range")
	@Severity(SeverityLevel.NORMAL)
	public void verifyFilterRangeWhenNoVisits() {

		dashboardPage.verifyFilterRangeWhenNoVisits();

		// add asservtion for validation
	}

	@Test(priority = 9, description = "Verify Filter popup closes after Apply", enabled = true)
	@Description("Verify Filter popup closes after Apply")
	@Severity(SeverityLevel.NORMAL)
	public void verifyPopupClosesAfterApply() {

		Assert.assertFalse(dashboardPage.verifyFilterPopupClosesAfterApply());

	}

	@Test(priority = 10, description = "Verify Filter works along with Search Visit By ID", enabled = true)
	@Description("Verify Filter works along with Search vist By ID")
	@Severity(SeverityLevel.NORMAL)
	public void verifyFilterWorksAlongWithSearchVisitByOpenMrsID() {

		Assert.assertTrue(dashboardPage.verifyFilterWorksAlongWithSearchVisitByOpenMRSId());

	}

	@Test(priority = 11, description = "Verify Filter works along with Search Visit By Name", enabled = true)
	@Description("Verify Filter works along with Search vist Name")
	@Severity(SeverityLevel.NORMAL)
	public void verifyFilterWorksAlongWithSearchVisitByPatientName() {

		Assert.assertTrue(dashboardPage.verifyFilterWorksAlongWithSearchVisitByName());

	}

	@Test(priority = 12, description = "Click Apply without selecting from date in Range", enabled = true)
	@Description("Click Apply without selecting from date in Range")
	@Severity(SeverityLevel.NORMAL)
	public void verifyApplyWithoutSelectingFromDateAfterChoosingRangeOption() {

		Assert.assertEquals(dashboardPage.verifyApplyButtonFunctionalityWithoutSelectingFromDAteINRange(),
				prop.getProperty("error.message.start.date"));

	}

	@Test(priority = 13, description = "Click Apply without selecting To date in Range", enabled = true)
	@Description("Click Apply without selecting To date in Range")
	@Severity(SeverityLevel.NORMAL)
	public void verifyApplyWithoutSelectingToDateAfterChoosingRangeOption() {

		Assert.assertEquals(dashboardPage.verifyApplyButtonFunctionalityWithoutSelectingTODAteINRange(),
				prop.getProperty("error.message.end.date"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Throwable {
		basePage.quitDriver(testEnum);
		System.gc();
	}
}
