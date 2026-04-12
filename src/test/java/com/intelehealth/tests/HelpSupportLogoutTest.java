package com.intelehealth.tests;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.HelpSupportLogoutPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HelpSupportLogoutTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	HelpSupportLogoutPage helpSupportLogoutPage;
	Credentials credentials;
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
		helpSupportLogoutPage = new HelpSupportLogoutPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1648_Verify the Logout functionality", enabled = true)
	@Description("Verify the Logout functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1648_HelpSupport() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1648");
		helpSupportLogoutPage.logoutConfirmDialog();
	}

	@Test(priority = 2, description = "IDA4_1650_Verify the User can logout from app if clicking yes", enabled = true)
	@Description("Verify the User can logout from app if clicking yes")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1650_HelpSupport() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1650");
		helpSupportLogoutPage.logoutFunctionality();
	}

	@Test(priority = 3, description = "Verify that user is navigated to Help & Support screen when clicked from left panel", enabled = true)
	@Description("Validates successful navigation to Help & Support screen and verifies the screen header")
	@Severity(SeverityLevel.NORMAL)
	public void verifyNavigationToHelpAndSupportScreen() {

		Assert.assertEquals(helpSupportLogoutPage.navigateToHelpAndSupportScreen(), Arrays
				.asList(prop.getProperty("help.support.header.text"), prop.getProperty("help.support.tickets.text")),
				"Help & Support screen texts mismatch");

	}

	@Test(priority = 4, description = "Verify open tickets count matches total ticket count on Help & Support screen", enabled = true)
	@Description("Validates that the open tickets count displayed matches the total tickets count irrespective of ticket availability")
	@Severity(SeverityLevel.NORMAL)
	public void verifyOpenTicketCountMatchesTotalTicketCount() {

		Assert.assertTrue(helpSupportLogoutPage.isOpenTicketCountMatchingTotalCount(),
				"Open ticket count does not match total ticket count");

		Assert.assertEquals(helpSupportLogoutPage.getNoDataDisplayText(), prop.getProperty("no.data.display.text"));
	}

	@Test(priority = 5, description = "Verify Create Ticket popup UI elements and important texts")
	@Description("Verify that all Create Ticket popup UI elements are displayed and header, title, and submit button texts match expected values")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCreateTicketPopupElementsAndTexts() throws InterruptedException {
		// Open Create Ticket popup
		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();
		// Assert all UI elements are displayed
		Assert.assertTrue(helpSupportLogoutPage.areCreateTicketPopupElementsDisplayed(),
				"One or more Create Ticket popup elements are not displayed");

		// Expected texts from property file
		List<String> expectedTexts = Arrays.asList(prop.getProperty("create.ticket.popup.header"),
				prop.getProperty("create.ticket.popup.title"), prop.getProperty("create.ticket.popup.description"),
				prop.getProperty("create.ticket.popup.priority"), prop.getProperty("create.ticket.popup.low.priority"),
				prop.getProperty("create.ticket.popup.medium.priority"),
				prop.getProperty("create.ticket.popup.high.priority"),
				prop.getProperty("create.ticket.popup.create.button.text"),
				prop.getProperty("create.ticket.popup.cancel.button.text"));

		// Actual texts from the page
		List<String> actualTexts = helpSupportLogoutPage.getCreateTicketPopupTexts();

		// Assert texts
		Assert.assertEquals(actualTexts, expectedTexts, "Create Ticket popup texts mismatch");
	}

	@Test(priority = 6, description = "verify Search FIeld is Visible and in enabled state", enabled = true)
	@Description("verify Search FIeld is Visible and in enabled state")
	@Severity(SeverityLevel.NORMAL)
	public void verifySearchFIeldisVisibleAndInEnabledStates() {
		helpSupportLogoutPage.clickOnHelpAndSupportScreen();

		Assert.assertTrue(helpSupportLogoutPage.verifySearchFIeldisVisibleAndEnabled());
	}

	@Test(priority = 7, description = "Verify No Data message is displayed when searching with invalid ticket value", enabled = true)
	@Description("Validates empty search result message when no tickets match the search criteria")
	@Severity(SeverityLevel.NORMAL)
	public void verifyNoDataDisplayedForInvalidSearch() {

		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		Assert.assertEquals(
				helpSupportLogoutPage.searchTicketAndVerifyNoDataDisplayed(prop.getProperty("invalid.ticket.number")),
				prop.getProperty("no.data.display.text"),
				"No Data message is not displayed after searching with invalid ticket");
	}

	@Test(priority = 8, description = "Verify No Data message is displayed when searching When There Are No Tickets", enabled = true)
	@Description("Validates empty search result message When There Are No Tickets")
	@Severity(SeverityLevel.NORMAL)
	public void verifyNoDataDisplayedForSearchWhenThereAreNoTickets() {

		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		Assert.assertEquals(
				helpSupportLogoutPage.searchTicketAndVerifyNoDataDisplayed(prop.getProperty("valid.ticket.number")),
				prop.getProperty("no.data.display.text"),
				"No Data message is not displayed after searching with invalid ticket");
	}

	@Test(priority = 9, description = "Verify creation of ticket", enabled = true)
	@Description("Verify creation of ticket")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCreateTicket() throws InterruptedException {
		helpSupportLogoutPage.createTicket(prop.getProperty("ticket.title"), prop.getProperty("ticket.description"));
		// need to add assertion after the bug
		//bug:gate way timeout

	}

	@Test(priority = 10, description = "Verify Create Ticket Modal And Title", enabled = true)
	@Description("Verify Create Ticket Modal And Title")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCreateTicketModalAndTitle() {
		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();

		Assert.assertTrue(helpSupportLogoutPage.createTicketModalIsDisplayed());

		Assert.assertEquals(helpSupportLogoutPage.verifyCreateTicketModaltitle(),
				prop.getProperty("create.ticket.popup.header"), "Create Ticket popup texts mismatch");
	}

	@Test(priority = 11, description = "Verify Create Ticket With No Data", enabled = true)
	@Description("Verify Create Ticket With No Data")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCreateTicketWithNoData() {


		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();

		Assert.assertEquals(helpSupportLogoutPage.verifyCreateTicketWithNoData(), Arrays
				.asList(prop.getProperty("enter.title.error.text"), prop.getProperty("enter.description.error.text")),
				"Error texts mismatch");
	}

	@Test(priority = 12, description = "Verify close button functionality", enabled = true)
	@Description("Verify close button functionality")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCloseButtonFuntionalityInCreateTicketModal() {
		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();

		Assert.assertFalse(helpSupportLogoutPage.VerifyCloseButtonFunctionality());
	}

	@Test(priority = 13, description = "Verify cancel button functionality", enabled = true)
	@Description("Verify cancel button functionality")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCancelButtonFuntionalityInCreateTicketModal() {

		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();

		Assert.assertFalse(helpSupportLogoutPage.VerifyCancelButtonFunctionality());
	}

	@Test(priority = 14, description = "Verify Priority Selection", enabled = true)
	@Description("Verify Priority Selection")
	@Severity(SeverityLevel.NORMAL)
	public void verifyPrioritySelectionInCreateTicket() {
		helpSupportLogoutPage.clickOnHelpAndSupportScreen();
		helpSupportLogoutPage.clickOnCreateTicketButton();

		Assert.assertTrue(helpSupportLogoutPage.VerifyPrioritySelection());
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		basePage.quitDriver(testEnum);
		System.gc();
	}
}

