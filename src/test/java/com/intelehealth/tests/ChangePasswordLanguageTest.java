package com.intelehealth.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.ChangePasswordLanguagePage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ChangePasswordLanguageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ChangePasswordLanguagePage changePasswordLanguagePage;
	Credentials credentials;// Declare  as a member variable

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		changePasswordLanguagePage = new ChangePasswordLanguagePage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1554_Verify that user can Change the password", enabled = true)
	@Description("Verify that user can Change the password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1554_ChangePasswordLanguage() throws InterruptedException {
		changePasswordLanguagePage.VerifyChangePassword(prop.getProperty("OldPassword"), prop.getProperty("NewPassword"),  loginPage);
	}
	
	@Test(priority = 2, description = "IDA4_1565_Verify Generate password link functionality", enabled = true)
	@Description("Verify Generate password link functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1565_ChangePasswordLanguage() throws InterruptedException {
		changePasswordLanguagePage.VerifyGeneratePassword(prop.getProperty("password"));
	}
	
	@Test(priority = 3, description = "IDA4_1568_Verify user can login using new password", enabled = true)
	@Description("Verify user can login using new password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1568_ChangePasswordLanguage() throws InterruptedException {
		changePasswordLanguagePage.VerifyLoginNewPassword(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 4, description = "IDA4_1569_Verify that user can select the language", enabled = true)
	@Description("Verify that user can select the language")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1569_ChangePasswordLanguage() throws InterruptedException { 
		changePasswordLanguagePage.VerifyChangeLanguage();
	}
	
	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
