package com.intelehealth.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.ProfilePage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ProfilePageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials;
	ProfilePage profilePage;
	String testEnum;

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();

		driver = basePage.init_driver1(prop, testEnum);
		// driver = basePage.init_driver1(prop,WebDriverEnum.PROFILE_PAGE_TEST);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		profilePage = new ProfilePage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1522_Verify user can update the First name , Middle name and Last name, Gender, DOB fields", enabled = true)
	@Description("Verify user can update the First name , Middle name and Last name, Gender, DOB fields")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1522_Profile() throws InterruptedException {
		try {

			// System.out.println("Started execution of IDA4_1522");
			profilePage.VerifyProfilePageUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, description = "IDA4_1526_Verify that user can update the Mobile number, Whatsapp number and Email ID", enabled = true)
	@Description("Verify that user can update the Mobile number, Whatsapp number and Email ID")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1526_Profile() throws InterruptedException {
		try {

			// System.out.println("Started execution of IDA4_1526");
			profilePage.VerifyProfilePageUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3, description = "IDA4_1532_Verify that user can select the signature from dropdown", enabled = true)
	@Description("Verify that user can select the signature from dropdown")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1532_Profile() throws InterruptedException, IOException {
		try {

			// System.out.println("Started execution of IDA4_1532");
			profilePage.VerifyProfilePageSignatureUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4, description = "IDA4_1534_Verify that user can add signature by Uploading jpg, jpeg and png images between 5kb to 50kb sizes.", enabled = true)
	@Description("Verify that user can add signature by Uploading jpg, jpeg and png images between 5kb to 50kb sizes.")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1534_Profile() throws InterruptedException, IOException {
		try {

			// System.out.println("Started execution of IDA4_1534");
			profilePage.VerifyProfilePictureUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5, description = "IDA4_1550_Verify that user can able to update the profile", enabled = true)
	@Description("Verify that user can able to update the profile")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1550_Profile() throws InterruptedException, IOException {
		try {

			// System.out.println("Started execution of IDA4_1550");
			profilePage.VerifyProfileUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Throwable {
		basePage.quitDriver(testEnum);
		System.gc();
	}
}
