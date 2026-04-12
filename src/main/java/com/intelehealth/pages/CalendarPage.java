package com.intelehealth.pages;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class CalendarPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By calendarLink = By.xpath("//a[@data-test-id='linkCalendar']");
	By setupCalendar = By.xpath("//h6[@data-test-id='calendarSetupHeading']");
	By viewCalendar = By.xpath("//button[@data-test-id='btnViewCal']");
	By addMoreMonths = By.xpath("//a[@data-test-id='linkAddMonths']");
	By selectAddedMonth = By.xpath("(//li[contains(@data-test-id,'month')])[last()]");
	By startdate = By.xpath("//input[@data-test-id='etSelStartDate']");
	By endDate = By.xpath("//input[@data-test-id='etSelEndDate']");
	By dataMonth = By.xpath("//mat-icon[@data-test-id='monthItemArrow']");
	// No data test
	By daysoff = By.xpath("//div[@formarrayname='daysOff']");//
	By startDateCalendar = By.xpath("//span[@data-test-id='dpicSelStartDate']");//
	// No data test
	// calendar start date fields
	By availabilityStartDate = By.xpath("//div[contains(@class,'-body-today')]");
	By startMonthYearText = By.xpath("//button[@aria-label='Choose month and year']");
	// No data test
	// calendar end date fields
	By endMonthYearText = By.xpath("//button[@aria-label='Choose month and year']");
	By endDateCalendar = By.xpath("//span[@data-test-id='dpicSelEndDate']");
	By moreTimingsMonth = By.xpath("//li[contains(@data-test-id,'monthItem')][last()]");
	By moreTimings = By.xpath("//a[@data-test-id='linkAddTime']");
	By moreTimingsSave = By.xpath("//button[@data-test-id='btnSaveSlot']");
	By moreTimingsCancel = By.xpath("//button[@data-test-id='btnCanelSlot']");
	By startTime = By.xpath("//ng-select[@data-test-id='selStartTime']");
	// No data test//selectStartTime
	By selectStartTime = By.xpath("(//div[@role='option'])[2]");// am
	By selectStartTimeAm = By.xpath("//div[@data-test-id='start-meridiem-AM']");// previously we have data test id bu //
																				// removed no
	By startTimeAmPm = By.xpath("//ng-select[@data-test-id='selStartAmPm']");
	By endTime = By.xpath("//ng-select[@data-test-id='selEndTime']");
	// No data test//selectEndTime
	By selectEndTime = By.xpath("(//div[@aria-selected='false'])[1]");// am
	By selectEndTimePm = By.xpath("//div[@data-test-id='meridiem-PM']");// pm
	By endTimeAmPm = By.xpath("//ng-select[@data-test-id='selEndTime']//following-sibling::ng-select/div");
	By selectDay = By.xpath("//ng-select[@data-test-id='selDays']");
	// no data test id, written working xpath as of now
	By selectTheDay = By.xpath("//input[contains(@type,'checkbox')]");
	By saveSlot = By.xpath("//button[@data-test-id='btnSaveSlot']");
	By deleteButton = By.xpath("//button[contains(@data-test-id,'btnDeleteSlot')]");
	By deleteButtons = By.xpath("//button[contains(@data-test-id,'btnDeleteSlot')]");
	By confirmPopup = By.xpath("//div[@data-test-id='confirmationModal']");
	By confirmText = By.xpath("//h6[@data-test-id='lblConfirmationTitle']");
	By popupText = By.xpath("//p[@data-test-id='lblConfirmationMessage']");
	By confirmButton = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");// remove daysoff
	By confirmButtonDayOff = By.xpath("//button[@data-test-id='btnConfirmDayOffModal']");// markdayoof
	By confirmButtonhoursOff = By.xpath("//button[@data-test-id='btnSubmitHoursOffModal']");// hoursoff
	By cancelButton = By.xpath("//button[@data-test-id='btnCancelHoursOffModal']");
	By daysOffCalendar = By.xpath("//div[@data-test-id='dpicSelDayOff']");
	By removeAllDaysoff = By.xpath("//button[@data-test-id='btnCloseConfirmationModal']");
	By allDates = By.xpath("//td[@role='gridcell']");
	// no data test id for days off
	By selectDateDaysoff = By.xpath("(//td[@tabindex='-1'])[last()]");
	// no data test id
	By pleaseWaitLoader = By.xpath("//div[@class='sk-ball-spin-clockwise']");
	By latestDaysoffSaved = By.xpath("(//button[contains(@data-test-id,'btnRemoveDaysOff')])[last()]");
	// no data test id
	By monthlyTab = By.xpath("//span[@data-test-id='tabMonthly']");
	By weeklyTab = By.xpath("//span[@data-test-id='tabWeekly']");
	By nextArrowCalendar = By.xpath("//button[@data-test-id='btnCalNextView']");
	By previousArrowCalendar = By.xpath("//button[@data-test-id='btnCalPreviousView']");
	By calendarDaysoff = By.xpath("(//div[@data-test-id='mwlCalMonthView'])[last()-5]//..//div[text()=' Day Off ']");
	By yourCalendarTitle = By.xpath("//h6[@data-test-id='calendarTitle']");
	// these were not found
	By manageCalendarButton = By.xpath("//button[@data-test-id='btnManageCal']");
	By dateDayYearCalendar = By.xpath("//h6[@data-test-id='lblViewDate']");
	By lastDate = By.xpath("(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[last()]");
	By lastSecondDate = By.xpath("(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[last()-1]");

	// create a appointmnet or followup in weekly calendar and have to check
	By weeklyCalendarPatients = By.xpath("//div[@data-test-id='mwlCalWeekView']");
	By weeklyCalendarBookedByNurse = By.xpath("//div[@data-test-id='bookedBy']");
	By weeklyCalendarBookedByWithNurseName = By.xpath("//div[@data-test-id='bookedBy']");
	By weeklyCalendarAppointmentText = By.xpath("//h6[@data-test-id='eventTitle']");
	By weeklyCalendarPatientNameandAge = By.xpath("(//h6[@data-test-id='patientName'])[3]");
	By bookedBy = By.xpath("//div[@data-test-id='bookedBy_label']");
	By weeklyCalendarCurrentTimeGreenLine = By.xpath("//div[@class='cal-current-time-marker ng-star-inserted']");
	By weeklyCalendarViewDetailsLink = By.xpath("//a[@data-test-id='linkViewPatientDetails']");
	By weeklyCalendarPatientId = By.xpath("//p[@data-test-id='patientId']");
	By weeklyCalendarStatus = By.xpath("//div[@data-test-id='patientVisitStatus']");
	By weeklyCalendarAppointmentOn = By.xpath("//div[@data-test-id='rowAppointmentOn']");
	By weeklyCalendarAppointmentBookedOn = By.xpath("//div[@data-test-id='rowBookedOn']");
	By weeklyCalendarChiefComplaint = By.xpath("//div[@data-test-id='rowChiefComplaint']");
	By weeklyCalendarAppointmentProvidePrescriptionButton = By.xpath("//button[@data-test-id='btnProvideAppDetail']");
	By weeklyCalendarAppointmentFollowUpCallIcon = By.xpath("//a[@data-test-id='linkCallBookedBy']");
	By weeklyCalendarFollowUpVisitPrescriptionCreated = By.xpath("//div[@data-test-id='appointmentExtraInfo']");
	By weeklyCalendarEditPrescriptionButton = By.xpath("//button[@data-test-id='btnEditAppDetail']");
	By weeklyCalendarAppointmentorFollowUpVisitStatusCompleted = By.xpath("//div[@data-test-id='patientVisitStatus']");
	By weeklyCalendarAppointmentCancelButton = By.xpath("//button[@data-test-id='btnCancelAppDetail']");
	By weeklyCalendarAppointmentRescheduleButton = By.xpath("//button[@data-test-id='btnRescheduleAppDetail']");
	By closeButton = By.xpath("//button[@data-test-id='btnCloseAppDetail']");
	By weeklyCalendarAppointmentStatusAwaiting = By.xpath("//div[text()=' Awaiting ']");
	By weeklyCalendarAppointmentStatusCompleted = By.xpath("//div[text()=' Completed ']");
	By weeklyCalendarCurrentDateHeaderInWeeklyCalendar = By.xpath("//div[@data-test-id='weekHeaderDay4']");
	By weeklyCalendarWeeks = By.xpath("//div[contains(@data-test-id,'weekHeaderDay')]");
	By monthlyCalendarFollowUpVisit = By
			.xpath("//div[@data-test-id='mwlCalMonthView-events']//..//div[contains(text(),' Follow-up visit ')]");
	By monthlyCalendarAppointment = By
			.xpath("//div[@data-test-id='mwlCalMonthView-events']//..//div[contains(text(),'Appointment')]");
	By monthlyFollowUp = By.xpath("//div[@data-test-id='mwlCalMonthView']//..//div[contains(text(),'Follow-up')]");
	By monthlyCalendarDates = By.xpath("//span[@data-test-id='mwlCalMonthView-dayNumber']");
	By monthlyCalendarDayOff = By.xpath("//mwl-calendar-month-cell[contains(@class,'today')]//div[text()=' Day Off ']");
	By firstAppointmentMonthlyCalendar = By
			.xpath("(//div[@data-test-id='mwlCalMonthView']//..//div[contains(text(),'Appointment')])[1]");
	By firstFollowUpVisitMonthlyCalendar = By
			.xpath("(//div[@data-test-id='mwlCalMonthView']//..//div[contains(text(),'Follow-up visit')])[1]");
	By selectFromMonthlyCalendar = By.xpath("//div[@data-test-id='mwlCalMonthView']");
	// @
	/////////////
	By monthlyCalendarPopUpDate = By.xpath("//h6[@data-test-id='lblDateAppDetailMonth']");
	By monthlyCalendarPopUpAppointment = By.xpath("//div[@data-test-id='lblAppointmentsAppDetailMonth']");
	By monthlyCalendarPopUpFollowUps = By.xpath("//div[@data-test-id='lblFollowupsAppDetailMonth']");
	By monthlyCalendarPopUpMarkAs = By.xpath("//label[@data-test-id='lblMarkAsAppDetailMonth']");
	By monthlyCalendarPopUpDayOff = By.xpath("//input[@data-test-id='radioDayOffAppDetailMonth']");
	By continueButton = By.xpath("//button[@data-test-id='btnSubmitAppDetailMonth']");
	// @
	By verifyMonthlyCalendarPopUpText = By
			.xpath("//p[text()=' as day off? All the appointments will be canceled for the day.']");
	// @
	By monthlyCalendarPopUpHoursOff = By.xpath("//input[@data-test-id='radioHourOffAppDetailMonth']");
	By monthlyCalendarPopUpHoursOffFrom = By.xpath("//ng-select[@data-test-id='selectHourOffFromAppDetailMonth']");
	By monthlyCalendarPopUpHoursOffFromTime = By.xpath("(//div[@role='option'])[2]");
	By monthlyCalendarPopUpHoursOffTo = By.xpath("//ng-select[@data-test-id='selectHourOffToAppDetailMonth']");
	By monthlyCalendarPopUpHoursOffToTime = By.xpath("(//div[@role='option'])[4]");
	By markAsHoursOffPopUp = By.xpath("//div[@data-test-id='hoursOffModal']");
	By followUpVisitTitle = By.xpath("//h6[text()='Follow-up visit details']");
	By appointmentTitle = By.xpath("//h6[text()='Appointment details']");
	By alreadyDayOff = By.xpath("//div[@aria-label='Already DayOff']");
	By monthlyCalendarToday = By.xpath("//mwl-calendar-month-cell[contains(@class,'today')]//div//div");
	By closeButtonDayOff = By.xpath("//button[@data-test-id='btnCloseDayOffModal']");
	By markAsDayOffText = By.xpath("//h6[@data-test-id='lblDayOffTitle']");
	By monthlyCalendarHoursOff = By
			.xpath("(//mwl-calendar-month-cell[contains(@class,'today')]//..//div[text()=' Hours Off '])[2]");
	By selectedStartDate = By.xpath("//td[@aria-selected='true']//div[contains(@class,'-body-today')]");
	By selectedEndDate = By.xpath("(//td[@tabindex='-1'])[last()]/..//td[@aria-selected='true']");
	By dateSelectedTrue = By.xpath("//td[@aria-selected='true']");
	By lastDateSelected = By.xpath("//td[@aria-selected='true']//div[@class='mat-calendar-body-cell-preview'][last()]");
	By dailyFollowUpAppointments = By.xpath("//div[@data-test-id='mwlCalDayView']");
	By inProgress = By.xpath("//div[text()=' In-progress ']");
	By calendarDate = By.xpath("//h6[@data-test-id='labelCalendarDate']");
	By endDateCalendarEndDate = By.xpath("(//td[@tabindex='-1'])[last()]");
	By endDateCalendarEndDateSecond = By.xpath("(//td[@tabindex='-1'])[last()-1]");
	// By selectedMonth = By.xpath("//span[@data-test-id='spSelectMonth']");
	By selectedMonth = By.xpath("//li[@data-test-id='monthItem1']");
	By calenadrPopupTypeOfVisitTitle = By.xpath("//h6[contains(text(),'details')]");
	By monthlyCalendarPopUpDayOffByText = By
			.xpath("//div[@class='form-group row']//label[@for='markAS']/..//label[text()='Day off']");
	By monthlyCalendarPopUpHoursOffByText = By
			.xpath("//div[@class='form-group row']//label[@for='markAS']/..//label[text()='Hours off']");
	By monthlyCalendarTodayFollowUp = By
			.xpath("//mwl-calendar-month-cell[contains(@class,'today')]//div[contains(text(),'Follow-up visit')]");
	By monthlyCalendarTodayAppointment = By
			.xpath("//mwl-calendar-month-cell[contains(@class,'today')]//div[contains(text(),'Appointment')]");
	// need to check
	By daysoffSaved = By.xpath("//h6[@data-test-id='lblYourDaysOff']/..//div[@class='chip-item ng-star-inserted']");
	By daysOffField = By.xpath("//input[@data-test-id='etDayOff']");
	By saveButtonDaysoff = By.xpath("//button[@data-test-id='btnSaveDayOff']");
	By daysoffConfirmPopup = By.xpath("//div[@class='modal-con mt-4']");
	By saveDaysoffPopupText = By.xpath("//p[text()=' Do you really want to save these days off ? ']");
	By firstSavedDayOff = By.xpath("//div[@data-test-id='chipDayOff0']");
	By daysoffRemovePopup = By.xpath("//div[@class='intel-con-modal']");
	By removeDaysoff = By.xpath("(//mat-icon[text()='close'])[last()]");
	By daysoffRemovePopupText = By.xpath("//p[text()='Do you really want to remove this day off ?']");
	By secondSavedDayOff = By
			.xpath("(//h6[@data-test-id='lblYourDaysOff']/..//div[@class='chip-item ng-star-inserted'])[2]");

	By visitSummaryPageDisplayedVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By visitSummaryPageText = By.xpath("//a[@class=\"navbar-brand\"]//li[text()=' Visit Summary ']");
	By clickBody = By.xpath("(//div[@class='card-body'])[1]");
	By lstRemoveDaysOff = By.xpath("//button[contains(@data-test-id,'btnRemoveDaysOff')]");
	By lstTimeslots = By.xpath("//table[@data-test-id='timingsTable']//tr");

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// Global variable
	String selectedDate;

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Generic method -
	 * Clicking on calendar link of calendar page
	 */
	public void OpenCalendar() throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on 'Calendar' link");
		elementActions.waitForElementClickable(calendarLink);
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Generic method -
	 * Removing the days off if there are any
	 */
	public void DeleteMarkedDaysOff() throws Throwable, ElementClickInterceptedException {
		List<WebElement> AllDaysOff = elementActions.getElements(removeAllDaysoff);

		for (Iterator<WebElement> iterator = AllDaysOff.iterator(); iterator.hasNext();) {
			if (elementActions.doIsDisplayed2(removeAllDaysoff) == false) {
				break;
			}
			DeleteDayOFF();
		}
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Generic method -
	 * Confirming the days off if there are any
	 */
	public void DeleteDayOFF() throws Throwable, ElementClickInterceptedException {
		Thread.sleep(3000);
		if (elementActions.doIsDisplayed2(removeAllDaysoff) == true) {
			extentReport.logToExtentReport("Deleting the saved days off");
			extentReport.logToExtentReport("Clicking on remove dayoff button");
			elementActions.waitForElementPresent(removeAllDaysoff);
			elementActions.JavaScriptExecutorClick(removeAllDaysoff);
			extentReport.logToExtentReport("Clicking on 'Confirm' button");
			elementActions.JavaScriptExecutorClick(confirmButton);
		}

	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Generic method -
	 * Deleting the time slots if there are any
	 */
	public void DeleteTimeSlots() throws Throwable, ElementClickInterceptedException, StaleElementReferenceException {
		if (elementActions.doIsDisplayed2(deleteButton) == true) {
			extentReport.logToExtentReport("Deleting the saved time slots");
//		List<WebElement> AllDaysOff = elementActions.getElements(DeleteButtons);
//		for (Iterator<WebElement> iterator = AllDaysOff.iterator(); iterator.hasNext();) {
//			WebElement webElement = (WebElement) iterator.next();
//			Thread.sleep(3000);
//			extentReport.logToExtentReport("Clicking on 'Delete' timeslots button");
//			elementActions.JavaScriptExecutorClickWebElement(webElement);
//			extentReport.logToExtentReport("Clicking on 'Confirm' button");
//			elementActions.JavaScriptExecutorClick(ConfirmButton);
//		}
			while (true) {
				try {
					Thread.sleep(2000);
					if (elementActions.doIsDisplayed(deleteButton) == true) {
						Thread.sleep(2000);
						elementActions.JavaScriptExecutorClick(deleteButton);
						elementActions.JavaScriptExecutorClick(confirmButton);
					} else {
						break;
					}
				} catch (NoSuchElementException e) {
					break;
				}
			}
		}
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Verify the UI elements
	 * of calendar page
	 */
	@Step("Verify UI")
	public void CalendarPageUi() throws ElementClickInterceptedException {
		boolean SetupDisplayed = elementActions.doIsDisplayed(setupCalendar);
		boolean ViewCalendarDisplayed = elementActions.doIsDisplayed(viewCalendar);
		if (SetupDisplayed == true && ViewCalendarDisplayed == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'setup calendar' title and 'View Calendar' button is displayed");
		} else {
			extentReport.logToExtentReport(
					"Verification - Whether 'setup calendar' title and 'View Calendar' button is not displayed");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Verify clicking on any
	 * of the month in calendar
	 */
	@Step("Verify clicking on any of the month in calendar")
	public void VerifyClickingOnAnyOfTheMonthInCalendar()
			throws ElementClickInterceptedException, InterruptedException {

		elementActions.waitForElementClickable(selectAddedMonth);
		String month = elementActions.doGetText(selectedMonth);
		boolean StartDateValue = elementActions.dogetAttributeEmptybyClass(startdate);
		if (StartDateValue == false) {
			extentReport.logToExtentReport("Verification - The start date has been set for the month " + month + "");
		}
		boolean EndDateValue = elementActions.dogetAttributeEmptybyClass(endDate);
		if (EndDateValue == false) {
			extentReport.logToExtentReport("Verification - The end date has been set for the month " + month + "");
		}
		boolean SavedDaysOff = elementActions.doIsDisplayed2(daysoffSaved);
		boolean SavedTimeSlot = elementActions.doIsDisplayed2(deleteButton);
		if (SavedDaysOff == true && SavedTimeSlot == true) {
			extentReport.logToExtentReport("Verification - Verifying whether Working days and Days off are displayed");
		} else {
			extentReport.logToExtentReport("Verification - Working days and days off have not been set for this month");
		}
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Adding more months by
	 * clicking on Add more months link
	 */
	@Step("Verify the functionality of Add more months link")
	public void VerifytheFunctionalityofAddMoreMonthsLink() throws Throwable, ElementClickInterceptedException {
//		Thread.sleep(6000);
		elementActions.scrollToElementByText(" Add more months ");
		String LastMonth = elementActions.doGetText(selectAddedMonth);
		if (LastMonth.contains("December")) {
			extentReport.logToExtentReport(
					"Verification - Will not be able to add a new month because all months of the year have already been selected");
			return;
		}
		extentReport.logToExtentReport("Clicking on 'Add more months' link");
		elementActions.JavaScriptExecutorClick(addMoreMonths);
//		Thread.sleep(6000);
		extentReport.logToExtentReport("Clicking on added month");
		elementActions.JavaScriptExecutorClick(selectAddedMonth);
		boolean StartDateBeEmpty = elementActions.dogetAttributeEmptybyId(startdate);
		boolean EndDateBeEmpty = elementActions.dogetAttributeEmptybyId(endDate);
		Thread.sleep(2000);
		boolean DeleteButton = elementActions.doIsDisplayed2(deleteButtons);
		if (StartDateBeEmpty == true && EndDateBeEmpty == true && DeleteButton == false) {
			extentReport.logToExtentReport("Verification - Verifying whether new month is added");
		} else {
			extentReport.logToExtentReport("Verification - Unable to add a new month");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Scheduling doctor
	 * availability dates
	 */
	@Step("Verify the doctor availability schedule")
	public void VerifytheDoctorAvailabilitySchedule()
			throws Throwable, ElementClickInterceptedException, StaleElementReferenceException {
		List<WebElement> timeslotAvailability = elementActions.getElements(lstTimeslots);

//		Thread.sleep(2000);
		DeleteTimeSlots();
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on start date calendar icon");
		elementActions.waitForElementClickable(startDateCalendar);
		if (elementActions.doIsDisplayed(allDates)) {
			extentReport.logToExtentReport("Verification - Verifying whether dates are displayed on the calendar");
		}
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting the availability start date");
		elementActions.JavaScriptExecutorClick(availabilityStartDate);
		elementActions.waitForElementClickable(startDateCalendar);
		extentReport.logToExtentReport("Checking whether the date is selected");
		elementActions.doIsDisplayed(selectedStartDate);
//		Thread.sleep(2000);
		boolean SelectedDate = elementActions.dogetAttributeEmptybyClass(startdate);
//		elementActions.JavaScriptExecutorClick(AvailabilityStartDate);
		extentReport.logToExtentReport("Checking whether the start date textfield is not empty");
		if (SelectedDate == false) {
			extentReport.logToExtentReport("Verification - Verifying whether selected start date is added");
		}
		Thread.sleep(2000);
		elementActions.moveToElementAndClick(endDateCalendar);
		elementActions.moveToElementAndClick(endDateCalendar);
		Thread.sleep(2000);
		// elementActions.waitForElementClickable(startDateCalendar);

		// elementActions.JavaScriptExecutorClick(availabilityStartDate);
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on end date calendar icon");
		// elementActions.waitForElementClickable(endDateCalendar);
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting the availability end date");
		elementActions.JavaScriptExecutorClick(endDateCalendarEndDate);
//		Thread.sleep(2000);
		elementActions.waitForElementClickable(endDateCalendar);
		boolean EndDate = elementActions.dogetAttributeEmptybyClass(endDateCalendarEndDate);
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Checking whether the date is selected");
		elementActions.doIsDisplayed(selectedEndDate);
		extentReport.logToExtentReport("Checking whether the end date textfield is not empty");
		if (EndDate == false) {
			extentReport.logToExtentReport("Verification - Verifying whether selected end date is added");
		} else {
			extentReport.logToExtentReport("Verification - Verifying whether selected end date is not added");
		}
		elementActions.JavaScriptExecutorClick(endDateCalendarEndDate);
	}

	@Step("Verify the doctor availability schedule")
	public boolean VerifytheDoctorAvailabilityScheduleforAPpointment()
			throws Throwable, ElementClickInterceptedException, StaleElementReferenceException {

//		Thread.sleep(2000);
		// DeleteTimeSlots();
//		Thread.sleep(2000);
		System.out.println(elementActions.getElement(moreTimings).getText());
		boolean istrue = (elementActions.getElement(moreTimings).getText()).equalsIgnoreCase("Add more timings");
		if (istrue) {
			extentReport.logToExtentReport("Clicking on start date calendar icon");
			elementActions.waitForElementClickable(startDateCalendar);
			if (elementActions.doIsDisplayed(allDates)) {
				extentReport.logToExtentReport("Verification - Verifying whether dates are displayed on the calendar");
			}
//		Thread.sleep(2000);
			extentReport.logToExtentReport("Selecting the availability start date");
			elementActions.JavaScriptExecutorClick(availabilityStartDate);
			elementActions.waitForElementClickable(startDateCalendar);
			extentReport.logToExtentReport("Checking whether the date is selected");
			elementActions.doIsDisplayed(selectedStartDate);
//		Thread.sleep(2000);
			boolean SelectedDate = elementActions.dogetAttributeEmptybyClass(startdate);
//		elementActions.JavaScriptExecutorClick(AvailabilityStartDate);
			extentReport.logToExtentReport("Checking whether the start date textfield is not empty");
			if (SelectedDate == false) {
				extentReport.logToExtentReport("Verification - Verifying whether selected start date is added");
			}
			Thread.sleep(2000);
			elementActions.moveToElementAndClick(endDateCalendar);
			elementActions.moveToElementAndClick(endDateCalendar);
			Thread.sleep(2000);
			elementActions.JavaScriptExecutorClick(availabilityStartDate);
//		Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking on end date calendar icon");
			elementActions.waitForElementClickable(endDateCalendar);
//		Thread.sleep(2000);
			extentReport.logToExtentReport("Selecting the availability end date");
			elementActions.JavaScriptExecutorClick(endDateCalendarEndDate);
//		Thread.sleep(2000);
			elementActions.waitForElementClickable(endDateCalendar);
			boolean EndDate = elementActions.dogetAttributeEmptybyClass(endDateCalendarEndDate);
//		Thread.sleep(2000);
			extentReport.logToExtentReport("Checking whether the date is selected");
			elementActions.doIsDisplayed(selectedEndDate);
			extentReport.logToExtentReport("Checking whether the end date textfield is not empty");
			if (EndDate == false) {
				extentReport.logToExtentReport("Verification - Verifying whether selected end date is added");
			} else {
				extentReport.logToExtentReport("Verification - Verifying whether selected end date is not added");
			}
			elementActions.JavaScriptExecutorClick(endDateCalendarEndDate);
		}
		return istrue;
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Verifying calendar dates
	 * showing only dates of the selected month
	 */
	@Step("Verify that user can select date from calendar , calendar dates should show only dates of selected month"
			+ "and selected dates should be autofilled in Start and End date fields")
	public void VerifyThatUserCanSelectDateFromCalendar() throws Throwable, ElementClickInterceptedException {
		elementActions.scrollToElementByText(" Add more months ");
		extentReport.logToExtentReport("Clicking on month");
//		Thread.sleep(4000);
		elementActions.JavaScriptExecutorClick(selectAddedMonth);
//		Thread.sleep(2000);
		elementActions.JavaScriptExecutorClick(calendarLink);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on start date calendar icon");
		elementActions.waitForElementClickable(startDateCalendar);
		extentReport.logToExtentReport("Getting the text of added month and customizing");
		String fullText = elementActions.doGetText(selectAddedMonth);
		String firstThreeLetters = fullText.substring(0, 3);
		String SelectedMonthText = firstThreeLetters.toUpperCase();
		extentReport.logToExtentReport("Getting the text of month from the start date calendar");
		String textStartMonthYear = elementActions.doGetText(startMonthYearText);
		if (textStartMonthYear.contains(SelectedMonthText)) {
			elementActions.doIsDisplayed(allDates);
			extentReport.logToExtentReport(
					"Verification - Verifying whether only the dates of the selected month are visible in the start-month calendar");
		} else {
			// fail();
		}
//		boolean OnlySelectedStartMonthsDates = elementActions.VerifyText(SelectedMonth, StartMonthYearText);
		elementActions.JavaScriptExecutorClick(lastDate);
		elementActions.waitForElementClickable(startDateCalendar);
		if (elementActions.doIsDisplayed(lastDateSelected)) {
			extentReport.logToExtentReport("Verification - Verifying whether selected date is displayed");
		} else {
			// fail();
		}
		elementActions.JavaScriptExecutorClick(lastDate);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on end date calendar icon");
		elementActions.waitForElementClickable(endDateCalendar);
		extentReport.logToExtentReport("Getting the text of month from the end date calendar");
		String textEndMonthYearText = elementActions.doGetText(endMonthYearText);
		if (textEndMonthYearText.contains(SelectedMonthText)) {
			elementActions.doIsDisplayed(allDates);
			extentReport.logToExtentReport(
					"Verification - Verifying whether only the dates of the selected month are visible in the end-month calendar");
		} else {
			// fail();
		}

		// boolean OnlySelectedEndMonthsDates =
		// elementActions.VerifyText(SelectAddedMonth, EndMonthYearText);
		elementActions.JavaScriptExecutorClick(lastDate);
		elementActions.waitForElementClickable(endDateCalendar);
		if (elementActions.doIsDisplayed(lastDateSelected)) {
			extentReport.logToExtentReport("Verification - Verifying whether selected date is displayed");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 14/09/23 Description : Adding more timings by
	 * clicking on add more timings link
	 */
	@Step("Verify the Add more timing link functionality , CLick on (+)Add more timings link")
	public void VerifytheAddMoreTimingLinkFunctionality() throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Deleting the saved time slots,if there are any saved time slots");
		Thread.sleep(2000);
		DeleteTimeSlots();
//		Thread.sleep(2000);
		VerifytheDoctorAvailabilitySchedule();
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Add more months' link");
		elementActions.JavaScriptExecutorClick(moreTimings);
//		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(startTime) && elementActions.doIsDisplayed(endTime)
				&& elementActions.doIsDisplayed(startTimeAmPm) && elementActions.doIsDisplayed(endTimeAmPm)
				&& elementActions.doIsDisplayed(selectDay) && elementActions.doIsDisplayed(moreTimingsSave)
				&& elementActions.doIsDisplayed(moreTimingsCancel)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether Start time field , End time field and Days field are displayed along with Save and Cancel buttons");
		} else {
			// fail();
		}
	}

	@Step("Verify the Add more timing link functionality , CLick on (+)Add more timings link")
	public boolean VerifytheAddMoreTimingLinkFunctionalityForAppointments()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Deleting the saved time slots,if there are any saved time slots");
		Thread.sleep(2000);
//		DeleteTimeSlots();
//		Thread.sleep(2000);
		boolean istrue = VerifytheDoctorAvailabilityScheduleforAPpointment();
//		Thread.sleep(2000);
		if (istrue) {
			extentReport.logToExtentReport("Clicking on 'Add more months' link");
			elementActions.JavaScriptExecutorClick(moreTimings);
//		Thread.sleep(2000);
			if (elementActions.doIsDisplayed(startTime) && elementActions.doIsDisplayed(endTime)
					&& elementActions.doIsDisplayed(startTimeAmPm) && elementActions.doIsDisplayed(endTimeAmPm)
					&& elementActions.doIsDisplayed(selectDay) && elementActions.doIsDisplayed(moreTimingsSave)
					&& elementActions.doIsDisplayed(moreTimingsCancel)) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether Start time field , End time field and Days field are displayed along with Save and Cancel buttons");
			} else {
				// fail();
			}
		}
		return istrue;
	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Verifying user is able
	 * to select the time from the dropdown
	 */
	@Step("Verify that user can select the time from dropdown")
	public void VerifythatUserCanSelecttheTimeFromDropdown() throws Throwable, ElementClickInterceptedException {
		Thread.sleep(2000);
		this.VerifytheAddMoreTimingLinkFunctionality();
		extentReport.logToExtentReport("Clicking on start time dropdown");
		Thread.sleep(4000);
		elementActions.waitForElementClickable(startTime);
		Thread.sleep(2000);
		String StartTimeText = elementActions.doGetText(selectStartTime);
		extentReport.logToExtentReport("Selecting start time");
		elementActions.waitForElementClickable(selectStartTime);
		boolean StartTimeSElected = elementActions.VerifyText2(startTime, StartTimeText);
		if (StartTimeSElected == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected start time is displayed in the start time textfield");
		} else {
			// fail();
		}
		extentReport.logToExtentReport("Clicking on start time AM PM dropdown");
		Thread.sleep(2000);
		// elementActions.waitForElementClickable(selectStartTimeAm);..startTimeAmPm
		elementActions.waitForElementClickable(startTimeAmPm);
		extentReport.logToExtentReport("Clicking on AM");
		elementActions.waitForElementClickable(selectStartTimeAm);
		if (elementActions.doGetText(startTimeAmPm).equalsIgnoreCase("AM")) {
			extentReport
					.logToExtentReport("Verification - Verifying whether selected 'AM' is displayed in the textfield");
		} else {
			// fail();
		}
		extentReport.logToExtentReport("Clicking on end time dropdown");
		elementActions.waitForElementClickable(endTime);
//		Thread.sleep(2000);
		String EndTimeText = elementActions.doGetText(selectEndTime);
		extentReport.logToExtentReport("Selecting end time");
		elementActions.waitForElementClickable(selectEndTime);
		boolean EndTimeSElected = elementActions.VerifyText2(endTime, EndTimeText);
		if (EndTimeSElected == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected end time is displayed in the end time textfield");
		} else {
			// fail();
		}
		extentReport.logToExtentReport("Clicking on end time AM PM dropdown");
		elementActions.waitForElementClickable(endTimeAmPm);
		extentReport.logToExtentReport("Clicking on PM");
		elementActions.waitForElementClickable(selectEndTimePm);
		if (elementActions.doGetText(endTimeAmPm).equalsIgnoreCase("PM")) {
			extentReport
					.logToExtentReport("Verification - Verifying whether selected 'PM' is displayed in the textfield");
		} else {
			// fail();
		}
	}

	@Step("Verify that user can select the time from dropdown")
	public boolean VerifythatUserCanSelecttheTimeFromDropdownForAppointment()
			throws Throwable, ElementClickInterceptedException {
		Thread.sleep(2000);
		boolean istrue = VerifytheAddMoreTimingLinkFunctionalityForAppointments();
		if (istrue) {
			extentReport.logToExtentReport("Clicking on start time dropdown");
			Thread.sleep(4000);
			elementActions.waitForElementClickable(startTime);
			Thread.sleep(2000);
			String StartTimeText = elementActions.doGetText(selectStartTime);
			extentReport.logToExtentReport("Selecting start time");
			elementActions.waitForElementClickable(selectStartTime);
			boolean StartTimeSElected = elementActions.VerifyText2(startTime, StartTimeText);
			if (StartTimeSElected == true) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether selected start time is displayed in the start time textfield");
			} else {
				// fail();
			}
			extentReport.logToExtentReport("Clicking on start time AM PM dropdown");
			Thread.sleep(2000);
			// elementActions.waitForElementClickable(selectStartTimeAm);..startTimeAmPm
			elementActions.waitForElementClickable(startTimeAmPm);
			extentReport.logToExtentReport("Clicking on AM");
			elementActions.waitForElementClickable(selectStartTimeAm);
			if (elementActions.doGetText(startTimeAmPm).equalsIgnoreCase("AM")) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether selected 'AM' is displayed in the textfield");
			} else {
				// fail();
			}
			extentReport.logToExtentReport("Clicking on end time dropdown");
			elementActions.waitForElementClickable(endTime);
//		Thread.sleep(2000);
			String EndTimeText = elementActions.doGetText(selectEndTime);
			extentReport.logToExtentReport("Selecting end time");
			elementActions.waitForElementClickable(selectEndTime);
			boolean EndTimeSElected = elementActions.VerifyText2(endTime, EndTimeText);
			if (EndTimeSElected == true) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether selected end time is displayed in the end time textfield");
			} else {
				// fail();
			}
			extentReport.logToExtentReport("Clicking on end time AM PM dropdown");
			elementActions.waitForElementClickable(endTimeAmPm);
			extentReport.logToExtentReport("Clicking on PM");
			elementActions.waitForElementClickable(selectEndTimePm);
			if (elementActions.doGetText(endTimeAmPm).equalsIgnoreCase("PM")) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether selected 'PM' is displayed in the textfield");
			} else {
				// fail();
			}
		}
		return istrue;
	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Saving the Doctor's
	 * availability
	 */
	@Step("Verify clicking on save button in calendar , "
			+ "Selected Start time,end time & days should be shown along with Delete button")
	public void VerifyClickingonSaveButtonAfterAddingTime() throws Throwable, ElementClickInterceptedException {
//		Thread.sleep(2000);
		this.VerifythatUserCanSelecttheTimeFromDropdown();
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting the days");
		elementActions.waitForElementClickable(selectDay);
		List<WebElement> Day = elementActions.getElements(selectTheDay);
		for (Iterator<WebElement> iterator = Day.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			webElement.click();
		}
		String DaysText = elementActions.doGetText(selectDay);
		if (DaysText.contains("Mon") && DaysText.contains("Tue") && DaysText.contains("Wed") && DaysText.contains("Thu")
				&& DaysText.contains("Fri")) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected days are displayed in the Days Field");
		} else {
			// fail();
		}
//		Thread.sleep(3000);
		extentReport.logToExtentReport("Clicking on save button to save the slot");elementActions.waitForElementClickable(saveSlot);if(elementActions.doIsDisplayed(deleteButton))
	{
		extentReport.logToExtentReport("Verification - Verifying whether working days and timings have been set");
	}else
	{
		extentReport.logToExtentReport("Unable to set working days and timings");
		// fail();
	}
	}

	@Step("Verify clicking on save button in calendar , "
			+ "Selected Start time,end time & days should be shown along with Delete button")
	public boolean VerifyClickingonSaveButtonAfterAddingTimeForAppointment()
			throws Throwable, ElementClickInterceptedException {
//		Thread.sleep(2000);
		boolean istrue = VerifythatUserCanSelecttheTimeFromDropdownForAppointment();
//		Thread.sleep(2000);
		if (istrue) {
			extentReport.logToExtentReport("Selecting the days");
			elementActions.waitForElementClickable(selectDay);
			List<WebElement> Day = elementActions.getElements(selectTheDay);
			for (Iterator<WebElement> iterator = Day.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				webElement.click();
			}
			String DaysText = elementActions.doGetText(selectDay);
			if (DaysText.contains("Mon") && DaysText.contains("Tue") && DaysText.contains("Wed")
					&& DaysText.contains("Thu") && DaysText.contains("Fri")) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether selected days are displayed in the Days Field");
			} else {
				// fail();

			}

//		Thread.sleep(3000);
			extentReport.logToExtentReport("Clicking on save button to save the slot");
			elementActions.waitForElementClickable(saveSlot);
			if (elementActions.doIsDisplayed(deleteButton)) {
				extentReport
						.logToExtentReport("Verification - Verifying whether working days and timings have been set");
			} else {
				extentReport.logToExtentReport("Unable to set working days and timings");
				// fail();
			}
		}
		return istrue;
	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Deleting the saved
	 * timings by clicking on delete button
	 */
	@Step("Clicking delete functionality in calendar ")
	public void VerifyDeleteFunctionalityInCalendarSavedTimings() throws Throwable, ElementClickInterceptedException {
		VerifyClickingonSaveButtonAfterAddingTime();
		extentReport.logToExtentReport("Clicking on delete button to delete the saved slot");
		try {
			elementActions.JavaScriptExecutorClick(deleteButton);
			extentReport.logToExtentReport("Verification - Verifying whether confirm popup is displayed");
			elementActions.doIsDisplayed(confirmPopup);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Confirming the popup
	 * elements
	 */
	@Step("Verify delete functionality in calendar and verify its confirm popup elements")
	public void VerifyDeleteConfirmPopup() throws Throwable, ElementClickInterceptedException {
		Thread.sleep(6000);
		this.VerifyDeleteFunctionalityInCalendarSavedTimings();
		if (elementActions.doIsDisplayed(confirmText) && elementActions.doIsDisplayed(popupText)
				&& elementActions.doIsDisplayed(confirmButton) && elementActions.doIsDisplayed2(cancelButton)) {
			extentReport.logToExtentReport("Verification - Verifying the confirm popup elements");
		} else {
			// fail();
		}
		Thread.sleep(6000);

	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Confirming to delete the
	 * saved slot
	 */
	@Step("Verify confirm functionality when clicked on delete in calendar , Delete the slot by clicking on confirm")
	public void VerifyConfirmFunctionalityWhenClickedonDeleteinCalendar()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyDeleteFunctionalityInCalendarSavedTimings();
		try {
			elementActions.waitForElementClickable(confirmButton);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		boolean NotVisible = elementActions.doIsDisplayed2(deleteButton);
		if (NotVisible == true) {
			throw new Exception("Error : Slot is not deleted");
		}
		if (NotVisible == false) {
			extentReport.logToExtentReport("Verification - Verifying whether time slot is displayed");
		} else {
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Changing or updating the
	 * dates
	 */
	@Step("User able to change/update selected dates")
	public void ChangeSelectedDates() throws Throwable, ElementClickInterceptedException {
		this.VerifythatUserCanSelecttheTimeFromDropdown();
//		Thread.sleep(2000);
		elementActions.waitForElementClickable(startDateCalendar);
		String StartText = elementActions.doGetText(dateSelectedTrue);
		elementActions.waitForElementClickable(dateSelectedTrue);
		elementActions.waitForElementClickable(endDateCalendar);
		String EndText = elementActions.doGetText(dateSelectedTrue);
		elementActions.waitForElementClickable(dateSelectedTrue);
		extentReport.logToExtentReport("Selecting the day");
		elementActions.waitForElementClickable(selectDay);
		List<WebElement> Day = elementActions.getElements(selectTheDay);
		for (Iterator<WebElement> iterator = Day.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			webElement.click();
		}
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on start date calendar");
		elementActions.doClick(saveSlot);

		elementActions.waitForElementClickable(startDateCalendar);
		extentReport.logToExtentReport("Changing the start date");
		elementActions.JavaScriptExecutorClick(endDateCalendarEndDateSecond);
		extentReport.logToExtentReport("Click on end date calendar");
		elementActions.waitForElementClickable(endDateCalendar);
		extentReport.logToExtentReport("Changing the end date");
		elementActions.waitForElementClickable(availabilityStartDate);
//		Thread.sleep(2000);
		elementActions.waitForElementClickable(startDateCalendar);
		String ChangedStartText = elementActions.doGetText(dateSelectedTrue);
		elementActions.waitForElementClickable(dateSelectedTrue);
		elementActions.waitForElementClickable(endDateCalendar);
		String ChangedEndText = elementActions.doGetText(dateSelectedTrue);
		elementActions.waitForElementClickable(dateSelectedTrue);
		boolean UpdatedStart = elementActions.ComparingValues(StartText, ChangedStartText);
		boolean UpdatedEnd = elementActions.ComparingValues(EndText, ChangedEndText);
		if (UpdatedStart == false && UpdatedEnd == false) {
			extentReport.logToExtentReport("Verification - Verifying whether dates are changed");
		} else {
			extentReport.logToExtentReport("Unable to change the dates");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 15/09/23 Description : Verifying the days off
	 * calendar
	 */
	@Step("Verify clicking on calendar icon under days off section")
	public void VerifyClickingonCalendarIconUnderDaysoffSection() throws Throwable, ElementClickInterceptedException {
		elementActions.scrollToElementByText(" Add more months ");
		extentReport.logToExtentReport("Selecting a month");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(selectAddedMonth);
		extentReport.logToExtentReport("Deleting the saved time slots,if there are any saved time slots");
		DeleteMarkedDaysOff();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		elementActions.doIsDisplayed(allDates);
		boolean SelectedMonthCalendar = elementActions.VerifyText(selectAddedMonth, startMonthYearText);
		if (SelectedMonthCalendar == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether Days off calendar is showing dates of the selected month");
		} else {
			extentReport.logToExtentReport("Days off calendar is not showing dates of the selected month");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 21/09/23 Description : Selecting the date from
	 * days off calendar
	 */
	@Step("Select Days off from calendar")
	public String VerifyUsercanSelectDatefromCalendarUnderDaysoffSection()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyClickingonCalendarIconUnderDaysoffSection();
		String SelectedDate = elementActions.doGetText(lastDate);
		this.selectedDate = SelectedDate;
		Thread.sleep(4000);
		extentReport.logToExtentReport("Selecting a day for dayoff");
		elementActions.JavaScriptExecutorClick(lastDate);
		String DaysOffFieldText = elementActions.doGetText(daysOffField);
		if (SelectedDate.contains(DaysOffFieldText)) {
			extentReport.logToExtentReport("Verification - Verifying whether selected date is displayed");
		} else {
			extentReport.logToExtentReport("Selected date is not displayed");
			// fail();
		}
		Thread.sleep(3000);
		extentReport.logToExtentReport("Checking the daysoff textfield is not empty after selecting the date");
		elementActions.dogetAttributeEmptybyClass(daysOffField);
		return SelectedDate;
	}

	/*
	 * Author : Rajesh H S Created : 21/09/23 Description : Clicking on save button
	 * and checking whether confirm popup is displayed or not after selecting
	 * multiple dates
	 */
	@Step("Verify save functionality after selecting multiple dates under days off section")
	public void VerifySaveFunctionalityAfterSelectingMultipleDatesUnderDaysoffSection()
			throws Throwable, ElementClickInterceptedException {
		elementActions.scrollToElementByText(" Add more months ");
		extentReport.logToExtentReport("Clicking on a month");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(selectAddedMonth);
		Thread.sleep(2000);
		DeleteMarkedDaysOff();
		Thread.sleep(3000);
		extentReport.logToExtentReport("Click on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting multiple dates");
		elementActions.doSelectMultipleElements(allDates);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on save button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		boolean PopUp = elementActions.doIsDisplayed(daysoffConfirmPopup);
		if (PopUp == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether confirm popup is displayed after selecting multiple dates");
		} else {
			extentReport.logToExtentReport("Confirm popup is not displayed after selecting multiple dates");
//			fail();
		}

	}

	@Step("Verify confirm functionality after selecting multiple dates under days off section")
	public void VerifyConfirmFunctionalityAfterSelectingMultipleDatesUnderDaysoffSection()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport(
				"Clicking on confirm button in the popup after selecting multiple dates under days off section");
		this.SelectMultipleDaysoff();
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Verifying the popup
	 * elements
	 */
	@Step("Verify the confirm popup when clicked on Save under days off section")
	public void VerifyTheConfirmPopupWhenClickedOnSaveUnderDaysoffSection()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyTheFunctionalityOfSaveButtonUnderDaysOffSectionAfterSelectingSingleDate();
		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(confirmButton) && elementActions.doIsDisplayed(cancelButton)
				&& elementActions.doIsDisplayed(saveDaysoffPopupText)) {
			extentReport.logToExtentReport(
					"Verification - Verifying that the 'Confirm' button, 'Cancel' button & 'Save Days off' text is displayed in the confirm popup when clicked on Save under days off section");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Confirming to save the
	 * days off
	 */
	@Step("Verify clicking confirm in the popup when clicked on Save under days off section")
	public void VerifyClickingConfirmInThePopupWhenClickedOnSaveUnderDaysOffSection()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyTheConfirmPopupWhenClickedOnSaveUnderDaysoffSection();
		Thread.sleep(4000);
		extentReport.logToExtentReport("Clicking on confirm button on save days of popup");
		elementActions.waitForElementClickable(confirmButton);
		WebElement Highlighted = elementActions.getElement(daysoffSaved);
		extentReport.logToExtentReport("Verification - Verifying whether saved daysoff is highlighted in blue color");
		elementActions.doHighlightedInBlueColorDaysOff(Highlighted);
		Thread.sleep(3000);
		String SavedDaysOff = elementActions.doGetText(firstSavedDayOff);
		if (SavedDaysOff.contains(selectedDate)) {
			extentReport.logToExtentReport("Verification - Verifying whether selected date is marked as days off");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Selecting multiple dates
	 * in a months for day off
	 */
	@Step("Verify whether user can select multiple dates in month under days off section")
	public void SelectMultipleDaysoff() throws Throwable, ElementClickInterceptedException {
		elementActions.scrollToElementByText(" Add more months ");
		extentReport.logToExtentReport("Clicking on a month");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(selectAddedMonth);
		Thread.sleep(2000);
		DeleteMarkedDaysOff();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		Thread.sleep(2000);
		String SelectedDates = elementActions.doGetText(allDates);
		extentReport.logToExtentReport("Selecting multiple dates");
		elementActions.doSelectMultipleElements(allDates);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on save button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on confirm button");
		elementActions.waitForElementClickable(confirmButton);
		String SavedText = elementActions.doGetText(daysoffSaved);
		WebElement SavedDaysOff = elementActions.getElement(daysoffSaved);
		if (SavedText.contains(SelectedDates)) {
			extentReport.logToExtentReport("Verification - Verifying whether selected days are marked as dayoff");
		} else {
			extentReport.logToExtentReport("Selected days are not marked as dayoff");
//			fail();
		}
		extentReport.logToExtentReport("Verification - Verifying whether saved daysoff is highlighted in blue color");
		elementActions.doHighlightedInBlueColorDaysOff(SavedDaysOff);
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Removing the selected
	 * days off
	 */
	@Step("Verify whether selected days off date can be removed under days off section")
	public void VerifyWhetherSelectedDaysOffDateCanBeRemovedUnderDaysOffSection()
			throws Throwable, ElementClickInterceptedException {
		this.SelectMultipleDaysoff();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on remove days off button");
		elementActions.waitForElementClickable(removeDaysoff);
		boolean PopUpDisplayed = elementActions.doIsDisplayed(daysoffRemovePopup);
		if (PopUpDisplayed == true) {
			extentReport.logToExtentReport("Verification - Verifying whether confirm Popup is displayed");
		} else {
//			fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Confirming the popup
	 * elements
	 */
	@Step("Verify the confirm popup when dates are to be removed under days off section")
	public void VerifyTheConfirmPopupWhenDatesAreToBeRemovedUnderDaysOffSection()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyWhetherSelectedDaysOffDateCanBeRemovedUnderDaysOffSection();
		if (elementActions.doIsDisplayed(confirmText) && elementActions.doIsDisplayed(daysoffRemovePopupText)
				&& elementActions.doIsDisplayed(confirmButton) && elementActions.doIsDisplayed(cancelButton)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether all elements of remove daysoff confirm Popup are displayed");
		}
	}

	/*
	 * Author : Rajesh H S Created : 22/09/23 Description : Confirming to remove the
	 * days off by clicking on confirm button in the popup
	 */
	@Step("Verify clicking confirm in the popup when dates are to be removed under days off section")
	public void VerifyClickingConfirmInThePopupWhenDatesAreToBeRemovedUnderDaysOffSection()
			throws Throwable, ElementClickInterceptedException {
		VerifyTheConfirmPopupWhenDatesAreToBeRemovedUnderDaysOffSection();
		DeleteMarkedDaysOff();
		try {
			Thread.sleep(2000);
			elementActions.doClick(confirmButton);
		} catch (Exception e) {
			// TODO: handle exception
		}
		elementActions.doIsDisplayed(pleaseWaitLoader);
		Thread.sleep(2000);
		boolean Removed = elementActions.doIsDisplayed2(daysoffSaved);
		if (Removed == false) {
			Thread.sleep(2000);
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected dayoff is removed and 'Please Wait' loader is displayed");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : Changing or updating the
	 * days off's dates
	 */
	@Step("Verify whether user able to change/update selected dates")
	public void VerifyWheTherUserAbleToChangeorUpdateSelectedDates()
			throws Throwable, ElementClickInterceptedException {
		elementActions.scrollToElementByText(" Add more months ");
		extentReport.logToExtentReport("Clicking on a month");
//		Thread.sleep(6000);
		elementActions.waitForElementClickable(selectAddedMonth);
		DeleteMarkedDaysOff();
		extentReport.logToExtentReport("Clicking on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
//		Thread.sleep(2000);
		String FirstDayOff = elementActions.doGetText(lastDate);
//		Thread.sleep(3000);
		extentReport.logToExtentReport("Selecting  a date");
		elementActions.JavaScriptExecutorClick(lastDate);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		Thread.sleep(2000);
		String SecondDayOff = elementActions.doGetText(lastSecondDate);
		extentReport.logToExtentReport("Selecting  another date");
		elementActions.JavaScriptExecutorClick(lastSecondDate);
		extentReport.logToExtentReport("Clicking on save button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		extentReport.logToExtentReport("Clicking on confirm button");
		elementActions.waitForElementClickable(confirmButton);
		String Saved = elementActions.doGetText(daysoffSaved);
		String Saved2 = elementActions.doGetText(secondSavedDayOff);
		if (!FirstDayOff.equals(SecondDayOff) && Saved.contains(FirstDayOff) && Saved2.contains(SecondDayOff)) {
			extentReport.logToExtentReport("Verification - Verifying whether 'Days off' updated successfully");
		} else {
			// fail();
		}
		WebElement FirstSaved = elementActions.getElement(firstSavedDayOff);
		WebElement SecondSaved = elementActions.getElement(secondSavedDayOff);
		extentReport.logToExtentReport("Verification - Verifying whether saved days off are highlighted in blue color");
		elementActions.doHighlightedInBlueColorDaysOff(FirstSaved);
		elementActions.doHighlightedInBlueColorDaysOff(SecondSaved);
	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : Saving the days off by
	 * clicking on save button and verifying the confirm popup is displayed
	 */
	@Step("Verify the functionality of save button under days off section after selecting single date")
	public void VerifyTheFunctionalityOfSaveButtonUnderDaysOffSectionAfterSelectingSingleDate()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyUsercanSelectDatefromCalendarUnderDaysoffSection();
		extentReport.logToExtentReport("Clicking on save  button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		extentReport.logToExtentReport(
				"Verification - Verifying whether confirm popup is displayed when clicked on save button under days off section after selecting single date");
		elementActions.doIsDisplayed(daysoffConfirmPopup);
	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : Confirming the days off
	 */
	@Step("Confirm & save the updated days off")
	public void VerifyConfirmFunctionalityWhenClickedOnSaveUnderDaysOffSection()
			throws Throwable, ElementClickInterceptedException {
		this.VerifyTheFunctionalityOfSaveButtonUnderDaysOffSectionAfterSelectingSingleDate();
		extentReport.logToExtentReport("Clicking on confirm button");
		elementActions.waitForElementClickable(confirmButton);
		elementActions.doIsDisplayed(daysoffSaved);
		WebElement Saved = elementActions.getElement(daysoffSaved);
		extentReport.logToExtentReport(
				"Verification - Verifying whether the updated days off is highlighted in blue color");
		elementActions.doHighlightedInBlueColorDaysOff(Saved);
	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : Verifying the days off
	 * is displayed in the calendar
	 */
	@Step("Verify the saved day off is marked as day off in monthly calendar ")
	public void VerifyTheSavedDayOffIsMarkedAsDayOffInMonthlyCalendar()
			throws Throwable, ElementClickInterceptedException {
		DeleteMarkedDaysOff();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting a date from the daysoff calendar");
		elementActions.waitForElementClickable(availabilityStartDate);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on save button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on confirm button");
		elementActions.waitForElementClickable(confirmButton);
		Thread.sleep(3000);
		elementActions.waitForElementClickable(calendarLink);
		Thread.sleep(3000);
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(5000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(monthlyTab);
		Thread.sleep(3000);
		boolean DayOff = elementActions.doIsDisplayed(monthlyCalendarDayOff);
		if (DayOff == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether saved daysOff date is marked as dayoff in the monthly calendar");
		} else {
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : Verifying the 'Calendar'
	 * title and 'Manage Calendar' button is displayed
	 */
	@Step("Verify that your calendar title And Manage Calendar button display in screen")
	public void VerifyCalendarTitleAndManageCalendarButtonDisplayedOnTheScreen()
			throws InterruptedException, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(2000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		if (elementActions.doIsDisplayed(yourCalendarTitle) && elementActions.doIsDisplayed(manageCalendarButton)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Your Calendar' title and 'Manage Calendar' button are displayed");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 25/09/23 Description : User can see the date
	 * and can change the date
	 */
	@Step("Verify that user can view the current date on Screen And can change the date")
	public void VerifyThatUserCanViewTheDateOnScreenAndCanChangeTheDate()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(20000);
		String CurrentDate = elementActions.doGetText(dateDayYearCalendar);// 25
		extentReport.logToExtentReport("Clicking on next arrow");
		Thread.sleep(10000);
		elementActions.waitForElementClickable(nextArrowCalendar);// 26
		Thread.sleep(8000);
		String NextDate = elementActions.doGetText(dateDayYearCalendar);// 26
		Thread.sleep(8000);
		extentReport.logToExtentReport("Clicking on previous arrow");
		elementActions.waitForElementClickable(previousArrowCalendar);// 25
		Thread.sleep(8000);
		String PreviousDate = elementActions.doGetText(dateDayYearCalendar);// 25
		Thread.sleep(8000);
		System.out.println(CurrentDate);
		System.out.println(NextDate);
		System.out.println(PreviousDate);
		if (!CurrentDate.equals(NextDate) && CurrentDate.equals(PreviousDate)) {
			extentReport.logToExtentReport("Verification - Verifying whether able to change the dates");
		} else {
			throw new Exception("Not able to change the dates");
		}
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying Appointments
	 * and follow up's are displayed in weekly calendar
	 */
	@Step("Appointment and Follow-up visit displayed in weekly calendar")
	public void VerifyThatAppointmentListAndFollowupListDisplayInTimeSlot()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);

		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();

		StringBuilder typeOfVisitsBuilder = new StringBuilder();

		for (int i = 0; i < TotalPatients; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);


			if (elementActions.doIsDisplayed2(appointmentTitle)) {
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				extentReport.logToExtentReport(
						"Verification - Verifying whether the type of visit 'Appointment' is displayed with Patient Name, Age, and Booked by Nurse details");
				if (typeOfVisitsBuilder.length() > 0) {
					typeOfVisitsBuilder.append(", ");
				}
				typeOfVisitsBuilder.append("Appointment");
			}

			if (elementActions.doIsDisplayed2(followUpVisitTitle)) {
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				extentReport.logToExtentReport(
						"Verification - Verifying whether the type of visit 'Follow Up' is displayed with Patient Name, Age, and Booked by Nurse details");
				if (typeOfVisitsBuilder.length() > 0) {
					typeOfVisitsBuilder.append(", ");
				}
				typeOfVisitsBuilder.append("Follow Up");
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
		}

		String typeOfVisits = typeOfVisitsBuilder.toString();

		if (!typeOfVisits.contains("Appointment")) {
			extentReport.logToExtentReport("Verification - No appointments found");
			// fail();
		}

		if (!typeOfVisits.contains("Follow Up")) {
			extentReport.logToExtentReport("Verification - No follow-up visits found");
			// fail();
		}

		if (elementActions.doIsDisplayed(weeklyCalendarCurrentTimeGreenLine)) {
			extentReport.logToExtentReport("Verification - Verifying whether the time line is displayed");
		}
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying gender and age
	 * is displayed beside patient's name
	 */
	@Step("Gender,Age is displayed beside Patient Name and Nurse name is dsplayed")
	public void GenderAgeisdisplayedbesidePatientNameAndNurseNameDisplayed()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on 'View Calendar'");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Verification : Verifying Appointments/Follow Up visit is displayed");
		elementActions.doIsDisplayed(dailyFollowUpAppointments);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);
			boolean Appointment = elementActions.doIsDisplayed2(appointmentTitle);
			boolean FollowUp = elementActions.doIsDisplayed2(followUpVisitTitle);
			if (FollowUp == true || Appointment == true) {
				char[] genderChar = elementActions.doGetLastChar(weeklyCalendarPatientNameandAge);
				String genderString = String.valueOf(genderChar);
				String gender = genderString.replaceAll("[^a-zA-Z]", "");
				if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is displayed");
				} else {
					extentReport.logToExtentReport("Gender is not displayed");
					// fail();
				}
				if (gender.equalsIgnoreCase("M")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Male'");
				}
				if (gender.equalsIgnoreCase("F")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Female'");
				}
				if (gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Other'");
				}
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				elementActions.doIsDisplayed(bookedBy);
				extentReport.logToExtentReport(
						"Verification - Verifying whether the type of visit-'Follow up'or 'Appointment',Patient,Name,Age,Booked by Nurse is displayed");
			}
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
		}
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying user is able
	 * to view the appointment details
	 */
	@Step("Verify that user can able to view the 'Completed' Appointment details popup")
	public void UserisAbleToViewTheCompletedAppointmentDetailsPopup()
			throws Throwable, ElementClickInterceptedException {

		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(7000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(2000);

		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		StringBuilder typeOfVisitsBuilder = new StringBuilder();
		StringBuilder visitStatusesBuilder = new StringBuilder();
		for (int i = 0; i < TotalPatients; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);

			String visit = elementActions.doGetText(calenadrPopupTypeOfVisitTitle);
			if (typeOfVisitsBuilder.length() > 0) {
				typeOfVisitsBuilder.append(", ");
			}
			typeOfVisitsBuilder.append(visit);

			if (elementActions.doIsDisplayed2(appointmentTitle) == true) {
				String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);
				if (VisitStatus.equalsIgnoreCase("Completed")) {
					if (visitStatusesBuilder.length() > 0) {
						visitStatusesBuilder.append(", ");
					}
					visitStatusesBuilder.append(VisitStatus);
					elementActions.doIsDisplayed(weeklyCalendarViewDetailsLink);
					elementActions.doIsDisplayed(weeklyCalendarPatientId);
					elementActions.doIsDisplayed(weeklyCalendarStatus);
					elementActions.doIsDisplayed(weeklyCalendarAppointmentOn);
					elementActions.doIsDisplayed(weeklyCalendarAppointmentBookedOn);
					elementActions.doIsDisplayed(weeklyCalendarChiefComplaint);
					elementActions.doIsDisplayed(weeklyCalendarEditPrescriptionButton);
					extentReport.logToExtentReport(
							"Verification - Verifying whether the completed 'Appointment' has 'Edit Prescription' button and all the elements of the popup are displayed");
					break;
				}
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
		}

		String allVisits = typeOfVisitsBuilder.toString();
		String appintmentVisitStatuses = visitStatusesBuilder.toString();

		if (!allVisits.contains("Appointment")) {
			extentReport.logToExtentReport("No 'Appointment' found");
			// fail();
		}
		if (!appintmentVisitStatuses.contains("Completed")) {
			extentReport.logToExtentReport("No Completed 'Appointment' found");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying the
	 * Appointment status , Prescription created message , Nurse name displaying
	 * correctly
	 */
	@Step("Verify that Appointment status , Prescription created message , Nurse name displaying correctly on appointment details popup")
	public void AppointmentStatusPrescriptionCreatedMessageNurseNameDisplayingCorrectlyOnAppointmentDetailsPopup()
			throws Throwable, ElementClickInterceptedException {
		UserisAbleToViewTheCompletedAppointmentDetailsPopup();
		if (elementActions.doIsDisplayed(weeklyCalendarStatus)
				&& elementActions.doIsDisplayed(weeklyCalendarFollowUpVisitPrescriptionCreated)
				&& elementActions.doIsDisplayed(weeklyCalendarBookedByNurse) && elementActions.doIsDisplayed(bookedBy)
				&& elementActions.doIsDisplayed2(weeklyCalendarAppointmentFollowUpCallIcon)) {

			extentReport.logToExtentReport(
					"Verification - Verifying whether the completed appointment popup has 'Prescription created text','Booked By' and 'Call Icon' is displayed");

			return;
		}
		extentReport.logToExtentReport("Required elements not found in the appointment details popup");
		// fail("Verification failed - Required elements not found in the appointment
		// details popup");
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying user can
	 * navigate to visit summary page by view details link
	 */
	@Step("Verify user can navigate to visit summary page by clicking  view details link on Appointment details popup")
	public void VerifyUserCanNavigateToVisitSummaryPageByClickingViewDetailsLinkOnAppointmentDetailsPopup()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(4000);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(5000);
			WebElement Patients = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(Patients);
			Thread.sleep(2000);

			boolean Appointment = elementActions.doIsDisplayed2(appointmentTitle);
			if (Appointment == true) {
				extentReport.logToExtentReport("Clicking on 'View Details' link");
				elementActions.waitForElementClickable(weeklyCalendarViewDetailsLink);
				Thread.sleep(2000);
				if (elementActions.doIsDisplayed(visitSummaryPageDisplayedVideoIcon)
						&& elementActions.doIsDisplayed(visitSummaryPageText)) {
					extentReport.logToExtentReport("Verification - Verifying whether visit summary page is displayed");
					break;
				}
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}
	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying user can
	 * navigate to visit summary page by Edit Prescription Button
	 */
	@Step("Verify user can navigate to visit summary page by clicking  Provide Prescription Button on Appointment/Follow-up visit details popup")
	public void VerifyUserCanNavigateToVisitSummaryPageByClickingProvidePrescriptionButtonOnAppointmentOrFollopVisitDetailsPopup()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		extentReport.logToExtentReport("Clicking on weekly tab");
//		Thread.sleep(2000);
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(4000);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(5000);
			WebElement Patients = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(Patients);
			Thread.sleep(2000);
			boolean VisitStatus = elementActions.doIsDisplayed2(inProgress);
			if (VisitStatus == true) {
				boolean ProvidePrescriptionButton = elementActions
						.doIsDisplayed2(weeklyCalendarAppointmentProvidePrescriptionButton);
				if (ProvidePrescriptionButton == true) {
					elementActions.waitForElementClickable(weeklyCalendarAppointmentProvidePrescriptionButton);
					Thread.sleep(3000);
					if (elementActions.doIsDisplayed(visitSummaryPageDisplayedVideoIcon)
							&& elementActions.doIsDisplayed(visitSummaryPageText)) {
						extentReport
								.logToExtentReport("Verification - Verifying whether visit summary page is displayed");
						break;
					}
				}
				if (ProvidePrescriptionButton == false) {
					throw new Exception("There is no provide prescription button");
				}
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(4000);

		}
	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : Verify that FollowUp
	 * Visit display in Weekly Calendar
	 */
	@Step("Verify that FollowUp list display in time slot")
	public void VerifyThatFollowUpListDisplayinTimeSlot() throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		driver.navigate().refresh();
		elementActions.doIsDisplayed(dailyFollowUpAppointments);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(3000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
			Thread.sleep(2000);

			boolean FollowUp = elementActions.doIsDisplayed2(followUpVisitTitle);
			if (FollowUp == true) {
				elementActions.doIsDisplayed(weeklyCalendarStatus);
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				char[] genderChar = elementActions.doGetLastChar(weeklyCalendarPatientNameandAge);
				String genderString = String.valueOf(genderChar);
				String gender = genderString.replaceAll("[^a-zA-Z]", "");
				if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is displayed");
				} else {
					extentReport.logToExtentReport("Gender is not displayed");
					// fail();
				}
				if (gender.equalsIgnoreCase("M")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Male'");
				}
				if (gender.equalsIgnoreCase("F")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Female'");
				}
				if (gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Other'");
				}
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				extentReport.logToExtentReport(
						"Verification - Verifying whether all the elements are displayed on 'Follow up visit details' popup");
				break;
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}
		if (elementActions.doIsDisplayed2(followUpVisitTitle) == false) {
			extentReport.logToExtentReport("There is no 'follow-up' visit");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : Verifying the details of
	 * the popup according to the status
	 */
	@Step("Verify Appointment and Follow up visit details popup page for In-progress/Awaiting/priority visit patient")
	public void VerifyAppointmentAndFollowUpDetailsPopupPageforInprogressOrAwaitingVisitPatient()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(3000);
		elementActions.doIsDisplayed(weeklyCalendarPatients);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();

		StringBuilder visitStatusBuilder = new StringBuilder();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(3000);
			extentReport.logToExtentReport("Clicking on visit");
			WebElement Visits = AppointmentOrFollowUpVisit.get(i);
			elementActions.JavaScriptExecutorClickWebElement(Visits);
			Thread.sleep(2000);
			String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);

			if (visitStatusBuilder.length() > 0) {
				visitStatusBuilder.append(", ");
			}
			visitStatusBuilder.append(VisitStatus);

			boolean RescheduleButton = elementActions.doIsDisplayed2(weeklyCalendarAppointmentRescheduleButton);
			boolean CancelButton = elementActions.doIsDisplayed2(weeklyCalendarAppointmentCancelButton);
			boolean ProvidePrescriptionButton = elementActions
					.doIsDisplayed2(weeklyCalendarAppointmentProvidePrescriptionButton);
			if (VisitStatus.equalsIgnoreCase("Awaiting") || VisitStatus.equalsIgnoreCase("Priority")) {
				if (RescheduleButton && CancelButton) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Cancel' and 'Reschedule' buttons are displayed when the status is 'Awaiting' or 'Priority'");
				} else if (ProvidePrescriptionButton) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether Provide Prescription button is displayed when the status is 'Awaiting' or 'Priority'");
				} else {
					extentReport.logToExtentReport(
							"Verification failed - Neither 'Cancel' and 'Reschedule' buttons nor 'Provide Prescription' button are displayed when the status is 'Awaiting' or 'Priority'");
					// fail();
				}
			}

			if (VisitStatus.equalsIgnoreCase("In-progress")) {
				elementActions.doIsDisplayed(weeklyCalendarAppointmentProvidePrescriptionButton);
				extentReport.logToExtentReport(
						"Verification - Verifying whether 'Provide Prescription' button is displayed when the status is 'In-progress'");
			}

			if (VisitStatus.equalsIgnoreCase("Completed")) {
				elementActions.doIsDisplayed(weeklyCalendarEditPrescriptionButton);
				extentReport.logToExtentReport(
						"Verification - Verifying whether 'Edit Prescription' button is displayed when the status is 'Completed'");
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}

		/*
		 * String visitStatus = visitStatusBuilder.toString(); if
		 * (!visitStatus.contains("Awaiting")) {
		 * extentReport.logToExtentReport("There is no Awaiting visit"); fail(); } if
		 * (!visitStatus.contains("Priority")) {
		 * extentReport.logToExtentReport("There is no Priority visit"); fail(); } if
		 * (!visitStatus.contains("In-progress")) {
		 * extentReport.logToExtentReport("There is no In-progress visit"); fail(); } if
		 * (!visitStatus.contains("Completed")) {
		 * extentReport.logToExtentReport("There is no Completed visit"); fail(); }
		 */

	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : Verifying the label when
	 * status is completed
	 */
	@Step("Verify the label in Appointment details/Follow-up visit popup page when appointment/follow-up is completed")
	public void VerifyLabelInAppointmentDtailsOrFollowupVisitPopupPageWhenAppointmentOrFollowupIsCompleted()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(2000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(2000);
		elementActions.doIsDisplayed(weeklyCalendarPatients);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		StringBuilder visitStatusBuilder = new StringBuilder();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(3000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
//			AppointmentOrFollowUpVisit.get(i).click();
			Thread.sleep(2000);
			String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);

			if (visitStatusBuilder.length() > 0) {
				visitStatusBuilder.append(", ");
			}
			visitStatusBuilder.append(VisitStatus);

			if (VisitStatus.equalsIgnoreCase("Completed")) {
				elementActions.doIsDisplayed(weeklyCalendarEditPrescriptionButton);
				elementActions.doIsDisplayed(weeklyCalendarAppointmentorFollowUpVisitStatusCompleted);
				extentReport.logToExtentReport(
						"Verification - Verifying whether proper elements are displayed in completed visit popup");
				break;
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}
		String visitStatus = visitStatusBuilder.toString();
		if (!visitStatus.contains("Completed")) {
			extentReport.logToExtentReport("There is no Completed visit");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : Verifying the follow- up
	 * visit's detail
	 */
	@Step("Verify that user can view the FollowUp visit details screen")
	public void VerifythatUsercanViewtheFollowUpVisitDetailsScreen()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		driver.navigate().refresh();
		elementActions.doIsDisplayed(dailyFollowUpAppointments);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
			Thread.sleep(2000);
			boolean FollowUp = elementActions.doIsDisplayed2(followUpVisitTitle);
			if (FollowUp == true) {
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				char[] genderChar = elementActions.doGetLastChar(weeklyCalendarPatientNameandAge);
				String genderString = String.valueOf(genderChar);
				String gender = genderString.replaceAll("[^a-zA-Z]", "");
				if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is displayed");
				} else {
					extentReport.logToExtentReport("Gender is not displayed");
					// fail();
				}
				if (gender.equalsIgnoreCase("M")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Male'");
				}
				if (gender.equalsIgnoreCase("F")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Female'");
				}
				if (gender.equalsIgnoreCase("O")) {
					extentReport.logToExtentReport("Verification - Verifying whether the Gender is 'Other'");
				}
				elementActions.doIsDisplayed(weeklyCalendarPatientId);
				elementActions.doIsDisplayed(weeklyCalendarStatus);
				elementActions.doIsDisplayed(weeklyCalendarAppointmentBookedOn);
				elementActions.doIsDisplayed(weeklyCalendarAppointmentOn);
				elementActions.doIsDisplayed(weeklyCalendarChiefComplaint);
				elementActions.doIsDisplayed(weeklyCalendarBookedByWithNurseName);
				extentReport.logToExtentReport(
						"Verification - Verifying whether all the details are displayed on FollowUp visit details popup");
				break;
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}
		if (elementActions.doIsDisplayed2(followUpVisitTitle) == false) {
			extentReport.logToExtentReport("There is no follow-up visit in the Daily tab");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : User can navigate to
	 * visit summary page by view details link
	 */
	@Step("Verify user can navigate to visit summary page by clicking  view details link on Follow-up visit details popup ")
	public void VerifyUsercanNavigatetoVisitSummaryPageageByClickingViewDetailsLinkOnFollowUpVisit()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
//		Thread.sleep(2000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
//			AppointmentOrFollowUpVisit.get(i).click();
			Thread.sleep(2000);
			boolean FollowUp = elementActions.doIsDisplayed2(followUpVisitTitle);
			if (FollowUp == true) {
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on view details link on Follow-up visit details popup");
				elementActions.waitForElementClickable(weeklyCalendarViewDetailsLink);
				Thread.sleep(2000);
				if (elementActions.doIsDisplayed(visitSummaryPageDisplayedVideoIcon)
						&& elementActions.doIsDisplayed(visitSummaryPageText)) {
					extentReport.logToExtentReport("Verification - Verifying whether visit summary page is displayed");
					break;
				}
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);

		}
	}

	/*
	 * Author : Rajesh H S Created : 27/09/23 Description : User can navigate to
	 * visit summary page by clicking on Edit Prescription button
	 */
	@Step("Verify user can navigate to visit summary page by Edit Prescription button")
	public void VerifyUsercanNavigatetoVisitSummaryPageByEditPrescriptionButton()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(2000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(2000);
		elementActions.doIsDisplayed(weeklyCalendarPatients);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		StringBuilder visitStatusBuilder = new StringBuilder();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
			Thread.sleep(2000);
			String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);

			if (visitStatusBuilder.length() > 0) {
				visitStatusBuilder.append(", ");
			}
			visitStatusBuilder.append(VisitStatus);

			if (VisitStatus.equalsIgnoreCase("Completed")) {
				if (elementActions.doIsDisplayed(weeklyCalendarEditPrescriptionButton)) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether Edit Prescription Button is displayed in 'completed' status visit");
				}
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}

		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.moveToWebElementAndClick(AppointmentOrFollowUpVisit.get(i));
			Thread.sleep(2000);
			String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);

			if (VisitStatus.equalsIgnoreCase("Completed")) {
				elementActions.waitForElementClickable(weeklyCalendarEditPrescriptionButton);
				extentReport.logToExtentReport("Verification - Clicking on Edit Prescription button");
				break;
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}

		if (elementActions.doIsDisplayed(visitSummaryPageDisplayedVideoIcon)
				&& elementActions.doIsDisplayed(visitSummaryPageText)) {
			extentReport.logToExtentReport("Verification - Verifying whether visit summary page is displayed");

		}
		String visitStatus = visitStatusBuilder.toString();
		if (!visitStatus.contains("Completed")) {
			extentReport.logToExtentReport("There is no 'Completed' visit");
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : Verifying that
	 * Prescription created message display on Appointment popup
	 */
	@Step("Verify that Prescription created message is displayed for completed follow-up visit")
	public void VerifythatPrescriptionCreatedMessageDisplayForCompletedVisit()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(2000);
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(2000);
		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		StringBuilder visitStatusBuilder = new StringBuilder();
		for (int i = 0; i <= TotalPatients - 1; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);
			String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);

			if (visitStatusBuilder.length() > 0) {
				visitStatusBuilder.append(", ");
			}
			visitStatusBuilder.append(VisitStatus);

			boolean FollowUp = elementActions.doIsDisplayed2(followUpVisitTitle);
			if (FollowUp == true) {
				if (VisitStatus.equalsIgnoreCase("Completed")) {
					elementActions.doIsDisplayed(weeklyCalendarFollowUpVisitPrescriptionCreated);
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Prescription created' message is displayed");
				}
			}
			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
			Thread.sleep(2000);
		}
		String visitStatus = visitStatusBuilder.toString();
		if (!visitStatus.contains("Completed")) {
			extentReport.logToExtentReport("There is no 'Completed' visit");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : User is able to see the
	 * week and change the week
	 */
	@Step("Verify that user can see the current week's dates and change the week")
	public void VerifyThatUserisAbletoSeethecurrentWeeksDatesandChangetheWeek()
			throws Throwable, ElementClickInterceptedException, StaleElementReferenceException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(3000);
		List<WebElement> CurrentWeeks = elementActions.getElements(weeklyCalendarWeeks);
		List<String> expectedCurrentWeekTexts = elementActions.CurrentWeekDatesAndDays();
		List<String> expectedNextWeekTexts = elementActions.NextWeekDatesAndDays();
		List<String> expectedPreviousWeekTexts = elementActions.PreviousWeekDatesAndDays();
		List<String> currentWeekTexts = CurrentWeeks.stream().map(WebElement::getText).collect(Collectors.toList());
		// Remove spaces from both lists before comparison
		List<String> trimmedCurrentWeekTexts = currentWeekTexts.stream().map(text -> text.replaceAll("\\s+", ""))
				.collect(Collectors.toList());
		List<String> trimmedExpectedCurrentWeekTexts = expectedCurrentWeekTexts.stream()
				.map(text -> text.replaceAll("\\s+", "")).collect(Collectors.toList());
		if (trimmedCurrentWeekTexts.equals(trimmedExpectedCurrentWeekTexts)) {
			extentReport.logToExtentReport("Verification - Verifying display of current week's dates");
		} else {
			extentReport.logToExtentReport("Not displaying the current week's dates");
			// fail();
		}
		extentReport.logToExtentReport("Clicking on next arrow");
		elementActions.waitForElementClickable(nextArrowCalendar);
		List<WebElement> nextWeeks = elementActions.getElements(weeklyCalendarWeeks);
		List<String> nextWeekTexts = nextWeeks.stream().map(WebElement::getText).collect(Collectors.toList());
		// Remove spaces from both lists before comparison
		List<String> trimmedNextWeekTexts = nextWeekTexts.stream().map(text -> text.replaceAll("\\s+", ""))
				.collect(Collectors.toList());
		List<String> trimmedExpectedNextWeekTexts = expectedNextWeekTexts.stream()
				.map(text -> text.replaceAll("\\s+", "")).collect(Collectors.toList());

		if (!trimmedNextWeekTexts.equals(trimmedCurrentWeekTexts)
				&& trimmedNextWeekTexts.equals(trimmedExpectedNextWeekTexts)) {
			extentReport.logToExtentReport("Verification - Verifying whether user is able to change to next week");
		} else {
			extentReport.logToExtentReport("Not able to change the week");
			// fail();
		}
		extentReport.logToExtentReport("Clicking on previous arrow");
		elementActions.waitForElementClickable(previousArrowCalendar);
		extentReport.logToExtentReport("Clicking on previous arrow");
		elementActions.waitForElementClickable(previousArrowCalendar);
		List<WebElement> previousWeeks = elementActions.getElements(weeklyCalendarWeeks);
		List<String> previousWeekTexts = previousWeeks.stream().map(WebElement::getText).collect(Collectors.toList());
		// Remove spaces from both lists before comparison
		List<String> trimmedPreviousWeekTexts = previousWeekTexts.stream().map(text -> text.replaceAll("\\s+", ""))
				.collect(Collectors.toList());
		List<String> trimmedExpectedPreviousWeekTexts = expectedPreviousWeekTexts.stream()
				.map(text -> text.replaceAll("\\s+", "")).collect(Collectors.toList());
		if (!trimmedPreviousWeekTexts.equals(trimmedCurrentWeekTexts)
				&& trimmedPreviousWeekTexts.equals(trimmedExpectedPreviousWeekTexts)) {
			extentReport.logToExtentReport("Verification - Verifying whether user is able to change to previous week");
		} else {
			extentReport.logToExtentReport("Not able to change the week");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : Verifying that All the
	 * appointment & Follow up visits display in Selected week
	 */
	@Step("Verify that All the appointment & Follow up visits display in Selected week")
	public void VerifyThatAllTheAppointmentAndFollowUpVisitsDisplayInSelectedWeek()
			throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(3000);
		if (elementActions.doIsDisplayed(weeklyCalendarPatients)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether the appointments and Follow-up's are displayed in a selected week");
		}

		List<WebElement> Dates = elementActions.getElements(weeklyCalendarWeeks);
		// Get the current date text to compare against
		CharSequence currentFormattedDate = elementActions.doGetFormattedCurrentDate();

		for (WebElement Date : Dates) {
			String dateText = Date.getText();
			if (dateText.contains(currentFormattedDate)) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether the current date is highlighted in blue color");
				elementActions.doGetHighlightedInBlueColor(Date);
				break;
			}
		}

	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : Verifying that All the
	 * appointment & Follow up visits display in Selected month
	 */
	@Step("Verify that All the appointment & Follow up visits display in Selected month")
	public void VerifyThatAllTheAppointmentAndFollowUpVisitsDisplayInSelectedMonth()
			throws Throwable, ElementClickInterceptedException {
		Thread.sleep(8000);
		extentReport.logToExtentReport("Clicking on view calendar");
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(monthlyTab);
		Thread.sleep(5000);
		if (elementActions.doIsDisplayed(monthlyCalendarAppointment) && elementActions.doIsDisplayed(monthlyFollowUp)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Appointments' and 'Follow-up' visits are displayed");
		}
		List<WebElement> Dates = elementActions.getElements(monthlyCalendarDates);
		CharSequence currentFormattedDate = elementActions.doGetFormattedCurrentOnlyDate();
		for (WebElement Date : Dates) {
			String dateText = Date.getText();
			if (dateText.contains(currentFormattedDate)) {
				extentReport.logToExtentReport("Verification - Verifying whether current date is displayed");
				extentReport.logToExtentReport(
						"Verification - Verifying whether the current date is highlighted in blue color");
				elementActions.doGetHighlightedInBlueColorOnlyDate(Date);
				Thread.sleep(5000);
			}
		}
		extentReport.logToExtentReport("Verification - Verifying whether No. of follow-up visits are displayed");
		Thread.sleep(5000);
		elementActions.waitForElementClickable(monthlyTab);
		elementActions.doGetFirstCharFollowUp(monthlyCalendarFollowUpVisit);
		extentReport.logToExtentReport("Verification - Verifying whether No. of appointments are displayed");

		elementActions.doGetFirstCharAppointments(monthlyCalendarAppointment);
	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : Day off is displayed in
	 * the monthly calendar
	 */
	@Step("Verify that Day off is displayed in marked dates")
	public void VerifyThatDayOffIsDisplayedInMarkedDates() throws Throwable, ElementClickInterceptedException {
		DeleteDayOFF();
		extentReport.logToExtentReport("Clicking on daysoff calendar");
		elementActions.waitForElementClickable(daysOffCalendar);
		extentReport.logToExtentReport("Selecting a day for dayoff");
		elementActions.JavaScriptExecutorClick(availabilityStartDate);
		extentReport.logToExtentReport("Clicking on save  button");
		elementActions.waitForElementClickable(saveButtonDaysoff);
		extentReport.logToExtentReport("Clicking on confirm button on save days of popup");
		elementActions.waitForElementClickable(confirmButton);
		elementActions.waitForElementClickable(calendarLink);
		Thread.sleep(4000);
		extentReport.logToExtentReport("Clicking on view calendar");
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(6000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		elementActions.waitForElementClickable(monthlyTab);
		if (elementActions.doIsDisplayed(monthlyCalendarDayOff)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether Marked Days off is displayed in monthly calendar");
		}
	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : User can select a date
	 * from the monthly calendar and the pop up is displayed
	 */
	@Step("Verify that user can navigate to the selected date popup")
	public void VerifyThatUserCanNavigateToTheSelectedDatePopup() throws Throwable, ElementClickInterceptedException {
		DeleteMarkedDaysOff();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(8000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		Thread.sleep(20000);
		elementActions.waitForElementClickable(monthlyTab);
		Thread.sleep(5000);
		extentReport.logToExtentReport("Clicking on current date on monthly calendar");
		Thread.sleep(8000);

		elementActions.doClick(monthlyCalendarToday);
		if (elementActions.doIsDisplayed(monthlyCalendarPopUpDate)) {
			extentReport.logToExtentReport("Verification - Verifying whether popup is dsplayed");
		}
		char noOfAppointments = elementActions.doGetLastOneChar(monthlyCalendarPopUpAppointment);
		if (Character.isDigit(noOfAppointments)) {
			extentReport.logToExtentReport("Verification - Verifying whether No. of 'appointments' are displayed");
		} else {
			extentReport.logToExtentReport("No. of 'appointments' is not displayed");
			// fail();
		}
		char noOfFollowUps = elementActions.doGetLastOneChar(monthlyCalendarPopUpFollowUps);
		if (Character.isDigit(noOfFollowUps)) {
			extentReport.logToExtentReport("Verification - Verifying whether No. of 'Follow-up' are displayed");
		} else {
			extentReport.logToExtentReport("No. of 'Follow-up' is not displayed");
			// fail();
		}
		if (elementActions.doIsDisplayed(monthlyCalendarPopUpMarkAs)
				&& elementActions.doIsDisplayed(monthlyCalendarPopUpHoursOffByText)
				&& elementActions.doIsDisplayed(monthlyCalendarPopUpDayOffByText)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Mark As' text, 'Day off' and 'Hours off' are displayed in the popup");
		}
	}

	/*
	 * Author : Rajesh H S Created : 28/09/23 Description : User is able to mark day
	 * off in the monthly calendar
	 */
	@Step("Verify that user is able to mark as day off and All the appointments & Follow ups auto cancelled for the Day off")
	public void VerifyUserIsAbleToMarkAsDayOffInMonthlyCalendar() throws Throwable, ElementClickInterceptedException {
		DeleteMarkedDaysOff();
		extentReport.logToExtentReport("Clicking on calendar link");
		Thread.sleep(2000);
		elementActions.waitForElementClickable(calendarLink);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(6000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(20000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(monthlyTab);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Verification - Verifying if there is a 'Follow-up' visit on the current date");
		elementActions.doIsDisplayed(monthlyCalendarTodayFollowUp);
		extentReport.logToExtentReport("Verification - Verifying if there is a 'Appointment' on the current date");
		elementActions.doIsDisplayed(monthlyCalendarTodayAppointment);
		extentReport.logToExtentReport("Clicking on current date on monthly calendar");
		Thread.sleep(3000);
		elementActions.waitForElementClickable(monthlyCalendarToday);
		Thread.sleep(4000);
		extentReport.logToExtentReport("Clicking on 'dayoff' on popup");
		elementActions.scrollToElementByText("Day off");
		try {
			elementActions.doSelect(monthlyCalendarPopUpDayOff);
			elementActions.waitForElementClickable(monthlyCalendarPopUpDayOff);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Continue' button");
		elementActions.waitForElementVisible(continueButton);
		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(verifyMonthlyCalendarPopUpText)) {
			extentReport.logToExtentReport("Verification - Verifying whether correct text is displayed on the popup");
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Confirm' button");
		elementActions.waitForElementClickable(confirmButtonDayOff);
		Thread.sleep(3000);
		elementActions.doIsDisplayed(monthlyCalendarDayOff);
		boolean FollowUpDisplayed = elementActions.doIsDisplayed2(monthlyCalendarTodayFollowUp);
		if (FollowUpDisplayed == true) {
			extentReport
					.logToExtentReport("Verification: MonthlyCalendarFollowUpVisit is displayed after marking day off");

		} else {
			extentReport.logToExtentReport(
					"Verification: MonthlyCalendarFollowUpVisit is not displayed after marking day off");
			// fail();
		}
		boolean AppointmentDisplayed = elementActions.doIsDisplayed2(monthlyCalendarTodayAppointment);
		if (AppointmentDisplayed == false) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether scheduled 'Appointments'are removed after marking the day as 'Day off'");
		} else {
			extentReport
					.logToExtentReport("Error: MonthlyCalendar Appointment is displayed even after marking day off");
			// fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 29/09/23 Description : User selecting the
	 * dates, from and to dates
	 */
	@Step("Verify that user can select the FROM and TO dates")
	public void VerifyThatUserCanSelectTheFROMAndTODates() throws Throwable, ElementClickInterceptedException {
		DeleteMarkedDaysOff();
		extentReport.logToExtentReport("Clicking on calendar link");
		Thread.sleep(2000);
		elementActions.waitForElementClickable(calendarLink);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(300);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(20000);
		extentReport.logToExtentReport("Clicking on monthly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(monthlyTab);
		Thread.sleep(8000);
		extentReport.logToExtentReport("Clicking on current date on monthly calendar");
		elementActions.waitForElementClickable(monthlyCalendarToday);
		Thread.sleep(2000);
		elementActions.scrollToElementByText("Hours off");
		extentReport.logToExtentReport("Clicking on 'Hours off' on the popup");
		try {
			elementActions.doSelect(monthlyCalendarPopUpHoursOff);
			elementActions.doClick(monthlyCalendarPopUpHoursOff);

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'From' dropdown");
		elementActions.waitForElementClickable(monthlyCalendarPopUpHoursOffFrom);
		Thread.sleep(2000);
		String FromTime = elementActions.doGetText(monthlyCalendarPopUpHoursOffFromTime);
		extentReport.logToExtentReport("Selecting 'From' time from 'From' dropdown");
		elementActions.waitForElementClickable(monthlyCalendarPopUpHoursOffFromTime);
		Thread.sleep(2000);
		String SelectedFromTime = elementActions.doGetText(monthlyCalendarPopUpHoursOffFrom);
		if (FromTime.equals(SelectedFromTime)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected 'From' date is displayed in the 'From' textfield");
		} else {
			// fail();
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'To' dropdown");
		elementActions.waitForElementClickable(monthlyCalendarPopUpHoursOffTo);
		Thread.sleep(2000);
		String ToTime = elementActions.doGetText(monthlyCalendarPopUpHoursOffToTime);
		extentReport.logToExtentReport("Selecting 'To' time from 'To' dropdown");
		elementActions.waitForElementClickable(monthlyCalendarPopUpHoursOffToTime);
		Thread.sleep(2000);
		String SelectedToTime = elementActions.doGetText(monthlyCalendarPopUpHoursOffTo);
		if (ToTime.equals(SelectedToTime)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether selected 'To' date is displayed in the 'To' textfield");
		} else {
			// fail();
		}
	}

	/*
	 * Author : Rajesh H S Created : 29/09/23 Description : User setting the off
	 * hours
	 */
	@Step("Verify user can able to set the off hours")
	public void VerifyUserCanAbleToSetTheOffHours() throws Throwable, ElementClickInterceptedException {
		this.VerifyThatUserCanSelectTheFROMAndTODates();
		extentReport.logToExtentReport("Clicking on view 'Continue' button");
		Thread.sleep(2000);
		elementActions.waitForElementClickable(continueButton);
		if (elementActions.doIsDisplayed(markAsHoursOffPopUp)) {
			extentReport.logToExtentReport("Verification - Verifying whether mark as 'Hours off' popup is displayed");
		}
		extentReport.logToExtentReport("Clicking on view 'Confirm' button");
		elementActions.waitForElementClickable(confirmButtonhoursOff);
		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(monthlyCalendarHoursOff)) {
			extentReport.logToExtentReport("Verification - Verifying whether able to set the hours off");
		}

	}

	/*
	 * Author : Rajesh H S Created : 26/09/23 Description : Verifying Appointments
	 * and follow up's are displayed in weekly calendar
	 */
	@Step("Appointment and Follow-up visit displayed in weekly calendar")
	public void VerifyThatAppointmentListDisplayInTimeSlot() throws Throwable, ElementClickInterceptedException {
		extentReport.logToExtentReport("Clicking on view calendar");
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);

		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(dailyFollowUpAppointments);
		int TotalPatients = AppointmentOrFollowUpVisit.size();
		StringBuilder typeOfVisitsBuilder = new StringBuilder();
		for (int i = 0; i < TotalPatients; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);

			if (elementActions.doIsDisplayed2(appointmentTitle)) {
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				extentReport.logToExtentReport(
						"Verification - Verifying whether the type of visit 'Appointment' is displayed with Patient Name, Age, and Booked by Nurse details");
				if (typeOfVisitsBuilder.length() > 0) {
					typeOfVisitsBuilder.append(", ");
				}
				typeOfVisitsBuilder.append("Appointment");
			}

			if (elementActions.doIsDisplayed2(followUpVisitTitle)) {
				elementActions.doIsDisplayed(weeklyCalendarPatientNameandAge);
				elementActions.doIsDisplayed(weeklyCalendarBookedByNurse);
				extentReport.logToExtentReport(
						"Verification - Verifying whether the type of visit 'Follow Up' is displayed with Patient Name, Age, and Booked by Nurse details");
				if (typeOfVisitsBuilder.length() > 0) {
					typeOfVisitsBuilder.append(", ");
				}
				typeOfVisitsBuilder.append("Follow Up");
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
		}

		String typeOfVisits = typeOfVisitsBuilder.toString();

		if (!typeOfVisits.contains("Appointment")) {
			extentReport.logToExtentReport("Verification - No appointments found");
			// fail();
		}

		if (elementActions.doIsDisplayed(weeklyCalendarCurrentTimeGreenLine)) {
			extentReport.logToExtentReport("Verification - Verifying whether the time line is displayed");
		}
	}

	@Step("Verify that user can able to view the 'Completed' Appointment details popup")
	public void UserAbleToViewTheCompletedAppointmentDetailsPopup() throws Throwable, ElementClickInterceptedException {

		extentReport.logToExtentReport("Clicking on view calendar");
		Thread.sleep(7000);
		elementActions.waitForElementClickable(viewCalendar);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on weekly tab");
		Thread.sleep(8000);
		elementActions.waitForElementClickable(weeklyTab);
		Thread.sleep(2000);

		List<WebElement> AppointmentOrFollowUpVisit = elementActions.getElements(weeklyCalendarPatients);
		int TotalPatients = AppointmentOrFollowUpVisit.size();

		StringBuilder typeOfVisitsBuilder = new StringBuilder();
		StringBuilder visitStatusesBuilder = new StringBuilder();

		for (int i = 0; i < TotalPatients; i++) {
			Thread.sleep(2000);
			WebElement FromFirst = AppointmentOrFollowUpVisit.get(i);
			extentReport.logToExtentReport("Clicking on visit");
			elementActions.JavaScriptExecutorClickWebElement(FromFirst);
			Thread.sleep(2000);

			String visit = elementActions.doGetText(calenadrPopupTypeOfVisitTitle);
			if (typeOfVisitsBuilder.length() > 0) {
				typeOfVisitsBuilder.append(", ");
			}
			typeOfVisitsBuilder.append(visit);

			if (elementActions.doIsDisplayed2(appointmentTitle) == true) {
				String VisitStatus = elementActions.doGetText(weeklyCalendarStatus);
				if (VisitStatus.equalsIgnoreCase("Completed")) {
					if (visitStatusesBuilder.length() > 0) {
						visitStatusesBuilder.append(", ");
					}
					visitStatusesBuilder.append(VisitStatus);
					elementActions.doIsDisplayed(weeklyCalendarViewDetailsLink);
					elementActions.doIsDisplayed(weeklyCalendarPatientId);
					elementActions.doIsDisplayed(weeklyCalendarStatus);
					elementActions.doIsDisplayed(weeklyCalendarAppointmentOn);
					elementActions.doIsDisplayed(weeklyCalendarAppointmentBookedOn);
					elementActions.doIsDisplayed(weeklyCalendarChiefComplaint);
					elementActions.doIsDisplayed(weeklyCalendarEditPrescriptionButton);
					extentReport.logToExtentReport(
							"Verification - Verifying whether the completed 'Appointment' has 'Edit Prescription' button and all the elements of the popup are displayed");
					break;
				}
			}

			Thread.sleep(2000);
			extentReport.logToExtentReport("Clicking the close button on the visit popup");
			elementActions.waitForElementClickable(closeButton);
		}

		String allVisits = typeOfVisitsBuilder.toString();
		String appintmentVisitStatuses = visitStatusesBuilder.toString();
		if (!allVisits.contains("Appointment")) {
			extentReport.logToExtentReport("No 'Appointment' found");
			// fail();
		}

	}

	public void RemoveAllDaysOff() throws Throwable {
		OpenCalendar();
		try {
			List<WebElement> daysOff = null;
			List<WebElement> daysOffList = elementActions.getElements(lstRemoveDaysOff);
			for (int i = 0; i <= daysOffList.size(); i++) {
				daysOff = elementActions.getElements(lstRemoveDaysOff);

				if (daysOff.isEmpty()) {
					break;
				}
				WebElement dayOff = daysOff.get(0);
				Thread.sleep(6000);
				dayOff.click();
				elementActions.waitForElementClickable(confirmButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
