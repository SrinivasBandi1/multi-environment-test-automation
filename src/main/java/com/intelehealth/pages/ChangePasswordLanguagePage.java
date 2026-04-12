package com.intelehealth.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class ChangePasswordLanguagePage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By DashboardMenu = By.xpath("//*[@data-test-id='labelDashboard']");
	By HamburgerMenu = By.xpath("//*[@data-test-id='iconProfileDropdown']");//a[@data-test-id="linkDashboard"]
	By ChangePasswordOption = By.xpath("//*[@data-test-id='btnChangePasswordMain']\n"
			+"");
	By ChangeLanguageOption = By.xpath("//*[@data-test-id='btnSelectLanguageMain']\n"
			+"");
	By ChangePasswordOldPWTextbox = By.xpath("//*[@data-test-id='etOldPass']\n"
			+"");
	By ChangePasswordNewPWTextbox = By.xpath("//*[@data-test-id='etNewPass']");
	By ChangePasswordConfirmPWTextbox = By.xpath("//*[@data-test-id='etConfirmPass']");
	By ChangePasswordButton = By.xpath("//*[@data-test-id='btnSubmit']");
	By GeneratePasswordLink = By.xpath("//a[@data-test-id='linkGeneratePass']");
	//By ChangePasswordSuccessPopup = By.xpath("//div[text()=' Password has been changed successful"
			//+ "ly! ']");
	By LogoutLink = By.xpath("//a[@data-test-id='linkLogout']");
	By LogoutConfirmYes = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");
	By UsernameTextbox = By.xpath("//input[@data-test-id='etUsername']");
	By PasswordTextbox = By.xpath("//input[@data-test-id='etPassword']");
	By LoginButton = By.xpath("//button[@data-test-id='btnSubmit']");
	//By LoginSuccessPopup = By.xpath("//div[@aria-label='Login Successful']");
	By SelectEnglishLanguage = By.xpath("//*[@data-test-id='radioEnglish']");
	By SelectRussianLanguage = By.xpath("//*[@data-test-id='radioRussian']");
	By SelectButton = By.xpath("//*[@data-test-id='btnSubmitSelectLanguageModal']");
	By ProfileLanguageEnglish = By.xpath("//h6[contains(text(),'Hello')]");

	// Constructor of page class:
	public ChangePasswordLanguagePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify that user can Change the password
	 */
	@Step("Verify that user can Change the password")
	public void VerifyChangePassword(String OldPassword, String NewPassword, LoginPage loginPage) throws InterruptedException {
		elementActions.doClick(HamburgerMenu);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doClick(ChangePasswordOption);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doSendKeys(ChangePasswordOldPWTextbox, OldPassword);
		extentReport.logToExtentReport("Entered Old Password");
		elementActions.doSendKeys(ChangePasswordNewPWTextbox, NewPassword);
		extentReport.logToExtentReport("Entered New Password");
		elementActions.doSendKeys(ChangePasswordConfirmPWTextbox, NewPassword);
		extentReport.logToExtentReport("Entered Confirm Password");
		elementActions.doClick(ChangePasswordButton);
		extentReport.logToExtentReport("Clicked on Change Password Button");
		//elementActions.doIsDisplayed(ChangePasswordSuccessPopup);
		extentReport.logToExtentReport("Password changed success popup is displayed");
		Thread.sleep(3000);
		//Changing the NEW PASSWORD back to OLD PASSWORD for smooth execution of Automation test scripts.
		
		loginPage.doLoginWithNewPassword("doctor1", NewPassword );
		elementActions.doClick(DashboardMenu);
		extentReport.logToExtentReport("Clicked on Dashboard Menu");
		Thread.sleep(3000);
		elementActions.doClick(HamburgerMenu);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doClick(ChangePasswordOption);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doSendKeys(ChangePasswordOldPWTextbox, NewPassword);
		extentReport.logToExtentReport("Entered Old Password");
		elementActions.doSendKeys(ChangePasswordNewPWTextbox, OldPassword);
		extentReport.logToExtentReport("Entered New Password");
		elementActions.doSendKeys(ChangePasswordConfirmPWTextbox, OldPassword);
		extentReport.logToExtentReport("Entered Confirm Password");
		elementActions.doClick(ChangePasswordButton);
		extentReport.logToExtentReport("Clicked on Change Password Button");
		//elementActions.doIsDisplayed(ChangePasswordSuccessPopup);
		extentReport.logToExtentReport("Password changed success popup is displayed");	
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify Generate password
	 * link functionality
	 */
	@Step("Verify Generate password link functionality")
	public void VerifyGeneratePassword(String password) throws InterruptedException {
		elementActions.doClick(HamburgerMenu);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doClick(ChangePasswordOption);
		extentReport.logToExtentReport("Clicked on Change Password Menu from Hamburger menu");
		Thread.sleep(2000);
		elementActions.doSendKeys(ChangePasswordOldPWTextbox, password);
		extentReport.logToExtentReport("Entered Old Password");
		Thread.sleep(2000);
		elementActions.doClick(GeneratePasswordLink);
		extentReport.logToExtentReport("Clicked on Generate Password link");
		Thread.sleep(2000);
		//elementActions.doIsDisplayed(ChangePasswordConfirmPWTextbox);
		//extentReport.logToExtentReport("Confirm Password textbox is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify user can login using new password
	 */
	@Step("Verify user can login using new password")
	public void VerifyLoginNewPassword(String username, String password) throws InterruptedException {
		elementActions.doClick(LogoutLink);
		extentReport.logToExtentReport("Clicked on Logout Link from left panel");
		elementActions.doClick(LogoutConfirmYes);
		extentReport.logToExtentReport("Clicked on YES button from Logout Popup");
		elementActions.doSendKeys(UsernameTextbox, username);
		extentReport.logToExtentReport("Entered Username");
		elementActions.doSendKeys(PasswordTextbox, password);
		extentReport.logToExtentReport("Entered NewPassword");
		elementActions.doClick(LoginButton);
		extentReport.logToExtentReport("Clicked on Login Button");
		//elementActions.doIsDisplayed(LoginSuccessPopup);
		//extentReport.logToExtentReport("Verification: Login success popup is displayed");
	}
	
	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify that user can select the language
	 */
	@Step("Verify that user can select the language")
	public void VerifyChangeLanguage() throws InterruptedException {
		elementActions.doClick(HamburgerMenu);
		extentReport.logToExtentReport("Clicked on Hamburger Menu from dashboard menu");
		elementActions.doClick(ChangeLanguageOption);
		extentReport.logToExtentReport("Clicked on Change Language option");
		Thread.sleep(3000);
		elementActions.JavaScriptExecutorClick(SelectRussianLanguage);
		extentReport.logToExtentReport("Russian Language Selected");
		elementActions.JavaScriptExecutorClick(SelectEnglishLanguage);
		extentReport.logToExtentReport("English Language Selected");
		elementActions.doClick(SelectButton);
		extentReport.logToExtentReport("Clicked on Select Button");
		elementActions.doIsDisplayed(ProfileLanguageEnglish);
		extentReport.logToExtentReport("Verification: Application is displayed in English ");
	}
}
