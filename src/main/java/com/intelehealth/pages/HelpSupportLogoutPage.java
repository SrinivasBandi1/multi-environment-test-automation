package com.intelehealth.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class HelpSupportLogoutPage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By logoutLink = By.xpath("//span[@data-test-id='textLogout']");
	By logoutYesBtn = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");
	By logoutNoBtn = By.xpath("//button[@data-test-id='btnCancelConfirmationModal']");
	By logoutClose = By.xpath("//button[@data-test-id='btnCloseConfirmationModal']");
	By Username = By.xpath("//input[@data-test-id='etUsername']");

	// help and support
	By lftPnlHelpSupport = By.xpath("//span[@data-test-id='labelHelp']");
	By lblTickets = By.xpath("//h6[@data-test-id='lblTickets']");
	By lblHelpSupportHeader = By.xpath("//h6[@data-test-id='headerTitle']");
	By lblOpenTickets = By.xpath("//span[@data-test-id='lblOpenTickets']");
	By paginationcountLabel = By.xpath("(//mat-paginator[@data-test-id='paginatorTickets']//div)[last()]");
	By btnCreateTicketInHelpAndSupport = By.xpath("//button[@data-test-id='btnCreateTicket']");

	// Popup create ticket popup
	By createTicketModalPopup = By.xpath("//div[@data-test-id='addTicketModal']");
	By lblCreateTicketPopupHeader = By.xpath("//div[@data-test-id='modalTitleContainer']");
	By lblTitleInCreateTicketPopup = By.xpath("//div[@data-test-id='groupTitle']/label");
	By inpTitleInInCreateTicketPopup = By.xpath("//input[@data-test-id='etTicketTitle']");
	By lblDescriptionInCreateTicketPopup = By.xpath("//div[@data-test-id='groupDescription']/label");
	By inpDescriptionInCreateTicketPopup = By.xpath("//textarea[@data-test-id='etTicketDescription']");
	By lblPriorityInCreateTicketPopup = By.xpath("//div[@data-test-id='groupPriority']/label");
	By rdoLowPriorityInCreateTicketPopup = By.xpath("//div[@data-test-id='optionLow']/input");
	By rdoMediumPriorityInCreateTicketPopup = By.xpath("//div[@data-test-id='optionMedium']/input");
	By rdoHighPriorityInCreateTicketPopup = By.xpath("//div[@data-test-id='optionHigh']/input");
	By btnCreateTicketInCreateTicketPopup = By.xpath("//button[@data-test-id='btnSubmitAddTicket']");
	By btnCancelTicketInCreateTicketPopup = By.xpath("//button[@data-test-id='btnCancelAddTicket']");
	By btnCloseTicketInCreateTicketPopup = By.xpath("//button[@data-test-id='btnCloseAddTicket']");

	By msgErrorForTitleInputField = By.xpath("//div[@data-test-id='errorTicketTitle']");
	By msgErrorForDescriptionInputField = By.xpath("//div[@data-test-id='errorTicketDescription']");

	// search ticket
	By inpSearchTicket = By.xpath("//input[@data-test-id='etSearchTickets']");
	By lblNoDataDisplay = By.xpath("//table[@data-test-id='ticketsTable']//td");

	// Constructor of page class:
	public HelpSupportLogoutPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	@Step("User navigates to Help & Support screen from left panel")
	public void clickOnHelpAndSupportScreen() {
		elementActions.doClick(lftPnlHelpSupport);
	}

	@Step("User navigates to Help & Support screen and fetches screen texts")
	public List<String> navigateToHelpAndSupportScreen() {
		clickOnHelpAndSupportScreen();
		return Arrays.asList(elementActions.doGetText(lblHelpSupportHeader), elementActions.doGetText(lblTickets));
	}

	@Step("User navigates to Help & Support screen and verifies open tickets count matches total count")
	public boolean isOpenTicketCountMatchingTotalCount() {
		clickOnHelpAndSupportScreen();

		String openTicketsText = elementActions.doGetText(lblOpenTickets);

		String paginationText = elementActions.doGetText(paginationcountLabel);

		int openTickets = Integer.parseInt(openTicketsText.replaceAll("[^0-9]", ""));

		int totalTickets = Integer.parseInt(paginationText.replaceAll(".*of\\s*", "").trim());

		return openTickets == totalTickets;
	}

	@Step("Get No Data Display Text")
	public String getNoDataDisplayText() {
		return elementActions.doGetText(lblNoDataDisplay);
	}

	@Step("User clicks on Create Ticket button in Help & Support screen")
	public void clickOnCreateTicketButton() {
		try {
			elementActions.waitForElementClickable(btnCreateTicketInHelpAndSupport);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementActions.doClick(btnCreateTicketInHelpAndSupport);
	}

	@Step("Verify Create Ticket popup UI elements are displayed")
	public boolean areCreateTicketPopupElementsDisplayed() {

		elementActions.waitForElementVisible(lblCreateTicketPopupHeader);
		boolean a = elementActions.doIsDisplayed(inpTitleInInCreateTicketPopup);
		boolean b = elementActions.doIsDisplayed(inpDescriptionInCreateTicketPopup);
		boolean c = elementActions.doIsDisplayed(rdoLowPriorityInCreateTicketPopup);
		boolean d = elementActions.doIsDisplayed(rdoMediumPriorityInCreateTicketPopup);
		boolean e = elementActions.doIsDisplayed(rdoHighPriorityInCreateTicketPopup);
		boolean f = elementActions.doIsDisplayed(btnCreateTicketInCreateTicketPopup);
		boolean g = elementActions.doIsDisplayed(btnCancelTicketInCreateTicketPopup);
		boolean h = elementActions.doIsDisplayed(btnCloseTicketInCreateTicketPopup);

		return elementActions.doIsDisplayed(inpTitleInInCreateTicketPopup)
				&& elementActions.doIsDisplayed(inpDescriptionInCreateTicketPopup)
				&& elementActions.doIsDisplayed(rdoLowPriorityInCreateTicketPopup)
				&& elementActions.doIsDisplayed(rdoMediumPriorityInCreateTicketPopup)
				&& elementActions.doIsDisplayed(rdoHighPriorityInCreateTicketPopup)
				&& elementActions.doIsDisplayed(btnCreateTicketInCreateTicketPopup)
				&& elementActions.doIsDisplayed(btnCancelTicketInCreateTicketPopup)
				&& elementActions.doIsDisplayed(btnCloseTicketInCreateTicketPopup);
	}

	@Step("Get Create Ticket popup important UI texts")
	public List<String> getCreateTicketPopupTexts() {
		List<String> actualTexts = new ArrayList<>();

		actualTexts.add(elementActions.doGetText(lblCreateTicketPopupHeader));
		actualTexts.add(elementActions.doGetText(lblTitleInCreateTicketPopup));
		actualTexts.add(elementActions.doGetText(lblDescriptionInCreateTicketPopup));
		actualTexts.add(elementActions.doGetText(lblPriorityInCreateTicketPopup));
		actualTexts.add(elementActions.dogetAttributebyValue(rdoLowPriorityInCreateTicketPopup));
		actualTexts.add(elementActions.dogetAttributebyValue(rdoMediumPriorityInCreateTicketPopup));
		actualTexts.add(elementActions.dogetAttributebyValue(rdoHighPriorityInCreateTicketPopup));
		actualTexts.add(elementActions.doGetText(btnCreateTicketInCreateTicketPopup));
		actualTexts.add(elementActions.doGetText(btnCancelTicketInCreateTicketPopup));

		return actualTexts;
	}

	@Step("verify Search FIeld is Visible and in enabled state")
	public boolean verifySearchFIeldisVisibleAndEnabled() {

		return elementActions.doIsDisplayed(inpSearchTicket) && elementActions.doIsEnabled(inpSearchTicket);
	}

	@Step("Enter search value and verify No Data message is displayed")
	public String searchTicketAndVerifyNoDataDisplayed(String searchValue) {

		elementActions.waitForElementVisible(inpSearchTicket);
		elementActions.doClearTextbox(inpSearchTicket);
		elementActions.doSendKeys(inpSearchTicket, searchValue);
		elementActions.waitForElementVisible(lblNoDataDisplay);

		return elementActions.doGetText(lblNoDataDisplay);
	}

	@Step("Enter search value and verify No Data message is displayed")
	public String searchTicketWhenNoTicketsAndVerifyNoDataDisplayed(String searchValue) {

		String paginationText = elementActions.doGetText(paginationcountLabel);
		String lblNoDataDisplayText = elementActions.doGetText(paginationcountLabel);

		if (Integer.parseInt(paginationText.replaceAll(".*of\\s*", "").trim()) == 0) {

			lblNoDataDisplayText = searchTicketAndVerifyNoDataDisplayed(searchValue);
		}
		return lblNoDataDisplayText;
	}

	@Step("creation of ticket")
	public void createTicket(String ticketTitle, String Description) throws InterruptedException {
		clickOnHelpAndSupportScreen();
		clickOnCreateTicketButton();
		elementActions.doActionsSendKeys(inpTitleInInCreateTicketPopup, ticketTitle);
		elementActions.doActionsSendKeys(inpDescriptionInCreateTicketPopup, Description);
		elementActions.doActionsClick(btnCreateTicketInCreateTicketPopup);
	}

	@Step("Enter search value and verify No Data message is displayed")
	public boolean createTicketModalIsDisplayed() {

		return elementActions.doIsDisplayed(createTicketModalPopup);
	}

	@Step("verify Create Ticket Modal title")
	public String verifyCreateTicketModaltitle() {

		return elementActions.doGetText(lblCreateTicketPopupHeader);
	}

	@Step("verify Create Ticket with no data")
	public List<String> verifyCreateTicketWithNoData() {
		elementActions.doActionsClick(btnCreateTicketInCreateTicketPopup);
		return Arrays.asList(elementActions.doGetText(msgErrorForTitleInputField),
				elementActions.doGetText(msgErrorForDescriptionInputField));

	}

	@Step("Verify Cancel button functionality")
	public boolean VerifyCancelButtonFunctionality() {
		elementActions.doClick(btnCancelTicketInCreateTicketPopup);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elementActions.doIsDisplayed(createTicketModalPopup);

	}

	@Step("Verify close button functionality")
	public boolean VerifyCloseButtonFunctionality() {
		elementActions.doClick(btnCloseTicketInCreateTicketPopup);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elementActions.doIsDisplayed(createTicketModalPopup);

	}

	@Step("Verify Priority Selection")
	public boolean VerifyPrioritySelection() {

		boolean isSelectedLowPriority = elementActions.doIsSelected(rdoLowPriorityInCreateTicketPopup);

		elementActions.doActionsClick(rdoMediumPriorityInCreateTicketPopup);
		boolean isSelectedMediumPriority = elementActions.doIsSelected(rdoMediumPriorityInCreateTicketPopup);
		elementActions.doActionsClick(rdoHighPriorityInCreateTicketPopup);

		boolean isSelectedHignPriority = elementActions.doIsSelected(rdoHighPriorityInCreateTicketPopup);

		return isSelectedLowPriority && isSelectedMediumPriority && isSelectedHignPriority;
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify the Logout
	 * functionality
	 */

	@Step("Verify the Logout functionality")
	public void logoutConfirmDialog() throws InterruptedException {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from side panel");
		elementActions.doIsDisplayed(logoutYesBtn);
		extentReport.logToExtentReport("Yes button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(logoutNoBtn);
		extentReport.logToExtentReport("No button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(logoutClose);
		extentReport.logToExtentReport("Close button is displayed on logout confirmation dialog");
		elementActions.doClick(logoutClose);
		extentReport.logToExtentReport("Clicked on Close button");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify the User can logout
	 * from app if clicking yes
	 */
	@Step("Verify the User can logout from app if clicking yes")
	public void logoutFunctionality() throws InterruptedException {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from side panel");
		Thread.sleep(2000);
		elementActions.doClick(logoutYesBtn);
		extentReport.logToExtentReport("Yes button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(Username);
		extentReport.logToExtentReport("No button is displayed on logout confirmation dialog");
	}
}