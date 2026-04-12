package com.intelehealth.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.ChatPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ChatPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ChatPage chatPage;
	Credentials credentials;
	VisitSummaryPage vstSummaryPage;

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		// Initialize  here
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		chatPage = new ChatPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1826_Verify chat option visibility", enabled = true)
	@Description("Verify chat option visibility")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1826_Chat() throws InterruptedException {
		 
		//System.out.println("Started execution of IDA4_1826");
		chatPage.chatOptionvisibility();
	}
	
	//@Test(priority = 2, description = "IDA4_1828_Verify chat option functionality in visit summary page", enabled = true)
	@Description("Verify chat option visibility")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1828_Chat() throws InterruptedException {
		 
		//System.out.println("Started execution of IDA4_1828");
		chatPage.chatOptionfunctionality();
	}
	
//	@Test(priority = 3, description = "IDA4_1830_Verify sending message in chat", enabled = true)
	@Description("Verify sending message in chat")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1830_Chat() throws InterruptedException {
		 
		//System.out.println("Started execution of IDA4_1830");
		chatPage.chatSendMessage();
	}
	
//	@Test(priority = 4, description = "IDA4_1833_Verify whether HW able to click on the PN when doctor send a chat msg", enabled = true)
	@Description("Verify whether HW able to click on the PN when doctor send a chat msg")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1833_Chat() throws InterruptedException {
		 
		//System.out.println("Started execution of IDA4_1833");
		chatPage.chatSendMessagetoHW();
	}
	
//	@Test(priority = 5, description = "IDA4_1834_Verify whether healthworker able to reply to doctor message/Check the sent message from doctor by logging into mobile", enabled = true)
	@Description("Verify whether healthworker able to reply to doctor message/Check the sent message from doctor by logging into mobile")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1834_Chat() throws InterruptedException {
		 
		//System.out.println("Started execution of IDA4_1834");
		chatPage.chatSendMessagetoHW();
	}
	
	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
