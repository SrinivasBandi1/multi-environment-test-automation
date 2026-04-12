package com.intelehealth.pages;

import static org.testng.Assert.fail;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.AppConstants;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class AwaitPriortyInProgress extends BasePage {

	private static final String String = null;
	WebDriver driver;
	ElementActions elementActions;
	VisitSummaryPage vstsum;
	VisitSummaryPage visitSummaryPage;

	BasePage basePage = new BasePage();
	// Properties prop = basePage.init_prop();
	Properties prop;

	ExtentReportListener extentReport = new ExtentReportListener();
	By VsPatientDetailsName = By.xpath("//h6[@data-test-id='etPatientName']");
	By vstsumpatientSectionAge = By.xpath("//p[@data-test-id='etPatient']");
	By vstsumpatientDetailsDropdown = By.xpath("//button[@class='btn ng-star-inserted']");
	By vstsumpatientSectionAddress = By
			.xpath("//h6[text()='Corresponding address 1']//following-sibling::p[@data-test-id='etPatient']");
	By vstsumpatientSectionOccupation = By
			.xpath("//h6[text()='Occupation']//following-sibling::p[@data-test-id='etPatient']");
	By vstsumpatientSectionNationalID = By
			.xpath("//h6[text()='National ID']//following-sibling::p[@data-test-id='etPatient']");
	By vstsumpatientSectionContactNo = By.xpath("//p[@data-test-id='etPhoneNumber']");
	By vstsumCurrentVstSummaryTab = By
			.xpath("//div[@class='mat-tab-label-content']/..//div[text()='Current visit summary']");
	By vstsumPastVstHistoryTab = By.xpath("//div[@class='mat-tab-label-content']/..//div[text()='Past visit history']");
	By awtvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_name-Awaiting-0']");
	By vsStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By vstsumpatientChatIcon = By.xpath("//img[@data-test-id='imgStartChat']");
	By vstsumpatientVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");

	By vsConsultDetVstID = By.xpath("//label[@data-test-id='etVisitIdConDets']");
	By vsConsultDetVstCrtd = By.xpath("//label[@data-test-id='etVisitCreConDets']");
	By vsConsultDetVstUpld = By.xpath("//label[@data-test-id='etVisitUplConDets']");
	By vsConsultDetVstAptOn = By.xpath("//label[@data-test-id='etAppOnConDets']");
	By vsConsultDetVstStatus = By.xpath("//label[@data-test-id='etStatusConDets']");
	By vsConsultDetVstLoc = By.xpath("//label[@data-test-id='etLocatinConDets']");
	By vsConsultDetVstProvdBy = By.xpath("//label[@data-test-id='etProvidedByConDets']");

	By vsConsultDetVitHt = By.xpath("//label[@data-test-id='height_cm']");
	By vsConsultDetVitWt = By.xpath("//label[@data-test-id='weight_kg']");
	By vsConsultDetVitBMI = By.xpath("//label[@data-test-id='bmi']");
	By vsConsultDetVitBP = By.xpath("//label[@data-test-id='bp_systolic']");
	By vsConsultDetVitPulse = By.xpath("//label[@data-test-id='pulse_bpm']");
	By vsConsultDetVitTemp = By.xpath("//label[@data-test-id='temprature_f']");
	By vsConsultDetVitSpo2 = By.xpath("//label[@data-test-id='spo2']");
	By vsConsultDetVitRespRate = By.xpath("//label[@data-test-id='respiratory_rate']");

	// Check-Up reason field
	By vsChkUpRsn = By.xpath("//h6[@data-test-id='etTitleDryCheckup']");
	By vsChkUpRsnChfCmplnt = By.xpath("//h6[@data-test-id='etHeaderConDets']");

	By vsChkUpRsnPhysicalExam = By.xpath("//h6[@data-test-id='Physical examination test']");
	By vsChkUpRsnGenearalExam = By.xpath("//h6[@data-test-id='etTitleGenPhysicalExam']");
	By vsChkUpRsnMedHistory = By.xpath("//h6[@data-test-id='Medical history']");
	By vsChkUpRsnFamHistory = By.xpath("//h6[@data-test-id='etTitleFamMedicalhis']");
	By vsChkUpRsnPatientHistory = By.xpath("//h6[@data-test-id='etTitlePatMedicalhis']");
	By vsChkUpRsnAddDocmnts = By.xpath("//h6[@data-test-id='Additional Documents']");

	By vsChkUpRsnReferToSpecialtyDropdown = By
			.xpath("(//mat-expansion-panel-header[@data-test-id='matExpHeaderConDets'])[last()]");
	By vsChkupReferToAnotherRadBtnYes = By.xpath("//input[@data-test-id='radioReferYes']");
	By vsChkupReferToAnotherRadBtnNo = By.xpath("//input[@data-test-id='radioReferNo']");
	By vsChkupReferSpecialityRadBtnYes = By.xpath("//input[@data-test-id='radioReferralYes']");
	By vsChkupReferSpecialityRadBtnNo = By.xpath("//input[@data-test-id='radioReferralNo']");
	By vsChkupReferToAnotherDrpdwn = By.xpath("//ng-select[@data-test-id='selectReferralSpecialityVisitSummary']");
	By vsChkupReferSpecialityDrpdwn = By.xpath("//ng-select[@data-test-id='selectRefer']");
	By vsChkupReferToAnotherDrpdwnPediarician = By.xpath("//div[@role='option']//span[text()=' Pediatrician ']");
	By vsChkupReferSpecialityDrpdwnPediarician = By.xpath("//div[@role='option']//span[text()=' Pediatrician ']");
	By vsChkupReferSpecialityDrpdwnGeneralPhysician = By
			.xpath("//div[@role='option']//span[text()=' General Physician ']");
	By vsChkupReferSpecialityDrpdwnDermatologist = By.xpath("//div[@role='option']//span[text()=' Dermatologist ']");
	By vsChkupReferSpecialityDrpdwnGynecologist = By.xpath("//div[@role='option']//span[text()=' Gynecologist ']");
	By vsChkupReferToAnotherDrpdwnPediaricianVrfy = By
			.xpath("//ng-select[@data-test-id='selectRefer']//span[text()=' Pediatrician ']");
	By vsChkupReferSpecialityDrpdwnPediaricianVrfy = By
			.xpath("//ng-select[@data-test-id='selectReferralSpeciality']//span[text()=' Pediatrician ']");
	By vsChkupReferFacilityDrpdwn = By.xpath("//ng-select[@data-test-id='selectReferralFacilityVisitSummary']");
	By vsChkupReferFacilityDrpdwnHSC = By.xpath("//span[text()=' HSC ']");

	By vsChkupReferFacilityAddButton = By.xpath("//button[@data-test-id='btnSubmitReferralVisitSummary']");
	By vsChkupReferFacilityRefReasonTextArea = By.xpath("//textarea[@data-test-id='radioReferralReason']");
	By vsChkupReferToAnotherReassignButton = By.xpath("//button[@data-test-id='btnSubmitRefer']");
	By vsChkupReferSpecialityReassignButton = By.xpath("//button[@data-test-id='btnSubmitReferral']");
	By vsChkupReferSpecialityReferto = By.xpath("//th[@data-test-id='thReferralTo']");
	By vsChkupReferSpecialityConfirmPopupText = By
			.xpath("//p[text()=' Are you sure to re-assign this visit to another doctor? ']");
	By vsChkupReferSpecialityConfirmButton = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");
	By vsChkupReferSpecialityCancelButton = By.xpath("//button[@data-test-id='btnCancelConfirmationModal']");
	By vsChkupReferSpecialityCloseButton = By.xpath("//button[@data-test-id='btnCloseSharePrescriptionModal']");
	By vsChkupReferSpecialityReassignSuccessPopup = By.xpath("//div[@aria-label='Visit Re-assigned!']");
	By vsChkupStartVisitNoteButton = By.xpath("//button[@data-test-id='btnStartVisitNote']");

	By vsChkupStartVisitResferalDelBtn = By.xpath("//button[@data-test-id='btnDeleteReferralVisitSummary0']");
	By vsChkupStartVisitNotePatientInteraction = By.xpath("//h6[@data-test-id='titleCallDetails']");
	By vsChkupStartVisitNoteDiagnosis = By.xpath("//h6[@data-test-id='titleDiagnosisDetails']");
	By vsChkupStartVisitNoteSelectDiagnosisTextboxArrow = By
			.xpath("(//ng-select[@data-test-id='selectDiagnosisName']//span)[1]");
	By vsChkupStartVisitNoteSelectDiagnosisTextbox = By
			.xpath("//ng-select[@data-test-id='selectDiagnosisName']//input");
	By vsChkupStartVisitNoteSelectDiagnosisFirstValue = By.xpath("(//div[@class='ng-option ng-star-inserted'])[1]");
	By vsChkupStartVisitNoteNote = By.xpath("//h6[@data-test-id='txtNoteTitle']");
	By vsChkupStartVisitNoteMedication = By.xpath("//h6[text()='Medications']");
	By vsChkupStartVisitNoteAdvice = By.xpath("//h6[@data-test-id='titleAdvice']");
	By vsChkupStartVisitNoteTest = By.xpath("//h6[text()='Investigations']");// investigation
	By vsChkupStartVisitNoteReferralOut = By.xpath("//h6[@data-test-id='lblReferralTitle']");
	By vsChkupStartVisitNoteFollowup = By.xpath("//h6[@data-test-id='lblFollowUpTitle']");
	By vsChkupStartVisitNoteSharePrescBtn = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsChkupStartVisitNoteUpdatePrescBtn = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsChkupStartVisitNoteViewPrescBtn = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By vsCloseButton = By.xpath("//button[@data-test-id='btnClose']");
	By vsChkupStartVisitNoteConnLabl = By.xpath("//label[@data-test-id='labelConnectWithPatient']");
	By vsChkupStartVisitNoteConnLablValue = By.xpath("//span[text()='Patient Mobile number is not available']");
	By vsChkupStartVisitNoteCallIcon = By.xpath("//a[@data-test-id='linkPatientPhone']");
	By vsChkupStartVisitNoteWhatsappIcon = By.xpath("//a[@data-test-id='linkPatientWhatsApp']");
	By vsChkupStartVisitNoteRadBtnYeslabel = By.xpath("//input[@data-test-id='patientRadioYes']");
	By vsChkupStartVisitNoteRadBtnYes = By.xpath("//input[@data-test-id='patientRadioYes']");
	By vsChkupStartVisitNoteInteractionRadBtnYes = By.xpath("//input[@data-test-id='radioPatientInteractionYes']");
	By vsChkupStartVisitNoteRadBtnNo = By.xpath("//input[@data-test-id='radioPatientInteractionNo']");
	By vsChkupStartVisitNoteRadBtnNoLabel = By.xpath("//input[@data-test-id='radioPatientInteractionNo']");
	By vsChkupStartVisitNoteSaveBtn = By.xpath("//button[@data-test-id='btnSubmitPatientInteraction']");
	By vsChkupStartVisitNoteCallDuration = By.xpath("//p[@data-test-id='etPatientAddrs']");
	By vsChkupStartVisitNoteSpanCallDuration = By.xpath("//span[@data-test-id='spanCallDuration']");
	// span[@data-test-id='spanCallDuration']
	// label[@data-test-id='labelCallDuration']
	By vsChkupStartVisitNoteDelBtn = By.xpath("//button[@data-test-id='btnDeletePatientInteraction']");
	By VsPatientDetailsAge = By.xpath("//p[@data-test-id='etPatientAge']");
	By VsPatientDetailsAddress = By.xpath("//p[@data-test-id='etPatientAddrs']");
	By VsPatientDetailsOccupation = By.xpath("//p[@data-test-id='etPatientOccup']");
	By VsPatientDetailsNationID = By.xpath("//p[@data-test-id='etPatientNatId']");
	By VsPatientDetailsContact = By.xpath("//p[@data-test-id='etWhatsApp']");
	By StartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By SelectDiagnosisDownArrow = By
			.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//span[@class='ng-arrow']");
	By SelectDiagnosisTextField = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']/..//input");
	By SelectDiagnosislist = By.xpath("//div[@role='option']//span[contains(text(),'Fever')]");
	By DiagnosisSelected = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']/div/div");
	By DropdownFirstOption = By.xpath("(//span[@class='ng-option-label ng-star-inserted'])[1]");
	By DiagnosisTypePrimary = By.xpath("//input[@data-test-id='radioDiagnosisTypePrimary']");
	By DiagnosisStatusProvisional = By.xpath("//input[@data-test-id='radioDiagnosisStatusProvisional']");
	By DiagnosisStatusConfirmed = By.xpath("//input[@data-test-id='radioDiagnosisStatusConfirmed']");
	By AddDiagnosis = By.xpath("//button[@data-test-id='btnSubmitDiagnosis']");
	By FollowupOptionYes = By.xpath("//input[@data-test-id='radioFollowUpYes']");
	By FollowupOptionNo = By.xpath("//input[@data-test-id='radioFollowUpNo']");
	By FollowupCalendar = By.xpath("//mat-datepicker-toggle[@data-test-id='dpFollowUpDate']");
	By FollowupDatePick = By
			.xpath("//div[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	By FollowupTimeClick = By.xpath("//ng-select[@data-test-id='selectFollowUpTime']");
	By FollowupTimePick = By.xpath("//div[@class='ng-option ng-star-inserted']/span");
	By FollowupSaveButton = By.xpath("//button[@data-test-id='btnSubmitFollowUp']");
	By FollowupDelButton = By.xpath("//button[@data-test-id='btnDeleteFollowUp']");
	By FollowupLabel = By.xpath("//label[text()='Do you want to have follow up with the patient?']");
	By SharePrescptnText = By.xpath("//p[@data-test-id='sharePrescriptionModalMessage']");
	By SharePrescptnSuccessText = By
			.xpath("//p[text()='The prescription has been successfully sent. View prescription or go to dashboard']");
	By SharePrescptnConfirmButton = By.xpath("//button[@data-test-id='btnSubmitSharePrescriptionModal']");
	By SharePrescptnSuccessPopupViewPrescBtn = By.xpath("//button[@data-test-id='btnView']");
	By PescPopupDownloadBtn = By.xpath("//button[@data-test-id='btnDownload']");
	By ConstDetViewPrescptn = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By DiagnosisColumn = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']//input");
	By TypeColumn = By.xpath("//td[text()='Primary']");
	By StatusColumn = By.xpath("//td[text()='Provisional']");
	By DeleteIcon = By.xpath("//button[@data-test-id='btnDeleteDiagnosisVisitSummary0']");
	By DeleteIconMedications = By.xpath("//button[@data-test-id='btnDeleteMedVisitSummary0']");
	By DeleteIconAdvice = By.xpath("//button[@data-test-id='btnDeleteAdviceVisitSummary0']");
	By DeleteIconReferal = By.xpath("//img[@data-test-id='imgDeleteReferralIcon0']");
	By DeleteIconNote = By.xpath("//button[@data-test-id='btnDeleteDiagnosisVisitSummary0']");
	By diagnosisDeleteIcon = By.xpath("(//span[@class='mat-ripple mat-button-ripple mat-button-ripple-round'])[3]");
	By noteDeleteIcon = By.xpath("//img[@data-test-id='imgDeleteIcon0']");
	By NoteTextField = By.xpath("//textarea[@data-test-id='etNote']");
	By AddNoteButton = By.xpath("//button[@data-test-id='btnSubmitNote']");
	By Buffering = By.xpath("//div[@class='sk-ball-spin-clockwise']");
	By PleaseWaitText = By.xpath("//span[text()='Please Wait...']");
	By DrugNameTextField = By.xpath("//input[@data-test-id='etStandardDrugName']");
	By DrugNameTextFieldDropdown = By.xpath("(//input[@data-test-id='etStandardDrugName']/..//button)[1]");
	By StrengthTextField = By.xpath("//input[@data-test-id='etDrugStrength']");
	By NoteText = By.xpath("//div[@class='d-flex justify-content-between align-items-center']");
	By SelectHighlighted = By.xpath("//span[@class='ngb-highlight ng-star-inserted']");
	By NoOfDaysTextField = By.xpath("//input[@data-test-id='etDays']");
	By TimingsTextField = By.xpath("//ng-select[@data-test-id='selectTiming']");
	By AdditionalInstructionsTextArea = By.xpath("//textarea[@data-test-id='etAI']");
	By SaveAdditionalInstructions = By.xpath("//button[@data-test-id='btnSubmitAI']");
	By AdditionalInstructionText = By.xpath("//div[@class='d-flex justify-content-between']");
	By AddAdviceTextField = By.xpath("//input[@data-test-id='etAdvice']");
	By AddAdviceButton = By.xpath("//button[@data-test-id='btnSubmitAdvice']");
	By NoofdaysDropdownValue = By.xpath("//button[contains(@id,'ngb-typeahead')]");

	By lblPatientName1 = By.xpath("//td[@data-test-id='awPatient0']//span");
	By btnStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By lblTest = By.xpath("//label[@data-test-id='labelTest']");
	By txtTestName = By.xpath("//input[@data-test-id='etTest']");
	By txtTestNameVal1 = By.xpath("//button[contains(@id,'ngb-typeahead')]");
	By drpTestNames = By.xpath("//ngb-typeahead-window[contains(@id,'ngb-typeahead')]//ngb-highlight");

	By icnClose = By.xpath("//button[@data-test-id='btnClose']//mat-icon");
	By btnTest = By.xpath(
			"//input[@data-test-id='etTest']//following-sibling::ngb-typeahead-window//button//preceding-sibling::button//preceding-sibling::button");
	By btnAddTest = By.xpath("//button[@data-test-id='btnSubmitTest']");
	By iconDelete = By.xpath("//button[@data-test-id='btnDeleteTestVisitSummary0']");
	By textTest = By.xpath("//span[contains(text(),'test')]");
	By lblMedication = By.xpath("//h6[@data-test-id='medicationsTitle']");
	By txtAdditonalInstruction = By.xpath("//textarea[@data-test-id='etAI']");
	By lblAdvice = By.xpath("//div[@data-test-id='divAccordionTitleAdvice']");
	By lblAdditonalInstruction = By.xpath("//h6[text()='Additional instructions']");
	By txtAdvice = By.xpath("//input[@data-test-id='etAdvice']");
	By drpAdvice = By.xpath("//ngb-highlight[@class='ng-star-inserted']");
	By iconDeleteAI = By.xpath("//span[@class='mat-button-wrapper']/img");
	By lblselectedText = By.xpath("//span[@data-test-id='txtInvestigation0']");
	By lblselectedAdviceText = By.xpath("(//div[@class='d-flex justify-content-between'])[2]");
	By drugSaveButton = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By expandAdvice = By.cssSelector(".mat-icon.notranslate.ng-tns-c154-266.material-icons.mat-icon-no-color");
	By addtext = By.xpath("//input[@data-test-id='etTest']");
	By addAdvice = By.xpath("//input[@data-test-id='etAdvice']");
	By deleteButton = By.xpath("//button[@data-test-id='btnDeleteAdviceVisitSummary0']");
	By btnAddAdvice = By.xpath("//button[@data-test-id='btnSubmitAdvice']");
	By btnClickAddTest = By.xpath("//button[@data-test-id='btnSubmitTest']");
	By remarksTextField = By.xpath("//input[@data-test-id='etRemarkMed']");
	public static String button = "//button[@data-test-id='${button}']";
	By drugTimingValue = By.xpath("(//span[@class='ng-option-label ng-star-inserted'])[1]");
	By patientName = By.xpath("//td[@data-test-id='awPatient0']");
	By lblpatientName = By.xpath("//h6[@data-test-id='etPatientName']");
	By lblDashBoard = By.xpath("//li[@class='breadcrumb-item ng-star-inserted']//a");
	By searchField = By.xpath("//input[@placeholder='Search patient']");
	By searchIcon = By.xpath("//span[@class='input-group-text click']");
	By lstPatients = By.xpath("//tr[@class='ng-star-inserted']/td/preceding-sibling::td");
	By lstOpenMRSId = By.xpath("//div[@class='identifier']");
	By btnView = By.xpath(
			"//button[contains(@data-test-id,'btnViewSearchedPatients')]//span/preceding-sibling::span/preceding-sibling::span");
	By btnClose = By.xpath(
			"//button[@data-test-id='btnCloseSearchedPatients']//preceding-sibling::span//preceding-sibling::span");
	By lblPatientName = By.xpath("//div[@class='identifier']/../following-sibling::td/preceding-sibling::td");
	By lblOpenMRSID = By.xpath("//div[@class='identifier']");
	By drpTimings = By.xpath("//ng-select[@data-test-id='selectTiming']//span");
	By patientViewPopup = By.xpath("//app-searched-patients[@class='ng-star-inserted']");
	By lblPatientNameInAppointmentsSection = By.xpath("//td[@data-test-id='awPatient0']//span");
	By lblPatientNameInAwaitingVisitsSection = By
			.xpath("//tr[@data-test-id='aw0']//span[contains(@class,'font-bold')]");
	By inpDosage = By.xpath("//input[@data-test-id='etDose']");
	By inpFrequency = By.xpath("//ng-select[@data-test-id='selectFrequency']//input");
	By inpFrequencyValue = By.xpath("//span[text()='Three times daily']");
	By inpDurationNumber = By.xpath("//input[@data-test-id='durationNo']");
	By inpDurationUnits = By.xpath("//ng-select[@data-test-id='etDurationUnit']//input");
	By inpDurationUnitsValue = By.xpath("//span[text()='Days']");
	By inpAdditionalInstructions = By.xpath("//input[@data-test-id='etAI']");

	public static String lblFirstPatientNameUnderSections = "//tr[@data-test-id='{$patientName}']//span[contains(@class,'font-bold')]";

	public AwaitPriortyInProgress(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		prop = basePage.init_prop();
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verifying visit summary
	 * page is displayed after clicking on Awaiting Visits/In-Progress/Priority
	 * visits
	 */
	@Step("Verify visit summary page for Awaiting Visits/In-Progress/Priority visits")
	public void verifyVisitSumPageDetails() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(2000);
		elementActions.doIsDisplayed(VsPatientDetailsName);
		extentReport.logToExtentReport("Patient name is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionAge);
		extentReport.logToExtentReport("Age is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientDetailsDropdown);
		extentReport.logToExtentReport("Dropdown is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionAddress);
		extentReport.logToExtentReport("Address is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionOccupation);
		extentReport.logToExtentReport("Occupation is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionNationalID);
		extentReport.logToExtentReport("National ID is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionContactNo);
		extentReport.logToExtentReport("Contact No is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumCurrentVstSummaryTab);
		extentReport.logToExtentReport("Current visit summary tab is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumPastVstHistoryTab);
		extentReport.logToExtentReport("Past Visit history tab is displayed in Patient details");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Consult details with Vit BMI is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Consult details with Vit BMI is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnMedHistory);
		extentReport.logToExtentReport("Medical history is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnAddDocmnts);
		extentReport.logToExtentReport("Additional documents is displayed");
		elementActions.doIsDisplayed(vsStartVisitNote);
		extentReport.logToExtentReport("Start Visit Note button is displayed");
		elementActions.doIsDisplayed(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Chat icon is displayed");
		elementActions.doIsDisplayed(vstsumpatientVideoIcon);
		extentReport.logToExtentReport("Video icon is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verifying visit summary
	 * page is displayed after clicking on Awaiting Visits/In-Progress/Priority
	 * visits
	 */
	@Step("Verify the details of the patient are correctly displayed in visit summary page")
	public void verifyVstSumPageDetails() throws InterruptedException {
		// Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		elementActions.doIsDisplayed(VsPatientDetailsName);
		extentReport.logToExtentReport("Patient name is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionAge);
		extentReport.logToExtentReport("Patient Age is displayed");
		elementActions.doIsDisplayed(vstsumpatientDetailsDropdown);
		extentReport.logToExtentReport("Dropdown is displayed in Patient details");
		elementActions.doIsDisplayed(vstsumpatientSectionAddress);
		extentReport.logToExtentReport("Patient Address is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionOccupation);
		extentReport.logToExtentReport("Patient Occupation is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionNationalID);
		extentReport.logToExtentReport("Patient National ID is displayed");
		elementActions.doIsDisplayed(vstsumpatientSectionContactNo);
		extentReport.logToExtentReport("Patient contact number is displayed");
		elementActions.doIsDisplayed(vstsumCurrentVstSummaryTab);
		extentReport.logToExtentReport("Current visit summary tab is displayed");
		elementActions.doIsDisplayed(vstsumPastVstHistoryTab);
		extentReport.logToExtentReport("Past visit history is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Vitamin BMI details is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Vitamin BMI details is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnMedHistory);
		extentReport.logToExtentReport("Medical history is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnAddDocmnts);
		extentReport.logToExtentReport("Additional documents is displayed");
		elementActions.doIsDisplayed(vsStartVisitNote);
		extentReport.logToExtentReport("Start Visit Note button is displayed");
		elementActions.doIsDisplayed(vstsumpatientChatIcon);
		extentReport.logToExtentReport("Chat icon is displayed");
		elementActions.doIsDisplayed(vstsumpatientVideoIcon);
		extentReport.logToExtentReport("Video icon is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstID);
		extentReport.logToExtentReport("Consult Visit ID is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstCrtd);
		extentReport.logToExtentReport("Consult details visit created date is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstUpld);
		extentReport.logToExtentReport("Consult visit details upload is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstAptOn);
		extentReport.logToExtentReport("Consult Detials Appointment on is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstStatus);
		extentReport.logToExtentReport("Consult Details Visit Status is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstLoc);
		extentReport.logToExtentReport("Consult Visit Details Location is displayed");
		elementActions.doIsDisplayed(vsConsultDetVstProvdBy);
		extentReport.logToExtentReport("Consult Details Visit Provided By is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitHt);
		extentReport.logToExtentReport("Consult Details Visit Height is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitWt);
		extentReport.logToExtentReport("Consult Visit details Weight is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitBMI);
		extentReport.logToExtentReport("Consult details visit BMI is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitBP);
		extentReport.logToExtentReport("Consult Visit details BP is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitPulse);
		extentReport.logToExtentReport("Consult Visit details Pulse is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitTemp);
		extentReport.logToExtentReport("Consult Visit details Temp is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitSpo2);
		extentReport.logToExtentReport("Consult Visit Details SPO2 is displayed");
		elementActions.doIsDisplayed(vsConsultDetVitRespRate);
		extentReport.logToExtentReport("Consult Details Visit Resp Rate is displayed");
		elementActions.doIsDisplayed(vsChkUpRsn);
		extentReport.logToExtentReport("Check up reason is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnChfCmplnt);
		extentReport.logToExtentReport("Check up reason chief complaint is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnPhysicalExam);
		extentReport.logToExtentReport("Check up reason Physical exam is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnGenearalExam);
		extentReport.logToExtentReport("Check up reason General exam is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnMedHistory);
		extentReport.logToExtentReport("Check up reason Medical history is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnFamHistory);
		extentReport.logToExtentReport("Check up reason Family history is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnPatientHistory);
		extentReport.logToExtentReport("Check up reason Patient history is displayed");
		elementActions.doIsDisplayed(vsChkUpRsnAddDocmnts);
		extentReport.logToExtentReport("Check up reason Add Documents is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify when can select
	 * Refer speciality Yes radio button No radio button is not selected.
	 */
	public void verifyVisitSumReferSpecialityRadBtn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting Patient");
		Thread.sleep(3000);
		elementActions.scrollToElementByText("Additional Documents");
		Thread.sleep(3000);
		elementActions.doClick(vsChkUpRsnReferToSpecialtyDropdown);
		Thread.sleep(5000);
		elementActions.doSelect(vsChkupReferToAnotherRadBtnYes);
		extentReport.logToExtentReport("Clicked on Refer speciality YES Radio button");
		elementActions.doIsNotSelected(vsChkupReferToAnotherRadBtnNo);
		extentReport.logToExtentReport("Verified that Refer Speciality NO radio button is not selected");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify you can select
	 * only one value from refer specialty dropdown
	 */
	public void verifyVisitSumReferSpecialityDrpdwn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting Patient");
		Thread.sleep(3000);
		elementActions.scrollToElementByText("Additional Documents");
		Thread.sleep(2000);
		elementActions.doClick(vsChkUpRsnReferToSpecialtyDropdown);
		elementActions.doSelect(vsChkupReferToAnotherRadBtnYes);
		extentReport.logToExtentReport("Clicked on Refer speciality Radio button Yes");
		elementActions.doClick(vsChkupReferSpecialityDrpdwn);
		extentReport.logToExtentReport("Clicked on Refer Specialty dropdown");
		elementActions.doClick(vsChkupReferSpecialityDrpdwnGeneralPhysician);
		extentReport.logToExtentReport("Clicked on General Phisician in Refer Specialty dropdown");
		Thread.sleep(2000);
		elementActions.doIsNotDisplayed(vsChkupReferToAnotherDrpdwnPediarician);
		extentReport.logToExtentReport(
				"Pediatrician in Refer Specialty dropdown is not displayed as the Genaral Physician is already selected");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify you can select
	 * only one value from refer specialty dropdown
	 */
	public void verifyVisitSumReferralyAddBtn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting Patient");
		Thread.sleep(3000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(8000);
		/*
		 * elementActions.doSelect(vsChkupReferSpecialityRadBtnYes);
		 * extentReport.logToExtentReport("Clicked on Refer speciality radio button Yes"
		 * );
		 */
		elementActions.doClick(vsChkupReferToAnotherDrpdwn);
		extentReport.logToExtentReport("Clicked on Refer to dropdown");

		elementActions.doClick(vsChkupReferSpecialityDrpdwnPediarician);
		extentReport.logToExtentReport("Selected Pediatrician");

		elementActions.doClick(vsChkupReferFacilityDrpdwn);
		extentReport.logToExtentReport("Clicked on Refer facility dropdown");

		elementActions.doClick(vsChkupReferFacilityDrpdwnHSC);
		extentReport.logToExtentReport("Selected HSC from Refer facility dropdown");

//        elementActions.doSendKeys(vsChkupReferFacilityRefReasonTextArea, "Test");
//        extentReport.logToExtentReport("Enter text in Refer specialty text area");
		elementActions.doClick(vsChkupReferFacilityAddButton);
		extentReport.logToExtentReport("Clicked on Refer specialty Reassign button");
//        elementActions.doIsDisplayed(vsChkupReferSpecialityReferto);
//        extentReport.logToExtentReport("Verified Refer facility is added");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify you can select
	 * only one value from refer specialty dropdown
	 */
	public void verifyVisitSumReferralyDelBtn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doIsDisplayed(vsChkupStartVisitResferalDelBtn);
		extentReport.logToExtentReport("Delete icon is displayed");
		elementActions.doClick(vsChkupStartVisitResferalDelBtn);
		extentReport.logToExtentReport("Clicked On Delete Icon");
		elementActions.doIsNotDisplayed(vsChkupReferSpecialityDrpdwn);
		extentReport.logToExtentReport("Verified: Referral speciality is deleted");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify confirm popup is
	 * displayed when you click on Re Assign button
	 */
	public void verifyVisitSumReferSpecialityDrpdwnSelect() throws Exception {
		elementActions.doClick(vsChkupReferSpecialityDrpdwn);
		extentReport.logToExtentReport("Clicked on Refer Specialty dropdown");
		elementActions.doIsDisplayed(vsChkupReferSpecialityDrpdwnGeneralPhysician);
		extentReport.logToExtentReport("Verified General Phisician in Refer Specialty dropdown");
		elementActions.doIsDisplayed(vsChkupReferSpecialityDrpdwnDermatologist);
		extentReport.logToExtentReport("Verified Dermatologist in Refer Specialty dropdown");
		elementActions.doIsDisplayed(vsChkupReferSpecialityDrpdwnGynecologist);
		extentReport.logToExtentReport("Verified Gynecologist in Refer Specialty dropdown");
		elementActions.doIsDisplayed(vsChkupReferSpecialityDrpdwnPediarician);
		extentReport.logToExtentReport("Verified Pediatrician in Refer Specialty dropdown");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupReferToAnotherDrpdwnPediarician);
		extentReport.logToExtentReport("Selected Pediatrician from Refer Specialty dropdown");
		Thread.sleep(2000);
		elementActions.doIsDisplayed(vsChkupReferToAnotherDrpdwnPediaricianVrfy);
		extentReport.logToExtentReport("Verified Pediatrician is selected from Refer specialty dropdown");
		elementActions.doClick(vsChkupReferToAnotherReassignButton);
		extentReport.logToExtentReport("Clicked on ReAssign button");
		elementActions.doIsDisplayed(vsChkupReferSpecialityConfirmPopupText);
		extentReport.logToExtentReport("Verified Refer Specialty Confirm popup text is displayed");
		elementActions.doIsDisplayed(vsChkupReferSpecialityConfirmButton);
		extentReport.logToExtentReport("Verified Refer Speciality confirm button is displayed");
		elementActions.doIsDisplayed(vsChkupReferSpecialityCancelButton);
		extentReport.logToExtentReport("Verified Refer Speciality Cancel button is displayed");
		elementActions.doIsDisplayed(vsChkupReferSpecialityCloseButton);
		extentReport.logToExtentReport("Verified Refer Speciality Close button is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verify doctor speciality
	 * success popup is displayed.
	 */
	public void verifyVisiSumReferSpecialtyReassignsuccessPopup() {
		elementActions.doClick(vsChkupReferSpecialityConfirmButton);
		extentReport.logToExtentReport("clicked on Refer Specialty Confirm button");
		elementActions.doIsDisplayed(vsChkupReferSpecialityReassignSuccessPopup);
		extentReport.logToExtentReport("Verified Refer Reassign Success popup is displayed");
	}

	public void verifyVisitSumStartVisitNote() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		elementActions.doIsDisplayed(vsChkupStartVisitNotePatientInteraction);
		extentReport.logToExtentReport("Patient interaction is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteDiagnosis);
		extentReport.logToExtentReport("Diagnosis is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteNote);
		extentReport.logToExtentReport("Note field is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteMedication);
		extentReport.logToExtentReport("Medication field is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteAdvice);
		extentReport.logToExtentReport("Advise field is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteTest);
		extentReport.logToExtentReport("Test field is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteReferralOut);
		extentReport.logToExtentReport("Referral Out section is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteFollowup);
		extentReport.logToExtentReport("Follow up section is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteSharePrescBtn);
		extentReport.logToExtentReport("Share prescription is displayed");
	}

	public void verifyVisitSumPatInteraction() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteConnLabl);
		extentReport.logToExtentReport("Connection label is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteCallIcon);
		extentReport.logToExtentReport("Call icon is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteWhatsappIcon);
		extentReport.logToExtentReport("Whatsapp icon is displayed");
		Thread.sleep(4000);
		elementActions.doIsDisplayed2(vsChkupStartVisitNoteRadBtnYeslabel);
		extentReport.logToExtentReport("Yes Radio button is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteRadBtnNoLabel);
		extentReport.logToExtentReport("No radio button is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteSaveBtn);
		extentReport.logToExtentReport("Save button is displayed");
	}

	public void verifyVisitSumPatInteractionwithoutPhNo() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(3000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteConnLabl);
		extentReport.logToExtentReport("Connection label is displayed");
//		if(elementActions.doIsDisplayed(vsChkupStartVisitNoteConnLablValue))
//		{
//			extentReport.logToExtentReport("Connection label value is displayed");
//		}
//		else
//		{
//			extentReport.logToExtentReport("Connection label value is not displayed");
//		}
		elementActions.doIsDisplayed2(vsChkupStartVisitNoteRadBtnYes);
		extentReport.logToExtentReport("Yes radio button is displayed");
		Thread.sleep(2000);
		elementActions.doIsDisplayed(vsChkupStartVisitNoteRadBtnNoLabel);
		extentReport.logToExtentReport("No radio button is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteSaveBtn);
		extentReport.logToExtentReport("Save button is displayed");
	}

	public void verifyVisitSumPatInteractionCall() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(3000);
		elementActions.doClick(vsChkupStartVisitNoteCallIcon);
		extentReport.logToExtentReport("Clicked on Call icon");
	}

	public void verifyVisitSumPatInteractionWhatsapp() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(3000);
		elementActions.doClick(vsChkupStartVisitNoteWhatsappIcon);
		extentReport.logToExtentReport("Clicked on Whatsapp icon");
	}

	public void verifyVisitSumPatInteractionSavefn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(8000);
		elementActions.doSelect(vsChkupStartVisitNoteInteractionRadBtnYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button");
		/*
		 * elementActions.doClick(vsChkupStartVisitNoteSaveBtn);
		 * extentReport.logToExtentReport("Clicked on Save button");
		 * elementActions.doIsDisplayed(vsChkupStartVisitNoteDelBtn); extentReport.
		 * logToExtentReport("Patient interaction is saved and Delete button is displayed"
		 * );
		 */
	}

	public void verifyVisitSumPatInteractionDelfn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(8000);
		elementActions.doSelect(vsChkupStartVisitNoteInteractionRadBtnYes);
		extentReport.logToExtentReport("Clicked on yes Radio button");
		// elementActions.doClick(vsChkupStartVisitNoteSaveBtn);
		extentReport.logToExtentReport("Clicked on Save button");
		Thread.sleep(3000);

//		elementActions.scrollToElementByText("Spoken with the patient directly?");
		/*
		 * 
		 * extentReport.logToExtentReport("Clicked on Delete button");
		 * Thread.sleep(3000);
		 * elementActions.doIsDisplayed(vsChkupStartVisitNoteRadBtnYeslabel);
		 * extentReport.
		 * logToExtentReport("verified Patient interaction deleted successfully");
		 */
	}

	public void verifyVisitSumDiagnosisdrpdwn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(3000);
		elementActions.doClick(SelectDiagnosisTextField);
		elementActions.doSendKeys(SelectDiagnosisTextField, "fever");
		extentReport.logToExtentReport("Enter text in Diagnosis text field");
		Thread.sleep(5000);
		elementActions.doIsDisplayed(SelectDiagnosislist);
		extentReport.logToExtentReport("Verified Diagnosis list is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Adding the Diagnosis,type
	 * and provisional
	 */
	@Step("Verify Add functionality under Diagnosis section")
	public void VerifyAddFunctionalityUnderDiagnosisSection() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(4000);
//		elementActions.doClick(SelectDiagnosisDownArrow);
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
		elementActions.VerifyText(DiagnosisTypePrimary, TypeColumn);
		extentReport.logToExtentReport("Verified Diagnosis type as primary is displayed");
		elementActions.VerifyText(DiagnosisStatusProvisional, StatusColumn);
		extentReport.logToExtentReport("Verified Diagnosis Status as provisional is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Deleting the saved table
	 * under Diagnosis
	 */
	@Step("Verify delete icon functionality under Diagnosis section")
	public void VerifyDeleteIconFunctionalityUnderDiagnosisSection() throws Throwable {
		this.VerifyAddFunctionalityUnderDiagnosisSection();
		elementActions.doClick(diagnosisDeleteIcon);
		extentReport.logToExtentReport("Clicked on delete icon");
		Thread.sleep(2000);
		boolean DiagnosisNull = elementActions.doIsDisplayed2(DiagnosisColumn);
		boolean TypeNull = elementActions.doIsDisplayed2(DiagnosisColumn);
		boolean StatusNull = elementActions.doIsDisplayed2(StatusColumn);
		if (DiagnosisNull == false && TypeNull == false && StatusNull == false) {
			// System.out.println("Table is deleted");
			extentReport.logToExtentReport("Table is deleted successfully");
		}
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Doctor writing note in
	 * Note text area
	 */
	@Step("Verify doctor is able to enter text")
	public void VerifyDoctorIsAbleToEnterText() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(NoteTextField, prop.getProperty("NoteTextField"));
		extentReport.logToExtentReport("Entered text in Note text field");
		elementActions.doClick(AddNoteButton);
		extentReport.logToExtentReport("Clicked on Add Note button");
		String NoteTextValue = elementActions.doGetText(NoteText);
		if (NoteTextValue.equals(prop.getProperty("NoteTextField"))) {
			// System.out.println("Doctor is able to the add text");
			extentReport.logToExtentReport("Doctor is able to the add text");
		} else {
			extentReport.logToExtentReport("Doctor is not able to add text");
			fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Doctor writing note in
	 * Note text area and saving it
	 */
	@Step("Verify add note functionality")
	public void VerifyAddNoteFunctionality(String NoteValue) throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(NoteTextField, "Hello");
		extentReport.logToExtentReport("Entered text in Note Text field");
		Thread.sleep(2000);
		elementActions.doClick(AddNoteButton);
		extentReport.logToExtentReport("Clicked on Add Note button");
		// elementActions.doIsDisplayed(Buffering);
		// extentReport.logToExtentReport("Verified Buffering is displayed");
		// elementActions.doIsDisplayed(PleaseWaitText);
		// extentReport.logToExtentReport("Verified Please wait text is displayed");
		Thread.sleep(2000);
		String NoteTextValue = elementActions.doGetText(NoteText);
		if (NoteTextValue.equals(NoteValue)) {
			// System.out.println("Doctor is able to the add text");
			extentReport.logToExtentReport("Doctor is able to the add text");
		} else {
			extentReport.logToExtentReport("Doctor is not able to add text");
			fail();
		}
		elementActions.doIsDisplayed(DeleteIcon);
		extentReport.logToExtentReport("Verified Delete button is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Deleting the saved note
	 */
	@Step("Verify delete icon functionality")
	public void VerifyDeleteIconFunctionality() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note Button");
		Thread.sleep(2000);
		elementActions.doSendKeys(NoteTextField, "Testing");
		extentReport.logToExtentReport("Entered text in Note text field");
		Thread.sleep(2000);
		elementActions.doClick(AddNoteButton);
		extentReport.logToExtentReport("Clicked on Add Note button");
		Thread.sleep(2000);
		elementActions.doClick(noteDeleteIcon);
		extentReport.logToExtentReport("Clicked on Delete button");
		Thread.sleep(2000);
		boolean DeleteIconNull = elementActions.doIsDisplayed2(noteDeleteIcon);
		if (DeleteIconNull == false) {
			// System.out.println("The Note is deleted");
			extentReport.logToExtentReport("The Note is deleted successfully");
		} else {
			extentReport.logToExtentReport("The Note is not deleted ");
			fail();
		}

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : User typing drug name
	 * which contains numbers
	 */
	@Step("Verify if user can type in drug name textbox and if numbers or spl characters allowed")
	public void VerifyIfUserCanTypeInDrugNameTextboxAndIfNumbersOrSplCharactersAllowed() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(2000);
		
		elementActions.doActionsSendKeys(DrugNameTextField, prop.getProperty("Drugname"));
		extentReport.logToExtentReport("Verification: Entered Data in Drug Name text field");

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Selected drug is
	 * displayed in the text field
	 */
	@Step("Verify if the selected drug appears if choosed")
	public void VerifyIfTheSelectedDrugAppearsIfChoosed() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit Note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(DrugNameTextField, prop.getProperty("Drugname"));
		extentReport.logToExtentReport("Verification: Entered Drug name is Drugname text field");
		Thread.sleep(9000);
		elementActions.doSelect(DrugNameTextFieldDropdown);
		extentReport.logToExtentReport("Verification: Drug name entered is chosen");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : User is able type the
	 * strength and numbers are allowed
	 */
	@Step("Verify if user can type in strength and if characters or spl characters are allowed")
	public void VerifyIfUserCanTypeInStrengthAndIfCharactersOrSplCharactersAreAllowed() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.doActionsSendKeys(StrengthTextField, prop.getProperty("DrugStrength"));
		extentReport.logToExtentReport("Verification: Spl characters are allowed in Drug Strength text field");

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Selected strength appears
	 * in the text field if selected
	 */
	@Step("Verify if the selected strength appears if selected")
	public void VerifyIfTheSelectedStrengthAppearsIfSelected() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(StrengthTextField, prop.getProperty("DrugStrength"));
		extentReport.logToExtentReport("Entered the strength of Drug in Strength text field");
		Thread.sleep(2000);
		elementActions.doClick(SelectHighlighted);
		extentReport.logToExtentReport("Verification: Selected the highlighted Drug");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : User is able to enter the
	 * number of days
	 */
	@Step("Verify if user can type in No. of days and characters or spl characters in the textbox")
	public void VerifyIfUserCanTypeInNoOfDaysAndCharactersOrSplCharactersInTheTextbox(String NoOfDaysValue)
			throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(5000);
		elementActions.doActionsSendKeys(NoOfDaysTextField, NoOfDaysValue);
		extentReport
				.logToExtentReport("Verification: User is able to enter the data in no of days text field for Drug");
		Thread.sleep(9000);
		elementActions.doClick(NoofdaysDropdownValue);
		extentReport
				.logToExtentReport("Verification: User is able to select the data in no of days text field for Drug");

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Selected days appears in
	 * the text field if selected
	 */
	@Step("Verify if the selected days appears if selected")
	public void VerifyIfTheSelectedDaysAppearsIfSelected(String NoOfDaysValue) throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(NoOfDaysTextField, NoOfDaysValue);
		extentReport.logToExtentReport("Enter the no of days in text field for drug");
		Thread.sleep(2000);
		elementActions.doSelect(SelectHighlighted);
		extentReport.logToExtentReport("Verification: Selected on Highlighted one");

	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : User can type the timings
	 */
	@Step("Verify if user can type in timings dropdown")
	public void VerifyIfUserCanTypeInTimingsDropdown() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.doActionsSendKeys(TimingsTextField, prop.getProperty("DrugTimings"));
		extentReport.logToExtentReport("Verification: User is able to type in the timings dropdown");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Verifying user is able to
	 * enter text in additional instructions text area under medication section
	 */
	@Step("Verify user is able to enter text in additional instructions text area under medication section")
	public void VerifyUserIsAbleToEnterTextInAdditionalInstructionsTextAreaUnderMedicationSection() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(AdditionalInstructionsTextArea, "Drink more water");
		extentReport.logToExtentReport("Verification: Doctor is able to the add additional instruction");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Saving the additional
	 * instructions
	 */
	@Step("Verify save functionality for additional instructions under medication section")
	public void VerifySaveFunctionalityForAdditionalInstructionsUnderMedicationSection() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(AdditionalInstructionsTextArea, "Hello");
		extentReport.logToExtentReport("Entered data in Additional instructions text area");
		Thread.sleep(2000);
		/*
		 * // dont have svae and delete buttons for addiytional instructions
		 * //elementActions.doClick(SaveAdditionalInstructions); //extentReport.
		 * logToExtentReport("Clicked on Save button fro Additional instructions");
		 * //elementActions.doIsDisplayed(Buffering);
		 * //extentReport.logToExtentReport("Buffering is displayed");
		 * //elementActions.doIsDisplayed(PleaseWaitText);
		 * //extentReport.logToExtentReport("Please wait text is displayed"); String
		 * InstructionValue = elementActions.doGetText(AdditionalInstructionText); if
		 * (InstructionValue.contains("Hello")) { //
		 * System.out.println("Entered text is added");
		 * extentReport.logToExtentReport("Entered text is added"); } else {
		 * extentReport.logToExtentReport("Text is not added");
		 * 
		 * } elementActions.doIsDisplayed(DeleteIcon);
		 * extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		 */
	}

	@Step("Verify if multiple instructions can be added under medication section")
	public void VerifyAdditionalInstructionswithMultipleLines(String AdditionalInstructions1,
			String AdditionalInstructions2) throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.doSendKeys(AdditionalInstructionsTextArea, AdditionalInstructions1);
		extentReport.logToExtentReport("Entered data in Additional Instructions Text area");
		Thread.sleep(4000);
		// elementActions.doClick(SaveAdditionalInstructions);
		// extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doTabEnterByRobot(AdditionalInstructionsTextArea);
		Thread.sleep(4000);
		elementActions.doActionsSendKeys(AdditionalInstructionsTextArea, AdditionalInstructions2);
		extentReport.logToExtentReport("Entered text in Additional instructions text area");
		Thread.sleep(4000);
		// elementActions.doClick(SaveAdditionalInstructions);
		// extentReport.logToExtentReport("Clicked on Save button");
		elementActions.doIsDisplayed(AdditionalInstructionText);
		extentReport.logToExtentReport("Additional instructions text is displayed");
		elementActions.doIsDisplayed(DeleteIcon);
		extentReport.logToExtentReport("Delete icon is displayed fro the Additional instructions added");
	}

	@Step("Verify if multiple instructions can be added under medication section")
	public void VerifyAddMultipleAdvice(String AdditionalInstructions1, String AdditionalInstructions2)
			throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(7000);
		elementActions.doSendKeys(AddAdviceTextField, AdditionalInstructions1);
		extentReport.logToExtentReport("Entered data in Add Advice text field");
		Thread.sleep(2000);
		elementActions.doClick(AddAdviceButton);
		extentReport.logToExtentReport("Clicked on Add Advice button");
		Thread.sleep(2000);
		elementActions.doActionsSendKeys(AdditionalInstructionsTextArea, AdditionalInstructions2);
		extentReport.logToExtentReport("Entered data in Add Additional instructions Text Area");
		Thread.sleep(2000);
		// elementActions.doClick(SaveAdditionalInstructions);
		// extentReport.logToExtentReport("Clicked on Save Additional instructions");
		elementActions.doIsDisplayed(AdditionalInstructionText);
		extentReport.logToExtentReport("Additional instructions text is displayed");
	}

	@Step("Verify doctor should be able to select only one option for question: Have you spoken with patient")
	public void VerifyOneOptionSelected() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(10000);
//		elementActions.doClick(vsChkupStartVisitNotePatientInteraction);
//		extentReport.logToExtentReport("Clicked on Patient interaction");
//		Thread.sleep(2000);
		elementActions.doSelect(vsChkupStartVisitNoteInteractionRadBtnYes);
		extentReport.logToExtentReport("Clicked on Yes radio button");
		Thread.sleep(5000);
		elementActions.doIsNotSelected(vsChkupStartVisitNoteRadBtnNoLabel);
		extentReport.logToExtentReport("Verified No Radio button is not selected");
	}

	@Step("Verify diagnosis type, Primary or Secondary under Diagnosis section")
	public void VerifyOneDiagnosisOptionSelected(String diagnosis) throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(5000);
//		elementActions.scrollToElementByText("Provisional");
		elementActions.doSelect(vsChkupStartVisitNoteSelectDiagnosisTextboxArrow);
		Thread.sleep(3000);
		elementActions.doSendKeys(vsChkupStartVisitNoteSelectDiagnosisTextbox, diagnosis);
		extentReport.logToExtentReport("Entered text in Select Diagnosis text box");
		Thread.sleep(2000);
		String diagnosisSelectedValue = elementActions.doGetText(vsChkupStartVisitNoteSelectDiagnosisFirstValue);
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteSelectDiagnosisFirstValue);
		extentReport.logToExtentReport("Select diagnosis value");
		String diagnosisSelected = elementActions.doGetText(DiagnosisSelected);
		Thread.sleep(2000);

		extentReport.logToExtentReport("Verified diagnosis selected");
	}

	@Step("Verify status, Provisional or Confirmed under Diagnosis section")
	public void VerifyOneDiagnosisStatus(String diagnosis) throws Throwable {

		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(2000);
		elementActions.scrollToElementByText("Provisional");
//		elementActions.doSelect(vsChkupStartVisitNoteSelectDiagnosisTextboxArrow);
		elementActions.doSendKeys(vsChkupStartVisitNoteSelectDiagnosisTextbox, diagnosis);
		extentReport.logToExtentReport("Entered Data in Diagnosis text box");
		Thread.sleep(2000);
		String diagnosisSelectedValue = elementActions.doGetText(vsChkupStartVisitNoteSelectDiagnosisFirstValue);
		elementActions.doClick(vsChkupStartVisitNoteSelectDiagnosisFirstValue);
		extentReport.logToExtentReport("Selected first Diagnosis dropdown value");
		String diagnosisSelected = elementActions.doGetText(DiagnosisSelected);
		extentReport.logToExtentReport("Verified the diagnosis selected");
		elementActions.doSelect(DiagnosisTypePrimary);
		extentReport.logToExtentReport("Clicked on Diagnosis type as Primary");
		elementActions.doSelect(DiagnosisStatusProvisional);
		extentReport.logToExtentReport("Clicked on Diagnosis Status as Provisional");
		elementActions.doIsEnabled(AddDiagnosis);
		extentReport.logToExtentReport("Verified Add Diagnosis button is enabled");
		elementActions.doIsNotSelected(DiagnosisStatusConfirmed);
		extentReport.logToExtentReport("Verified Diagnosis status Confirmed is not selected");
	}

	@Step("Verify Save button functionality in followup section")
	public void VerifyFollowupSaveBtn() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(StartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit Note button");
		Thread.sleep(2000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Follow Up Option as YES");
		elementActions.doClick(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow Up Calendar");
		elementActions.doClick(FollowupDatePick);
		extentReport.logToExtentReport("Clicked on Date Pick");
		elementActions.doClick(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Time pick");
		elementActions.doClick(FollowupTimePick);
		extentReport.logToExtentReport("Clicked on Time pick");
		elementActions.doClick(FollowupSaveButton);
		extentReport.logToExtentReport("Clicked on Save Button");
		elementActions.doIsDisplayed(FollowupDelButton);
		extentReport.logToExtentReport("Verified Delete button is displayed");
	}

	@Step("Click on close")
	public void clickOnClose() {
		if (elementActions.doIsDisplayed(icnClose)) {
			elementActions.doClick(icnClose);
			extentReport.logToExtentReport("Clicked on Close icon");
		} else {
			extentReport.logToExtentReport("Close Icon is not displayed");
			fail();
		}
	}

	@Step("Click on Stat visit note button for an awaiting patient")
	public void strtVstforAwaitPatient() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(2000);
		elementActions.doClick(btnStartVisitNote);
	}

	@Step("Click on close")
	public void addTimingsMedication() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(4000);
		elementActions.doClick(btnStartVisitNote);

	}

	@Step("Click on close")
	public void addMultipleMedications(Boolean medications) throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(4000);
		elementActions.doClick(btnStartVisitNote);
		if (medications == true && medications != null) {
//write the code related to the medications if the medications toggle is turned on from the admin panel			
			System.out.println();
			elementActions.doSendKeys(DrugNameTextField, "Paracetomol");
			elementActions.doSendKeys(inpDosage, "7.5 ml");
			elementActions.doClick(inpFrequency);
			elementActions.doClick(inpFrequencyValue);
			elementActions.doSendKeys(inpDurationNumber, "10");
			elementActions.doClick(inpDurationUnits);
			elementActions.doClick(inpDurationUnitsValue);
			elementActions.doSendKeys(inpAdditionalInstructions, "Drink more waters");
			elementActions.doSendKeys(remarksTextField, "Suffering from Fever");
			elementActions.doClick(drugSaveButton);
			
		} else {
			Thread.sleep(7000);
			elementActions.doSendKeys(DrugNameTextField, "Paracetomol");
			Thread.sleep(2000);
			elementActions.doSendKeys(StrengthTextField, "75 MG");
			elementActions.doClick(SelectHighlighted);
			Thread.sleep(2000);
			elementActions.doSendKeys(NoOfDaysTextField, "5");
			elementActions.doClick(SelectHighlighted);
			Thread.sleep(2000);
			elementActions.doClick(TimingsTextField);
			Thread.sleep(2000);
			elementActions.doClick(drugTimingValue);
			Thread.sleep(2000);
			elementActions.doSendKeys(remarksTextField, "Suffering from Fever");
			elementActions.doClick(drugSaveButton);
			Thread.sleep(2000);
			elementActions.doSendKeys(DrugNameTextField, "Dolo 650");
			Thread.sleep(2000);
			elementActions.doSendKeys(StrengthTextField, "75 MG");
			elementActions.doClick(SelectHighlighted);
			Thread.sleep(2000);
			elementActions.doSendKeys(NoOfDaysTextField, "5");
			elementActions.doClick(SelectHighlighted);
			Thread.sleep(2000);
			elementActions.doClick(TimingsTextField);
			Thread.sleep(2000);
			elementActions.doClick(drugTimingValue);
			Thread.sleep(2000);
			elementActions.doSendKeys(remarksTextField, "Suffering from Fever");
			elementActions.doClick(drugSaveButton);
		}
	}

	public void addMultipleMedications() throws InterruptedException {
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(4000);
		elementActions.doClick(btnStartVisitNote);
		Thread.sleep(7000);
		elementActions.doSendKeys(DrugNameTextField, "Paracetomol");
		Thread.sleep(2000);
		elementActions.doSendKeys(StrengthTextField, "75 MG");
		elementActions.doClick(SelectHighlighted);
		Thread.sleep(2000);
		elementActions.doSendKeys(NoOfDaysTextField, "5");
		elementActions.doClick(SelectHighlighted);
		Thread.sleep(2000);
		elementActions.doClick(TimingsTextField);
		Thread.sleep(2000);
		elementActions.doClick(drugTimingValue);
		Thread.sleep(2000);
		elementActions.doSendKeys(remarksTextField, "Suffering from Fever");
		elementActions.doClick(drugSaveButton);
		Thread.sleep(2000);
		elementActions.doSendKeys(DrugNameTextField, "Dolo 650");
		Thread.sleep(2000);
		elementActions.doSendKeys(StrengthTextField, "75 MG");
		elementActions.doClick(SelectHighlighted);
		Thread.sleep(2000);
		elementActions.doSendKeys(NoOfDaysTextField, "5");
		elementActions.doClick(SelectHighlighted);
		Thread.sleep(2000);
		elementActions.doClick(TimingsTextField);
		Thread.sleep(2000);
		elementActions.doClick(drugTimingValue);
		Thread.sleep(2000);
		elementActions.doSendKeys(remarksTextField, "Suffering from Fever");
		elementActions.doClick(drugSaveButton);
	}

	@Step("Click on close")
	public void verifyDeleteIcon() throws InterruptedException {
		elementActions.doIsDisplayed(DeleteIconMedications);
		Thread.sleep(2000);
	}

	@Step("Click on patient name")
	public void clickOnPatientName() {
		elementActions.waitForElementToBeClickable(this.driver, elementActions.getElement(lblPatientName1));
		elementActions.doClick(lblPatientName1);
		extentReport.logToExtentReport("Clicked on Patient label name");
	}

	@Step("Click on start visit note button")
	public void clickOnStartVisitNote() {
		elementActions.waitForElementToBeClickable(this.driver, elementActions.getElement(btnStartVisitNote));
		elementActions.doClick(btnStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit Note button");
	}

	@Step("Get text of test")
	public String getTextOfTest() {
		return elementActions.doGetText(lblTest);
	}

	@Step("Set test name")
	public void setTestName(String testName) {
		elementActions.doClick(txtTestName);
		extentReport.logToExtentReport("Clicked on Test name Text");
		elementActions.doActionsSendKeys(txtTestName, testName);
		extentReport.logToExtentReport("Entered data in Text name test");
		elementActions.doActionsClick(drpTestNames);
	}

	@Step("Isdisplayed tests list")
	public boolean isDisplayedTestsList(String name) {
		for (int i = 0; i < elementActions.getElements(drpTestNames).size(); i++) {
			if (!elementActions.getElements(drpTestNames).get(i).getText().contains(name.toUpperCase())) {
				return false;
			}
		}
		return true;
	}

	@Step("Click on test name")
	public void clickOnTestName(String name) {
		// elementActions.doClick(btnTest);
		/*
		 * for (int i = 0; i < elementActions.getElements(drpTestNames).size(); i++) {
		 * //
		 * System.out.println(elementActions.getElements(drpTestNames).get(i).getText())
		 * ; if
		 * (elementActions.getElements(drpTestNames).get(i).getText().equalsIgnoreCase(
		 * name)) { elementActions.getElements(drpTestNames).get(i).click(); break; } }
		 */
		elementActions.doActionsClick(txtTestNameVal1);
	}

	@Step("Isdisplayed delete icon")
	public boolean isDisplayedDeleteIcon() {
		return elementActions.doIsDisplayed(iconDelete);

	}

	@Step("Get advice text")
	public String getAdviceText() throws InterruptedException {
		Thread.sleep(7000);
		return elementActions.doGetText(lblAdvice);
	}

	@Step("Set advice")
	public void setAdvice(String advice) {
		elementActions.doClick(txtAdvice);
		extentReport.logToExtentReport("Clicked on Text Advice");
		elementActions.doActionsSendKeys(txtAdvice, advice);
		extentReport.logToExtentReport("entered data in text advice");
	}

	@Step("Isdisplayed advice list")
	public boolean isDisplayedAdviceList(String name) {
		for (int i = 0; i < elementActions.getElements(drpAdvice).size(); i++) {
			if (!elementActions.getElements(drpAdvice).get(i).getText().contains(name.toUpperCase())) {
				return false;
			}
		}
		return true;
	}

	@Step("Click on advice name")
	public void clickOnAdvice(String name) {
		// elementActions.doClick(btnTest);
		for (int i = 0; i < elementActions.getElements(drpAdvice).size(); i++) {
			// System.out.println(elementActions.getElements(drpAdvice).get(i).getText());
			if (elementActions.getElements(drpAdvice).get(i).getText().equalsIgnoreCase(name)) {
				elementActions.getElements(drpAdvice).get(i).click();
				break;
			}
		}
	}

	@Step("Click on buttons")
	public void clickOnButtons(String buttonName) {
		System.out.println(button.replace("${button}", buttonName));

		elementActions.doActionsClick(By.xpath(button.replace("${button}", buttonName)));
		// driver.findElement(By.xpath(button.replace("${button}",
		// buttonName))).click();
	}

	@Step("Get additional instructions text")
	public String getAdditionalInstructionsText() {
		return elementActions.doGetText(lblAdditonalInstruction);
	}

	@Step("Set additional instructions")
	public void setAdditionalInstructions(String additionalInstructions) {
		elementActions.doClick(txtAdditonalInstruction);
		extentReport.logToExtentReport("Clicked on Additional instructions text");
		elementActions.doActionsSendKeys(txtAdditonalInstruction, additionalInstructions);
		extentReport.logToExtentReport("Entered data in Additional instructions text field");
	}

	@Step("IsEnabled button")
	public boolean isEnabledButton(String buttonName) {
		try {
			return driver.findElement(By.xpath(button.replace("${button}", buttonName))).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Isdisplayed delete AI icon")
	public boolean isDisplayedDeleteAIIcon() {
		try {
			return elementActions.doIsDisplayed(iconDeleteAI);
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Click on AI Delete Icon")
	public void clickOnAIDeleteIcon() {
		elementActions.doClick(iconDeleteAI);
		extentReport.logToExtentReport("Clicked on Delete AI icon");
	}

	@Step("Get text of test")
	public String getTextOfSelectedTest() {
		System.out.println(elementActions.doGetText(lblselectedText));
		return elementActions.doGetText(lblselectedText);

	}

	@Step("Get text of Advice")
	public String getTextOfSelectedAdvice() {
		return elementActions.doGetText(lblselectedAdviceText);
	}

	@Step("Clicked On patient")
	public void ClickedOnPatient() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(lblPatientName1);
		extentReport.logToExtentReport("Clicked on Patient name label");
	}

	@Step("Clicked On StartVisit")
	public void Clickonstartvisit() {
		elementActions.doClick(btnStartVisitNote);
		extentReport.logToExtentReport("Clicked on Start visit note button");
	}

	@Step("Add the text in advice")
	public void ClickonAddAdvice() {
		elementActions.doClick(btnAddAdvice);
		extentReport.logToExtentReport("Clicked on Add Advice button");
	}

	@Step("Add the text in Test Field")
	public void Addadvice() throws InterruptedException {
		Thread.sleep(4000);
		elementActions.doSendKeys(addAdvice, "Drink Water");
		extentReport.logToExtentReport("Enter ddata in add advice text field");
	}

	@Step("Click on delete button")
	public void ClickOnDeleetButton() throws InterruptedException {
		Thread.sleep(3000);
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		Thread.sleep(3000);
		elementActions.doClick(StartVisitNote);
		Thread.sleep(5000);
		elementActions.doSendKeys(AddAdviceTextField, "Testing");
		Thread.sleep(6000);
		elementActions.doClick(AddAdviceButton);
		Thread.sleep(4000);
		elementActions.doClick(DeleteIconAdvice);
		extentReport.logToExtentReport("Clicked on delete button");
	}

	@Step("Click on Expand Test")
	public void ClickOnExpandTest() {
		elementActions.doClick(btnTest);
		extentReport.logToExtentReport("Clicked on ATest button");
	}

	@Step("Click on Add details in Test")
	public void ClickOnAddTest(String water) {
		elementActions.doSendKeys(addtext, "Test 1");
		extentReport.logToExtentReport("Entered text as Test1");
	}

	@Step("Click on Submit Test ")
	public void ClickOnSubmitTest() {
		elementActions.doClick(btnClickAddTest);
		extentReport.logToExtentReport("Clicked on Add test button");
	}

	@Step("Verify delete icon functionality in followup section ")
	public void verifyDelFunctnFollowUpsection() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
//		elementActions.doClick(vsChkupStartVisitNoteFollowup);
//		extentReport.logToExtentReport("Clicked on Follow up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
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
		Thread.sleep(4000);
		elementActions.doClick(FollowupDelButton);
		extentReport.logToExtentReport("Clicked on Delete button");
		elementActions.doIsDisplayed(FollowupLabel);
		extentReport.logToExtentReport("Follow up is deleted successfully");
	}

	@Step("Verify delete icon functionality in followup section ")
	public void verifyFollowUpsectionRadYesNO() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(4000);
//		elementActions.doClick(vsChkupStartVisitNoteFollowup);
//		extentReport.logToExtentReport("Clicked on Follow up");
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes rad btn in Follow up section");
		elementActions.doIsNotSelected(FollowupOptionNo);
		extentReport.logToExtentReport("Verified No radio button in follow up section is not seleted");
	}

	@Step("Verify delete icon functionality in followup section ")
	public void verifyFollowUpsectionRadYes() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(6000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
//		elementActions.doClick(vsChkupStartVisitNoteFollowup);
//		extentReport.logToExtentReport("Clicked on Follow up section");
		Thread.sleep(6000);
		elementActions.scrollToElementByText("Follow-up");
		Thread.sleep(4000);
		elementActions.doSelect(FollowupOptionYes);
		extentReport.logToExtentReport("Clicked on Yes Radio button in follow up section");
		elementActions.doIsDisplayed(FollowupCalendar);
		extentReport.logToExtentReport("Clicked on Follow up Calendar");
		elementActions.doIsDisplayed(FollowupTimeClick);
		extentReport.logToExtentReport("Clicked on Follow up Time");
		elementActions.doIsDisplayed(FollowupSaveButton);
		extentReport.logToExtentReport("Verified Save button is displayed");
	}

	@Step("Verify share prescription button functionality in followup section ")
	public void verifySharePrescriptionBtn() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(4000);
		elementActions.doClick(vsChkupStartVisitNoteSharePrescBtn);
		extentReport.logToExtentReport("Clicked on Share prescription button");
		elementActions.doIsDisplayed(SharePrescptnText);
		extentReport.logToExtentReport("Verified Share prescription popup text is displayed");
		elementActions.doIsDisplayed(vsChkupReferSpecialityConfirmButton);
		extentReport.logToExtentReport("Verified Confirm button is displayed");
		elementActions.doIsDisplayed(vsChkupReferSpecialityCancelButton);
		extentReport.logToExtentReport("Verified Cancel button is displayed");
	}

	@Step("Verify Confirm functionality under share prescription")
	public void verifyConfBtnSharePrescription() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(4000);
		this.VerifyAddDiagnosisAndFollowupFunctionality("diagnosis");
		elementActions.doClick(vsChkupStartVisitNoteSharePrescBtn);
		extentReport.logToExtentReport("Clicked on Share prescription button");
		elementActions.doClick(SharePrescptnConfirmButton);
		extentReport.logToExtentReport("Clicked on Confirm Button");
		elementActions.doIsDisplayed(SharePrescptnSuccessText);
		extentReport.logToExtentReport("Verified Share prescription text is displayed on popup");
		elementActions.doIsDisplayed(SharePrescptnSuccessPopupViewPrescBtn);
		extentReport.logToExtentReport("Verified View prescription button is displayed");
		elementActions.doIsDisplayed(SharePrescptnConfirmButton);
		extentReport.logToExtentReport("Verified Go To Dashboard button is displayed");
	}

	@Step("Verify View prescription functionality")
	public void verifyViewPrescptnSharePrescription() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(4000);
		this.VerifyAddDiagnosisAndFollowupFunctionality(String);
		elementActions.doClick(vsChkupStartVisitNoteSharePrescBtn);
		extentReport.logToExtentReport("Clicked on Share prescription button");
		Thread.sleep(4000);
		elementActions.doClick(SharePrescptnConfirmButton);
		extentReport.logToExtentReport("Clicked on Confirm button");
		Thread.sleep(4000);
		elementActions.doClick(SharePrescptnSuccessPopupViewPrescBtn);
		extentReport.logToExtentReport("Clicked on View prescription button");
		Thread.sleep(4000);
		elementActions.doIsDisplayed(PescPopupDownloadBtn);
		extentReport.logToExtentReport("Verified Download button in Prescription popup is displayed");
		elementActions.doIsDisplayed(ConstDetViewPrescptn);
		extentReport.logToExtentReport("Verified View prescription is displayed");
	}

	@Step("Verify Update prescription functionality")
	public void verifyUpdatePrescptnFnctnlty() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(vsCloseButton);
		extentReport.logToExtentReport("Clicked on Close Button");
		Thread.sleep(3000);
		elementActions.doClick(vsChkupStartVisitNoteUpdatePrescBtn);
		extentReport.logToExtentReport("Clicked on Update Prescription Button");
		elementActions.doIsDisplayed(SharePrescptnText);
		extentReport.logToExtentReport(
				"Verified: Update Prescription button is clicked and Share Prescription popup is displayed");
	}

	@Step("Verify buttons are changed once prescription is shared to a patient on visit summary page")
	public void verifyUpdateViewPrescptnBtninVisitSumPage() throws Throwable {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start visit note button");
		Thread.sleep(4000);
		this.VerifyAddDiagnosisAndFollowupFunctionality("diagnosis");
		elementActions.doClick(vsChkupStartVisitNoteSharePrescBtn);
		extentReport.logToExtentReport("Clicked on Share prescription button");
		elementActions.doClick(SharePrescptnConfirmButton);
		extentReport.logToExtentReport("Clicked on Confirm button");
		Thread.sleep(4000);
		elementActions.doClick(vsCloseButton);
		extentReport.logToExtentReport("Clicked on Close button");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteUpdatePrescBtn);
		extentReport.logToExtentReport("Verified Update Prescription button is displayed");
		elementActions.doIsDisplayed(vsChkupStartVisitNoteViewPrescBtn);
		extentReport.logToExtentReport("Verified View Prescription button is displayed");
	}

	@Step("Verify delete icon functionality")
	public void verifyDelFnctninVisitSumPage(String Testdata) throws InterruptedException {
		Thread.sleep(3000);
		elementActions.doClick(awtvstPatient1Name);
		extentReport.logToExtentReport("Clicked on Awaiting visit Patient");
		Thread.sleep(5000);
		elementActions.scrollToElementByText("Refer to Specialist");
		Thread.sleep(2000);
		elementActions.doClick(vsChkupStartVisitNoteButton);
		extentReport.logToExtentReport("Clicked on Start Visit Note button");
		Thread.sleep(4000);
		elementActions.doSendKeys(txtTestName, Testdata);
		extentReport.logToExtentReport("Entered data in texttestname");
		Thread.sleep(4000);
		elementActions.doClick(txtTestNameVal1);
		extentReport.logToExtentReport("Select the first value Testname field");
		Thread.sleep(2000);
		elementActions.doClick(btnAddTest);
		extentReport.logToExtentReport("Clicked on Add test button");
		elementActions.doClick(iconDelete);
		extentReport.logToExtentReport("Clicked on Delete icon");
		elementActions.doIsNotDisplayed(textTest);
		extentReport.logToExtentReport("Verified text in Test field is displayed");
	}

	@Step("getting the page title")
	public String getPageTitle() {
		extentReport.logToExtentReport("get the page title");
		return elementActions.doGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}

	@Step("Click on Search icon")
	public DashboardPage clickOnSearchicon() {
		elementActions.doClick(searchIcon);
		extentReport.logToExtentReport("Click on Search icon");
		return new DashboardPage(driver);
	}

	@Step("Get patient name")
	public String getPatientName() {
		try {

			return elementActions.doGetText(patientName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Step("Click on Dashboard")
	public void clickOnDashboard() {
		extentReport.logToExtentReport("Click on Dashboard");
		elementActions.doClick(lblDashBoard);
	}

	@Step("Get patient names list")
	public boolean getListOfPatients(String name) {
		extentReport.logToExtentReport("Get patient names list");
		return elementActions.getTextFromElements(lstPatients, name);
	}

	@Step("Get close text")
	public String getCloseText() {
		extentReport.logToExtentReport("Get close text");
		return elementActions.doGetText(btnClose);
	}

	@Step("Get view text")
	public boolean getViewText(String view) {
		extentReport.logToExtentReport("Get view text");
		return elementActions.checkAllElementsWithText(btnView, view);
	}

	@Step("Click on close button")
	public void clickOnCloseButton() {
		elementActions.doClick(btnClose);
		extentReport.logToExtentReport("Click on close button");
	}

	@Step("Click on close button")
	public boolean getPatientNae(String name) {
		extentReport.logToExtentReport("Click on close button");
		return elementActions.getTextFromElements(patientName, name);
	}

	@Step("Is Displayed Patient Name In Appointments Section")
	public boolean isDisplayedPatientName() {
		try {
			extentReport.logToExtentReport("Patient Name In Appointments Section is displayed");
			return elementActions.doIsDisplayed(lblPatientNameInAppointmentsSection);
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Click on patient name in appointments section")
	public void clickOnPatientNameInAppointmentsSection() {
		elementActions.doClick(lblPatientNameInAppointmentsSection);
		extentReport.logToExtentReport("Click on patient name in appointments section");
	}

	@Step("Is displayed patient view popup")
	public boolean isDisplayedPatientViewPopup() {

		try {
			Thread.sleep(5000);
			extentReport.logToExtentReport("patient view popup is displayed");
			return elementActions.doIsDisplayed(patientViewPopup);
		} catch (Exception e) {
			return false;
		}
	}

	@Step("Enter patient name in search field")
	public DashboardPage setPatientNameInSearch(String searchName) throws InterruptedException {
		Thread.sleep(2000);
		elementActions.waitForElementVisible(searchField);
		extentReport.logToExtentReport("wait for search field visible");
		elementActions.doClick(searchField);
		extentReport.logToExtentReport("click on search field");
		elementActions.doActionsSendKeys(searchField, searchName);
		extentReport.logToExtentReport("Enter name in search filed");
		return new DashboardPage(driver);
	}

	@Step("Get view text")
	public String getViewText() {
		extentReport.logToExtentReport("Get view text");
		return elementActions.doGetText(btnView);
	}

	@Step("get patient name text")
	public String getPatientNameText() {
		extentReport.logToExtentReport("get patient name text");
		return elementActions.doGetText(lblPatientName1);
	}

	@Step("get Patient OpenMRSID text")
	public String getPatientOpenMRSIDText() {
		extentReport.logToExtentReport("get Patient OpenMRSID text");
		return elementActions.doGetText(lblOpenMRSID).split("[(]")[0];
	}

	@Step("Click on patient name in awaiting visits section")
	public void clickOnPatientNameInAwaitingVisitsSection() {
		elementActions.doClick(lblPatientNameInAwaitingVisitsSection);
		extentReport.logToExtentReport("Click on patient name in awaiting visits section");
	}

	@Step("Click on patient name in awaiting visits section")
	public void clickOnPatientName(String section) {
		elementActions.doClick(By.xpath(lblFirstPatientNameUnderSections.replace("{$patientName}", section)));
		extentReport.logToExtentReport("Click on patient name in awaiting visits section");
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