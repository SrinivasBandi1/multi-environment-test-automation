package com.intelehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class ForgotUsernamePasswordPage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By UsernameTextbox = By.xpath("//input[@data-test-id='etUsername']");
	By PasswordTextbox = By.xpath("//input[@data-test-id='etPassword']");
	By NextButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By ForgotuserName = By.xpath("//a[@data-test-id='linkForgotUsername']");
	By Forgotpassword = By.xpath("//a[@data-test-id='linkForgotPassword']");
	By MobileNumberTab = By.xpath("//a[@data-test-id='navMobile']");
	By EmailTab = By.xpath("//a[@data-test-id='navEmail']");
	By MobileNumberTextbox = By.xpath("//input[@data-test-id='etMobile']");
	By EmailTextbox = By.xpath("//input[@data-test-id='etEmail']");
	By MobileTabNextButton = By.xpath("//button[@data-test-id='btnSubmitMobile']");
	By EmailTabNextButton = By.xpath("//button[@data-test-id='btnSubmitEmail']");
	By OTPVerificationPage = By.xpath("//h6[text()='OTP verification']");
	By OTPInputTextbox = By.xpath("//ng-otp-input[@data-test-id='etOtpInput']");
	By OTPResendLink = By.xpath("//a[@data-test-id='linkResend']");
	By OTPVerifyButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By OTPSuccessfullVerificationPopup = By.xpath("//div[contains(text(),'OTP sent on ')]");
	// Constructor of page class:
	public ForgotUsernamePasswordPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user gets the
	 * Forgot username screen on clicking the link
	 */
	@Step("Verify that user gets the Forgot username screen on clicking the link")
	public void VerifyForgotUsernamePage() throws InterruptedException {
		elementActions.doClick(ForgotuserName);
		extentReport.logToExtentReport( "Clicked on Forgot Username Link");
		elementActions.doIsDisplayed(MobileNumberTab);
		extentReport.logToExtentReport( "Mobile Number tab is displayed");
		elementActions.doIsDisplayed(MobileNumberTextbox);
		extentReport.logToExtentReport( "Mobile Number textbox is displayed");
		elementActions.doIsDisplayed(MobileTabNextButton);
		extentReport.logToExtentReport( "Next Button of Mobile Tab is displayed");
		elementActions.doIsDisplayed(EmailTab);
		extentReport.logToExtentReport( "Email tab is displayed");
		elementActions.doClick(EmailTab);
		extentReport.logToExtentReport( "Clicked on EmailTab");
		elementActions.doIsDisplayed(EmailTextbox);
		extentReport.logToExtentReport( "Email ID textbox is displayed");
		elementActions.doIsDisplayed(EmailTabNextButton);
		extentReport.logToExtentReport( "Next Button of Email tab is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user gets the
	 * Forgot username screen on clicking the link
	 */
	@Step("Verify that user gets the Forgot username screen on clicking the link")
	public void VerifyForgotUsernameMobileNumber() throws InterruptedException {
		elementActions.doClick(ForgotuserName);
		extentReport.logToExtentReport( "Clicked on Forgot Username Link");
		elementActions.doClick(MobileNumberTab);
		extentReport.logToExtentReport( "Clicked on Mobile Number tab");
		Thread.sleep(3000);
		elementActions.doSendKeys(MobileNumberTextbox, "9916701662");
		extentReport.logToExtentReport( "Entered Mobile Number in Mobile Number textbox");
		elementActions.doClick(MobileTabNextButton);
		extentReport.logToExtentReport( "Clicked on Next Button of Mobile Tab");
		elementActions.doIsDisplayed(OTPSuccessfullVerificationPopup);
		extentReport.logToExtentReport( "OTP Successfull Verification popup is displayed");
		elementActions.doIsDisplayed(OTPVerificationPage);
		extentReport.logToExtentReport( "OTP Verification is displayed");
		elementActions.doIsDisplayed(OTPInputTextbox);
		extentReport.logToExtentReport( "OTP Input fields are displayed");
		elementActions.doIsDisplayed(OTPVerifyButton);
		extentReport.logToExtentReport( "OTP Verify Button are displayed");
		
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user gets OTP
	 * sent successfull popup
	 */
	@Step("Verify that user gets OTP sent successfull popup")
	public void VerifyOTPVerificationSuccessPopup() throws InterruptedException {
		elementActions.doIsDisplayed(OTPSuccessfullVerificationPopup);
		extentReport.logToExtentReport( "Verification: OTP sent success message is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify Resend link from
	 * Mobile Number tab
	 */
	@Step("Verify Resend link from Mobile Number tab")
	public void VerifyResendLink() throws InterruptedException {
		Thread.sleep(62000);
		extentReport.logToExtentReport( "Waited for 60secs for Resend link to activate");
		elementActions.doIsDisplayed(OTPResendLink);
		extentReport.logToExtentReport( "OTP Resend Link");
		elementActions.doClick(OTPResendLink);
		extentReport.logToExtentReport( "Clicked on OTP Resend Link");
		elementActions.doIsDisplayed(OTPSuccessfullVerificationPopup);
		extentReport.logToExtentReport( "Verification: OTP sent success message is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify user entering valid
	 * Email ID and clicking Next
	 */
	@Step("Verify user entering valid Email ID and clicking Next")
	public void VerifyForgotUsernameEmailID() throws InterruptedException {
		elementActions.doClick(ForgotuserName);
		extentReport.logToExtentReport( "Clicked on Forgot Username Link");
		elementActions.doClick(EmailTab);
		extentReport.logToExtentReport( "Clicked on Email Tab");
		Thread.sleep(3000);
		elementActions.doSendKeys(EmailTextbox, "rajesh.shivanand@gmail.com");
		extentReport.logToExtentReport( "Entered email ID in email textbox");
		elementActions.doClick(EmailTabNextButton);
		extentReport.logToExtentReport( "Clicked on Next Button of Email Tab");
		elementActions.doIsDisplayed(OTPVerificationPage);
		extentReport.logToExtentReport( "OTP Verification is displayed");
		elementActions.doIsDisplayed(OTPInputTextbox);
		extentReport.logToExtentReport( "OTP Input fields are displayed");
		elementActions.doIsDisplayed(OTPVerifyButton);
		extentReport.logToExtentReport( "OTP Verify Button are displayed");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify user entering valid
	 * Email ID and clicking Next
	 */
	@Step("Verify user entering valid Email ID and clicking Next")
	public void VerifyForgotPassword() throws InterruptedException {
		elementActions.doClick(Forgotpassword);
		extentReport.logToExtentReport( "Clicked on Forgot Password Link");
		elementActions.doIsDisplayed(UsernameTextbox);
		extentReport.logToExtentReport( "Username Textbox is displayed");
		elementActions.doIsDisplayed(ForgotuserName);
		extentReport.logToExtentReport( "Forgot Username link is displayed");
		elementActions.doIsDisplayed(NextButton);
		extentReport.logToExtentReport( "Next Button is displayed");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify user entering valid
	 * Email ID and clicking Next
	 */
	@Step("Verify user entering valid Email ID and clicking Next")
	public void VerifyForgotPasswordByUsernameNext(String username) throws InterruptedException {
		elementActions.doClick(Forgotpassword);
		extentReport.logToExtentReport( "Clicked on Forgot Password Link");
		elementActions.doIsDisplayed(ForgotuserName);
		extentReport.logToExtentReport( "Forgot Username link is displayed");
		elementActions.doSendKeys(UsernameTextbox, username);
		extentReport.logToExtentReport( "Entered username in Username Textbox");
		elementActions.doClick(NextButton);
		extentReport.logToExtentReport( "Click on Next button");
		elementActions.doIsDisplayed(OTPInputTextbox);
		extentReport.logToExtentReport( "Verified: OTP Textbox");
		elementActions.doIsDisplayed(OTPVerifyButton);
		extentReport.logToExtentReport( "Verified: OTP Verify button");
		Thread.sleep(62000);
		extentReport.logToExtentReport( "Wait 60 seconds to generate resend link");
		elementActions.doIsDisplayed(OTPResendLink);
		extentReport.logToExtentReport( "Verified: OTP Resend Link button");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify the Resend functionality
	 */
	@Step("Verify user entering valid Email ID and clicking Next")
	public void VerifyForgotPasswordResendLink(String username) throws InterruptedException {
		elementActions.doClick(Forgotpassword);
		extentReport.logToExtentReport( "Clicked on Forgot Password Link");
		elementActions.doSendKeys(UsernameTextbox, username);
		extentReport.logToExtentReport( "Entered Username in Username textbox");
		elementActions.doClick(NextButton);
		extentReport.logToExtentReport( "Next Button is Clicked");
		Thread.sleep(62000);
		elementActions.doClick(OTPResendLink);
		extentReport.logToExtentReport( "Clicked on resend link");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 Description: Verify that user is able to Login using new password
	 */
	@Step("Verify that user is able to Login using new password")
	public void VerifyUserLogin() throws InterruptedException {
		elementActions.doSendKeys(UsernameTextbox, "doctor1");
		extentReport.logToExtentReport( "Entered Usernamein Username textbox");
		elementActions.doSendKeys(PasswordTextbox, "Doctor@123");
		extentReport.logToExtentReport( "Entered Password in Password textbox");
		elementActions.doClick(NextButton);
		extentReport.logToExtentReport( "Next Button is Clicked");
	}
}
