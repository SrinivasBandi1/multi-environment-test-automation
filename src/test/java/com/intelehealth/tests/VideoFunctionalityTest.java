package com.intelehealth.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.VideoFunctionalityPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class VideoFunctionalityTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	VideoFunctionalityPage videoFunctionalityPage;
	Credentials credentials;
	ExtentReportListener extentReport = new ExtentReportListener();

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		videoFunctionalityPage = new VideoFunctionalityPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1843_Verify that user can make the video call", enabled = true)
	@Description("Verify that user can make the video call")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1843_VideoFunctionality() throws InterruptedException {
		videoFunctionalityPage.verifyVideoCall();
	}

	@Test(priority = 2, description = "IDA4_1846_Verify when user turns on mic and video", enabled = true)
	@Description("Verify when user turns on mic and video")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1846_VideoFunctionality() throws InterruptedException {
		videoFunctionalityPage.verifyVideoCallButton();
	}

	@Test(priority = 3, description = "IDA4_1847_Verify when doctor initiates the call, HW gets the incoming call", enabled = true)
	@Description("Verify when doctor initiates the call, HW gets the incoming call")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1847_VideoFunctionality() throws InterruptedException {
		videoFunctionalityPage.verifyVideoCallButton();
		extentReport.logToExtentReport("Verification not possible for HW(Mobile App) getting incoming call");
	}

	@Test(priority = 4, description = "IDA4_1848_Verify on clicking Accept by HW during the video call", enabled = true)
	@Description("Verify on clicking Accept by HW during the video call")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1848_VideoFunctionality() throws InterruptedException {
		videoFunctionalityPage.verifyVideoCallButton();
		extentReport.logToExtentReport("Verification not possible for HW(Mobile App) getting incoming call");
	}

	@Test(priority = 5, description = "IDA4_1850_Verify the video call page from HW side", enabled = true)
	@Description("Verify the video call page from HW side")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1850_VideoFunctionality() throws InterruptedException {
		videoFunctionalityPage.verifyVideoCallButton();
		extentReport.logToExtentReport("Verification not possible for HW(Mobile App) getting incoming call");
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
