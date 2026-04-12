package com.intelehealth.tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.pages.CalendarPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CalendarPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CalendarPage calendarPage;
	Credentials credentials;
	String testEnum;

	@BeforeMethod(alwaysRun = true)

	public void setUp(Method method) throws Throwable {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();

		driver = basePage.init_driver1(prop, testEnum);
		// driver = basePage.init_driver1(prop,WebDriverEnum.CALENDAR_PAGE_TEST);
		loginPage = new LoginPage(driver);
		calendarPage = new CalendarPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.doLogin(credentials);
	}

	@Test(priority = 1, description = "IDA4_1857_Calendar_Verify the UI elements of calendar page", enabled = true)
	@Description("Verify the UI elements of calendar page")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1857_Calendar() throws Throwable {
		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.CalendarPageUi();
	}

	@Test(priority = 24, description = "IDA4_1859_Verify clicking on any of the month in calendar", enabled = true)
	@Description("Verify clicking on any of the month in calendar")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1859_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingOnAnyOfTheMonthInCalendar();
	}

	@Test(priority = 23, description = "IDA4_1860_Calendar_Verify the functionality of Add more months link", enabled = true)
	@Description("Verify the functionality of Add more months link")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1860_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifytheFunctionalityofAddMoreMonthsLink();
	}

	@Test(priority = 25, description = "IDA4_1861_Calendar_Verify the doctor availability schedule", enabled = true)
	@Description("Verify the doctor availability schedule")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1861_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifytheDoctorAvailabilitySchedule();
	}

	@Test(priority = 26, description = "IDA4_1863_Calendar_Verify that user can select date from calendar", enabled = true)
	@Description("Verify that user can select date from calendar")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1863_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatUserCanSelectDateFromCalendar();
	}

	@Test(priority = 27, description = "IDA4_1864_Calendar_Verify the Add more timing link functionality", enabled = true)
	@Description("Verify the Add more timing link functionality")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1864_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifytheAddMoreTimingLinkFunctionality();

	}

	@Test(priority = 28, description = "IDA4_1865_Calendar_Verify that user can select the time from dropdown", enabled = true)
	@Description("Verify that user can select the time from dropdown")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1865_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifythatUserCanSelecttheTimeFromDropdown();
	}

	@Test(priority = 29, description = "IDA4_1867_Calendar_Verify clicking on save button in calendar", enabled = true)
	@Description("Verify clicking on save button in calendar")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1867_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingonSaveButtonAfterAddingTime();

	}

	@Test(priority = 30, description = "IDA4_1868_Calendar_Verify delete functionality in calendar", enabled = true)
	@Description("Verify delete functionality in calendar")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1868_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyDeleteFunctionalityInCalendarSavedTimings();

	}

	@Test(priority = 31, description = "IDA4_1870_Calendar_Verify confirm functionality when clicked on delete in calendar", enabled = true)
	@Description("Verify confirm functionality when clicked on delete in calendar")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1870_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyConfirmFunctionalityWhenClickedonDeleteinCalendar();

	}

	@Test(priority = 32, description = "IDA4_1871_Calendar_Verify whether user able to change/update selected dates", enabled = true)
	@Description("Verify whether user able to change/update selected dates")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1871_Calendar() throws Throwable {

		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.ChangeSelectedDates();
	}

	@Test(priority = 33, description = "IDA4_1874_Calendar_Verify clicking on calendar icon under days off section", enabled = true)
	@Description("Verify clicking on calendar icon under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1874_Calendar() throws Throwable {
		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingonCalendarIconUnderDaysoffSection();
	}

	@Test(priority = 34, description = "IDA4_1875_Calendar_Verify user can select date from calendar under days off section", enabled = true)
	@Description("Verify user can select date from calendar under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1875_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyUsercanSelectDatefromCalendarUnderDaysoffSection();
	}

	@Test(priority = 35, description = "IDA4_1876_Calendar_Verify the functionality of save button under days off section after selecting single date", enabled = true)
	@Description("Verify the functionality of save button under days off section after selecting single date")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1876_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyTheFunctionalityOfSaveButtonUnderDaysOffSectionAfterSelectingSingleDate();

	}

	@Test(priority = 36, description = "IDA4_1877_Calendar_Verify the confirm popup when clicked on Save under days off section", enabled = true)
	@Description("Verify the confirm popup when clicked on Save under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1877_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyTheConfirmPopupWhenClickedOnSaveUnderDaysoffSection();
	}

	@Test(priority = 37, description = "IDA4_1879_Calendar_Verify clicking confirm in the popup when clicked on Save under days off section after selecting single date", enabled = true)
	@Description("Verify clicking confirm in the popup when clicked on Save under days off section after selecting single date")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1879_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingConfirmInThePopupWhenClickedOnSaveUnderDaysOffSection();
	}

	@Test(priority = 38, description = "IDA4_1880_Calendar_Verify whether user can select multiple dates in month under days off section", enabled = true)
	@Description("Verify whether user can select multiple dates in month under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1880_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.SelectMultipleDaysoff();
	}

	@Test(priority = 39, description = "IDA4_1881_Calendar_Verify whether selected days off date can be removed under days off section", enabled = true)
	@Description("Verify whether selected days off date can be removed under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1881_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyWhetherSelectedDaysOffDateCanBeRemovedUnderDaysOffSection();

	}

	@Test(priority = 40, description = "IDA4_1882_Calendar_Verify the confirm popup when dates are to be removed under days off section", enabled = true)
	@Description("Verify the confirm popup when dates are to be removed under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1882_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyTheConfirmPopupWhenDatesAreToBeRemovedUnderDaysOffSection();

	}

	@Test(priority = 41, description = "IDA4_1884_Calendar_Verify clicking confirm in the popup when dates are to be removed under days off section", enabled = true)
	@Description("Verify clicking confirm in the popup when dates are to be removed under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1884_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingConfirmInThePopupWhenDatesAreToBeRemovedUnderDaysOffSection();
	}

	@Test(priority = 42, description = "IDA4_1885_Calendar_Verify whether user able to change/update the dates", enabled = true)
	@Description("Verify whether user able to change/update selected dates")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1885_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyWheTherUserAbleToChangeorUpdateSelectedDates();

	}

	@Test(priority = 43, description = "IDA4_1887_Calendar_Verify save functionality after selecting multiple dates under days off section", enabled = true)
	@Description("Verify save functionality after selecting multiple dates under days off section")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1887_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifySaveFunctionalityAfterSelectingMultipleDatesUnderDaysoffSection();
	}

	@Test(priority = 44, description = "IDA4_1888_Calendar_Verify confirm functionality when clicked on save under days off section after selecting multiple dates", enabled = true)
	@Description("Verify confirm functionality when clicked on save under days off section after selecting multiple dates")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1888_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyConfirmFunctionalityAfterSelectingMultipleDatesUnderDaysoffSection();
	}

	@Test(priority = 45, description = "IDA4_1889_Calendar_Verify the saved day off is marked as day off in monthly calendar ", enabled = true)
	@Description("Verify the saved day off is marked as day off in monthly calendar ")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1889_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyTheSavedDayOffIsMarkedAsDayOffInMonthlyCalendar();
	}

	@Test(priority = 46, description = "IDA4_1891_Calendar_Verify that your calendar title And Manage Calendar button display in screen", enabled = true)
	@Description("Verify that your calendar title And Manage Calendar button display in screen")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1891_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyCalendarTitleAndManageCalendarButtonDisplayedOnTheScreen();
	}

	@Test(priority = 47, description = "IDA4_1892_Calendar_Verify that user can view the current date on Screen And can change the date", enabled = true)
	@Description("Verify that user can view the current date on Screen And can change the date")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1892_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatUserCanViewTheDateOnScreenAndCanChangeTheDate();
	}

	@Test(priority = 2, description = "IDA4_1894_Calendar_Verify that Appointment list/Followup list display in time slot", enabled = true)
	@Description("Verify that Appointment list/Followup list display in time slot")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1894_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatAppointmentListDisplayInTimeSlot();
	}

	@Test(priority = 3, description = "IDA4_1896_Calendar_Verify that Gender and Age is displayed beside patient name and Nurse name is displayed in the popup", enabled = true)
	@Description("Verify that Gender and Age is displayed beside patient name and Nurse name is displayed in the popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1896_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.GenderAgeisdisplayedbesidePatientNameAndNurseNameDisplayed();
	}

	@Test(priority = 4, description = "IDA4_1897_Calendar_Verify that user can able to view the 'Completed' Appointment details popup", enabled = true)
	@Description("Verify that user can able to view the 'Completed' Appointment details popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1897_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.UserAbleToViewTheCompletedAppointmentDetailsPopup();
	}

	@Test(priority = 5, description = "IDA4_1898_Calendar_Verify that Appointment status , Prescription created message , Nurse name displaying correctly on appointment details popup", enabled = true)
	@Description("Verify that Appointment status , Prescription created message , Nurse name displaying correctly on appointment details popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1898_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.AppointmentStatusPrescriptionCreatedMessageNurseNameDisplayingCorrectlyOnAppointmentDetailsPopup();
	}

	@Test(priority = 6, description = "IDA4_1899_Calendar_Verify user can navigate to visit summary page by clicking  view details link on Appointment details popup", enabled = true)
	@Description("Verify user can navigate to visit summary page by clicking  view details link on Appointment details popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1899_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyUserCanNavigateToVisitSummaryPageByClickingViewDetailsLinkOnAppointmentDetailsPopup();
	}

	@Test(priority = 7, description = "IDA4_1900_Calendar_Verify user can navigate to visit summary page by clicking  Provide Prescription Button on Appointment/Follow-up visit details popup", enabled = true)

	@Description("Verify user can navigate to visit summary page by clicking  Provide Prescription Button on Appointment/Follow-up visit details popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1900_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage
				.VerifyUserCanNavigateToVisitSummaryPageByClickingProvidePrescriptionButtonOnAppointmentOrFollopVisitDetailsPopup();
	}

	@Test(priority = 8, description = "IDA4_1903_Calendar_Verify that FollowUp list display in time slot", enabled = true)
	@Description("Verify that FollowUp list display in time slot")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1903_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatFollowUpListDisplayinTimeSlot();
	}

	@Test(priority = 9, description = "IDA4_1904_Calendar_Verify Appointment and Follow up visit details popup page for In-progress/Awaiting/priority visit patient", enabled = true)

	@Description("Verify Appointment and Follow up visit details popup page for In-progress/Awaiting/priority visit patient")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1904_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyAppointmentAndFollowUpDetailsPopupPageforInprogressOrAwaitingVisitPatient();
	}

	@Test(priority = 10, description = "IDA4_1905_Calendar_Verify the label in Appointment details/Follow-up visit popup page when appointment/follow-up is completed", enabled = true)

	@Description("Verify the label in Appointment details/Follow-up visit popup page when appointment/follow-up is completed")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1905_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyLabelInAppointmentDtailsOrFollowupVisitPopupPageWhenAppointmentOrFollowupIsCompleted();

	}

	@Test(priority = 11, description = "IDA4_1906_Calendar_Verify that user can view the FollowUp visit details screen", enabled = true)

	@Description("Verify that user can view the FollowUp visit details screen")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1906_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifythatUsercanViewtheFollowUpVisitDetailsScreen();
	}

	@Test(priority = 12, description = "IDA4_1907_Calendar_Verify user can navigate to visit summary page by clicking  view details link on Follow-up visit details popup ", enabled = true)

	@Description("Verify user can navigate to visit summary page by clicking  view details link on Follow-up visit details popup ")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1907_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyUsercanNavigatetoVisitSummaryPageageByClickingViewDetailsLinkOnFollowUpVisit();
	}

	@Test(priority = 13, description = "IDA4_1908_Calendar_Verify Edit Prescription Button", enabled = true)

	@Description("Verify Edit Prescription Button")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1908_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyUsercanNavigatetoVisitSummaryPageByEditPrescriptionButton();
	}

	@Test(priority = 14, description = "IDA4_1909_Calendar_Verify that Prescription created message is displayed for completed follow-up visit ", enabled = true)

	@Description("Verify that Prescription created message is displayed for completed follow-up visit ")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1909_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifythatPrescriptionCreatedMessageDisplayForCompletedVisit();
	}

	@Test(priority = 15, description = "IDA4_1912_Calendar_Verify that user can see the current week's dates and change the week", enabled = true)

	@Description("Verify that user can see the current week's dates and change the week")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1912_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatUserisAbletoSeethecurrentWeeksDatesandChangetheWeek();
	}

	@Test(priority = 16, description = "IDA4_1913_Calendar_Verify that All the appointment & Follow up visits display in Selected week", enabled = true)

	@Description("Verify that All the appointment & Follow up visits display in Selected week")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1913_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatAllTheAppointmentAndFollowUpVisitsDisplayInSelectedWeek();
	}

	@Test(priority = 17, description = "IDA4_1915_Calendar_Verify that All the appointment & Follow up visits display in Selected month", enabled = true)

	@Description("Verify that All the appointment & Follow up visits display in Selected month")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1915_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatAllTheAppointmentAndFollowUpVisitsDisplayInSelectedMonth();
	}

	@Test(priority = 18, description = "IDA4_1916_Calendar_Verify that Day off is displayed in marked dates", enabled = true)

	@Description("Verify that Day off is displayed in marked dates")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1916_Calendar() throws Throwable {

		calendarPage.OpenCalendar();
		calendarPage.VerifyThatDayOffIsDisplayedInMarkedDates();
	}

	@Test(priority = 19, description = "IDA4_1917_Calendar_Verify that user can navigate to the selected date popup", enabled = true)

	@Description("Verify that user can navigate to the selected date popup")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1917_Calendar() throws Throwable {
		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.VerifyThatUserCanNavigateToTheSelectedDatePopup();
	}

	@Test(priority = 22, description = "IDA4_1918_Calendar_Verify that user is able to mark as day off and All the appointments & Follow ups auto cancelled for the Day off", enabled = true)
	@Description("Verify that user is able to mark as day off and All the appointments & Follow ups auto cancelled for the Day off")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1918_Calendar() throws Throwable {

		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.VerifyUserIsAbleToMarkAsDayOffInMonthlyCalendar();
	}

	@Test(priority = 20, description = "IDA4_1922_Calendar_Verify that user can select the FROM and TO dates", enabled = true)
	@Description("Verify that user can select the FROM and TO dates")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1922_Calendar() throws Throwable {

		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.VerifyThatUserCanSelectTheFROMAndTODates();
	}

	@Test(priority = 21, description = "IDA4_1923_Calendar_Verify user can set the off hours", enabled = true)
	@Description("Verify user can set the off hours")
	@Severity(SeverityLevel.CRITICAL)

	public void IDA4_1923_Calendar() throws Throwable {

		calendarPage.RemoveAllDaysOff();
		calendarPage.OpenCalendar();
		calendarPage.VerifyUserCanAbleToSetTheOffHours();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Throwable {
		basePage.quitDriver(testEnum);
		System.gc();

	}
}
