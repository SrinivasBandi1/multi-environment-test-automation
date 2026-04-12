package com.intelehealth.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class MessagesPage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();
	By lnkMessages = By.xpath("//a[@data-test-id='linkMessages']");
	By hdrMessages = By.xpath("//h6[@data-test-id='headerTitle']");
	By icnMessages = By.xpath("//img[@data-test-id='headerImg']");
	By hdrPatients = By.xpath("//div[@data-test-id='lblPatientsTitle']");
	By inpSearch = By.xpath("//input[@data-test-id='etSearchPatientName']");
	By lstPatientsNames = By.xpath("//h6[@data-test-id='lblPatientName']");
	By lblNoMessagesSelected = By.xpath("//h6[@data-test-id='lblNoChatTitle']");
	By lblNoMessagesSelectedDescription = By.xpath("//p[@data-test-id='lblNoChatDescription']");
	By lstPreviewMessages = By.xpath("//p[@data-test-id='lblLastMessage']");
	By lblPatientName = By.xpath("//h6[@data-test-id='lblChatPatientName']");
	By lblCHWName = By.xpath("//span[@data-test-id='lblChatCHW']");
	By lblMessages = By.xpath("//h6[@data-test-id='headerTitle']");
	By lblSentMessage = By.xpath("//li[contains(@data-test-id,'lblMessage-')]");
	By inpSendAMessage = By.xpath("//input[@data-test-id='etSendMessage1']");
	By lblMessageReadStatus = By.xpath("//img[contains(@data-test-id,'iconRead')]/following-sibling::span");

	By drpDate = By.xpath("//ng-select[@data-test-id='selectVisit']//div");
	By btnSendMessage = By.xpath("//button[@data-test-id='etSendMessage2']");
	By lblNoRecordsFound = By.xpath("//li[@data-test-id='lblNoPatientFound']//p");

	public MessagesPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	@Step("Get Message Page Labels ")
	public List<String> getMessagePagelabels() {
		elementActions.doClick(lnkMessages);
		List<String> actualTexts = new ArrayList<>();
		actualTexts.add(elementActions.doGetText(hdrMessages));
		actualTexts.add(elementActions.doGetText(hdrPatients));
		// actualTexts.add(elementActions.doGetText(lblPatientsName));
		actualTexts.add(elementActions.doGetText(lblNoMessagesSelected));
		actualTexts.add(elementActions.doGetText(lblNoMessagesSelectedDescription));
		return actualTexts;
	}

	@Step("Get Message Page fields ")
	public boolean getMessagePageFields() {
		elementActions.doClick(lnkMessages);
		return elementActions.doIsDisplayed(icnMessages) && elementActions.doIsDisplayed(inpSearch);
	}

	@Step("Get Message Page fields ")
	public boolean isDisplayedPatientsListAlongWithPreviewMessage() {
		elementActions.doClick(lnkMessages);
		return elementActions.doIsDisplayedElementList(lstPatientsNames)
				&& elementActions.doIsDisplayedElementList(lstPreviewMessages);
	}

	@Step("Verify Search by Patient Name")
	public boolean verifySearchPatientName() {
		elementActions.doClick(lnkMessages);
		String patientName = elementActions.doGetText(lstPatientsNames).split("\\(")[0].trim();
		elementActions.doActionsSendKeys(inpSearch, patientName);
		System.out.println(elementActions.doGetText(lstPatientsNames));
		return elementActions.doGetText(lstPatientsNames).contains(patientName);
	}

	@Step("Verify Search by Patient OpenMRSID")
	public boolean verifySearchPatientOpenMRSID() {
		elementActions.doClick(lnkMessages);
		// String patientNameAndID =
		// elementActions.doGetText(lstPatientsNames).split("\\(")[1];
		String patientNameAndID = elementActions.doGetText(lstPatientsNames).split("\\(")[1];
		String OpenMRSID = patientNameAndID.substring(0, patientNameAndID.length() - 1);
		elementActions.doActionsSendKeys(inpSearch, OpenMRSID);

		return elementActions.doGetText(lstPatientsNames).contains(patientNameAndID);

	}

	@Step("Verify Opening a Patient Conversation")
	public boolean verifyOpeningAPatientConversation() {
		elementActions.doClick(lnkMessages);
		String patientName = elementActions.doGetText(lstPatientsNames).split("\\(")[0];
		elementActions.doClick(lstPatientsNames);
		System.out.println(elementActions.doGetText(lblPatientName));
		System.out.println(elementActions.doGetText(lblPatientName).contains(patientName));
		System.out.println(elementActions.doIsDisplayed(lblCHWName));

		return elementActions.doGetText(lblPatientName).contains(patientName)
				&& elementActions.doIsDisplayed(lblCHWName);
		// String patientName = elementActions.doGetText(lstPatientsNames).split(
		// "(")[0];elementActions.doClick(lstPatientsNames);return
		// elementActions.doGetText(lblPatientName).equals(patientName)&&elementActions.doIsDisplayed(lblCHWName);

	}

	public boolean verifyMessageHistoryIsDisplayed() {
		elementActions.doClick(lnkMessages);
		elementActions.doClick(lstPatientsNames);
		return elementActions.doIsDisplayed(lblMessages);

	}

	@Step("Verify Sending a Text Message")

	public boolean verifySendingATextMessage(String message) {
		elementActions.doClick(lnkMessages);
		elementActions.doClick(lstPatientsNames);
		elementActions.doActionsSendKeys(inpSendAMessage, message);
		elementActions.doClick(btnSendMessage);
		return elementActions.doGetText(lblSentMessage).contains(message);
	}

	@Step("Verify Sent Message Status Is Updated")

	public String verifySentMessageStatusIsUpdated(String message) {
		elementActions.doClick(lnkMessages);
		elementActions.doClick(lstPatientsNames);
		elementActions.doActionsSendKeys(inpSendAMessage, message);
		elementActions.doClick(btnSendMessage);
		return elementActions.doGetText(lblMessageReadStatus);
	}

	@Step("Verify Message Date Display")

	public boolean verifyMessageDateDisplay(String message) {
		elementActions.doClick(lnkMessages);
		elementActions.doClick(lstPatientsNames);
		elementActions.doActionsSendKeys(inpSendAMessage, message);
		elementActions.doClick(btnSendMessage);
		String visitDateText = elementActions.doGetText(drpDate).trim();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
		LocalDate visitDate = LocalDate.parse(visitDateText, formatter);
		LocalDate todayDate = LocalDate.now();

		return visitDate.equals(todayDate);
	}

	@Step("Verify Search with Invalid Patient OpenMRSID")

	public String VerifySearchWithInvalidPatientOpenMRSID(String InvalidOpenMRSID) {
		elementActions.doClick(lnkMessages);
		elementActions.doActionsSendKeys(inpSearch, InvalidOpenMRSID);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elementActions.doGetText(lblNoRecordsFound);

	}

	@Step("Verify Search with Invalid Patient Name")

	public String VerifySearchWithInvalidPatientName(String InvalidName) {

		return VerifySearchWithInvalidPatientOpenMRSID(InvalidName);

	}

	@Step("Verify Sending an Empty Message Is Not Allowed")
	public void VerifySendingAnEmptyMessageIsNotAllowed() {
		elementActions.doClick(lnkMessages);
		elementActions.doActionsSendKeys(inpSearch, "");

//write logic for error message currently error msg is not displaying
	}
}