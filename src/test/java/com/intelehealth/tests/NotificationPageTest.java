package com.intelehealth.tests;


import com.intelehealth.base.BasePage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.NotificationPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class NotificationPageTest {
	Properties prop;
	WebDriver driver_One;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials;
	NotificationPage notificationPage;

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver_One = basePage.init_driver(prop);
		loginPage = new LoginPage(driver_One);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		notificationPage = new NotificationPage(driver_One);
		dashboardPage = loginPage.doLogin(credentials);
	}

	@Test(priority = 1, description = "Verify Navigate Profile", enabled = true)
	@Description("Verify Notification On")
	@Severity(SeverityLevel.BLOCKER)

	public void IDA4_1513_Notification() throws InterruptedException {
		try {
			notificationPage.Clickonthreedots();
			notificationPage.Clickonprofile();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("In After method");
		//driver_One.quit();
		System.gc();
	}
}
