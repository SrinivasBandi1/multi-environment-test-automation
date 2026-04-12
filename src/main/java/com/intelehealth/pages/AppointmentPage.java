package com.intelehealth.pages;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;
import com.intelehealth.util.TestUtils;

import io.qameta.allure.Step;

public class AppointmentPage extends BasePage {

	WebDriver driver;
	CalendarPage calendarPage;
	ElementActions elementActions;
	ExtentReportListener extentReport = new ExtentReportListener();

	By AppointmentLink = By.xpath("//a[@data-test-id=\"linkAppointments\"]");
	By AppointmentLabel = By.xpath("//mat-expansion-panel-header[@data-test-id=\"matExpHeaderAppointment\"]");
	By Patientheader = By.xpath("//th[text()=' Patient ']");
	By Ageheader = By.xpath("//th[text()=' Age ']");
	By startsinheader = By.xpath("//th[text()=' Starts in ']");
	By Locationheader = By.xpath("//th[text()=' Location ']");
	By ChiefComplaintheader = By.xpath("//th[text()=' Chief Complaint ']");
	By Actionsheader = By.xpath("//th[text()=' Actions ']");
	By PageNoandArrows = By.xpath("//mat-paginator[@data-test-id=\"matPaginatorAppointment\"]");
	By AppointmentPatients = By.xpath("//td[contains(@data-test-id,\"apPatient\")]");
	By NoPatientsInAppointments = By.xpath(" //td[text()=' No any appointments scheduled. '] ");
	By AppointmentsCancelButton = By.xpath("//button[contains(@data-test-id,'btnCancel')]");
	By CannotCancel = By.xpath("//div[@aria-label=\"Can't Cancel\"]");
	By CancelPopUp = By.xpath("//div[@class=\"cdk-overlay-pane modal-md\"]");
	By CancelTheAppointmentText = By.xpath("//h6[text()='Cancel the appointment']");
	By SureYouWantToCancelText = By.xpath("//p[text()='Are you sure you want to cancel your appointment on ']");
	By CancelButton = By.xpath("//button[@data-test-id=\"btnCancelAppConfirm\"]");
	By AppointmentCancelledSuccessfullyMessage = By
			.xpath("//div[text()=' The Appointment has been successfully canceled. ']");
	By RescheduleAppointmentButton = By.xpath("//button[@data-test-id=\"btnReschedule0\"]");
	By RescheduleAppointmentButtons = By.xpath("//button[contains(@data-test-id,\"btnReschedule\")]");
	By CloseButton = By.xpath("//button[@data-test-id=\"btnClose\"]");
	By SelectDateField = By.xpath("//input[@data-test-id='etRescheduleDate']");
	By CalendarIcon = By.xpath("//button[@aria-label='Open calendar']");
	By AllDates = By.xpath("//td[@role=\"gridcell\"]");
	By SelectTheDate = By.xpath("//div[contains(@class,'-body-today')]");
	By AvailableTimeSlots = By.xpath("//div[@class=\"slot-chip-item ng-star-inserted\"]");
	By RescheduleSubmitButton = By.xpath("//button[@data-test-id='btnSubmitReschedule']");
	By CalendarMonthYear = By.xpath("//button[@aria-label=\"Choose month and year\"]");
	By FirstTimeSlot = By.xpath("(//div[@class=\"slot-chip-item ng-star-inserted\"])[1]");
	By RescheduleAppointmentText = By.xpath("//h6[text()='Reschdule the appointment']");
	By ConfirmButton = By.xpath("//button[@data-test-id=\"btnSubmit\"]");
	By Buffering = By.xpath("//div[@class=\"sk-ball-spin-clockwise\"]");
	By PleaseWaitText = By.xpath("//span[text()='Please Wait...']");
	By ReschedulingMessage = By.xpath("//div[@role='alert']");
	By ReschedulingSuccessfulMessage = By.xpath("//div[text()=' The appointment has been rescheduled successfully! ']");
	By ReschedulingErrorMessage = By
			.xpath("//div[@aria-label='Another appointment has already been booked for this time slot.']");
	By vsStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By RescheduleTime = By.xpath("//div[text()=' 7:00 PM ']");
	By RescheduledTime = By.xpath("//td[contains(@data-test-id,'apStart0')]");
	By FirstPatient = By.xpath("//td[contains(@data-test-id,'td-patient_id-Appointment-0')]");
	By lstPatients = By.xpath("//td[contains(@data-test-id,'apPatient')]");
	By inProgressFirstPatient = By.xpath("//td[@data-test-id='td-patient_id-InProgress-0']");
	By VisitSummaryPageDisplayedVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By VisitSummaryPageText = By.xpath("//li[text()=' Visit Summary ']");
	By lstBtnCancel = By.xpath("//button[contains(@data-test-id,'btnCancel')]");

