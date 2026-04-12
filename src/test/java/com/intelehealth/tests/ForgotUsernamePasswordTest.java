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
import com.intelehealth.pages.ForgotUsernamePasswordPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ForgotUsernamePasswordTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials;
	ForgotUsernamePasswordPage forgotUsernamePasswordPage;
	ExtentReportListener extentReport = new ExtentReportListener();
	
	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		forgotUsernamePasswordPage = new ForgotUsernamePasswordPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1440_Verify that user gets the Forgot username screen on clicking the link", enabled = true)
	@Description("Verify that user gets the Forgot username screen on clicking the link")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1440_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1440");
		forgotUsernamePasswordPage.VerifyForgotUsernamePage();
	}
	
	@Test(priority = 2, description = "IDA4_1444_Verify entering mobile number and clicking next", enabled = true)
	@Description("Verify entering mobile number and clicking next")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1444_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1444");
		forgotUsernamePasswordPage.VerifyForgotUsernameMobileNumber();
	}
	
	@Test(priority = 3, description = "IDA4_1446_Verify user should get the OTP through mobile number", enabled = true)
	@Description("Verify user should get the OTP through mobile number")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1446_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1446");
		forgotUsernamePasswordPage.VerifyForgotUsernameMobileNumber();
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
	}
	
	@Test(priority = 4, description = "IDA4_1447_Verify username is retrieved and user should be able to login", enabled = true)
	@Description("Verify username is retrieved and user should be able to login")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1447_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1447");
		forgotUsernamePasswordPage.VerifyForgotUsernameMobileNumber();
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for retrieving Username from Mobile");
	}
	
	@Test(priority = 5, description = "IDA4_1448_Verify the Resend functionality", enabled = true)
	@Description("Verify the Resend functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1448_ForgotUNPW() throws InterruptedException {
		//System.out.println("Started execution of IDA4_1448");
		forgotUsernamePasswordPage.VerifyForgotUsernameMobileNumber();
		forgotUsernamePasswordPage.VerifyResendLink();
		extentReport.logToExtentReport( "Not verified for retrieving Username from Mobile");
	}
	
	@Test(priority = 6, description = "IDA4_1454_Verify that 6 digit OTP is received in registered mobile number", enabled = true)
	@Description("Verify that 6 digit OTP is received in registered mobile number")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1454_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1454");
		forgotUsernamePasswordPage.VerifyForgotUsernameMobileNumber();
		extentReport.logToExtentReport( "Not verified for OTP from Mobile");
	}
	
	@Test(priority = 7, description = "IDA4_1457_Verify user entering valid Email ID and clicking Next", enabled = true)
	@Description("Verify user entering valid Email ID and clicking Next")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1457_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1457");
		forgotUsernamePasswordPage.VerifyForgotUsernameEmailID();
	}
	
	@Test(priority = 8, description = "IDA4_1458_Verify user gets the OTP through Email ID", enabled = true)
	@Description("Verify user gets the OTP through Email ID")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1458_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1458");
		forgotUsernamePasswordPage.VerifyForgotUsernameEmailID();
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP from EmailID");
	}
	
	@Test(priority = 9, description = "IDA4_1459_Verify username is retrieved and user should be able to login", enabled = true)
	@Description("Verify username is retrieved and user should be able to login")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1459_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1459");
		forgotUsernamePasswordPage.VerifyForgotUsernameEmailID();
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP from EmailID");
	}
	
	@Test(priority = 10, description = "IDA4_1460_Verify the Resend functionality", enabled = true)
	@Description("Verify the Resend functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1460_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1460");
		forgotUsernamePasswordPage.VerifyForgotUsernameEmailID();
		forgotUsernamePasswordPage.VerifyResendLink();
		extentReport.logToExtentReport( "Not verified for OTP from EmailID");
	}
	
	@Test(priority = 11, description = "IDA4_1466_Verify that 6 digit OTP is received by user through Email", enabled = true)
	@Description("Verify that 6 digit OTP is received by user through Email")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1466_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1466");
		forgotUsernamePasswordPage.VerifyForgotUsernameEmailID();
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP from EmailID");
	}
	
	@Test(priority = 12, description = "IDA4_1468_Verify that user gets the Forgot password screen on clicking the link", enabled = true)
	@Description("Verify that user gets the Forgot password screen on clicking the link")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1468_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1468");
		forgotUsernamePasswordPage.VerifyForgotPassword();
	}
	
	@Test(priority = 13, description = "IDA4_1469_Verify that user can navigate to Forgot username screen on clicking link", enabled = true)
	@Description("Verify that user can navigate to Forgot username screen on clicking link")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1469_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1469");
		forgotUsernamePasswordPage.VerifyForgotPassword();
		forgotUsernamePasswordPage.VerifyForgotUsernamePage();
	}
	
	@Test(priority = 14, description = "IDA4_1471_Verify entering username and clicking Next", enabled = true)
	@Description("Verify entering username and clicking Next")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1471_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1471");
		forgotUsernamePasswordPage.VerifyForgotPasswordByUsernameNext(prop.getProperty("username"));
	}
	
	@Test(priority = 15, description = "IDA4_1473_Verify if user gets the OTP to Mobile number and Email", enabled = true)
	@Description("Verify if user gets the OTP to Mobile number and Email")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1473_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1473");
		forgotUsernamePasswordPage.VerifyForgotPasswordByUsernameNext(prop.getProperty("username"));
	}
	
	@Test(priority = 16, description = "IDA4_1474_Verify the Resend functionality", enabled = true)
	@Description("Verify the Resend functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1474_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1474");
		forgotUsernamePasswordPage.VerifyForgotPasswordResendLink(prop.getProperty("username"));
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP from Mobile Number");
	}
	
	@Test(priority = 17, description = "IDA4_1480_Verify that user receives 6 digit OTP in registered mobile number/email", enabled = true)
	@Description("Verify that user receives 6 digit OTP in registered mobile number/email")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1480_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1480");
		forgotUsernamePasswordPage.VerifyForgotPasswordResendLink(prop.getProperty("username"));
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP from Mobile Number");
	}
	
	@Test(priority = 18, description = "IDA4_1482_Verify that user is able to Reset the password", enabled = true)
	@Description("Verify that user is able to Reset the password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1482_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1482");
		forgotUsernamePasswordPage.VerifyForgotPasswordResendLink(prop.getProperty("username"));
		forgotUsernamePasswordPage.VerifyOTPVerificationSuccessPopup();
		extentReport.logToExtentReport( "Not verified for OTP");
	}
	
	@Test(priority = 19, description = "IDA4_1483_Verify that user is able to Login using new password", enabled = true)
	@Description("Verify that user is able to Login using new password")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1483_ForgotUNPW() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1483");
		forgotUsernamePasswordPage.VerifyUserLogin();
		extentReport.logToExtentReport( "Not verified for new password");
	}
	
	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}

}
