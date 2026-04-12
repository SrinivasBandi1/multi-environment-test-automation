package com.intelehealth.tests;

import static org.testng.Assert.fail;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.AppointmentPage;
import com.intelehealth.pages.CalendarPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class AppointmentPageTest {
	Properties prop;
	WebDriver driver;
	static BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AppointmentPage appointmentPage;
	CalendarPage calendarPage;
	Credentials credentials;
	String testEnum;

	@BeforeClass
	public void getAdminData() throws IOException {
		basePage = new BasePage();
		Response response = basePage.getAdmitDataAPI();
		/*
		 * boolean appointmentModuleEnabled = basePage.getAdmitDataAPI().jsonPath()
		 * .getBoolean("patient_visit_summary.standard_medication");
		 */
		boolean appointmentModuleEnabled = basePage.getAdmitDataAPI().jsonPath().getBoolean("sidebar_menus.appointment");
System.out.println("==========================================================================================="+appointmentModuleEnabled);
		 if (!appointmentModuleEnabled) {
		        throw new SkipException("Skipping tests: Appointment module not enabled for this project");
		    }

		// appointmentModuleEnabled =
		// response.jsonPath().getBoolean("patient_visit_summary.standard_medication")
		/*
		 * response.jsonPath().getBoolean( "patient_visit_summary.standard_medication")
		 */;
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++=" + appointmentModuleEnabled);
		String responseBody = response.getBody().asPrettyString();

		try (FileWriter file = new FileWriter("target/api-response.json")) {
			file.write(responseBody);
		}
	}

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();
		driver = basePage.init_driver1(prop, testEnum);
		// driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		appointmentPage = new AppointmentPage(driver);
		calendarPage = new CalendarPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1784_Appointments_Verify the UI elements of Appointment page", enabled = true)
	@Description("Verify the UI elements of Appointment page")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1784_Appointments() throws InterruptedException {
		appointmentPage.OpenAppointment();
		appointmentPage.AppointmentUI();
	}

	@Test(priority = 2, description = "IDA4_1787_Appointments_Verify whether Appointment section is showing count within brackets", enabled = true)
	@Description("Verify whether Appointment section is showing count within brackets")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1787_Appointments() throws InterruptedException {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyWhetherAppointmentSectionIsShowingCountWithinBrackets();
	}

	@Test(priority = 3, description = "IDA4_1788_Appointments_Verify whether scheduled appointments from healthworker -Mobile is reflecting in web app", enabled = true)
	@Description("Verify whether scheduled appointments from healthworker -Mobile is reflecting in web app")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1788_Appointments() throws InterruptedException {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyWhetherScheduledAppointmentsFromHealthworkerMobileIsReflectingInWebApp();
	}

	@Test(priority = 4, description = "IDA4_1791_Appointments_Verify whether user able to cancel the appointments", enabled = true)
	@Description("Verify whether user able to cancel the appointments")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1791_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyWhetherUserAbleToCancelTheAppointments();
	}

	@Test(priority = 11, description = "IDA4_1793_Appointments_Verify clicking on Cancel button on cancel the appointment popup", enabled = true)
	@Description("Verify clicking on Cancel button on cancel the appointment popup")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1793_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyClickingOnCancelButtonOnCancelTheAppointmentPopup();
	}

	@Test(priority = 5, description = "IDA4_1794_Appointments_Verify the functionality of 'Reschedule' action", enabled = true)
	@Description("Verify the functionality of 'Reschedule' action")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1794_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		Thread.sleep(2000);
		appointmentPage.VerifyTheFunctionalityOfRescheduleAction();
	}

	@Test(priority = 6, description = "IDA4_1796_Appointments_Verify date selection for rescheduling appointment", enabled = true)
	@Description("Verify date selection for rescheduling appointment")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1796_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyDateSelectionForReschedulingAppointment();
	}

	@Test(priority = 7, description = "IDA4_1798_Appointments_Verify time slot selection and clicking reschedule button functionality", enabled = true)
	@Description("Verify time slot selection and clicking reschedule button functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1798_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyTimeSlotSelectionAndClickingRescheduleButtonFunctionality();
	}

	@Test(priority = 8, description = "IDA4_1800_Appointments_Verify clicking on Confirm button on Reschedule the appointment popup", enabled = true)
	@Description("Verify clicking on Confirm button on Reschedule the appointment popup")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1800_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyClickingOnConfirmButtonOnRescheduleTheAppointmentPopup();
	}

	@Test(priority = 9, description = "IDA4_1801_Appointments_Verify whether the Rescheduled time slot reflects in Starts in column", enabled = true)
	@Description("Verify whether the Rescheduled time slot reflects in Starts in column")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1801_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyWhetherTheRescheduledTimeSlotReflectsInStartsInColumn();
	}

	@Test(priority = 10, description = "IDA4_1803_Appointments_Verify the Patient details on Appointments", enabled = true)
	@Description("Verify the Patient details on Appointments")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1803_Appointments() throws Throwable {
		appointmentPage.OpenAppointment();
		appointmentPage.VerifyThePatientDetailsOnAppointments();
	}

	@Test(priority = 12, description = "IDA4_1790 Verify user is able to cancel the already completed appointments", enabled = true)
	@Description("Verify user is able to cancel the already completed appointments")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1790_Appointments() throws Exception {
		appointmentPage.clickOnAppointments();
		appointmentPage.clickOnCancelButton();

		Assert.assertEquals(appointmentPage.getCancelAppointmentText(), "Cancel the appointment");

		appointmentPage.clickOnCancelButtonInPopup();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Throwable {
		Thread.sleep(1000);
		basePage.quitDriver(testEnum);
		System.gc();
	}
}