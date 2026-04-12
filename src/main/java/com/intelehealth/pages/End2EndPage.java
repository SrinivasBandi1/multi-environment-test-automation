package com.intelehealth.pages;

import static org.junit.Assert.fail;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class End2EndPage extends BasePage {
	AppointmentPage appointmentPage;
	EndToEndMethods endToEndMethods;
	CalendarPage calendarPage;
	WebDriver driver;
	ElementActions elementActions;
	ExtentReportListener extentReport = new ExtentReportListener();

	By AppointmentLink = By.xpath("//div[@data-test-id='chip-appointments']");
	By ConfirmButton = By.xpath("//button[@data-test-id='btnSubmitSharePrescriptionModal']");
	By LogoutLink = By.xpath("//span[@data-test-id='textLogout']");
	By LogoutYesButton = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");
	By FirstPatientAppointment = By.xpath("//td[@data-test-id='td-patient_id-Appointment-0']");
	By VisitSummaryPageDisplayedVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By VisitSummaryPageText = By.xpath("//li[text()=' Visit Summary ']");
	By StartVisitNoteButton = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By SharePrescriptionButton = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By CloseButton = By.xpath("//button[@class='modal-close-btn']");
	By patient1pressent = By.xpath("//td[@data-test-id='sentPatient0']");
	By vsViewPrescriptionBtn = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By vsViewPrescriptionPopup = By.xpath("//div[@id='mat-dialog-title-0']//*[contains(text(),'Prescription')]");
	By ViewPrescription = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By PrescriptionTitleText = By.xpath("//div[@class='mat-dialog-title title-con position-relative']");
	By ConsultationDetailsText = By.xpath("//h6[@data-test-id='etHeaderConDets'][contains(text(),'Consultation Details')]");
	By ConsultedDoctorsText = By.xpath("//h6[contains(text(),'Consulted doctor details')]");
	By DiagnosisLink = By.xpath("//h6[@data-test-id='titleDiagnosisDetails']");
	By MedicationText = By.xpath("//h6[@data-test-id='medicationsTitle']");
	By FirstPatientPriority = By.xpath("//td[@data-test-id='td-patient_id-Priority-0']");
	By InteractionYesRadioButton = By.xpath("//input[@data-test-id='radioPatientInteractionYes']");
	//By InteractionSaveButton = By.xpath("//button[@data-test-id=\"btnSubmitPatientInteraction\"]");
	By SelectDiagnosisTextField = By.xpath("//*[@data-test-id='selectDiagnosisName']");
	By DiagnosisStatusProvisional = By.xpath("//input[@data-test-id=\"radioDiagnosisStatusProvisional\"]");
	By AddDiagnosis = By.xpath("//button[@data-test-id=\"btnSubmitDiagnosis\"]");
	By NoteTextField = By.xpath("//textarea[@data-test-id=\"etNote\"]");
	By AddNoteButton = By.xpath("//button[@data-test-id=\"btnSubmitNote\"]");
	By DrugNameTextField = By.xpath("//input[@data-test-id=\"etDrugName\"]");
	By StrengthTextField = By.xpath("//input[@data-test-id=\"etDrugStrength\"]");
	By SelectHighlighted = By.xpath("//span[@class=\"ngb-highlight ng-star-inserted\"]");
	By NoOfDaysTextField = By.xpath("//input[@data-test-id=\"etDays\"]");
	By TestTextField = By.xpath("//input[@data-test-id=\"etTest\"]");
	By SaveTestButton = By.xpath("//button[@data-test-id='btnSubmitTest']");
	By ReferrealNoRadioButton = By.xpath("//input[@data-test-id=\"radioReferralNo\"]");
	By FollowUpNoRadioButton = By.xpath("//input[@data-test-id='radioFollowUpNo']");
	By SharePrescriptionSuccessfullyText = By.xpath("//h6[text()='Shared prescription successfully']");
	By UpdatePrescription = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By SharePrescriptionPopUpText = By.xpath("//h6[@data-test-id='sharePrescriptionModalTitle']");
	By SharedPrescriptionSuccesssfullyPopUpText = By.xpath("//h6[@class='mt-3']");
	By SelectAdviceOption = By.xpath("//h6[@data-test-id='divTitleAdvice']");
	By EnterRemarks = By.xpath("//input[@data-test-id=\"etRemarkMed\"]");
	By MedicationAddButton = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By awtvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-Awaiting-0']");
	By FirstInProgressPatient = By.xpath("//td[@data-test-id='td-patient_id-InProgress-0']");
	By NoPastVisitHistory = By.xpath("//div[@class='mat-elevation-z8 ng-star-inserted']");
	By AllSectionFirstPatient = By.xpath("//td[contains(@data-test-id,\"Patient0\")]");
	By PastVisitHistoryTab = By.xpath("//*[contains(text(),'Past visit history')]");
	By ViewSummaryButton = By.xpath("//div[@class=\"blue-pill\"]");
	By VitalsText = By.xpath("//div[@class='data-section-title']//*[contains(text(),'Vitals test')]");
	By CheckUpReasonText = By.xpath("//div[@class='cheif-complaint-wrapper']");
	By PhysicalWxaminationText = By.xpath("//h6[text()='Physical examination']");
	By MedicalHistoryText = By.xpath("//h6[text()='Medical history']");
	By AdditionalDocumentsText = By.xpath("//h6[text()='Additional documents']");
	By DashBoardLink = By.xpath("//span[@data-test-id='labelDashboard']");
	By BackDrop = By.xpath("//div[contains(@class,\"cdk-overlay-b\")]");
	By SearchPatientTextField = By.xpath("//input[@data-test-id='etSearchPatient']");
	By ViewPatientButton = By.xpath("//button[@data-test-id='btnViewSearchedPatient0']|//button[@data-test-id='btnStartVisitNote']");
	By WhatsAppIcon = By.xpath("//a[@data-test-id='linkWhatsApp']");
	By ContinueToChatButton = By.xpath("//a[@id=\"action-button\"]");
	By ChatIcon = By.xpath("//img[@data-test-id='imgStartChat']");
	By MessageTextField = By.xpath("//input[@data-test-id='etChatMessageChatBox']");
	By ChatSendButton = By.xpath("//button[@data-test-id='btnSendMessageChatBox']");
	By ChatSentText = By.xpath("//span[@data-test-id='chatStatusRead']");
	By ChatText = By.xpath("//*[@data-test-id='chatMessageList']");
	By InProgressPatients = By.xpath("//td[contains(@data-test-id,\"ipPatient\")]");
	By FirstPriorityPatient = By.xpath("//td[@data-test-id='td-patient_id-Priority-0']");
	By NextPage = By.xpath("(//button[@aria-label='Next page'])[last()]");
	By SearchPatientIcon = By.xpath("//img[@data-test-id='iconSearchPatient']");
	By vstsumpatientVideoWindowPatientname = By.xpath("\"//mat-dialog-container\"");
	By FirstFollowUpVisitMonthlyCalendar = By.xpath("(//div[@data-test-id=\"mwlCalMonthView\"]//..//div[contains(text(),'Follow-up visit')])[1]");
	By PrescriptionLink = By.xpath("//span[@data-test-id='labelPrescription']");
	By PrescriptionPatient = By.xpath("//*[@data-test-id='sentAge0']");
	By SharedPrescriptionSuccesfully = By.xpath("//h6[text()='Shared prescription successfully']");
	By CompletedVisitsTab = By.xpath("//span[@data-test-id='chipCompletedLabel']");
	By PrescriptionSent = By.xpath("//span[@data-test-id='chipSentLabel']");
	By DeleteIcon = By.xpath("//img[@src=\"assets/svgs/delete-icon.svg\"]");
	By UpdatedMedication = By.xpath("//div[@class=\"ng-star-inserted\"]");
	By vsUpdatePrescription = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsPrescriptionDrugTextBox = By.xpath("//input[@data-test-id='etDrugName']");
	By vsPrescriptionDrugStrengthTextBox = By.xpath("//input[@data-test-id='etDrugStrength']");
	By vsPrescriptionDrugNoOfDaysTextBox = By.xpath("//input[@data-test-id='etDays']");
	By vsPrescriptionDrugTimingDrpdown = By.xpath("//ng-select[@data-test-id='selectTiming']");
	By vsPrescriptionDrugRemarks = By.xpath("//input[@data-test-id='etRemarkMed']");
	By vsPrescriptionDrugTimingDrpdownval = By.xpath("//span[text()='1 - 0 - 0']");
	By vsPrescriptionDrugAddButton = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By vsUpdatePrescriptionBtn = By
			.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsSharePrescriptionSubmitButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By calendericon = By.xpath("//img[@data-test-id='dpDateIcon']");
	By vsSharePrescriptioncnfmSubmitButton = By.xpath("//button[@data-test-id='btnSubmitSharePrescriptionModal']");
	By drugdeletebutton = By.xpath("//button[@data-test-id='btnDeleteDiagnosisVisitSummary0']");
	By ViewPrescriptionButtonInPopUp = By.xpath("//button[@data-test-id='btnView']");
	By UpdatedDrug = By.xpath("(//td[text()='Dolo'])[last()]");
	By UpdatedStrength = By.xpath("(//td[text()='8'])[last()]");
	By UpdatedDays = By.xpath("(//input[@data-test-id='etDays']");
	By vsSharePrescription = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By consultationdetails = By.xpath("//div[@class='data-section-title']//*[contains(text(),'Consultation Details')]");
	By Diagnosisdetails = By.xpath("//div[@class='data-section']//*[contains(text(),'Diagnosis Details')]");
	By Medication = By.xpath("//div[@class='data-section-title']//*[contains(text(),'Medications')]");
	//By vsSharePrescriptionSubmitButton = By.xpath("//button[@data-test-id='btnSubmitSharePrescriptionModal']");
	By vsSharePrescPopupConfText = By.xpath("//p[text()='Are you sure you want to share this prescription?']");
	By vsViewPrescrptnBtn = By.xpath("//button[@data-test-id='btnView']");
	By vsGoToDashboardBtn = By.xpath("//button[@data-test-id='btnSubmit']");
	By vsCloseBtnPopup = By.xpath("//button[@data-test-id='btnClose']");
	By Reschedule = By.xpath("//button[@data-test-id='btn-action-Reschedule-0']");
	By timeslot = By.xpath("//*[@data-test-id='slotEveningChip'][3]");
	By Reschedulecnfmbtn = By.xpath("//button[@data-test-id='btnSubmitRescheduleModal']");
	By 	Reschedulecnfmbtn1 = By.xpath("//*[@data-test-id='btnSubmitRescheduleConfirm']");
	By 	selectdate = By.xpath("//div[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-selected']");
	

	
	
	//By vsUpdatePrescriptionBtn = By
			//.xpath("//button[@data-test-id='btnSharePrescription'][text()=' Update prescription ']");
	//diagnosis field
			By SelectDiagnosisDownArrow = By
					.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//span[@class='ng-arrow']");
			//By SelectDiagnosisTextField = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//input");
			By SelectDiagnosislist = By.xpath("//div[@role='option']//span[contains(text(),'Fever')]");
			By DiagnosisSelected = By
					.xpath("//ng-select[@data-test-id='selectDiagnosisName']//span[@class='ng-value-label ng-star-inserted']");
			By DropdownFirstOption = By.xpath("(//span[@class='ng-option-label ng-star-inserted'])[1]");
			By DiagnosisTypePrimary = By.xpath("//input[@data-test-id='radioDiagnosisTypePrimary']");
			//By DiagnosisStatusProvisional = By.xpath("//input[@data-test-id='radioDiagnosisStatusProvisional']");
			By DiagnosisStatusConfirmed = By.xpath("//input[@data-test-id='radioDiagnosisStatusConfirmed']");
			//By AddDiagnosis = By.xpath("//button[@data-test-id='btnSubmitDiagnosis']");
			By DiagnosisColumn = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']//input");
	//followup
			By FollowupOptionYes = By.xpath("//input[@data-test-id='radioFollowUpYes']");
			By FollowupOptionNo = By.xpath("//input[@data-test-id='radioFollowUpNo']");
			By FollowupCalendar = By.xpath("//mat-datepicker-toggle[@data-test-id='dpFollowUpDate']");
			By FollowupDatePick = By.xpath("//div[contains(text(),'30')]");
			By FollowupTimeClick = By.xpath("//ng-select[@data-test-id='selectFollowUpTime']");
			By FollowupTimePick = By.xpath("//span[contains(text(),'9:00 AM')]");
			By FollowupSaveButton = By.xpath("//button[@data-test-id='btnSubmitFollowUp']");
			By FollowupDelButton = By.xpath("//button[@data-test-id='btnDeleteFollowUp']");
			By FollowupLabel = By.xpath("//label[text()='Do you want to have follow up with the patient?']");


	public End2EndPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		appointmentPage = new AppointmentPage(driver);
		endToEndMethods = new EndToEndMethods(driver);
		calendarPage = new CalendarPage(driver);
	}

	/*
	 * Author: Rajesh H S Created: 14/10/23 Description: Generic method - Logging
	 * out from the application
	 */
	public void Logout() throws Throwable {
		extentReport.logToExtentReport("Clicking on 'logout' link");
		elementActions.doClick(LogoutLink);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on logout 'Yes' button");
		elementActions.doClick(LogoutYesButton);

	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, rescheduling an appointment, and logging out
	 */
	@Step("Login, Reschedule appointment, logout")
	public void LoginRescheduleAppointmentLogout() throws Throwable {
		extentReport.logToExtentReport("Clicking on 'Appointments' link");
		elementActions.doClick(AppointmentLink);
//		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Reschedule' link");
		elementActions.doClick(Reschedule);
		//elementActions.doClick(calendericon);
		//Thread.sleep(2000);
		//elementActions.doClick(selectdate);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'timeslot'");
		elementActions.doClick(timeslot);
		Thread.sleep(2000);
		elementActions.doClick(Reschedulecnfmbtn);
		extentReport.logToExtentReport("Clicking on 'Reschedule' link");
		Thread.sleep(2000);
		elementActions.doClick(Reschedulecnfmbtn1);
		

				
		//appointmentPage.VerifyClickingOnConfirmButtonOnRescheduleTheAppointmentPopup();
		extentReport.logToExtentReport("Logging out from the application");
		Logout();

	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, Canceling an appointment, and logging out
	 */
	@Step("Login, Cancel appointment, logout")
	public void LoginCancelAppointmentLogout() throws Throwable {
		extentReport.logToExtentReport("Clicking on 'Appointments' link");
		elementActions.doClick(AppointmentLink);
		appointmentPage.VerifyClickingOnCancelButtonOnCancelTheAppointmentPopup();
		extentReport.logToExtentReport("Logging out from the application");
		Logout();

	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, accessing appointments, reviewing visit summary and
	 * viewing prescriptions
	 */
	@Step("Login, appointment, visit summary, view prescription")
	public void LoginAppointmentVisitSummaryViewPrescription() throws Throwable {
		extentReport.logToExtentReport("Clicking on 'Appointments' link");
		elementActions.doClick(AppointmentLink);
		appointmentPage.VerifyThePatientDetailsOnAppointments();
		endToEndMethods.verifyvstsumPrescription();
		endToEndMethods.verifyvsprescrptionChangesViewPrescButton();
		if (elementActions.doIsDisplayed(PrescriptionTitleText) && elementActions.doIsDisplayed(ConsultationDetailsText)
				&& elementActions.doIsDisplayed(ConsultedDoctorsText) && elementActions.doIsDisplayed(MedicationText)
				&& elementActions.doIsDisplayed(DiagnosisLink)) {
			extentReport.logToExtentReport("Verification - Verifying whether 'Prescription' Page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the flow of
	 * visiting summary, starting a visit note, sharing updates, viewing
	 * prescriptions, and updating prescriptions
	 */
	public void VisitSummaryStartVisitNoteShareUpdateViewPrescription() throws Throwable {
		elementActions.doIsDisplayed(VisitSummaryPageText);
				extentReport.logToExtentReport("Verification - Verifying whether 'Visit summary' page is displayed");
				// System.out.println("Visit summary page is displayed");
			
			Thread.sleep(4000);
			//extentReport.logToExtentReport("Clicking on 'Start Visit Note' button");
			//elementActions.doClick(StartVisitNoteButton);
			Thread.sleep(2000);
			//extentReport.logToExtentReport("Clicking on 'Yes' radio button");
			//Thread.sleep(4000);
			//elementActions.doClick(InteractionYesRadioButton);
			//Thread.sleep(2000);
			//extentReport.logToExtentReport("Clicking on 'Save' button");
			//elementActions.doClick(InteractionSaveButton);
		
		endToEndMethods.VerifyAddFunctionalityUnderDiagnosisSection();
		//endToEndMethods.VerifyAddNoteFunctionality();
		endToEndMethods.verifyvsprescrptionChanges();
		Thread.sleep(2000);
		//endToEndMethods.VerifySaveFunctionalityForAdditionalInstructionsUnderMedicationSection();
		extentReport.logToExtentReport("Sending value to 'Test' textfield");
		elementActions.doActionsSendKeys(TestTextField, "Blood");
		Thread.sleep(2000);
		extentReport.logToExtentReport("Selecting 'Advice' option");
		elementActions.doClick(SelectAdviceOption);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Save' button");
		elementActions.doClick(SaveTestButton);
		Thread.sleep(2000);
		//extentReport.logToExtentReport("Clicking on 'No' radio button");
		//elementActions.doSelect(ReferrealNoRadioButton);
		//Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Follow uo' radio button");
		elementActions.doSelect(FollowUpNoRadioButton);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Share Prescription' button");
		elementActions.doClick(SharePrescriptionButton);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Confirm' button");
		elementActions.doClick(ConfirmButton);
		if (elementActions.doIsDisplayed(SharePrescriptionSuccessfullyText)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Share Prescription successfully' text is displayed on the popup");
		} else {
			fail();
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Close' button");
		elementActions.doClick(CloseButton);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Update Prescription' button");
		elementActions.doClick(UpdatePrescription);
		if (elementActions.doIsDisplayed(SharePrescriptionPopUpText)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Share Prescription' text is displayed on the popup");
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Confirm' button");
		elementActions.doClick(ConfirmButton);

		boolean Displayed = elementActions.doIsDisplayed(SharedPrescriptionSuccesssfullyPopUpText);
		if (Displayed == true) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Prescription' shared successfully for the patient");
			// System.out.println("Prescription shared successfully for the patient");
		} else {
			fail();
		}
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Close' button");
		elementActions.doClick(CloseButton);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'View Prescription' button");
		elementActions.doClick(ViewPrescription);
		if (elementActions.doIsDisplayed(PrescriptionTitleText) && elementActions.doIsDisplayed(ConsultationDetailsText)
				&& elementActions.doIsDisplayed(ConsultedDoctorsText) && elementActions.doIsDisplayed(MedicationText)
				&& elementActions.doIsDisplayed(DiagnosisLink)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether 'Prescription' popup is displayed with all the details");
			// System.out.println("Prescription popup is displayed with all the details");
		} else {
			fail();
		}
	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, priority visit, visiting summary, starting a visit note,
	 * sharing updates, viewing prescriptions, and updating prescriptions
	 */
	@Step("Login, priority visit, visit summary, start visit note, share/update/view prescription")
	public void LoginPriorityVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription() throws Throwable {
		extentReport.logToExtentReport("Clicking on first patient from priority visit section");
		elementActions.doClick(FirstPatientPriority);
		this.VisitSummaryStartVisitNoteShareUpdateViewPrescription();
	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, awaiting visit, visiting summary, starting a visit note,
	 * sharing updates, viewing prescriptions, and updating prescriptions
	 */
	@Step("Login, awaiting visit, visit summary, start visit note, share/update/view prescription")
	public void LoginAwaitingVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription() throws Throwable {
		extentReport.logToExtentReport("Clicking on first patient from awaiting visit section");
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(2000);
		this.VisitSummaryStartVisitNoteShareUpdateViewPrescription();

	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, In-progress visit, visiting summary, starting a visit
	 * note, sharing updates, viewing prescriptions, and updating prescriptions
	 */
	@Step("Login, in-progress visit, visit summary, start visit note, share/update/view prescription")
	public void LoginInProgressVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription() throws Throwable {
		extentReport.logToExtentReport("Clicking on first patient from In-progress section");
		elementActions.doClick(FirstInProgressPatient);
		Thread.sleep(2000);
		this.VisitSummaryInprogressVisit();

	}

	/*
	 * Author: Rajesh H S Created: 14/10/23 Description: Generic method - Past Visit
	 * History Tab
	 */
	public void PastVisitHistory() throws Throwable {
		extentReport.logToExtentReport("Clicking on past visit history tab");
		Thread.sleep(4000);
		elementActions.JavaScriptExecutorClick(PastVisitHistoryTab);
		if (elementActions.doIsDisplayed2(NoPastVisitHistory)) {
			extentReport.logToExtentReport(
					"Verification - Verifying whether there is no past visit history for the patient");
		}
		boolean IfDisplayed = elementActions.doIsDisplayed2(ViewSummaryButton);
		if (IfDisplayed == true) {
			extentReport.logToExtentReport("Clicking on 'View Summary' button");
			elementActions.doClick(ViewSummaryButton);
//			Thread.sleep(3000);
			if (elementActions.doIsDisplayed(ConsultationDetailsText) && elementActions.doIsDisplayed(VitalsText)
					&& elementActions.doIsDisplayed(CheckUpReasonText)
					&& elementActions.doIsDisplayed(PhysicalWxaminationText)
					&& elementActions.doIsDisplayed(MedicalHistoryText)
					&& elementActions.doIsDisplayed(AdditionalDocumentsText)) {
				extentReport.logToExtentReport(
						"Verification - Verifying whether Prescription popup is displayed with all details");
				extentReport.logToExtentReport("Clicking on Dashboard button");
				elementActions.doClick(DashBoardLink);
			}
		}
		extentReport.logToExtentReport("Clicking on Dashboard button");
		elementActions.doClick(DashBoardLink);
	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, navigating through Awaiting, In Progress, Priority, Visit
	 * Summary, Past Visit History, and viewing Visit Summary
	 */

	@Step("Login, awaiting/appointment/in-progress/priority, visit summary, past visit history, view visit summary")
	public void LoginAwaitingAppointmentInProgressPriorityVisitSummaryPastVisitHistoryViewVisitSummary()
			throws Throwable {
		// Appointments
		boolean Appointment = elementActions.doIsDisplayed2(FirstPatientAppointment);
		if (Appointment == true) {
			extentReport.logToExtentReport("Clicking on first patient from the appointments section");
			elementActions.doClick(FirstPatientAppointment);
//			Thread.sleep(2000);
			PastVisitHistory();
			extentReport.logToExtentReport(
					"Verification - Verifying whether Appointment patient's past visit history is displayed");
		}
		if (Appointment == false) {
			extentReport.logToExtentReport("There are no patients in the Appointment section");
			fail();
		}

		// Priority Visit
		boolean Priority = elementActions.doIsDisplayed2(FirstPatientPriority);
		if (Priority == true) {
			extentReport.logToExtentReport("Clicking on first patient from priority visit section");
			elementActions.doClick(FirstPatientPriority);
//			Thread.sleep(2000);
			PastVisitHistory();
			extentReport.logToExtentReport(
					"Verification - Verifying whether Priority patient's past visit history is displayed");
		}
		if (Priority == false) {
			extentReport.logToExtentReport("There are no patients in the Priority section");
			fail();
		}

		// Awaiting-visit
		boolean Awaiting = elementActions.doIsDisplayed2(awtvstPatient1Name);
		if (Awaiting == true) {
			extentReport.logToExtentReport("Clicking on first patient from awaiting visit section");
			elementActions.doClick(awtvstPatient1Name);
//			Thread.sleep(2000);
			PastVisitHistory();
			extentReport.logToExtentReport(
					"Verification - Verifying whether Awaiting patient's past visit history is displayed");
		}
		if (Awaiting == false) {
			extentReport.logToExtentReport("There are no patients in the Awaiting section");
			fail();
		}
		// In-Progress visit
		boolean InProgress = elementActions.doIsDisplayed2(FirstInProgressPatient);
		if (InProgress == true) {
			extentReport.logToExtentReport("Clicking on first patient from In-progress visit section");
			elementActions.doClick(FirstInProgressPatient);
			Thread.sleep(2000);
			PastVisitHistory();
			extentReport.logToExtentReport(
					"Verification - Verifying whether In-progress patient's past visit history is displayed");

		}
		if (InProgress == false) {
			extentReport.logToExtentReport("There are no patients in the In-Progress visit section");
			fail();
		}
	}
	/*
	 * Author: Rajesh H S Created: 19/10/23 Description: Verifying the end-to-end
	 * flow of logging in, searching for a patient, viewing Visit Summary, and
	 * calling the patient number
	 */

	@Step("Login, search patient, view, visit summary, call patient no")
	public void LoginSearchPatientViewVisitSummaryCallPatientNo() throws Throwable {
		SearchAndView();
		endToEndMethods.verifyStartCallOption();
	}

	/*
	 * Author: Rajesh H S Created: 14/10/23 Description: Generic method - Searching
	 * the patient and click on 'view' button
	 */
	public void SearchAndView() throws Throwable {
		extentReport.logToExtentReport("Clicking on search patient textfield");
		elementActions.doClick(SearchPatientTextField);
		String PatientName = elementActions.doGetText(awtvstPatient1Name);
		Thread.sleep(2000);
		String OnlyName = elementActions.splitString(PatientName, '(');
		// System.out.println(OnlyName);
		extentReport.logToExtentReport("Passing the awaiting visit's first patient name to search patient textField");
		elementActions.doActionsSendKeysValue(SearchPatientTextField, OnlyName);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on search patient icon");
		elementActions.doClick(SearchPatientIcon);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'view' button");
		elementActions.doClick(ViewPatientButton);
		elementActions.doClick(StartVisitNoteButton);
		if (elementActions.doIsDisplayed(VisitSummaryPageDisplayedVideoIcon)
				&& elementActions.doIsDisplayed(VisitSummaryPageText)) {
			extentReport.logToExtentReport("Verification - Verifying whether Visit summary page is displayed");
			// System.out.println("Visit summary page is displayed");
		} else {
			fail();
		}

	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, searching for a patient, viewing Visit Summary, and
	 * initiating a WhatsApp conversation with the patient
	 */
	@Step("Login, search patient, view, visit summary, whatsapp patient no")
	public void LoginSearchPatientViewVisitSummaryWhatsappPatientNo() throws Throwable {

		SearchAndView();
		boolean WhatsApp = elementActions.doIsDisplayed2(WhatsAppIcon);
		if (WhatsApp == true) {
			extentReport.logToExtentReport("Clicking on 'whatsapp' icon");
			elementActions.doClick(WhatsAppIcon);
			String mainId = driver.getWindowHandle();
			Set<String> allIds = driver.getWindowHandles();

			for (String id : allIds) {
				if (!mainId.equals(id)) {
					driver.switchTo().window(id);
					if (elementActions.doIsDisplayed(ContinueToChatButton)) {
						extentReport.logToExtentReport(
								"Verification - Verifying whether Share on Whastapp page is diplayed");
					}
				}
			}

		} else {
			fail();
		}
	}

	/*
	 * Author: Rajesh H S Created: 13/10/23 Description: Verifying the end-to-end
	 * flow of logging in, searching for a patient, viewing Visit Summary, and
	 * initiating a chat with a health worker
	 */
	@Step("Login, search patient, view, visit summary, chat with healthworker")
	public void LoginSearchPatientViewVisitSummaryChatWithHealthworker() throws Throwable {
		SearchAndView();
		extentReport.logToExtentReport("Clicking on chat icon");
		elementActions.waitForElementClickable(ChatIcon);
		Thread.sleep(2000);
		elementActions.doClick(MessageTextField);
		extentReport.logToExtentReport("Passing the value to message text field");
		elementActions.doActionsSendKeys(MessageTextField, "Good Morning");
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'send' button ");
		elementActions.doClick(ChatSendButton);
		//Thread.sleep(2000);
		//String SentChat = elementActions.doGetText(ChatText);
		//if (elementActions.doIsDisplayed(ChatSentText) && SentChat.equals("Good Morning")) {
			//extentReport.logToExtentReport("Verification - Verifying whether Chat sent successfully");
			// System.out.println("Chat sent successfully");
		//} else {
			//fail();
		//}
	}

	/*
	 * Author: Rajesh H S Created: 14/10/23 Description: Verifying the end-to-end
	 * flow of logging in, searching for a patient, viewing Visit Summary, and
	 * initiating a video call with a health worker
	 */
	@Step("Login, search patient, view, visit summary, video call with healthworker")
	public void LoginSearchPatientViewVisitSummaryVideoCallWithHealthworker() throws Throwable {
		SearchAndView();
		endToEndMethods.verifyvideoCall();

	}

	/*
	 * Author: Rajesh H S Created: 14/10/23 Description: Verifying the end-to-end
	 * flow of logging in, accessing the calendar, and setting up and managing the
	 * calendar
	 */
	@Step("Login, calendar, setup calendar [manage calendar]")
	public void LoginCalendarSetupCalendarManageCalendar() throws Throwable {
		calendarPage.OpenCalendar();
		calendarPage.VerifyClickingonSaveButtonAfterAddingTime();
		calendarPage.VerifyClickingConfirmInThePopupWhenClickedOnSaveUnderDaysOffSection();
	}

	/*
	 * Author: Rajesh H S Created: 18/10/23 Description: Verifying the end-to-end
	 * flow of logging in, accessing the calendar, viewing the calendar, clicking on
	 * monthly, marking a day off for the day where follow up has already been
	 * scheduled
	 */
	@Step("Login, calendar, view calendar, followup, mark as day off/hourly off")
	public void LoginCalendarViewCalendarFollowupMarkAsDayOffHourlyOff() throws Throwable {
		calendarPage.OpenCalendar();
		//calendarPage.VerifyUserIsAbleToMarkAsDayOffInMonthlyCalendar();
	}

	/*
	 * Author: Rajesh H S Created: 18/10/23 Description: Verifying the end-to-end
	 * flow of logging in, accessing the calendar, viewing the calendar, clicking on
	 * monthly, marking a hourly off for the day where appointment has already been
	 * scheduled
	 */
	@Step("Login, calendar, view calendar, appointment, mark as hourly off")
	public void LoginCalendarViewCalendarAppointmentMarkAsHourlyOff() throws Throwable {
		calendarPage.OpenCalendar();
		//calendarPage.VerifyUserCanAbleToSetTheOffHours();
	}

	/*
	 * Author: Rajesh H S Created: 19/10/23 Description: Verifying the end-to-end
	 * flow of logging in, selecting a patient from prescription, updating the
	 * details, updating the prescription
	 */
	@Step("Login, prescription sent, visit summary, update prescription")
	public void LoginPrescriptionSentVisitSummaryUpdatePrescription() throws Throwable {
		extentReport.logToExtentReport("Clicking on 'Prescription' link");
		elementActions.doClick(PrescriptionLink);
		extentReport.logToExtentReport("Clicking on next page");
		if (elementActions.doIsDisplayed2(PrescriptionPatient) == false) {
			elementActions.doClick(NextPage);
		}
		extentReport.logToExtentReport("Clicking on patient from the prescription section");
		elementActions.doClick(PrescriptionPatient);
		//try {
			//List<WebElement> IfSaved = elementActions.getElements(DeleteIcon);
			//for (Iterator<WebElement> iterator = IfSaved.iterator(); iterator.hasNext();) {
				//WebElement webElement = (WebElement) iterator.next();
				//elementActions.JavaScriptExecutorClickWebElement(webElement);
				//for (WebElement Delete : IfSaved) {
					//extentReport.logToExtentReport("Clicking on 'Delete' button");
					//elementActions.JavaScriptExecutorClickWebElement(Delete);
				//}
			//}
		//} catch (Exception e) {

		//}
		extentReport.logToExtentReport("Passing the value to 'Drug' textfield");
		elementActions.doSendKeys(vsPrescriptionDrugTextBox, "Dolo");
		String Drug = elementActions.doGetText(vsPrescriptionDrugTextBox);
		extentReport.logToExtentReport("Passing the value to 'Strength' textfield");
		elementActions.doSendKeys(vsPrescriptionDrugStrengthTextBox, "500MG");
		String Strength = elementActions.doGetText(vsPrescriptionDrugStrengthTextBox);
		extentReport.logToExtentReport("Passing the value to 'No. of days' textfield");
		elementActions.doSendKeys(vsPrescriptionDrugNoOfDaysTextBox, "8");
		String NoOfDays = elementActions.doGetText(vsPrescriptionDrugNoOfDaysTextBox);
		extentReport.logToExtentReport("Clicking on drug timing dropdown");
		elementActions.doClick(vsPrescriptionDrugTimingDrpdown);
		extentReport.logToExtentReport("Selecting a value from the drug timing dropdown");
		elementActions.doClick(vsPrescriptionDrugTimingDrpdownval);
		extentReport.logToExtentReport("Passing the value to 'Test' textfield");
		elementActions.doSendKeys(vsPrescriptionDrugRemarks, "Test");
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on'Add' button");
		elementActions.doClick(vsPrescriptionDrugAddButton);
		Thread.sleep(2000);
		
		extentReport.logToExtentReport("Clicking on 'Update Prescription' button");
		elementActions.doClick(vsUpdatePrescriptionBtn);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Share prescription' button");
		elementActions.doClick(vsSharePrescriptioncnfmSubmitButton);
		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(SharedPrescriptionSuccesfully)) {
			extentReport.logToExtentReport("Verification - Verifying whether Prescription shared successfully");
			// System.out.println("Prescription shared successfully");
		} else {
			fail();
		}
		extentReport.logToExtentReport("Clicking on 'View Prescription' button in popUp");
		elementActions.doClick(ViewPrescriptionButtonInPopUp);
		Thread.sleep(3000);
		//String DrugUpdated = elementActions.doGetText(UpdatedDrug);
		//String StrengthUpdated = elementActions.doGetText(UpdatedStrength);
		//String DaysUpdated = elementActions.doGetText(UpdatedDays);
		//Thread.sleep(3000);
		//if (DrugUpdated.contains(Drug) && StrengthUpdated.contains(Strength) && DaysUpdated.contains(NoOfDays)) {
			//extentReport.logToExtentReport(
					//"Verification - Verifying whether Prescription popup is displayed with updated details");
			// System.out.println("Prescription popup is displayed with updated details");
		//}
		//else {
			//fail();
		//}
	}

	/*
	 * Author: Rajesh H S Created: 19/10/23 Description: Verifying the end-to-end
	 * flow of logging in, accessing the calendar, viewing the calendar, select a
	 * follow up visit/Appointment and provide prescription
	 */
	@Step("Login, calendar, view calendar, followup visit, provide prescription")
	public void LoginCalendarViewCalendarFollowupVisitProvidePrescription() throws Throwable {
		calendarPage.OpenCalendar();
		calendarPage
				.VerifyUserCanNavigateToVisitSummaryPageByClickingProvidePrescriptionButtonOnAppointmentOrFollopVisitDetailsPopup();
		//endToEndMethods.VerifyAddFunctionalityUnderDiagnosisSection();
		//endToEndMethods.verifyvsprescrptionChangesSharePrescButton();

	}

	/*
	 * Author: Rajesh H S Created: 20/10/23 Description: Verifying the end-to-end
	 * flow of logging in, selecting a patient from prescription, viewing the
	 * prescription
	 */
	@Step("Login, prescription sent, visit summary, view prescription")
	public void LoginPrescriptionSentVisitSummaryViewPrescription() throws Throwable {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Prescription' link");
		elementActions.doClick(PrescriptionLink);
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on first patient from the prescription section");
		elementActions.doClick(PrescriptionPatient);
		Thread.sleep(10000);
		elementActions.doIsDisplayed(vsUpdatePrescription);
		extentReport.logToExtentReport("Update Prescription button is displayed");
		elementActions.waitForElementClickable(vsUpdatePrescription);
		Thread.sleep(4000);
		extentReport.logToExtentReport("Clicked on Update Prescription button");
		elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicking on 'Share prescription' button");
		elementActions.doClick(vsSharePrescriptioncnfmSubmitButton);
		Thread.sleep(2000);
		if (elementActions.doIsDisplayed(SharedPrescriptionSuccesfully)) {
			extentReport.logToExtentReport("Verification - Verifying whether Prescription shared successfully");
			// System.out.println("Prescription shared successfully");
		
		Thread.sleep(3000);
		if (elementActions.doIsDisplayed2(ConsultationDetailsText) && elementActions.doIsDisplayed(VitalsText)
				&& elementActions.doIsDisplayed(CheckUpReasonText)
				&& elementActions.doIsDisplayed(PhysicalWxaminationText)
				&& elementActions.doIsDisplayed(MedicalHistoryText)
				&& elementActions.doIsDisplayed(AdditionalDocumentsText)) 
			extentReport.logToExtentReport(
					"Verification - Verifying whether Prescription popup is displayed with all details");
			// System.out.println("Prescription popup is displayed with all details");
		} else {
			fail();
		}
	}
	public void  VisitSummaryInprogressVisit() throws Throwable{
		elementActions.doIsDisplayed(VisitSummaryPageText);
		extentReport.logToExtentReport("Verification - Verifying whether 'Visit summary' page is displayed");
		// System.out.println("Visit summary page is displayed");
		Thread.sleep(4000);
		endToEndMethods.VerifyAddFunctionalityUnderDiagnosisSection();
		endToEndMethods.verifyvsprescrptionChanges();
		Thread.sleep(2000);
		extentReport.logToExtentReport("Sending value to 'Test' textfield");
				elementActions.doActionsSendKeys(TestTextField, "Blood");
				Thread.sleep(2000);
				extentReport.logToExtentReport("Selecting 'Advice' option");
				elementActions.doClick(SelectAdviceOption);
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Save' button");
				elementActions.doClick(SaveTestButton);
				Thread.sleep(2000);
				//extentReport.logToExtentReport("Clicking on 'No' radio button");
				//elementActions.doSelect(ReferrealNoRadioButton);
				//Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Follow uo' radio button");
				elementActions.doSelect(FollowUpNoRadioButton);
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Share Prescription' button");
				elementActions.doClick(SharePrescriptionButton);
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Confirm' button");
				elementActions.doClick(ConfirmButton);
				if (elementActions.doIsDisplayed(SharePrescriptionSuccessfullyText)) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Share Prescription successfully' text is displayed on the popup");
				} else {
					fail();
				}
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Close' button");
				elementActions.doClick(CloseButton);
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Update Prescription' button");
				elementActions.doClick(UpdatePrescription);
				if (elementActions.doIsDisplayed(SharePrescriptionPopUpText)) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Share Prescription' text is displayed on the popup");
				}
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Confirm' button");
				elementActions.doClick(ConfirmButton);

				boolean Displayed = elementActions.doIsDisplayed(SharedPrescriptionSuccesssfullyPopUpText);
				if (Displayed == true) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Prescription' shared successfully for the patient");
					// System.out.println("Prescription shared successfully for the patient");
				} else {
					fail();
				}
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'Close' button");
				elementActions.doClick(CloseButton);
				Thread.sleep(2000);
				extentReport.logToExtentReport("Clicking on 'View Prescription' button");
				elementActions.doClick(ViewPrescription);
				if (elementActions.doIsDisplayed(PrescriptionTitleText) && elementActions.doIsDisplayed(ConsultationDetailsText)
						&& elementActions.doIsDisplayed(ConsultedDoctorsText) && elementActions.doIsDisplayed(MedicationText)
						&& elementActions.doIsDisplayed(DiagnosisLink)) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether 'Prescription' popup is displayed with all the details");
					// System.out.println("Prescription popup is displayed with all the details");
				} else {
					fail();
				}
			}




	/*
	 * Author: Rajesh H S Created: 20/10/23 Description : Verifying the end-to-end
	 * flow of logging in, selecting a patient from prescription, updating the
	 * details and sharing the prescription
	 */
	@Step("Login, prescription sent, visit summary, share prescription")
	public void LoginPrescriptionSentVisitSummarySharePrescription() throws Throwable {
		LoginPrescriptionSentVisitSummaryUpdatePrescription();
	}

	/*
	 * Author: Rajesh H S Created: 20/10/23 Description : Verifying the end-to-end
	 * flow of logging in, selecting a patient from completed prescription and
	 * viewing the prescription
	 */
	@Step("Login, completed visit sent, visit summary, view prescription")
	public void LoginCompletedVisitSentVisitSummaryViewPrescription() throws Throwable {
		Thread.sleep(2000);
		extentReport.logToExtentReport("Clicking on 'Prescription' link");
		elementActions.doClick(PrescriptionLink);
		Thread.sleep(4000);
		extentReport.logToExtentReport("Clicking on 'Completed Visits' tab");
		elementActions.doClick(CompletedVisitsTab);
		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			boolean Completed = elementActions.doIsDisplayed2(PrescriptionSent);
			if (Completed == true) {
				extentReport.logToExtentReport("Clicking on prescription sent");
				elementActions.doClick(PrescriptionSent);
				elementActions.doClick(patient1pressent);
				extentReport.logToExtentReport("Clicked on 1st patient from prescription sent");
				elementActions.doClick(vsViewPrescriptionBtn);
				extentReport.logToExtentReport("Clicked on View prescription");
				elementActions.doIsDisplayed(vsViewPrescriptionPopup);
				extentReport.logToExtentReport("View prescription popup is displayed");
				//endToEndMethods.verifyvsprescrptionChangesViewPrescButton();
				Thread.sleep(3000);
				if (elementActions.doIsDisplayed2(ConsultationDetailsText) && elementActions.doIsDisplayed(VitalsText)
						&& elementActions.doIsDisplayed(CheckUpReasonText)
						&& elementActions.doIsDisplayed(consultationdetails)
						&& elementActions.doIsDisplayed(Diagnosisdetails)
						&& elementActions.doIsDisplayed(Medication)) {
					extentReport.logToExtentReport(
							"Verification - Verifying whether Prescription popup is displayed with all details");
					// System.out.println("Prescription popup is displayed with all details");
					break;
				}
			} else {
				fail();
			}
			boolean Check = elementActions.doIsEnabled(NextPage);
			if (Check == true) {
				extentReport.logToExtentReport("Clicking on 'next' arrow");
				elementActions.doClick(NextPage);
				if (Check == false) {
					break;
				}

			}
			if (Completed == false) {
				throw new Exception("For none of the patients prescription has been sent");
			}
		}
	}


}
