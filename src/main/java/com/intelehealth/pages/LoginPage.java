package com.intelehealth.pages;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.intelehealth.base.BasePage;
import com.intelehealth.util.AppConstants;
import com.intelehealth.util.ElementActions;
import com.intelehealth.util.Credentials;
import com.intelehealth.listeners.ExtentReportListener;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	ExtentReportListener extentReport = new ExtentReportListener();
	// Locators for elements on the page
	By userName = By.xpath("//input[@data-test-id='etUsername']");
	By password = By.xpath("//input[@data-test-id='etPassword']");
	By NxtButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By ForgotuserName = By.xpath("//a[@data-test-id='linkForgotUsername']");
	By Forgotpassword = By.xpath("//a[@data-test-id='linkForgotPassword']");
	By languageDropdown = By
			.xpath("//ng-select[@data-test-id='selectLanguageSession']//span[@class='ng-arrow-wrapper']");
	By TermsandConditionslink = By.xpath("//a[@data-test-id='linkTermsAndConditions']");
	By PrivacyPolicylink = By.xpath("//a[@data-test-id='linkPrivacyPolicy']");
	By selectEnglishLanguage = By.xpath("//div[@role='option']//span[text()='English']");
	By selectRussianLanguage = By.xpath("//div[@role='option']//span[text()='Russian']");
	By russianLoginHeading = By.xpath("//h6[text()='Вход в систему']");
	By EnglishLoginHeading = By.xpath("//h6[text()='Login']");
	By closeInstall = By.xpath("//button[contains(@class,'toast-close-button ng-tns')]");
	By languageSelected = By.xpath("//span[contains(@class,'ng-value-label')]");
	By loginSuccessMessage = By.xpath("//div[@aria-label='Login Successful']");

	// Constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * used to get the title of Login page
	 */
	@Step("getting the page title")
	public String getPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * used to login to application by fetching the username and password from
	 * config property file and close the prompt displayed to install Application
	 */
	@Step("login with username: and password : ")
	public DashboardPage doLogin(Credentials credentials) {
		
//		System.out.println("credentials are : " + credentials.getUserName() + " " + credentials.getPassword());
			elementActions.waitForElementPresent(userName);
			extentReport.logToExtentReport("username entered");
			elementActions.doSendKeys(userName, credentials.getUserName());
			extentReport.logToExtentReport("password entered");
			elementActions.doSendKeys(password, credentials.getPassword());
			extentReport.logToExtentReport("click on login button");
			elementActions.doClick(NxtButton);
		//	elementActions.doIsDisplayed(loginSuccessMessage);
			extentReport.logToExtentReport("Logged into application successfully");
			if (elementActions.doIsDisplayed(closeInstall)) {
				elementActions.doClick(closeInstall);
				extentReport.logToExtentReport("close Install popup");
			}

		return new DashboardPage(driver);
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * used to verify the elements displayed on login page
	 */
	@Step("Verify the UI")
	public void displayed() {
		elementActions.doIsDisplayed(userName);
		extentReport.logToExtentReport("username field is displayed");
		elementActions.doIsDisplayed(password);
		extentReport.logToExtentReport("password field is displayed");
		elementActions.doIsDisplayed(NxtButton);
		extentReport.logToExtentReport("login button is displayed");
		elementActions.doIsDisplayed(ForgotuserName);
		extentReport.logToExtentReport("forgot username link is displayed");
		elementActions.doIsDisplayed(Forgotpassword);
		extentReport.logToExtentReport("forgot password link is displayed");
		elementActions.doIsDisplayed(TermsandConditionslink);
		extentReport.logToExtentReport("terms & conditions is displayed");
		elementActions.doIsDisplayed(PrivacyPolicylink);
		extentReport.logToExtentReport("privacy policy is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * used to click on the language dropdown displayed on Login page
	 */
	@Step("Select the language")
	public void selectlanguage() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(languageDropdown);
		extentReport.logToExtentReport("clicked on language dropdown");
		Thread.sleep(3000);
		elementActions.JavaScriptExecutorClick(selectRussianLanguage);
		extentReport.logToExtentReport("selected language is russian language");
		Thread.sleep(3000);
		elementActions.doIsDisplayed(russianLoginHeading);
		extentReport.logToExtentReport("Verified: Russian Heading");
		Thread.sleep(3000);
		elementActions.doClick(languageDropdown);
		extentReport.logToExtentReport("clicked on language dropdown");
		Thread.sleep(3000);
		elementActions.JavaScriptExecutorClick(selectEnglishLanguage);
		extentReport.logToExtentReport("selected language is English language");
		Thread.sleep(3000);
		elementActions.doIsDisplayed(EnglishLoginHeading);
		extentReport.logToExtentReport("Verified: English Heading");
		Thread.sleep(3000);
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * used to verify Terms & conditions page and Privacy policy page when clicked
	 * on the respective links from Login page
	 */
	@Step("Navigate to T&C and Privay Policy page")
	public void TermsandConditionsPrivacyPolicy() throws InterruptedException {
		String TermsConditionsLink = elementActions.getAttributeByKey(TermsandConditionslink, "href");
		elementActions.doClick(TermsandConditionslink);
		extentReport.logToExtentReport("Clicked on Terms & Conditions page ");
		String PrivacyPolicyLink = elementActions.getAttributeByKey(PrivacyPolicylink, "href");
		elementActions.doClick(PrivacyPolicylink);
		extentReport.logToExtentReport("Clicked on Privacy Policy Link");
		Thread.sleep(5000);
		elementActions.switchToTabByUrl(TermsConditionsLink+"/");
		String TermsConditionsActualTitle = driver.getTitle();
		assertEquals(TermsConditionsActualTitle,"Terms of Use | Intelehealth");
		extentReport.logToExtentReport("Terms & Conditions page is displayed");
		Thread.sleep(5000);
		elementActions.switchToTabByUrl(PrivacyPolicyLink+"/");
		String PrivacyPolicyActualTitle = driver.getTitle();
		assertEquals(PrivacyPolicyActualTitle,"Privacy Policy | Intelehealth");
		extentReport.logToExtentReport("Privacy Policy page is displayed");
	}
	
	public void doLoginWithNewPassword(String username,String Password) {
		elementActions.doSendKeys(userName, username);
		extentReport.logToExtentReport("password entered");
		elementActions.doSendKeys(password,Password);
		extentReport.logToExtentReport("click on login button");
		elementActions.doClick(NxtButton);
		elementActions.doIsDisplayed(loginSuccessMessage);
		extentReport.logToExtentReport("Logged into application successfully");
		if (elementActions.doIsDisplayed(closeInstall)) {
			elementActions.doClick(closeInstall);
			extentReport.logToExtentReport("close Install popup");
		}
	}
}