	By lnkAppointments = By.xpath("//a[@data-test-id='linkAppointments']");
	By btnReschedule = By.xpath(
			"//div[contains(@class,'actions-btn-wrap d-flex align-items-center')]/button//preceding-sibling::button");
	By btnCancel = By.xpath(
			"//div[contains(@class,'actions-btn-wrap d-flex align-items-center')]/button//following-sibling::button");
	By lblCanceltheappointment = By.xpath("//mat-dialog-container[contains(@id,'mat-dialog')]//h6");
	By btnCancelInPopup = By.xpath("//button[@data-test-id='btnCancelAppConfirm']");
	By msgCantCancel = By.xpath("//div[@id='toast-container']/div//div");
	By ReschedulingFailed = By.xpath("//div[@aria-label=\"Rescheduling failed!\"]");
	By FailedPopupClose = By.xpath("//button[@aria-label='Close']");
	By RescheduleAppointmentPopUpText = By.xpath("//h6[text()='Reschedule appointment']");
	By NextPage = By.xpath("//button[@aria-label=\"Next page\"]");
	By CancellingFailed = By.cssSelector("[aria-label='Canceling failed!']");

	// Constructor of page class:
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		calendarPage = new CalendarPage(driver);
	}

	public void OpenAppointment() throws InterruptedException {
		elementActions.doClick(AppointmentLink);
		extentReport.logToExtentReport("Clicked on Appointment link from left panel");
	}

	/*
	 * Author : Rajesh H S Created : 29/09/23 Description : Verifying the UI
	 * elements of Appointment page
	 */
	@Step("Verify UI")
	public void AppointmentUI() {
		elementActions.doIsDisplayed2(AppointmentLabel);
		extentReport.logToExtentReport("Appointment label is displayed");
		elementActions.doIsDisplayed(Patientheader);
		extentReport.logToExtentReport("Patient details is displayed in the header");
		elementActions.doIsDisplayed(Ageheader);
		extentReport.logToExtentReport("Age field is displayed on the header");
		elementActions.doIsDisplayed(startsinheader);
		extentReport.logToExtentReport("Starts in is displayed on the header");
		elementActions.doIsDisplayed(Locationheader);
		extentReport.logToExtentReport("Location is displayed on the Header");
		elementActions.doIsDisplayed(ChiefComplaintheader);
		extentReport.logToExtentReport("Chief Complaint section is displayed on the header");
		/*
		 * elementActions.doIsDisplayed(contactHeader);
		 * extentReport.logToExtentReport("Contact section is displayed on the header");
		 */

		elementActions.doIsDisplayed(Actionsheader);
		extentReport.logToExtentReport("Action field is displayed on the header");
		elementActions.doIsDisplayed(PageNoandArrows);
		extentReport.logToExtentReport("Page number and arrows are displayed on the header");
	}

	/*
	 * Author : Rajesh H S Created : 29/09/23 Description : Verifying whether
	 * Appointment section is showing count within brackets
	 */
	@Step("Verify whether Appointment section is showing count within brackets")
	public void VerifyWhetherAppointmentSectionIsShowingCountWithinBrackets() {
		elementActions.verifyBrackets(AppointmentLabel);
		extentReport.logToExtentReport("Fetch the count from the Appointment label");
	}

	/*
	 * Author : Rajesh H S Created : 29/09/23 Description : Verifying the scheduled
	 * appointments are displayed or not
	 */
	@Step("Verify whether scheduled appointments from healthworker -Mobile is reflecting in web app")
	public void VerifyWhetherScheduledAppointmentsFromHealthworkerMobileIsReflectingInWebApp() {
		if (elementActions.doIsDisplayed2(AppointmentPatients)) {
			// System.out.println("Patients who are having appointments are displayed");
			extentReport.logToExtentReport("Patients who are having appointments are displayed");
		} else {
			elementActions.doIsDisplayed2(NoPatientsInAppointments);
			// System.out.println("No any appointments scheduled");
			extentReport.logToExtentReport("No appointments are scheduled");
		}
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Cancelling the
	 * appointment
	 */
	@Step("Verify whether user able to cancel the appointments")
	public void VerifyWhetherUserAbleToCancelTheAppointments() throws Throwable {
//		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			elementActions.doClick(AppointmentsCancelButton);

			boolean Failed = elementActions.doIsDisplayed2(CancellingFailed);
			extentReport.logToExtentReport("Cancelling failed");
			if (Failed == true) {
				List<WebElement> CancelButtons = elementActions.getElements(AppointmentsCancelButton);
				for (Iterator<WebElement> iterator = CancelButtons.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					Thread.sleep(2000);
					elementActions.JavaScriptExecutorClickWebElement(webElement);
					try {
						elementActions.doClick(FailedPopupClose);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if (elementActions.doIsDisplayed2(CancelTheAppointmentText)) {
						break;
					}
				}
			}
			boolean Check = elementActions.doIsEnabled(NextPage);
			if (Check == true) {
				elementActions.doClick(NextPage);
				extentReport.logToExtentReport("Clicked on Next Page");
				if (Check == false) {
					break;
				}
			}
		}
		if (elementActions.doIsDisplayed(CancelTheAppointmentText)
				&& elementActions.doIsDisplayed(SureYouWantToCancelText)) {
			extentReport.logToExtentReport("All elements are displayed");
		}
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Clicking on Cancel button
	 * on cancel the appointment popup
	 */
	@Step("Verify clicking on Cancel button on cancel the appointment popup")
	public void VerifyClickingOnCancelButtonOnCancelTheAppointmentPopup() throws Throwable {
		this.VerifyWhetherUserAbleToCancelTheAppointments();
		elementActions.doClick(CancelButton);
		extentReport.logToExtentReport("Clicked on cancel button");
		boolean Cancel = elementActions.doIsDisplayed2(CannotCancel);
		if (Cancel == true) {
			Thread.sleep(2000);
			for (int i = 0; i < 5; i++) {
				List<WebElement> CancelButtons = elementActions.getElements(AppointmentsCancelButton);
//				int Next = CancelButtons.size();
				for (Iterator<WebElement> iterator = CancelButtons.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					webElement.click();
					elementActions.doClick(CancelButton);
					extentReport.logToExtentReport("Clicked on cancel button");
					Thread.sleep(2000);
					boolean Success = elementActions.doIsDisplayed2(AppointmentCancelledSuccessfullyMessage);
					if (Success == true) {
						extentReport.logToExtentReport("Cancelled the Appointment");
						break;
					}
				}
				boolean Check = elementActions.doIsEnabled(NextPage);
				if (Check == true) {
					elementActions.doClick(NextPage);
					extentReport.logToExtentReport("Clicked on Next Page");
					if (Check == false) {
						break;
					}
				}
				Thread.sleep(2000);
				boolean Success = elementActions.doIsDisplayed2(AppointmentCancelledSuccessfullyMessage);
				extentReport.logToExtentReport("Appointment cancelled successfully message is displayed");
				if (Success == true) {
					extentReport.logToExtentReport("Cancelled the Appointment");
					break;

				}

			}

		}
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Verifying the
	 * functionality of 'Reschedule' action
	 */
	@Step("Verify the functionality of 'Reschedule' action")
	public void VerifyTheFunctionalityOfRescheduleAction() throws Throwable, ElementClickInterceptedException {
		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingonSaveButtonAfterAddingTimeForAppointment();

		OpenAppointment();
//		Thread.sleep(5000);
		elementActions.waitForElementClickable(RescheduleAppointmentButton);
		extentReport.logToExtentReport("Waiting for Reschudeled Appointment button display");

		boolean Failed = elementActions.doIsDisplayed2(ReschedulingFailed);
		extentReport.logToExtentReport("Rescheduling failed");
		if (Failed == true) {
//			Thread.sleep(2000);
			for (int i = 0; i < 5; i++) {
				List<WebElement> RescheduleButtons = elementActions.getElements(RescheduleAppointmentButtons);
				for (Iterator<WebElement> iterator = RescheduleButtons.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();

					webElement.click();
					try {
						elementActions.doClick(FailedPopupClose);
					} catch (Exception e) {
						// TODO: handle exception
					}

					boolean ReschedulePopUp = elementActions.doIsDisplayed2(RescheduleAppointmentPopUpText);
					if (ReschedulePopUp == true) {
						Thread.sleep(2000);

						elementActions.doIsDisplayed(CloseButton);
						extentReport.logToExtentReport("Close button is displayed");
						String CurrentDate = elementActions.doGetFormattedCurrentDDMonYYYY();
						elementActions.VerifyTextString(SelectDateField, CurrentDate);
						elementActions.doIsDisplayed(CalendarIcon);
						extentReport.logToExtentReport("Calendar icon is displayed");
						elementActions.doClick(CalendarIcon);
						extentReport.logToExtentReport("Clicked on Calendar Icon");
						elementActions.doActionsClick(SelectTheDate);
						extentReport.logToExtentReport("Selected the date");
						elementActions.doIsDisplayed(AvailableTimeSlots);
						extentReport.logToExtentReport("Available Time Slots is displayed");
						elementActions.doIsDisplayed(RescheduleSubmitButton);
						extentReport.logToExtentReport("Reschedule Submit button displayed");
						break;
					}
//					break;
				}

				boolean Check = elementActions.doIsEnabled(NextPage);
				if (Check == true) {
					elementActions.doClick(NextPage);
					extentReport.logToExtentReport("Click on Next Page");
					if (Check == false) {
						break;
					}

				}
				boolean ReschedulePopUp = elementActions.doIsDisplayed2(RescheduleAppointmentPopUpText);
				if (ReschedulePopUp == true) {
					Thread.sleep(2000);
					elementActions.doIsDisplayed(CloseButton);
					extentReport.logToExtentReport("Close Button is displayed");
					String CurrentDate = elementActions.doGetFormattedCurrentDDMonYYYY();
					elementActions.VerifyTextString(SelectDateField, CurrentDate);
					elementActions.doIsDisplayed(CalendarIcon);
					extentReport.logToExtentReport("Calendar icon displayed");
					elementActions.doClick(CalendarIcon);
					extentReport.logToExtentReport("Clicked Calendar Icon");
					elementActions.doActionsClick(SelectTheDate);
					extentReport.logToExtentReport("Selected the date");
					elementActions.doIsDisplayed(AvailableTimeSlots);
					extentReport.logToExtentReport("Available time slots is displayed");
					elementActions.doIsDisplayed(RescheduleSubmitButton);
					extentReport.logToExtentReport("Reschedule popup displayed");
					// TestUtils.log().info("Reschedule PopUp is displayed");
					TestUtils.log().info("Reschedule PopUp is displayed");

					break;
				}

			}

		}
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Selecting date for
	 * rescheduling the appointment
	 */
	@Step("Verify date selection for rescheduling appointment")
	public void VerifyDateSelectionForReschedulingAppointment() throws Throwable {
//		Thread.sleep(2000);
		VerifyTheFunctionalityOfRescheduleAction();
		Thread.sleep(4000);
		elementActions.JavaScriptExecutorClick(CalendarIcon);
		extentReport.logToExtentReport("Clicked on Calendar icon");
//		Thread.sleep(2000);
		elementActions.doClick(SelectTheDate);
		extentReport.logToExtentReport("Clicked on Select the date");

	}

	public void sd() throws InterruptedException {
		OpenAppointment();
//		Thread.sleep(5000);
		elementActions.waitForElementClickable(RescheduleAppointmentButton);
		extentReport.logToExtentReport("Waiting for Reschudeled Appointment button display");
		boolean Failed = elementActions.doIsDisplayed2(ReschedulingFailed);
		extentReport.logToExtentReport("Rescheduling failed");
		if (Failed == true) {
//			Thread.sleep(2000);
			for (int i = 0; i < 5; i++) {
				List<WebElement> RescheduleButtons = elementActions.getElements(RescheduleAppointmentButtons);
				for (Iterator<WebElement> iterator = RescheduleButtons.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
//					Thread.sleep(2000);
					webElement.click();
					try {
						elementActions.doClick(FailedPopupClose);
					} catch (Exception e) {
						// TODO: handle exception
					}
					boolean ReschedulePopUp = elementActions.doIsDisplayed2(RescheduleAppointmentPopUpText);
					if (ReschedulePopUp == true) {
						Thread.sleep(2000);

						elementActions.doIsDisplayed(CloseButton);
						extentReport.logToExtentReport("Close button is displayed");
						String CurrentDate = elementActions.doGetFormattedCurrentDDMonYYYY();
						elementActions.VerifyTextString(SelectDateField, CurrentDate);
						elementActions.doIsDisplayed(CalendarIcon);
						extentReport.logToExtentReport("Calendar icon is displayed");
						elementActions.doClick(CalendarIcon);
						extentReport.logToExtentReport("Clicked on Calendar Icon");
						elementActions.doActionsClick(SelectTheDate);
						extentReport.logToExtentReport("Selected the date");
						elementActions.doIsDisplayed(AvailableTimeSlots);
						extentReport.logToExtentReport("Available Time Slots is displayed");
						elementActions.doIsDisplayed(RescheduleSubmitButton);
						extentReport.logToExtentReport("Reschedule Submit button displayed");
						break;
					}
//					break;
				}

				boolean Check = elementActions.doIsEnabled(NextPage);
				if (Check == true) {
					elementActions.doClick(NextPage);
					extentReport.logToExtentReport("Click on Next Page");
					if (Check == false) {
						break;
					}

				}
				boolean ReschedulePopUp = elementActions.doIsDisplayed2(RescheduleAppointmentPopUpText);
				if (ReschedulePopUp == true) {
					Thread.sleep(2000);
					elementActions.doIsDisplayed(CloseButton);
					extentReport.logToExtentReport("Close Button is displayed");
					String CurrentDate = elementActions.doGetFormattedCurrentDDMonYYYY();
					elementActions.VerifyTextString(SelectDateField, CurrentDate);
					elementActions.doIsDisplayed(CalendarIcon);
					extentReport.logToExtentReport("Calendar icon displayed");
					elementActions.doClick(CalendarIcon);
					extentReport.logToExtentReport("Clicked Calendar Icon");
					elementActions.doActionsClick(SelectTheDate);
					extentReport.logToExtentReport("Selected the date");
					elementActions.doIsDisplayed(AvailableTimeSlots);
					extentReport.logToExtentReport("Available time slots is displayed");
					elementActions.doIsDisplayed(RescheduleSubmitButton);
					extentReport.logToExtentReport("Reschedule popup displayed");

					break;
				}

			}

		}
		elementActions.JavaScriptExecutorClick(CalendarIcon);
		extentReport.logToExtentReport("Clicked on Calendar icon");
//		Thread.sleep(2000);
		elementActions.doClick(SelectTheDate);
		extentReport.logToExtentReport("Clicked on Select the date");
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Selecting the time slot
	 * and rescheduling the appointment
	 */
	@Step("Verify time slot selection and clicking reschedule button functionality")
	public void VerifyTimeSlotSelectionAndClickingRescheduleButtonFunctionality() throws Throwable {
//		Thread.sleep(2000);
		VerifyDateSelectionForReschedulingAppointment();

//		Thread.sleep(3000);

		driver.findElement(FirstTimeSlot).click();
		// elementActions.doClick(FirstTimeSlot);

		extentReport.logToExtentReport("clicked on first time slot");
//		Thread.sleep(2000);
		elementActions.doClick(RescheduleSubmitButton);
		extentReport.logToExtentReport("Clicked on reschedule Submit button");
//		Thread.sleep(4000);
//		elementActions.doIsDisplayed(RescheduleAppointmentText);
		extentReport.logToExtentReport("Reschedule Appointmnet Text is displayed");
//		Thread.sleep(3000);
	}

	/*
	 * Author : Rajesh H S Created : 3/10/23 Description : Clicking on Confirm
	 * button on Reschedule the appointment popup
	 */
	@Step("Verify clicking on Confirm button on Reschedule the appointment popup")
	public void VerifyClickingOnConfirmButtonOnRescheduleTheAppointmentPopup() throws Throwable {
//		Thread.sleep(2000);
		VerifyTimeSlotSelectionAndClickingRescheduleButtonFunctionality();

		elementActions.doClick(ConfirmButton);
		extentReport.logToExtentReport("Clicked on Reschedule Confirm button");
//		Thread.sleep(2000);
		elementActions.doIsDisplayed(PleaseWaitText);
		extentReport.logToExtentReport("Please wait text is displayed");
//		Thread.sleep(2000);
//		elementActions.doIsDisplayed(ReschedulingSuccessfulMessage);
		String reschedulingMessage = elementActions.doGetText(ReschedulingMessage);

		String reschedulingSuccessMsg = "The appointment has been rescheduled successfully!";
		String reschedulingErrorMsg = "Another appointment has already been booked for this time slot.";
		if (reschedulingMessage.contains(reschedulingSuccessMsg)
				|| reschedulingMessage.contains(reschedulingErrorMsg)) {
			extentReport.logToExtentReport("Rescheduling message is displayed");
		} else {
			extentReport.logToExtentReport("Rescheduling message is not displayed");
			// fail();

		}
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verifing whether
	 * rescheduled time slot reflects in Starts in column
	 */
	@Step("Verify whether the Rescheduled time slot reflects in Starts in column")
	public void VerifyWhetherTheRescheduledTimeSlotReflectsInStartsInColumn() throws Throwable {
		Thread.sleep(2000);
		VerifyClickingOnConfirmButtonOnRescheduleTheAppointmentPopup();
		elementActions.doIsDisplayed(RescheduledTime);
		extentReport.logToExtentReport("Reschedule time is displayed");

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Clicking on particular
	 * patient and verifying visit summary page is displayed
	 */
	@Step("Verify the Patient details on Appointments")
	public void VerifyThePatientDetailsOnAppointments() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> patientsList = elementActions.getElements(lstPatients);
		for (int i = 0; i < patientsList.size(); i++) {
			patientsList = elementActions.getElements(lstPatients);
			patientsList.get(i).click();
			if (elementActions.doIsDisplayed(VisitSummaryPageDisplayedVideoIcon)) {
				elementActions.doIsDisplayed(VisitSummaryPageText);
				break;

			}
			if (elementActions.doIsDisplayed(VisitSummaryPageDisplayedVideoIcon) == false
					&& elementActions.doIsDisplayed(vsStartVisitNote)) {
				elementActions.doClick(vsStartVisitNote);
				extentReport.logToExtentReport("Clicked on the first patient");
				if (elementActions.doIsDisplayed(VisitSummaryPageDisplayedVideoIcon)
						&& elementActions.doIsDisplayed(VisitSummaryPageText)) {
					// TestUtils.log().info("Visit summary page is displayed");
					extentReport.logToExtentReport("Visit summary page is displayed");
					break;
				} else {
					fail();
				}
			} else {
				elementActions.doActionsClick(AppointmentLink);
			}
			elementActions.doClick(inProgressFirstPatient);
			extentReport.logToExtentReport("Clicked on the first patient");
			if (elementActions.doIsDisplayed(VisitSummaryPageDisplayedVideoIcon)
					&& elementActions.doIsDisplayed(VisitSummaryPageText)) {
				// System.out.println("Visit summary page is displayed");
				extentReport.logToExtentReport("Visit summary page is displayed");
			} else {
				fail();
			}
		}
	}

	@Step("Click on Appointments in left panel")
	public void clickOnAppointments() throws InterruptedException {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on Appointments in left panel");
		elementActions.waitForElementClickable(lnkAppointments);
	}

	@Step("Click on Cancel button")
	public void clickOnCancelButton() throws InterruptedException {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on Cancel button");
		List<WebElement> CancelButtons = elementActions.getElements(lstBtnCancel);
		for (Iterator<WebElement> iterator = CancelButtons.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			Thread.sleep(2000);
			webElement.click();
			try {
				elementActions.doClick(FailedPopupClose);
			} catch (Exception e) {
				// TODO: handle exception
			}
			boolean cancelPopUp = elementActions.doIsDisplayed2(lblCanceltheappointment);
			if (cancelPopUp == true) {
				Thread.sleep(2000);
				break;

			}
		}


	}

	@Step("Get Cancel Appointment Text")
	public String getCancelAppointmentText() throws InterruptedException {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Get Cancel Appointment Text");
		return elementActions.doGetText(lblCanceltheappointment);

	}

	@Step("Click on Cancel button in popup")
	public void clickOnCancelButtonInPopup() throws InterruptedException {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Click on Cancel button in popup");
		elementActions.doClick(btnCancelInPopup);
	}

	@Step("Verify Cancelled successful popup")
	public void verifyCancelSuccessPopup() throws InterruptedException {
//		Thread.sleep(1000);
		elementActions.doIsDisplayed(AppointmentCancelledSuccessfullyMessage);
		extentReport.logToExtentReport("Appointment Cancelled success popup message is displayed");
		elementActions.doIsDisplayed(AppointmentCancelledSuccessfullyMessage);
		extentReport.logToExtentReport("Appointment Cancelled success popup message is displayed");
	}

	@Step("Get Cancel Appointment Text")
	public List<String> getCantCancelText() {
		List<String> toast = new ArrayList<>();
		for (int i = 0; i < elementActions.getElements(msgCantCancel).size(); i++) {
			extentReport.logToExtentReport("Get Cancel Appointment Text");
			toast.add(elementActions.getElements(msgCantCancel).get(i).getText());
		}
		return toast;
	}

}
