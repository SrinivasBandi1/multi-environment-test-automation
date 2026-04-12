package com.intelehealth.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class ProfilePage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By userName = By.xpath("//input[@data-test-id='etUsername']");
	By password = By.xpath("//input[@data-test-id='etPassword']");
	By NxtButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By Minmzepanel = By.xpath("//button[@data-test-id='btnToggleSidenav']");
	By profileName = By.xpath("//div[@data-test-id='navProfile']");
	By FirstNameTextbox = By.xpath("//input[@data-test-id='etGivenName']");
	By MiddleNameTextbox = By.xpath("//input[@data-test-id='etMiddleName']");
	By LastNameTextbox = By.xpath("//input[@data-test-id='etFamilyName']");
	By GenderMale = By.xpath("//input[@data-test-id='rdGenderMale']");
	By PhoneNumber = By.xpath("//input[@data-test-id='etPhoneNumber']");
	By WhatsappNumber = By.xpath("//input[@data-test-id='etWhatsAppNumber']");
	By emailID = By.xpath("//input[@data-test-id='etEmail']");
	By SignatureLetters = By.xpath("//input[@data-test-id='etSignature']");
	By NextButton = By.xpath("//button[@data-test-id='btnNext']");
	By SaveButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By SelectSignature = By.xpath("//ng-select[@data-test-id='etSignatureFont']");
	By Signature1 = By.xpath("(//p[@data-test-id='fontOption'])[1]");
	By ProfilePictureUploadIcon = By.xpath("//img[@data-test-id='imgCamera']");
	By CalendarIcon = By.xpath("//mat-datepicker-toggle[@data-test-id='dpBirthdate']");
	By CalendarYeardropdown = By.xpath("//div[@class='mat-calendar-arrow']");
	By CalenderSelectFirstOption = By.xpath("(//td[@role='gridcell'])[1]");

	// Constructor of page class:
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify user can update the
	 * First name , Middle name and Last name, Gender, DOB fields
	 */
	@Step("Verify user can update the First name , Middle name and Last name, Gender, DOB fields")
	public void VerifyProfilePageUpdate() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(Minmzepanel);
		elementActions.doClick(profileName);
		extentReport.logToExtentReport("Clicked on User Profile Name");
		elementActions.doClearTextbox(FirstNameTextbox);
		elementActions.doSendKeys(FirstNameTextbox, "Automation");
		extentReport.logToExtentReport("Updated first name");
		elementActions.doClearTextbox(MiddleNameTextbox);
		elementActions.doSendKeys(MiddleNameTextbox, "Testing");
		extentReport.logToExtentReport("Updated Middle Name");
		elementActions.doClearTextbox(LastNameTextbox);
		elementActions.doSendKeys(LastNameTextbox, "intelehealth");
		extentReport.logToExtentReport("Updated Last Name");
		elementActions.doSelect(GenderMale);
		extentReport.logToExtentReport("Gender Male selected");
		elementActions.doClearTextbox(PhoneNumber);
		elementActions.doSendKeys(PhoneNumber, "1233567890");
		extentReport.logToExtentReport("Updated Phone Number");
		elementActions.doClearTextbox(WhatsappNumber);
		elementActions.doSendKeys(WhatsappNumber, "1987654321");
		extentReport.logToExtentReport("Updated Whatsapp Number");
		elementActions.doClearTextbox(emailID);
		elementActions.doSendKeys(emailID, "doctor1@gmail.com");
		extentReport.logToExtentReport("Updated email ID");
		elementActions.doClearTextbox(SignatureLetters);
		elementActions.doSendKeys(SignatureLetters, "Dr Automation");
		extentReport.logToExtentReport("Updated Signature Letters");
		elementActions.doClick(NextButton);
		extentReport.logToExtentReport("Clicked on Next Button");
		elementActions.doClick(SaveButton);
		extentReport.logToExtentReport("Clicked on Save Button");
		String ProfileName = elementActions.doGetText(profileName);
		assertEquals(ProfileName, "Hello, Automation Testing intelehealth");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user can
	 * select the signature from dropdown
	 */
	@Step("Verify that user can select the signature from dropdown")
	public void VerifyProfilePageSignatureUpdate() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doSendKeysEnter(profileName);
		extentReport.logToExtentReport("Clicked on User Profile Name");

		elementActions.doClick(SelectSignature);
		extentReport.logToExtentReport("Clicked on Select Signature dropdown");
		Thread.sleep(4000);
		elementActions.doClick(Signature1);
		extentReport.logToExtentReport("select first signature from dropdown");

		elementActions.doClick(NextButton);
		extentReport.logToExtentReport("Clicked on Next Button");

		elementActions.doClick(SaveButton);
		extentReport.logToExtentReport("Clicked on Save Button");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user can
	 * select the signature from dropdown
	 */
	@Step("Verify that user can add signature by Uploading jpg, jpeg and png images between 5kb to 50kb sizes.")
	public void VerifyProfilePictureUpdate() throws InterruptedException, IOException {
		Thread.sleep(3000);
		elementActions.doClick(Minmzepanel);
		elementActions.doClick(profileName);
		extentReport.logToExtentReport("Clicked on User Profile Name");
//		    elementActions.doClick(ProfilePictureIcon);
//		    extentReport.logToExtentReport("Clicked on Profile picture icon");

		// Find the file input element on the web page (replace with the actual element
		// selector)
		WebElement fileInput = driver.findElement(By.className("file-input-con")); // Replace with the actual
																					// element locator

		// Specify the path to the image file you want to upload
		String imagePath = "C:\\Users\\Rajesh\\Desktop\\profile_picture.jpg"; // Replace with the actual path

		// Send the path to the image file to the file input element
		fileInput.sendKeys(imagePath);

		Thread.sleep(10000);
		// Optional: Add code to wait for the upload to complete and verify the uploaded
		// image size/format

	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user can
	 * select the signature from dropdown
	 */
	@Step("Verify that user can select the signature from dropdown")
	public void VerifyProfileUpdate() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(Minmzepanel);
		elementActions.doClick(profileName);
		extentReport.logToExtentReport("Clicked on User Profile Name");
		elementActions.doClick(SelectSignature);
		extentReport.logToExtentReport("Clicked on Select Signature dropdown");
		elementActions.doClick(CalendarIcon);
		extentReport.logToExtentReport("Clicked on Calendar Icon");
		elementActions.doClick(CalendarYeardropdown);
		extentReport.logToExtentReport("Clicked on Calendar Year dropdown");
		elementActions.doClick(CalenderSelectFirstOption);
		extentReport.logToExtentReport("Clicked on First Year option from table");
		elementActions.doClick(CalenderSelectFirstOption);
		extentReport.logToExtentReport("Clicked on First Month option from table");
		elementActions.doClick(CalenderSelectFirstOption);
		extentReport.logToExtentReport("Clicked on First Date option from table");
		elementActions.doSelect(GenderMale);
		extentReport.logToExtentReport("Gender Male selected");
		elementActions.doClearTextbox(PhoneNumber);
		elementActions.doSendKeys(PhoneNumber, "1233567890");
		extentReport.logToExtentReport("Updated Phone Number");
		elementActions.doClearTextbox(WhatsappNumber);
		elementActions.doSendKeys(WhatsappNumber, "1987654321");
		extentReport.logToExtentReport("Updated Whatsapp Number");
		elementActions.doClearTextbox(emailID);
		elementActions.doSendKeys(emailID, "doctor1@gmail.com");
		extentReport.logToExtentReport("Updated email ID");
		elementActions.doClick(SelectSignature);
		extentReport.logToExtentReport("Click on signature dropdown");
		elementActions.doClick(Signature1);
		extentReport.logToExtentReport("select first signature from dropdown");
		elementActions.doClick(NextButton);
		extentReport.logToExtentReport("Clicked on Next Button");
		elementActions.doClick(SaveButton);
		extentReport.logToExtentReport("Clicked on Save Button");
	}
}
