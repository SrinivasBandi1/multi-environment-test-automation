package com.intelehealth.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class VisitSummaryPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	AwaitPriortyInProgress awaitPriortyInProgress;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By appointmentLink = By.xpath("//a[@data-test-id='linkAppointments']");
	By apPatient1Name = By.xpath("//td[@data-test-id='apPatient0']");
	By apPatient2Name = By.xpath("//td[@data-test-id='apPatient1']");
	By apPatient3Name = By.xpath("//td[@data-test-id='apPatient2']");
	By apPatient4Name = By.xpath("//td[@data-test-id='apPatient3']");
	By apPatient5Name = By.xpath("//td[@data-test-id='apPatient4']");
	By apPatientNames = By.xpath("//h6[@data-test-id='etPatientName']");
	By vstSummaryAptStartBanner = By.xpath("//div[@class='appointment-banner']");
	By awtvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-Awaiting-0']");
	By dashboardLink = By.xpath("//a[@data-test-id='linkDashboard']");
	By NextPage = By.xpath("//button[@aria-label='Next page']");
	By vstsumpatientAptStartsField = By.xpath("//td[@data-test-id='td-starts_in-0']");
	By vstsumpatientSectionAge = By.xpath("//p[@data-test-id='etPatientAge']");
	By vstsumpatientSectionAddress = By.xpath("//p[@data-test-id='etPatientAddrs']");
	By vstsumpatientSectionOccupation = By
			.xpath("//h6[contains(@data-test-id,'etPatient') and contains(text(),'Occupation')]");
	By vstsumpatientSectionNationalID = By
			.xpath("//h6[contains(@data-test-id,'etPatient') and contains(text(),'National ID')]");
	By vstsumpatientSectionContactNo = By.xpath("//a[@data-test-id='linkWhatsApp']");
	By vstsumCurrentVstSummaryTab = By.xpath("//span[@data-test-id='mtCurrentVisitSummary']");
	By vstsumPastVstHistoryTab = By
			.xpath("//div[@class='mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted']");
	By vstsumNoPastVstHistoryText = By.xpath("//span[text()=' No past visit history ']");
	By vstsumpatientChatIcon = By.xpath("//img[@data-test-id='imgStartChat']");
	By vstsumpatientChatBox = By.xpath("//div[@class='chat-con-body']");
	By vstsumpatientChatBoxTitle = By.xpath("//div[@class='title']");
	By vstsumpatientChatTextBox = By.xpath("//input[@data-test-id='etChatMessageChatBox']");
	By vstsumpatientChatSendButton = By.xpath("//button[@data-test-id='btnSendMessageChatBox']");
	By vssumpatientVerifyChatText = By.xpath("//li[contains(text(),'hi')]");
	By vstsumpatientVideoWindow = By.xpath("//div[@id='mat-dialog-title-0']");
	By vstsumpatientVideoWindowPatientname = By.xpath("(//h6[@class='mb-0'])[2]");
	By vstsumpatientVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By vstsumpatientStartCallButton = By.xpath("//a[@data-test-id='linkPhoneNumber']");
	// Visit Summary page Consultation details fields
	By vsConsultDetVstID = By.xpath("//label[@data-test-id='etVisitIdConDets']");
	By vsConsultDetVstCrtd = By.xpath("//label[@data-test-id='etVisitCreConDets']");
	By vsConsultDetVstUpld = By.xpath("//label[@data-test-id='etVisitUplConDets']");
	By vsConsultDetVstAptOn = By.xpath("//label[@data-test-id='etAppOnConDets']");
	By vsConsultDetVstStatus = By.xpath("//label[@data-test-id='etStatusConDets']");
	By vsConsultDetVstLoc = By.xpath("//label[@data-test-id='etLocatinConDets']");
	By vsConsultDetVstProvdBy = By.xpath("//label[@data-test-id='etProvidedByConDets']");
	// Visit Summary page Vitals fields
	By vsConsultDetVitHt = By.xpath("//label[@data-test-id='height_cm']");
	By vsConsultDetVitWt = By.xpath("//label[@data-test-id='weight_kg']");
	By vsConsultDetVitBMI = By.xpath("//label[@data-test-id='bmi']");
	By vsConsultDetVitBP = By.xpath("//label[@data-test-id='bp_systolic']");
	By vsConsultDetVitPulse = By.xpath("//label[@data-test-id='pulse_bpm']");
	By vsConsultDetVitTemp = By.xpath("//label[@data-test-id='temprature_f']");
	By vsConsultDetVitSpo2 = By.xpath("//label[@data-test-id='spo2']");
	By vsConsultDetVitRespRate = By.xpath("//label[@data-test-id='respiratory_rate']");
	// Check-Up reason field
	By vsChkUpRsn = By.xpath("//h6[@data-test-id='Case Summary']");
	By vsChkUpRsnChfCmplnt = By.xpath("//h6[@data-test-id='etTitleAbdCheckup']");
	By vsChkUpRsnAssciatedSymptoms = By.xpath("//h6[@data-test-id='etTitleAssCheckup']");
	By vsChkUpRsnPhysicalExam = By.xpath("//h6[@data-test-id='Physical examination test']");
	By vsChkUpRsnGenearalExam = By.xpath("//h6[@data-test-id='etTitleGenPhysicalExam']");
	By vsChkUpRsnMedHistory = By.xpath("//h6[@data-test-id='Medical history']");
	By vsChkUpRsnFamHistory = By.xpath("//h6[@data-test-id='etTitleFamMedicalhis']");
	By vsChkUpRsnPatientHistory = By.xpath("//h6[@data-test-id='etTitlePatMedicalhis']");
	By vsChkUpRsnAddDocmnts = By.xpath("//h6[@data-test-id='Additional Documents']");
	By vsStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By vsSharePrescription = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsSharePrescriptionSubmitButton = By.xpath("//button[@data-test-id='btnSubmitSharePrescriptionModal']");
	By vsSharePrescPopupConfText = By.xpath("//p[@data-test-id='sharePrescriptionModalMessage']");
	By vsViewPrescrptnBtn = By.xpath("//button[@data-test-id='btnView']");
	By vsGoToDashboardBtn = By.xpath("//button[@data-test-id='btnSubmit']");
	By vsCloseBtnPopup = By.xpath("//button[@data-test-id='btnClose']");
	By vsUpdatePrescriptionBtn = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsViewPrescriptionBtn = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By vsViewPrescriptionPopup = By.xpath(("//h6[text()='  Prescription ']"));
	// diagnosis field
	By SelectDiagnosisDownArrow = By
			.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//span[@class='ng-arrow']");
	By SelectDiagnosisTextField = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//input");
	By SelectDiagnosislist = By.xpath("//div[@role='option']//span[contains(text(),'Fever')]");
	By DiagnosisSelected = By
			.xpath("//ng-select[@data-test-id='selectDiagnosisName']//span[@class='ng-value-label ng-star-inserted']");
	By DropdownFirstOption = By.xpath("(//span[@class='ng-option-label ng-star-inserted'])[1]");
	By DiagnosisTypePrimary = By.xpath("//input[@data-test-id='radioDiagnosisTypePrimary']");
	By DiagnosisStatusProvisional = By.xpath("//input[@data-test-id='radioDiagnosisStatusProvisional']");
	By DiagnosisStatusConfirmed = By.xpath("//input[@data-test-id='radioDiagnosisStatusConfirmed']");
	By AddDiagnosis = By.xpath("//button[@data-test-id='btnSubmitDiagnosis']");
	By DiagnosisColumn = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']//input");
	By FollowupOptionYes = By.xpath("//input[@data-test-id='radioFollowUpYes']");
	By FollowupOptionNo = By.xpath("//input[@data-test-id='radioFollowUpNo']");
	By FollowupCalendar = By.xpath("//mat-datepicker-toggle[@data-test-id='dpFollowUpDate']");
	By FollowupDatePick = By.xpath("//div[contains(text(),'28')]");
	By FollowupTimeClick = By.xpath("//ng-select[@data-test-id='selectFollowUpTime']");
	By FollowupTimePick = By.xpath("//span[contains(text(),'9:00 AM')]");
	By FollowupSaveButton = By.xpath("//button[@data-test-id='btnSubmitFollowUp']");
	By FollowupDelButton = By.xpath("//button[@data-test-id='btnDeleteFollowUp']");
	By FollowupLabel = By.xpath("//label[text()='Do you want to have follow up with the patient?']");
	By vsPrescriptionDrugTextBox = By.xpath("//input[@data-test-id='etDrugName']");
	By vsPrescriptionDrugStrengthTextBox = By.xpath("//input[@data-test-id='etDrugStrength']");
	By vsPrescriptionDrugNoOfDaysTextBox = By.xpath("//input[@data-test-id='etDays']");
	By vsPrescriptionDrugTimingDrpdown = By.xpath("//ng-select[@data-test-id='selectTiming']");
	By vsPrescriptionDrugRemarks = By.xpath("//input[@data-test-id='etRemarkMed']");
	By vsPrescriptionDrugTimingDrpdownval = By.xpath("//span[text()='1 - 0 - 0']");
	By vsPrescriptionDrugAddButton = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By lblOpenMRSIDInVisitSummary = By.xpath("//p[@data-test-id='etPatienOpenMRSId']");
	By lblPatientNameInVisitSummary = By.xpath("//h6[@data-test-id='etPatientName']");
	By lblDashboard = By.xpath("//ol[@class='breadcrumb']//a");
	By patientInfoXpath = By.xpath("//div[contains(@class,'patient-info-item')]//h6");
	By rdoYesInReferralToSpecialist = By.xpath("//input[@data-test-id='radioFollowUpYes']");
	By rdoNoInReferralToSpecialist = By.xpath("//input[@data-test-id='radioFollowUpNo']");
	By tabs = By.xpath("//div[@class='mat-tab-labels']/div");
	By btnStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By drpTimings = By.xpath("//ng-select[@data-test-id='selectTiming']//span");
	By drpTimingsList = By.xpath(
			"//ng-dropdown-panel[@class='ng-dropdown-panel visit-select custom ng-star-inserted ng-select-top']//span");
	By lblSelectedTiming = By.xpath("//ng-select[@data-test-id='selectTiming']//span/following-sibling::span");
	By btnAddMedicine = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By countTableRows = By.tagName("//tr");
	By drpDrugList = By
			.xpath("//input[@data-test-id='etDrugStrength']/following-sibling::ngb-typeahead-window//button");
	By drpDaysList = By.xpath("//input[@data-test-id='etDays']/following-sibling::ngb-typeahead-window//button");
	public static String lblDrugNames = "//input[@data-test-id='${lblDrugNames}']";
	public static String lblNames = "//h6[@data-test-id='${lblSections}']";

	// Constructor of page class:
	public VisitSummaryPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		awaitPriortyInProgress = new AwaitPriortyInProgress(this.driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description: This method navigates to
	 * visit summary page by clickin on 1st patient from Appointment field
	 */
	@Step("Navigate to VisitSummary Page")
	public void goToVisitSummaryPage() throws InterruptedException {
		Thread.sleep(5000);
		// elementActions.doClick(appointmentLink);

		extentReport.logToExtentReport("Clicked on Appointment link");
		Thread.sleep(3000);
		// elementActions.doClick(apPatient1Name);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on first appointment patient");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to verify
	 * the elements displayed in Visit summary page
	 */
	@Step("Verify the UI of VisitSummary Page")
	public void verifyVstSummaryUI() {
		elementActions.doIsDisplayed(vstsumpatientSectionAge);
		extentReport.logToExtentReport("Age section is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionAddress);
		extentReport.logToExtentReport("Address section is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionOccupation);
		extentReport.logToExtentReport("Occupation section is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionNationalID);
		extentReport.logToExtentReport("National ID section is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionContactNo);
		extentReport.logToExtentReport("Contact Number section is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to verify
	 * the Appointment starts date filed
	 */
	@Step("Verify the UI of VisitSummary Page")
	public void verifyAptStartinInDateTime() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(appointmentLink);
		extentReport.logToExtentReport("Clicked on Appointment link");
//		Thread.sleep(3000);
		elementActions.doClick(apPatient1Name);
		extentReport.logToExtentReport("Clicked on first patient from Appointment table");
//		Thread.sleep(3000);
		elementActions.doIsDisplayed2(vsStartVisitNote);
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to click
	 * on Start call buttom for the patient with registered ph no.
	 */
	@Step("click on Start Call option of VisitSummary Page")
	public void verifyStartCallOption() throws InterruptedException {
		Thread.sleep(4000);
		elementActions.doClick(vstsumpatientStartCallButton);
		extentReport.logToExtentReport("Call button from Visit summary page");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : this method is to verify
	 * the chat option present in Visit summary page
	 */
	@Step("Verify the chat option of VisitSummary Page")
	public void verifyChatOption() {
		elementActions.doIsDisplayed(btnStartVisitNote);
		elementActions.doActionsClick(btnStartVisitNote);
		elementActions.doClick(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Chat icon is clicked on Visit summary page");
		elementActions.doIsDisplayed(vstsumpatientChatBox);
		extentReport.logToExtentReport("Chat box is displayed");
		elementActions.doIsDisplayed(vstsumpatientChatBoxTitle);
		extentReport.logToExtentReport("Chat box title with patient name and ID is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to verify
	 * the message sent successfully from Visit summary page.
	 */
	@Step("Verify the message sent successfully from chat option of VisitSummary Page")
	public void verifyMessageSent() throws InterruptedException {
		elementActions.doIsDisplayed(btnStartVisitNote);
		elementActions.doActionsClick(btnStartVisitNote);
		Thread.sleep(3000);
		elementActions.doClick(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Clicked on Chat icon from Visit summary page");
		elementActions.doSendKeys(vstsumpatientChatTextBox, "hi");
		extentReport.logToExtentReport("Type Hi message from Chat text box");
		elementActions.doClick(vstsumpatientChatSendButton);
		extentReport.logToExtentReport("Clicked on send button");
		elementActions.doIsDisplayed(vstsumpatientChatBoxTitle);
		extentReport.logToExtentReport("Chat box title is displayed");
		elementActions.doIsDisplayed(vssumpatientVerifyChatText);
		extentReport.logToExtentReport("Sent message is displayed in Chat text dialog");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method verifies if
	 * the doctor is able to do a video call for the patient
	 */
	@Step("Verify the video call from video option of VisitSummary Page")
	public void verifyvideoCall() throws InterruptedException {
		elementActions.doIsDisplayed(btnStartVisitNote);
		Thread.sleep(3000);
		elementActions.doActionsClick(btnStartVisitNote);
		elementActions.doClick(vstsumpatientVideoIcon);
		extentReport.logToExtentReport("Clicked on Video icon from Visit summary page");
		elementActions.doIsDisplayed(vstsumpatientVideoWindow);
		extentReport.logToExtentReport("Video window is displayed");
		elementActions.doIsDisplayed(vstsumpatientVideoWindowPatientname);
		extentReport.logToExtentReport("Patient name is displayed in Video Window");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to veerify
	 * the elements displayed under current visit summary tab
	 * 
	 */
	@Step("Verify the current visit summary tab of VisitSummary Page")
	public void verifycurrentVisitSummaryField() {
		elementActions.doIsDisplayed(vsConsultDetVstID);
		extentReport.logToExtentReport("Visit ID is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstCrtd);
		extentReport.logToExtentReport("Visit created is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstUpld);
		extentReport.logToExtentReport("Visit Upload is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstAptOn);
		extentReport.logToExtentReport("Visit Appointment on is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstStatus);
		extentReport.logToExtentReport("Visit Status is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstLoc);
		extentReport.logToExtentReport("Visit Location is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVstProvdBy);
		extentReport.logToExtentReport("Visit Provided by is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitHt);
		extentReport.logToExtentReport("Vital height is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitWt);
		extentReport.logToExtentReport("Vital weight is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Vital BMI is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitBP);
		extentReport.logToExtentReport("Vital BP is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitPulse);
		extentReport.logToExtentReport("Vital Pulse is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitTemp);
		extentReport.logToExtentReport("Vital Temp is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitSpo2);
		extentReport.logToExtentReport("Vital SPO2 is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsConsultDetVitRespRate);
		extentReport.logToExtentReport("Vital Respiratory rate is displayed in Consultation details section");
		elementActions.doIsDisplayed(vsChkUpRsn);
		extentReport.logToExtentReport("Checkup reason is displayed ");
		elementActions.doIsDisplayed(vsChkUpRsnChfCmplnt);
		extentReport.logToExtentReport("Chief complaint is displayed in Checkup Reason field");
//		elementActions.doIsDisplayed(vsChkUpRsnAssciatedSymptoms);
		elementActions.doIsDisplayed(vsChkUpRsnPhysicalExam);
		extentReport.logToExtentReport("Physical exam is displayed in Checkup Reason field");
		elementActions.doIsDisplayed(vsChkUpRsnGenearalExam);
		extentReport.logToExtentReport("General Exam is displayed in Checkup Reason field");
		elementActions.doIsDisplayed(vsChkUpRsnMedHistory);
		extentReport.logToExtentReport("Medical history is displayed in Checkup Reason field");
		elementActions.doIsDisplayed(vsChkUpRsnFamHistory);
		extentReport.logToExtentReport("Family history is displayed in Checkup Reason field");
//		elementActions.doIsDisplayed(vsChkUpRsnPatientHistory);
		elementActions.doIsDisplayed(vsChkUpRsnAddDocmnts);
		extentReport.logToExtentReport("Add Documents is displayed in Checkup Reason field");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the video call from video option of VisitSummary Page")
	public void verifyvstsumPrescription() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting vist 1st patient");
		Thread.sleep(4000);
		elementActions.doClick(vsStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note");
		Thread.sleep(3000);
		elementActions.doIsDisplayed(vsSharePrescription);
		extentReport.logToExtentReport("Share Prescription button is displayed");
		Thread.sleep(4000);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		extentReport.logToExtentReport("Get the first value from diagnosis list displayed");
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		extentReport.logToExtentReport("Select the first option from the diagnosis list");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		extentReport.logToExtentReport("Clicked on Diagnosis Add button");
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		extentReport.logToExtentReport("Verified the text of the first option value from Diagnosis column");
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Yes Radio button is Follow up");
		Thread.sleep(2000);
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Follow up Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Follow up time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doClick(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Submit button is displayed from Share Prescription popup");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Submit button from Share Prescription popup");
		Thread.sleep(5000);
		elementActions.doIsDisplayed(vsGoToDashboardBtn);
		extentReport.logToExtentReport("Go to Dashboard button is displayed");
		elementActions.doClick(vsCloseBtnPopup);
		extentReport.logToExtentReport("Close button is displayed");
		Thread.sleep(5000);
		elementActions.doIsDisplayed(vsUpdatePrescriptionBtn);
		extentReport.logToExtentReport("Update Prescription button is displayed");
		elementActions.doIsDisplayed(vsViewPrescriptionBtn);
		extentReport.logToExtentReport("View Prescription button is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify doing any changes in any of the section in visit summary page")
	public void verifyvsprescrptionChanges() throws Throwable {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		Thread.sleep(3000);
		elementActions.doClick(vsStartVisitNote);
		Thread.sleep(5000);
		awaitPriortyInProgress.VerifyAddDiagnosisAndFollowupFunctionality("");
		//awaitPriortyInProgress.addMultipleMedications(medication);
		elementActions.doClick(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Share prescription is displayed");
		
		/*
		 * 
		 * extentReport.logToExtentReport("Clicked on Start Visit Note");
		 * elementActions.doSendKeys(vsPrescriptionDrugTextBox, "Dolo"); extentReport.
		 * logToExtentReport("Type Medicine DOLO in Prescription drug textbox");
		 * elementActions.doSendKeys(vsPrescriptionDrugStrengthTextBox, "500MG");
		 * extentReport.
		 * logToExtentReport("Type Drug Strength as 500MG in drug strength textbox");
		 * elementActions.doSendKeys(vsPrescriptionDrugNoOfDaysTextBox, "8");
		 * extentReport.logToExtentReport("Type 8 as No of days textbox ");
		 * elementActions.doClick(vsPrescriptionDrugTimingDrpdown);
		 * extentReport.logToExtentReport("Clicked on Drug time drop down");
		 * elementActions.doClick(vsPrescriptionDrugTimingDrpdownval);
		 * extentReport.logToExtentReport("Selected the value from Drug time dropdown");
		 * elementActions.doSendKeys(vsPrescriptionDrugRemarks, "Test");
		 * extentReport.logToExtentReport("Type in Drug Remarks");
		 * elementActions.doClick(vsPrescriptionDrugAddButton);
		 * extentReport.logToExtentReport("Clicked on Add button");
		 */
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of share prescription button in visit summary page")
	public void verifyvsprescrptionChangesSharePrescButton() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		Thread.sleep(4000);
		elementActions.doClick(vsStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note");
		Thread.sleep(4000);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		extentReport.logToExtentReport("Get the first value from diagnosis list displayed");
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		extentReport.logToExtentReport("Select the first option from the diagnosis list");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		extentReport.logToExtentReport("Clicked on Diagnosis Add button");
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		extentReport.logToExtentReport("Verified the text of the first option value from Diagnosis column");
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Yes Radio button is Follow up");
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Follow up Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Follow up time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doClick(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doIsDisplayed(vsSharePrescPopupConfText);
		extentReport.logToExtentReport("Share prescription Confirmation text is displayed");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Share prescription Submit button");
		elementActions.doIsDisplayed(vsGoToDashboardBtn);
		extentReport.logToExtentReport("Go to Dashboard button is displayed");
		elementActions.doClick(vsCloseBtnPopup);
		extentReport.logToExtentReport("Clicked on Close button from popup");
		elementActions.doIsDisplayed(vsUpdatePrescriptionBtn);
		extentReport.logToExtentReport("Update prescription is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of view prescription button in visit summary page")
	public void verifyvsprescrptionChangesViewPrescButton() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		Thread.sleep(4000);
		elementActions.doClick(vsStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note");
		Thread.sleep(4000);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		extentReport.logToExtentReport("Get the first value from diagnosis list displayed");
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		extentReport.logToExtentReport("Select the first option from the diagnosis list");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		extentReport.logToExtentReport("Clicked on Diagnosis Add button");
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		extentReport.logToExtentReport("Verified the text of the first option value from Diagnosis column");
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Yes Radio button is Follow up");
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Follow up Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Follow up time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doClick(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Share prescription Submit button");
		Thread.sleep(3000);
		elementActions.doClick(vsViewPrescriptionBtn);
		extentReport.logToExtentReport("Clicked on View prescription");
		Thread.sleep(3000);
		elementActions.doIsDisplayed(vsViewPrescriptionPopup);
		extentReport.logToExtentReport("View prescription popup is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of update prescription button in visit summary page")
	public void verifyvsprescrptionChangesUpdateButton() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		Thread.sleep(4000);
		elementActions.doClick(vsStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note");
		Thread.sleep(4000);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		extentReport.logToExtentReport("Get the first value from diagnosis list displayed");
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		extentReport.logToExtentReport("Select the first option from the diagnosis list");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		extentReport.logToExtentReport("Clicked on Diagnosis Add button");
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		extentReport.logToExtentReport("Verified the text of the first option value from Diagnosis column");
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Yes Radio button is Follow up");
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Follow up Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Follow up time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doClick(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Share prescription Submit button");
		Thread.sleep(3000);
		elementActions.doClick(vsCloseBtnPopup);
		extentReport.logToExtentReport("Clicked on close x button");
		Thread.sleep(3000);
		elementActions.doClick(vsUpdatePrescriptionBtn);
		extentReport.logToExtentReport("Clicked on Update Prescription");
		Thread.sleep(3000);
		elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Share prescription Submit button is displayed");
		elementActions.doIsDisplayed(vsSharePrescPopupConfText);
		extentReport.logToExtentReport("Share prescription Confirmation text on popup is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of update prescription button in visit summary page")
	public void verifyvsprescrptionChangesConfButton() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		Thread.sleep(4000);
		elementActions.doClick(btnStartVisitNote);
		Thread.sleep(3000);
		elementActions.doClick(vsSharePrescription);
		elementActions.doIsDisplayed(vsGoToDashboardBtn);
		extentReport.logToExtentReport("Confirm button is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of update prescription button in visit summary page")
	public void verifyvsprescrptionNoPastVstHistory() {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clickod on Appointment Patient");
		elementActions.doClick(vstsumPastVstHistoryTab);
		extentReport.logToExtentReport("Clickod on Past Visit history Tab");
		elementActions.doIsDisplayed(vstsumNoPastVstHistoryText);
		extentReport.logToExtentReport("No Past Visit history text is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of update prescription button in visit summary page")
	public void verifyvsprescrptionPastVstHistory() {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Appointment Patient");
		elementActions.doClick(vstsumPastVstHistoryTab);
		extentReport.logToExtentReport("Clicked on Past Visit history");
	}

	@Step("Get OpenMRSID text in visit summary")
	public String getOpenMRSIDText() {
		return elementActions.doGetText(lblOpenMRSIDInVisitSummary);
	}

	@Step("Get patient name text in visit summary ")
	public String getPatientNameTextInVisitSummary() {
		return elementActions.doGetText(lblPatientNameInVisitSummary);
	}

	@Step("Click on dashboard")
	public void clickOnDashboard() {
		try {
			elementActions.doClick(lblDashboard);
		} catch (Exception e) {
			elementActions.doActionsClick(lblDashboard);
		}
	}

	@Step("isEnabled add button")
	public boolean isEnabledAddButton() {
		try {
			extentReport.logToExtentReport("isEnabled add button");
			return elementActions.getElement(btnAddMedicine).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	@Step("get count of rows")
	public int getCountOfRows() {
		extentReport.logToExtentReport("get count of rows");
		return elementActions.getElements(countTableRows).size();
	}

	@Step("Click on Add Button")
	public void clickOnAddButton() {
		elementActions.doActionsClick(btnAddMedicine);
		extentReport.logToExtentReport("Click on Add Button");
	}

	@Step("Set medication name")
	public void setMedicationName(String stringToBeReplaced, String sendKeys) {
		elementActions.createElementReplacingString(lblDrugNames.replace("${lblDrugNames}", stringToBeReplaced))
				.sendKeys(sendKeys);
		extentReport.logToExtentReport("Set medication name");
	}

	@Step("Select drug name")
	public void selectDrugName(String drugName) {
		elementActions.clickOnElemenEqualsString(drpDrugList, drugName);
		extentReport.logToExtentReport("Select drug name");
	}

	@Step("select number of days")
	public void selectDaysOrStrenthOfMedicine(String stringToBeReplaced, String days, String actualDay) {
		elementActions.createElementReplacingString(lblDrugNames.replace("${lblDrugNames}", stringToBeReplaced))
				.click();
		extentReport.logToExtentReport("Clicked on drug name");
		elementActions.clickOnElemenEqualsString(drpTimingsList, actualDay);
		extentReport.logToExtentReport("select number of days");
	}

	@Step("Click on Timings Dropdown")
	public void clickOnTimingsDropdown() {
		try {
			elementActions.doSelect(drpTimings);
			extentReport.logToExtentReport("Click on Timings Dropdown");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("set the timings")
	public void setTimings(String timing) {
		elementActions.clickOnElemenEqualsString(drpTimingsList, timing);
		extentReport.logToExtentReport("set the timings");
	}

	@Step("Get selected Timing")
	public String getSelectedTiming() {
		extentReport.logToExtentReport("Get selected Timing");
		return elementActions.doGetText(lblSelectedTiming);
	}

	@Step("Click on Start Visit Note Button")
	public void clickOnStartVisitNoteButton() {
		try {
			elementActions.doClick(btnStartVisitNote);
			extentReport.logToExtentReport("Click on Start Visit Note Button");
		} catch (Exception e) {
			elementActions.doActionsClick(btnStartVisitNote);
			extentReport.logToExtentReport("Click on Start Visit Note Button");
		}
	}

	@Step("set Remarks")
	public void setRemarks(String Remarks) {
		elementActions.doSendKeys(vsPrescriptionDrugRemarks, Remarks);
		extentReport.logToExtentReport("Entered data in Remarks text field");
	}

	@Step("get patient information texts")
	public List<String> getPatientInformationTexts() {

		List<String> patientInfo = new ArrayList<>();
		for (WebElement e : elementActions.getElements(patientInfoXpath)) {
			patientInfo.add(e.getText());
		}
		return patientInfo;
	}

	@Step("Get Current And Past Visit Tabs")
	public List<String> getCurrentAndPastVisitTabs() {

		List<String> patientInfo = new ArrayList<String>();
		for (WebElement e : elementActions.getElements(tabs)) {
			patientInfo.add(e.getText());
		}
		return patientInfo;
	}

	@Step("Get Sub-Headings In Visit Summary")
	public List<String> getSubHeadingsInVisitSummary(String ids) {
		// ids =
		// "etHeaderConDets,etheaderVitals,etCh-upReasCheckup,etPhysicalexam,etMedicalHis,etAdditionalDoc,etReferToSpec";
		String[] headings = ids.split(",");
		List<String> replaceableItems = new ArrayList<String>();
		for (int i = 0; i < headings.length; i++) {
			replaceableItems
					.add(driver.findElement(By.xpath(lblNames.replace("${lblSections}", headings[i]))).getText());

		}
		return replaceableItems;

	}

	@Step("get patient information text")
	public void getPatientInformationTexts(String id) {

		elementActions.getPatientInformationText(lblNames, id);
		extentReport.logToExtentReport("Clickod on Past Visit history");
	}

	@Step("Isselected yes radio button")
	public boolean isSelectedYesRadioButton() {
		extentReport.logToExtentReport("yes radio button is selected");
		return elementActions.doIsSelected(rdoYesInReferralToSpecialist);

	}

	@Step("Isselected no radio button")
	public boolean isSelectedNoRadioButton() {
		extentReport.logToExtentReport("no radio button is selected");
		return elementActions.doIsSelected(rdoNoInReferralToSpecialist);

	}

	@Step("Click on NO radio button")
	public void clickOnNoRadioButton() {
		try {

			elementActions.scrollIntoView(rdoNoInReferralToSpecialist);
			extentReport.logToExtentReport("Scroll to NO radio button");
			elementActions.doClick(rdoNoInReferralToSpecialist);
			extentReport.logToExtentReport("Click on NO radio button");
		} catch (Exception e) {
			elementActions.doActionsClick(rdoNoInReferralToSpecialist);
			extentReport.logToExtentReport("Clickod on Past Visit history");
		}
	}

	@Step("Click on yes radio button")
	public void clickOnYesRadioButton() {
		try {
			elementActions.scrollIntoView(rdoYesInReferralToSpecialist);
			extentReport.logToExtentReport("Scroll to YES radio button");
			elementActions.doClick(rdoYesInReferralToSpecialist);
			extentReport.logToExtentReport("Click on YES radio button");
		} catch (Exception e) {
			elementActions.doActionsClick(rdoYesInReferralToSpecialist);
			extentReport.logToExtentReport("Click on YES radio button");
		}
	}

	@Step("Add diagnosis and followup")
	public void VerifyAddDiagnosisAndFollowupFunctionality(String diagnosis) throws Throwable {
		Thread.sleep(3000);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		extentReport.logToExtentReport("Get the first value from diagnosis list displayed");
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		extentReport.logToExtentReport("Select the first option from the diagnosis list");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		extentReport.logToExtentReport("Clicked on Diagnosis Add button");
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		extentReport.logToExtentReport("Verified the text of the first option value from Diagnosis column");
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Yes Radio button is Follow up");
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Follow up Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Follow up time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save button");

	}

}