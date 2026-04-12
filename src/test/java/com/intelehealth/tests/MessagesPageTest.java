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
import com.intelehealth.pages.MessagesPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MessagesPageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MessagesPage messagesPage;
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
		messagesPage = new MessagesPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "Verify Messages Page Loads Successfully", enabled = true)
	@Description("Verify Messages Page Loads Successfully")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyMessagesPageLoadsSuccessfully() {
		Assert.assertEquals(messagesPage.getMessagePagelabels(),
				Arrays.asList(prop.getProperty("messages.header"), prop.getProperty("patients.header"),
						prop.getProperty("no.patient.selected.text"),
						prop.getProperty("no.patient.selected.description.text")));
		Assert.assertTrue(messagesPage.getMessagePageFields());
		Assert.assertTrue(messagesPage.isDisplayedPatientsListAlongWithPreviewMessage());
	}

	@Test(priority = 2, description = "Verify Search by Patient Name", enabled = true)
	@Description("Verify Search by Patient Name")
	@Severity(SeverityLevel.BLOCKER)
	public void verifySearchByPatientName() {

		Assert.assertTrue(messagesPage.verifySearchPatientName());

	}

	@Test(priority = 3, description = "Verify Search by Patient OpenMRSID", enabled = true)
	@Description("Verify Search by Patient OpenMRSID")
	@Severity(SeverityLevel.BLOCKER)
	public void verifySearchByPatientOpenMRSID() {

		Assert.assertTrue(messagesPage.verifySearchPatientOpenMRSID());

	}

	@Test(priority = 4, description = "verify Opening A Patient Conversation", enabled = true)
	@Description("verify Opening A Patient Conversation")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyOpeningAPatientConversation() {

		Assert.assertTrue(messagesPage.verifyOpeningAPatientConversation());

	}

	@Test(priority = 5, description = "Verify Message History Is Displayed", enabled = true)
	@Description("Verify Message History Is Displayed")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyMessageHistoryIsDisplayed() {

		Assert.assertTrue(messagesPage.verifyMessageHistoryIsDisplayed());

	}

	@Test(priority = 6, description = "Verify Sending a Text Message", enabled = true)
	@Description("Verify Sending a Text Message")
	@Severity(SeverityLevel.BLOCKER)
	public void verifySendingATextMessage() {

		Assert.assertTrue(messagesPage.verifySendingATextMessage(prop.getProperty("message.text")));

	}

	@Test(priority = 7, description = "Verify Sending a Text Message", enabled = true)
	@Description("Verify Sending a Text Message")
	@Severity(SeverityLevel.BLOCKER)
	public void verifySentMessageStatusIsUpdated() {

		Assert.assertEquals(messagesPage.verifySentMessageStatusIsUpdated(prop.getProperty("message.text")),
				prop.getProperty("read.status"));

	}

	@Test(priority = 8, description = "Verify Message Date Display", enabled = true)
	@Description("Verify Message Date Display")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyMessageDateDisplay() {

		Assert.assertTrue(messagesPage.verifyMessageDateDisplay(prop.getProperty("message.text")));

	}

	@Test(priority = 9, description = "Verify Search with Invalid Patient OpenMRSID", enabled = true)
	@Description("Verify Search with Invalid Patient OpenMRSID")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifySearchWithInvalidPatientOpenMRSID() {

		Assert.assertEquals(messagesPage.VerifySearchWithInvalidPatientOpenMRSID(prop.getProperty("invalid.openmrs.id")),
				prop.getProperty("no.record.found.text"));

	}

	@Test(priority = 10, description = "Verify Search with Invalid Patient Name", enabled = true)
	@Description("Verify Search with Invalid Patient Name")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifySearchWithInvalidPatientName() {

		Assert.assertEquals(messagesPage.VerifySearchWithInvalidPatientName(prop.getProperty("message.text")),
				prop.getProperty("no.record.found.text"));

	}

	@Test(priority = 11, description = "Verify Sending an Empty Message Is Not Allowed", enabled = true)
	@Description("Verify Sending an Empty Message Is Not Allowed")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifySendingAnEmptyMessageIsNotAllowed() {

		messagesPage.VerifySendingAnEmptyMessageIsNotAllowed();
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() throws Throwable {
		Thread.sleep(1000);
		basePage.quitDriver(testEnum);
		System.gc();
	}
}