package com.intelehealth.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

public class ChatPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By appointmentLink = By.xpath("//*[@data-test-id='appointment-count']\n"
			+"");
	By awtvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-Awaiting-0']"
			+"");
	By vstsumpatientVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By vstsumpatientChatIcon = By.xpath("//img[@data-test-id='imgStartChat']");
	By chatPatientName = By.xpath("\n"
			+ "//*[@data-test-id='lblChatBoxPatientName']");
	By chatPatientID = By.xpath("\n"
			+ "//*[@data-test-id='lblChatBoxPatientId']\n"
			+ "");
	By chatTypeTextbox = By.xpath("//input[@data-test-id='etChatMessageChatBox']");
	By chatSendButton = By.xpath("//button[@data-test-id='btnSendMessageChatBox']");
	By chatCloseButton = By.xpath("//button[@data-test-id='btnCloseChatBox']");
	By chatSentMessage = By.xpath("//li[@class='chat-message right ng-star-inserted']");
	By loginSuccessClose = By.xpath("//button[@aria-label='Close']");
	By startvisit = By.xpath("//button[@data-test-id='btnStartVisitNote']");

	


	
	
	// Constructor of page class:
	public ChatPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify chat option visibility
	 */
	@Step("Verify Chat option is displayed")
	public void chatOptionvisibility() throws InterruptedException {
        Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		elementActions.doClick(startvisit);
		elementActions.doIsDisplayed(vstsumpatientVideoIcon);
		extentReport.logToExtentReport("Verification: Video icon is displayed");
		elementActions.doIsDisplayed(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Verification: Chat icon is displayed");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify chat option visibility
	 */
	@Step("Verify chat option functionality in visit summary page")
	public void chatOptionfunctionality() throws InterruptedException {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", awtvstPatient1Name);
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(3000);
		elementActions.doClick(startvisit);
		elementActions.doClick(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Clicked on Chat icon");
		elementActions.doIsDisplayed(chatPatientID);
		extentReport.logToExtentReport("Patient ID is displayed on Chat Page");
		elementActions.doIsDisplayed(chatPatientName);
		extentReport.logToExtentReport("Patient Name is displayed on Chat Page");
		elementActions.doIsDisplayed(chatTypeTextbox);
		extentReport.logToExtentReport("Type here textbox is displayed on Chat Page");
		elementActions.doIsDisplayed(chatSendButton);
		extentReport.logToExtentReport("send button is displayed on Chat Page");
		elementActions.doIsDisplayed(chatCloseButton);
		extentReport.logToExtentReport("close button is displayed on Chat Page");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify sending message in chat
	 */
	@Step("Verify sending message in chat")
	public void chatSendMessage() throws InterruptedException {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", awtvstPatient1Name);
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(3000);
		elementActions.doClick(startvisit);
		elementActions.doClick(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Clicked on chat icon");
		elementActions.doSendKeys(chatTypeTextbox, "hi");
		extentReport.logToExtentReport("Type message in chat Textbox");
		elementActions.doClick(chatSendButton);
		extentReport.logToExtentReport("Clicked on Send button");
		elementActions.doIsDisplayed(chatSentMessage);
		extentReport.logToExtentReport("Verification: Message sent is displayed");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify whether Health worker able to click on the PN when doctor send a chat msg
	 */
	@Step("Verify whether HW able to click on the PN when doctor send a chat msg")
	public void chatSendMessagetoHW() throws InterruptedException {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", awtvstPatient1Name);
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(3000);
		elementActions.doClick(startvisit);
		elementActions.doClick(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Clicked on chat icon");
		elementActions.doSendKeys(chatTypeTextbox, "hi");
		extentReport.logToExtentReport("Type message in chat Textbox");
		elementActions.doClick(chatSendButton);
		extentReport.logToExtentReport("Clicked on Send button");
		elementActions.doIsDisplayed(chatSentMessage);
		extentReport.logToExtentReport("Verification: Message sent is displayed");
		extentReport.logToExtentReport("NOTE: Verification from Mobile app is not automated");
	}
	
}