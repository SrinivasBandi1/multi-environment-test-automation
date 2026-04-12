package com.intelehealth.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DashboardPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials;

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		// Set the WebDriver instance in the ScreenshotListener
		ScreenshotListener.setDriver(driver);
	}
	
	@Test(priority = 1, description = "IDA4_1574_Dashboard_Verify the count shown for Appointments/Priority visits/Awaiting visits and In-Progress visits in the box",  enabled = true)
	@Description("Verify the count shown for Appointments/Priority visits/Awaiting visits and In-Progress visits in the box")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1574_Dashboard() {
		//System.out.println("Started execution of IDA4_1574");
		dashboardPage.verifyPatientCountHeader();
	}

	@Test(priority = 2, description = "IDA4_1577_Dashboard_Verify that appointment section shows all the appointments scheduled",  enabled = true)
	@Description("Verify that appointment section shows all the appointments scheduled")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1577_Dashboard() {
		//System.out.println("Started execution of IDA4_1577");
		dashboardPage.verifyDashboardAppointmentVisitField();
	}

	@Test(priority = 3, description = "IDA4_1578_Verify that Appointment header shows correct count of appointments",  enabled = true)
	@Description("Verify Dashboard screen is displayed after Login")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1578_Dashboard() {
		//System.out.println("Started execution of IDA4_1578");
		dashboardPage.ApntmtsCount();
	}

	@Test(priority = 4, description = "IDA4_1579_Dashboard_Verify clicking on any of the appointment navigates to visit summary page",  enabled = true)
	@Description("Verify clicking on any of the appointment navigates to visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1579_Dashboard() {
		//System.out.println("Started execution of IDA4_1579");
		dashboardPage.clickAptPatient();
	}

	@Test(priority = 5, description = "IDA4_1583_Dashboard_Verify that priority visits section shows all the priority visits scheduled",  enabled = true)
	@Description("Verify that priority visits section shows all the priority visits scheduled")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1583_Dashboard() {
		//System.out.println("Started execution of IDA4_1583");
		dashboardPage.verifyDashboardPriorityVisitField();
	}

	@Test(priority = 6, description = "IDA4_1584_Dashboard_Verify that Priority visits header shows the correct count of Priority visits",  enabled = true)
	@Description("Verify that Priority visits header shows the correct count of Priority visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1584_Dashboard() {
		//System.out.println("Started execution of IDA4_1583");
		dashboardPage.PrVstCount();
	}

	@Test(priority = 7, description = "IDA4_1585_Dashboard_Verify that user on clicking any of the priority visits navigates to visit summary page",  enabled = true)
	@Description("Verify that user on clicking any of the priority visits navigates to visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1585_Dashboard() {
		//System.out.println("Started execution of IDA4_1585");
		dashboardPage.clickPrPatient();
	}

	@Test(priority = 8, description = "IDA4_1589_Dashboard_Verify that Awaiting visits section shows all the awaiting visits",  enabled = true)
	@Description("Verify that Awaiting visits section shows all the awaiting visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1589_Dashboard() {
		//System.out.println("Started execution of IDA4_1589");
		dashboardPage.verifyDashboardAwaitingVisitField();
	}

	@Test(priority = 9, description = "IDA4_1590_Dashboard_Verify that Awaiting visits header shows the correct count of awaiting visits",  enabled = true)
	@Description("Verify that Awaiting visits header shows the correct count of awaiting visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1590_Dashboard() {
		//System.out.println("Started execution of IDA4_1590");
		dashboardPage.awVstCount();
	}

	@Test(priority = 10, description = "IDA4_1591_Dashboard_Verify that user is navigated to visit summary page on clicking any of the awaiting visits from the table",  enabled = true)
	@Description("Verify that user is navigated to visit summary page on clicking any of the awaiting visits from the table")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1591_Dashboard() {
		//System.out.println("Started execution of IDA4_1591");
		dashboardPage.clickawtVstPatient();
	}
	
	@Test(priority = 11, description = "IDA4_1572_Dashboard_verify dashboard page contents",  enabled = true)
	@Description("verify dashboard page contents")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1572_Dashboard() {
		//System.out.println("Started execution of IDA4_1572");
		dashboardPage.verifyDashboardComponents();

	}

	@Test(priority = 12, description = "IDA4_1595_Dashboard_Verify that In-progress visits section shows all the in-progress visits",  enabled = true)
	@Description("Verify that In-progress visits section shows all the in-progress visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1595_Dashboard() {
		//System.out.println("Started execution of IDA4_1595");
		dashboardPage.verifyDashboardInProgressVisitField();
	}

	@Test(priority = 13, description = "IDA4_1596_Dashboard_Verify that In-progress visits header shows the correct count of In-progress visits",  enabled = true)
	@Description("Verify that In-progress visits header shows the correct count of In-progress visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1596_Dashboard() {
		//System.out.println("Started execution of IDA4_1596");
		dashboardPage.inprVstCount();
	}

	@Test(priority = 14, description = "IDA4_1597_Dashboard_Verify that user can navigate to visit summary page on clicking any of the in-progress visits", enabled = true)
	@Description("Verify that user can navigate to visit summary page on clicking any of the in-progress visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1597_Dashboard() {
		//System.out.println("Started execution of IDA4_1597");
		dashboardPage.clickInprPatient();
	}
	
	@Test(priority = 15, description = "IDA4_1597_Dashboard_Verify that user can navigate to visit summary page on clicking any of the in-progress visits", enabled = true)
	@Description("Verify that user can navigate to visit summary page on clicking any of the in-progress visits")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1_Dashboard() {
		//System.out.println("Started execution of IDA4_1597");
		dashboardPage.clickcompletePatient();
	}
	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}