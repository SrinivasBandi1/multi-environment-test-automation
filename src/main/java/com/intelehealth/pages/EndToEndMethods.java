package com.intelehealth.pages;

import io.qameta.allure.Step;

import static org.testng.Assert.fail;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

public class EndToEndMethods extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	AwaitPriortyInProgress	awaitPriortyInProgress;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By vstsumpatientVideoCallEndButton = By.cssSelector("[data-test-id='btnEnd']");
	By vstsumpatientVideoWindowPatientname = By.xpath("//span[text()='Patient']/..");
	By vstsumpatientVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By vstsumpatientStartCallButton = By.xpath("//a[@data-test-id='linkPhoneNumber']");
	By vsStartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By vsSharePrescription = By.xpath("//button[@data-test-id='btnSharePrescription']");
	By vsSharePrescriptionSubmitButton = By.xpath("//button[@data-test-id='btnSubmit']");
	By vsSharePrescPopupConfText = By.xpath("//p[text()='Are you sure you want to share this prescription?']");
	By vsViewPrescrptnBtn = By.xpath("//button[@data-test-id='btnView']");
	By vsGoToDashboardBtn = By.xpath("//button[@data-test-id='btnSubmit']");
	By vsCloseBtnPopup = By.xpath("//button[@data-test-id='btnClose']");
	By vsUpdatePrescriptionBtn = By
			.xpath("//button[@data-test-id='btnSharePrescription'][text()=' Update prescription ']");
	By vsViewPrescriptionBtn = By.xpath("//button[@data-test-id='btnViewPrescription']");
	By vsViewPrescriptionPopup = By.xpath(("//h6[text()='  Prescription ']"));
	By vsPrescriptionDrugTextBox = By.xpath("//input[@data-test-id='etDrugName']");
	By vsPrescriptionDrugStrengthTextBox = By.xpath("//input[@data-test-id='etDrugStrength']");
	By vsPrescriptionDrugNoOfDaysTextBox = By.xpath("//input[@data-test-id='etDays']");
	By vsPrescriptionDrugTimingDrpdown = By.xpath("//ng-select[@data-test-id='selectTiming']");
	By vsPrescriptionDrugRemarks = By.xpath("//input[@data-test-id='etRemarkMed']");
	By vsPrescriptionDrugTimingDrpdownval = By.xpath("//span[text()='1 - 0 - 0']");
	By vsPrescriptionDrugAddButton = By.xpath("//button[@data-test-id='btnSubmitMed']");
	By vsSharedPrescriptionCloseButton = By.xpath("//button[@data-test-id=\"btnClose\"]");
	By StartVisitNote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By SelectDiagnosisTextField = By.xpath("//ng-select[@data-test-id='selectDiagnosisName']");
	By DropdownFirstOption = By.xpath("(//span[@class=\"ng-option-label ng-star-inserted\"])[1]");
	By DiagnosisTypePrimary = By.xpath("//input[@data-test-id='radioDiagnosisTypePrimary']");
	By DiagnosisStatusProvisional = By.xpath("//input[@data-test-id='radioDiagnosisStatusProvisional']");
	By AddDiagnosis = By.xpath("//button[@data-test-id=\"btnSubmitDiagnosis\"]");
	By DiagnosisColumn = By.xpath("//td[text()='Fever of unknown origin']");
	By TypeColumn = By.xpath("//td[text()='Primary']");
	By StatusColumn = By.xpath("//td[text()='Provisional']");
	By DeleteIcon = By.xpath("//img[@src=\"assets/svgs/delete-icon.svg\"]");
	By NoteTextField = By.xpath("//textarea[@data-test-id=\"etNote\"]");
	By AddNoteButton = By.xpath("//button[@data-test-id=\"btnSubmitNote\"]");
	By Buffering = By.xpath("//div[@class=\"sk-ball-spin-clockwise\"]");
	By PleaseWaitText = By.xpath("//span[text()='Please Wait...']");
	By DrugNameTextField = By.xpath("//input[@data-test-id=\"etDrugName\"]");
	By StrengthTextField = By.xpath("//input[@data-test-id=\"etDrugStrength\"]");
	By NoteText = By.xpath("//div[@class=\"d-flex justify-content-between align-items-center\"]");
	By SelectHighlighted = By.xpath("//span[@class=\"ngb-highlight ng-star-inserted\"]");
	By NoOfDaysTextField = By.xpath("//input[@data-test-id=\"etDays\"]");
	By TimingsTextField = By.xpath("//ng-select[@data-test-id=\"selectTiming\"]");
	By AdditionalInstructionsTextArea = By.xpath("//textarea[@data-test-id=\"etAI\"]");
	By SaveAdditionalInstructions = By.xpath("//button[@data-test-id=\"btnSubmitAI\"]");
	By AdditionalInstructionText = By.xpath("//div[@class=\"d-flex justify-content-between\"]");
	By AddAdviceTextField = By.xpath("//input[@data-test-id='etAdvice']");
	By AddAdviceButton = By.xpath("//button[@data-test-id='btnSubmitAdvice']");

	// Constructor of page class:
	public EndToEndMethods(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

		awaitPriortyInProgress = new AwaitPriortyInProgress(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method is to click
	 * on Start call buttom for the patient with registered ph no.
	 */
	@Step("click on Start Call option of VisitSummary Page")
	public void verifyStartCallOption() throws InterruptedException {
		Thread.sleep(4000);
		elementActions.doClick(vstsumpatientStartCallButton);
		extentReport.logToExtentReport("Clicked on call button from Visit summary page");
		String mainId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		boolean isOtherWindowOpened = false;
		for (String id : allIds) {
			if (!mainId.equals(id)) {
				extentReport.logToExtentReport("Other window is opened after clicking on the call icon");
				isOtherWindowOpened = true;
				break;
			}
		}
		if (!isOtherWindowOpened) {
			extentReport.logToExtentReport("Other window is not opened after clicking on the call icon");
			fail();
		}

	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description : This method verifies if
	 * the doctor is able to do a video call for the patient
	 */
	@Step("Verify the video call from video option of VisitSummary Page")
	public void verifyvideoCall() throws InterruptedException {
		Thread.sleep(3000);
		elementActions.waitForElementVisible(vstsumpatientVideoIcon);
		extentReport.logToExtentReport("Clicked on Video icon from Visit summary page");
		elementActions.doIsDisplayed(vstsumpatientVideoCallEndButton);
		extentReport.logToExtentReport("Video window is displayed");
		elementActions.doIsDisplayed(vstsumpatientVideoWindowPatientname);
		extentReport.logToExtentReport("Patient name is displayed in Video Window");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the video call from video option of VisitSummary Page")

	public void verifyvstsumPrescription() throws Throwable {
		try {
			if (elementActions.doIsDisplayed2(vsStartVisitNote)) {
				elementActions.waitForElementClickable(vsStartVisitNote);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	//	endToEndMethods.VerifyAddFunctionalityUnderDiagnosisSection();
		awaitPriortyInProgress.VerifyAddDiagnosisAndFollowupFunctionality("fever");
	//	elementActions.doSelect(FollowUpNoRadioButton);
		elementActions.doIsDisplayed(vsSharePrescription);
		extentReport.logToExtentReport("Share Prescription button is displayed");
		elementActions.waitForElementClickable(vsSharePrescription);
		extentReport.logToExtentReport("Clicked on Share Prescription button");
		elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Submit button is displayed from Share Prescription popup");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		//elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Submit button from Share Prescription popup");
		elementActions.doIsDisplayed(vsGoToDashboardBtn);
		extentReport.logToExtentReport("Go to Dashboard button is displayed");
		Thread.sleep(4000);
		elementActions.waitForElementClickable(vsCloseBtnPopup);
		extentReport.logToExtentReport("Close button is displayed");
		elementActions.doIsDisplayed(vsUpdatePrescriptionBtn);
		extentReport.logToExtentReport("Update Prescription button is displayed");
		elementActions.doIsDisplayed(vsViewPrescriptionBtn);
		extentReport.logToExtentReport("View Prescription button is displayed");
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify doing any changes in any of the section in visit summary page")
	public void verifyvsprescrptionChanges() {
		try {
			elementActions.doClick(vsStartVisitNote);
			extentReport.logToExtentReport("Clicked on Start Visit Note");
		} catch (Exception e) {
			// TODO: handle exception
		}
		elementActions.doSendKeys(vsPrescriptionDrugTextBox, "Dolo");
		extentReport.logToExtentReport("Type Medicine DOLO in Prescription drug textbox");
		elementActions.doSendKeys(vsPrescriptionDrugStrengthTextBox, "500MG");
		extentReport.logToExtentReport("Type Drug Strength as 500MG in drug strength textbox");
		elementActions.doSendKeys(vsPrescriptionDrugNoOfDaysTextBox, "8");
		extentReport.logToExtentReport("Type 8 as No of days textbox ");
		elementActions.doClick(vsPrescriptionDrugTimingDrpdown);
		extentReport.logToExtentReport("Clicked on Drug time drop down");
		elementActions.doClick(vsPrescriptionDrugTimingDrpdownval);
		extentReport.logToExtentReport("Selected the value from Drug time dropdown");
		elementActions.doSendKeys(vsPrescriptionDrugRemarks, "Test");
		extentReport.logToExtentReport("Type in Drug Remarks");
		elementActions.doClick(vsPrescriptionDrugAddButton);
		extentReport.logToExtentReport("Clicked on Add button");
		try {
			elementActions.doClick(vsUpdatePrescriptionBtn);
			extentReport.logToExtentReport("Clicked on Update Prescription button");
			elementActions.doIsDisplayed(vsSharePrescriptionSubmitButton);
			extentReport.logToExtentReport("Share prescription is displayed");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * Author: Rajesh HS Created: 26/09/2023 Description :
	 */
	@Step("Verify the functionality of share prescription button in visit summary page")
	public void verifyvsprescrptionChangesSharePrescButton() throws InterruptedException {
		verifyvsprescrptionChanges();
		try {
			elementActions.waitForElementClickable(vsSharePrescription);
			extentReport.logToExtentReport("Clicked on Share prescription button");
		} catch (Exception e) {
			// TODO: handle exception
		}
		elementActions.doIsDisplayed(vsSharePrescPopupConfText);
		extentReport.logToExtentReport("Share prescription Confirmation text is displayed");
		elementActions.doClick(vsSharePrescriptionSubmitButton);
		extentReport.logToExtentReport("Clicked on Share prescription Submit button");
		Thread.sleep(3000);
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
		try {
			Thread.sleep(3000);
			elementActions.doClick(vsSharedPrescriptionCloseButton);
			extentReport.logToExtentReport("Clicked on shared prescription close button");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		elementActions.doClick(vsViewPrescriptionBtn);
		extentReport.logToExtentReport("Clicked on View prescription");
		elementActions.doIsDisplayed(vsViewPrescriptionPopup);
		extentReport.logToExtentReport("View prescription popup is displayed");
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Adding the Diagnosis,type
	 * and provisional
	 */
	@Step("Verify Add functionality under Diagnosis section")
	public void VerifyAddFunctionalityUnderDiagnosisSection() throws Throwable {
		if (elementActions.doIsDisplayed2(StartVisitNote)) {
			elementActions.JavaScriptExecutorClick(StartVisitNote);
		}
		elementActions.doActionsSendKeys(SelectDiagnosisTextField, "fever");
		Thread.sleep(2000);
		String FirstOptionValue = elementActions.doGetText(DropdownFirstOption);
		Thread.sleep(2000);
		elementActions.doClick(DropdownFirstOption);
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisTypePrimary);
		Thread.sleep(2000);
		elementActions.doSelect(DiagnosisStatusProvisional);
		Thread.sleep(2000);
		elementActions.doClick(AddDiagnosis);
		Thread.sleep(2000);
		elementActions.VerifyText2(DiagnosisColumn, FirstOptionValue);
		elementActions.VerifyText(DiagnosisTypePrimary, TypeColumn);
		elementActions.VerifyText(DiagnosisStatusProvisional, StatusColumn);
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Doctor writing note in
	 * Note text area and saving it
	 */
	@Step("Verify add note functionality")
	public void VerifyAddNoteFunctionality() throws Throwable {
		try {
			elementActions.doClick(StartVisitNote);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		elementActions.doActionsSendKeys(NoteTextField, "Hello");
		Thread.sleep(2000);
		elementActions.doClick(AddNoteButton);
		elementActions.doIsDisplayed(Buffering);
		elementActions.doIsDisplayed(PleaseWaitText);
		Thread.sleep(2000);
		String NoteTextValue = elementActions.doGetText(NoteText);
		if (NoteTextValue.equals("Hello")) {
			// System.out.println("Doctor is able to the add text");
		}

		elementActions.doIsDisplayed(DeleteIcon);
	}

	/*
	 * Author : Rajesh H S Created : 4/10/23 Description : Saving the additional
	 * instructions
	 */
	@Step("Verify save functionality for additional instructions under medication section")
	public void VerifySaveFunctionalityForAdditionalInstructionsUnderMedicationSection() throws Throwable {
		try {
			elementActions.doClick(StartVisitNote);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		elementActions.doActionsSendKeys(AdditionalInstructionsTextArea, "Hello");
		Thread.sleep(2000);
		elementActions.doClick(SaveAdditionalInstructions);
		elementActions.doIsDisplayed(Buffering);
		elementActions.doIsDisplayed(PleaseWaitText);
		Thread.sleep(2000);
		String InstructionValue = elementActions.doGetText(AdditionalInstructionText);
		if (InstructionValue.contains("Hello")) {
			// System.out.println("Entered text is added");
		}

		elementActions.doIsDisplayed(DeleteIcon);
	}

}
