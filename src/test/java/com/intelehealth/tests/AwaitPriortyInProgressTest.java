package com.intelehealth.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.AwaitPriortyInProgress;
import com.intelehealth.pages.ChatPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class AwaitPriortyInProgressTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ChatPage chatPage;
	AwaitPriortyInProgress awaitPriortyInProgress;
	Credentials credentials;
	VisitSummaryPage visitSummaryPage;
	String testEnum;
	private Boolean medication = false;
	private Boolean typeOfConsultation = false;

	@BeforeClass
	public void getAdminData() throws IOException {
		basePage = new BasePage();
		Response response = basePage.getAdmitDataAPI();
		medication = response.jsonPath().getBoolean("patient_visit_summary.standard_medication")
		/*
		 * response.jsonPath().getBoolean( "patient_visit_summary.standard_medication")
		 */;
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++=" + medication);
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
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		awaitPriortyInProgress = new AwaitPriortyInProgress(driver);
		visitSummaryPage = new VisitSummaryPage(driver);
		chatPage = new ChatPage(driver);
		ScreenshotListener.setDriver(driver);
	}

//1716 1717 1719 1729 
	// 1743 1746 1747 1748 1749 1752 1760 1762 1767 1778
	@Test(priority = 1, description = "IDA4_1702_StartVisitNote_Verify Dashboard screen is displayed after Login", enabled = false)
	@Description("Verify Dashboard screen is displayed after Login")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1702_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1702");
		awaitPriortyInProgress.verifyVisitSumPageDetails();
	}

	@Test(priority = 2, description = "IDA4_1703_StartVisitNote_Verify the details of the patient are correctly displayed in visit summary page", enabled = true)
	@Description("Verify the details of the patient are correctly displayed in visit summary page")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1703_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1703");
		awaitPriortyInProgress.verifyVstSumPageDetails();
	}

	@Test(priority = 3, description = "IDA4_1706_StartVisitNote_Verify only one radio button can be selected in refer to specialist section", enabled = true)
	@Description("Verify only one radio button can be selected in refer to specialist section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1706_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1706");
		awaitPriortyInProgress.verifyVisitSumReferSpecialityRadBtn();
	}

	@Test(priority = 4, description = "IDA4_1707_StartVisitNote_Verify that only one specialization can be selected from the specialization drop down in Refer to specialist section", enabled = true)
	@Description("Verify that only one specialization can be selected from the specialization drop down in Refer to specialist section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1707_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1707");
		awaitPriortyInProgress.verifyVisitSumReferSpecialityDrpdwn();
	}

	@Test(priority = 5, description = "IDA4_1708_StartVisitNote_Verify clicking on Re-assign button in refer to specialist section", enabled = true)
	@Description("Verify clicking on Re-assign button in refer to specialist section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1708_StartVisitNote() throws Exception {
		// System.out.println("Started execution of IDA4_1708");
		awaitPriortyInProgress.verifyVisitSumReferSpecialityRadBtn();
		awaitPriortyInProgress.verifyVisitSumReferSpecialityDrpdwnSelect();
	}

	@Test(priority = 6, description = "IDA4_1709_StartVisitNote_Verify on clicking Confirm in the popup on re-assigning to another specialist", enabled = true)
	@Description("Verify on clicking Confirm in the popup on re-assigning to another specialist")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1709_StartVisitNote() throws Exception {
		// System.out.println("Started execution of IDA4_1709");
		awaitPriortyInProgress.verifyVisitSumReferSpecialityDrpdwn();
		awaitPriortyInProgress.verifyVisitSumReferSpecialityDrpdwnSelect();
		awaitPriortyInProgress.verifyVisiSumReferSpecialtyReassignsuccessPopup();
	}

	@Test(priority = 7, description = "IDA4_1710_StartVisitNote_Verify clicking on Start visit note", enabled = true)
	@Description("Verify clicking on Start visit note")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1710_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1710");
		awaitPriortyInProgress.verifyVisitSumStartVisitNote();
	}

	@Test(priority = 8, description = "IDA4_1712_StartVisitNote_Verify patient interaction section", enabled = true)
	@Description("Verify patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1712_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1712");
		awaitPriortyInProgress.verifyVisitSumPatInteraction();
	}

	@Test(priority = 9, description = "IDA4_1713_StartVisitNote_Verify when patient number is not available in patient interaction section", enabled = true)
	@Description("Verify when patient number is not available in patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1713_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1713");
		awaitPriortyInProgress.verifyVisitSumPatInteractionwithoutPhNo();
	}

	@Test(priority = 10, description = "IDA4_1714_StartVisitNote_Verify clicking on call feature in patient interaction section", enabled = true)
	@Description("Verify clicking on call feature in patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1714_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1714");
		awaitPriortyInProgress.verifyVisitSumPatInteractionCall();
	}

	@Test(priority = 11, description = "IDA4_1715_StartVisitNote_Verify clicking on whatsapp feature in patient interaction section", enabled = true)
	@Description("Verify clicking on whatsapp feature in patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1715_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1715");
		awaitPriortyInProgress.verifyVisitSumPatInteractionWhatsapp();
	}

	@Test(priority = 12, description = "IDA4_1716_StartVisitNote_Verify Save functionality in patient interaction section", enabled = true)
	@Description("Verify Save functionality in patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1716_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1716");
		awaitPriortyInProgress.verifyVisitSumPatInteractionSavefn();
	}

	@Test(priority = 13, description = "IDA4_1717_StartVisitNote_Verify delete icon functionality in patient interaction section", enabled = true)
	@Description("Verify delete icon functionality in patient interaction section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1717_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1717");
		awaitPriortyInProgress.verifyVisitSumPatInteractionDelfn();
	}

	@Test(priority = 14, description = "IDA4_1719_StartVisitNote_Verify Select Diagnosis drop down under Diagnosis section", enabled = true)
	@Description("Verify Select Diagnosis drop down under Diagnosis section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1719_StartVisitNote() throws InterruptedException {
		// System.out.println("Started execution of IDA4_1719");
		awaitPriortyInProgress.verifyVisitSumDiagnosisdrpdwn();
	}

	@Test(priority = 15, description = "IDA4_1720_StartVisitNote_Verify Add functionality under Diagnosis section", enabled = true)
	@Description("Verify Add functionality under Diagnosis section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1720_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1720");
		awaitPriortyInProgress.VerifyAddFunctionalityUnderDiagnosisSection();
	}

	@Test(priority = 16, description = "IDA4_1721_StartVisitNote_Verify delete icon functionality under Diagnosis section", enabled = true)
	@Description("Verify delete icon functionality under Diagnosis section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1721_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1721");
		awaitPriortyInProgress.VerifyDeleteIconFunctionalityUnderDiagnosisSection();
	}

	@Test(priority = 17, description = "IDA4_1723_StartVisitNote_Verify doctor is able to enter text", enabled = true)
	@Description("Verify doctor is able to enter text")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1723_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1723");
		awaitPriortyInProgress.VerifyDoctorIsAbleToEnterText();
	}

	@Test(priority = 18, description = "IDA4_1724_StartVisitNote_Verify add note functionality", enabled = true)
	@Description("Verify add note functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1724_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1724");
		awaitPriortyInProgress.VerifyAddNoteFunctionality(prop.getProperty("NoteValue"));
	}

	@Test(priority = 19, description = "IDA4_1725_StartVisitNote_Verify delete icon functionality", enabled = true)
	@Description("Verify delete icon functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1725_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1725");
		awaitPriortyInProgress.VerifyDeleteIconFunctionality();
	}

	@Test(priority = 20, description = "IDA4_1728_StartVisitNote_Verify if user can type in drug name textbox and if numbers or spl characters allowed", enabled = true)
	@Description("Verify if user can type in drug name textbox and if numbers or spl characters allowed")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1728_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1728");
		awaitPriortyInProgress.VerifyIfUserCanTypeInDrugNameTextboxAndIfNumbersOrSplCharactersAllowed();
	}

	@Test(priority = 21, description = "IDA4_1729_StartVisitNote_Verify if the selected drug appears if choosed", enabled = true)
	@Description("Verify if the selected drug appears if choosed")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1729_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1729");
		awaitPriortyInProgress.VerifyIfTheSelectedDrugAppearsIfChoosed();
	}

	@Test(priority = 22, description = "IDA4_1730_StartVisitNote_Verify if user can type in strength and if characters or spl characters are allowed", enabled = true)
	@Description("Verify if user can type in strength and if characters or spl characters are allowed")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1730_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1730");
		awaitPriortyInProgress.VerifyIfUserCanTypeInStrengthAndIfCharactersOrSplCharactersAreAllowed();
	}

	@Test(priority = 23, description = "IDA4_1731_StartVisitNote_Verify if the selected strength appears if selected", enabled = true)
	@Description("Verify if the selected strength appears if selected")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1731_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1731");
		awaitPriortyInProgress.VerifyIfTheSelectedStrengthAppearsIfSelected();
	}

	@Test(priority = 24, description = "IDA4_1732_StartVisitNote_Verify if user can type in No of days and characters or spl characters in the textbox", enabled = true)
	@Description("Verify if user can type in No of days and characters or spl characters in the textbox")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1732_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1732");
		awaitPriortyInProgress.VerifyIfUserCanTypeInNoOfDaysAndCharactersOrSplCharactersInTheTextbox(
				prop.getProperty("NoOfdaysValue"));
	}

	@Test(priority = 25, description = "IDA4_1733_StartVisitNote_Verify if the selected days appears if selected", enabled = true)
	@Description("Verify if the selected days appears if selected")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1733_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1733");
		awaitPriortyInProgress.VerifyIfTheSelectedDaysAppearsIfSelected(prop.getProperty("NoOfdaysValue"));
	}

	@Test(priority = 26, description = "IDA4_1734_StartVisitNote_Verify if user can type in timings dropdown", enabled = true)
	@Description("Verify if user can type in timings dropdown")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1734_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1734");
		awaitPriortyInProgress.VerifyIfUserCanTypeInTimingsDropdown();
	}

	@Test(priority = 27, description = "IDA4-1735,Verify if the selected time appears once chosen", enabled = true)
	@Description("Verify if the selected time appears once chosen")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1735_StartVisitNote() throws InterruptedException {

		awaitPriortyInProgress.addTimingsMedication();
		visitSummaryPage.clickOnTimingsDropdown();
		visitSummaryPage.setTimings(prop.getProperty("timings.text"));
		visitSummaryPage.clickOnDashboard();
	}

	@Test(priority = 28, description = "IDA4-1736,Verify if user can type in Remarks textbox and if numbers or special characters are allowed", enabled = true)
	@Description("Verify if user can type in Remarks textbox and if numbers or special characters are allowed")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1736_StartVisitNote() throws InterruptedException {
		awaitPriortyInProgress.addTimingsMedication();
		visitSummaryPage.setRemarks(prop.getProperty("remarks"));
	}

	@Test(priority = 29, description = "IDA4-1739,Verify if multiple medicines can be added in medication section", enabled = true)
	@Description("Verify if multiple medicines can be added in medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1739_StartVisitNote() throws InterruptedException {
		awaitPriortyInProgress.addMultipleMedications(medication);

	}

	@Test(priority = 30, description = "IDA4_1740_StartVisitNote_Verify user is able to enter text in additional instructions text area under medication section", enabled = true)
	@Description("Verify user is able to enter text in additional instructions text area under medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1740_StartVisitNote() throws Throwable {
		awaitPriortyInProgress.VerifyUserIsAbleToEnterTextInAdditionalInstructionsTextAreaUnderMedicationSection();
	}

	@Test(priority = 31, description = "IDA4_1741_StartVisitNote_Verify save functionality for additional instructions under medication section", enabled = true)
	@Description("Verify save functionality for additional instructions under medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1741_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1741");
		awaitPriortyInProgress.VerifySaveFunctionalityForAdditionalInstructionsUnderMedicationSection();
	}

	@Test(priority = 32, description = "IDA4_1742_StartVisitNote_Verify if multiple instructions can be added under medication section", enabled = true)
	@Description("Verify if multiple instructions can be added under medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1742_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1742");
		awaitPriortyInProgress.VerifyAdditionalInstructionswithMultipleLines(
				prop.getProperty("AdditionalInstructionsText1"), prop.getProperty("AdditionalInstructionsText2"));
	}

	@Test(priority = 33, description = "IDA4-1743, Verify delete icon functionality for instructions under medication section", enabled = true)
	@Description("Verify delete icon functionality for instructions under medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1743_StartVisitNote() throws Exception {

		awaitPriortyInProgress.addMultipleMedications();
		awaitPriortyInProgress.verifyDeleteIcon();
	}

	@Test(priority = 34, description = "IDA4-1745, Verify user is able to enter text and add advice functionality", enabled = true)
	@Description("Verify delete icon functionality for instructions under medication section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1745_StartVisitNote() throws Exception {

		awaitPriortyInProgress.strtVstforAwaitPatient();
		Assert.assertEquals(awaitPriortyInProgress.getAdviceText(), "Advice");
		Assert.assertFalse(awaitPriortyInProgress.isEnabledButton("btnSubmitAdvice"));
		awaitPriortyInProgress.setAdvice(prop.getProperty("advice.text"));
		Assert.assertTrue(awaitPriortyInProgress.isEnabledButton("btnSubmitAdvice"));
		awaitPriortyInProgress.clickOnButtons("btnSubmitAdvice");

	}

	@Test(priority = 35, description = "IDA4-1746, Verify if the selected advice appears if choosed under advice section", enabled = true)
	@Description("Verify if the selected advice appears if choosed under advice section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1746_StartVisitNote() throws Exception {

		awaitPriortyInProgress.strtVstforAwaitPatient();
		Assert.assertEquals(awaitPriortyInProgress.getAdviceText(), "Advice");
		awaitPriortyInProgress.setAdvice(prop.getProperty("advice.name"));
		String advice = prop.getProperty("text.advice.name");
		awaitPriortyInProgress.clickOnAdvice(advice);
		Thread.sleep(4000);
		awaitPriortyInProgress.clickOnButtons("btnSubmitAdvice");
		Assert.assertEquals(awaitPriortyInProgress.getTextOfSelectedAdvice(), advice);
		awaitPriortyInProgress.clickOnDashboard();
	}

	@Test(priority = 36, description = "IDA4-1747, Verify add advice functionality", enabled = true)
	@Description("Advice is added to the patient after starting the visit")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1747_StartVisitNote() throws Exception {
		awaitPriortyInProgress.strtVstforAwaitPatient();
		Thread.sleep(5000);
		awaitPriortyInProgress.Addadvice();
		Thread.sleep(2000);
		awaitPriortyInProgress.ClickonAddAdvice();
		Thread.sleep(2000);
	}

	@Test(priority = 37, description = "IDA4-1748, Verify delete advice functionality", enabled = true)
	@Description("Advice is deleted to the patient after starting the visit")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1748_StartVisitNote() throws Exception {
		awaitPriortyInProgress.ClickOnDeleetButton();
		Thread.sleep(2000);
	}

	@Test(priority = 38, description = "IDA4_1749_StartVisitNote_Verify if multiple advices can be added", enabled = true)
	@Description("Verify if multiple advices can be added")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1749_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1749");
		awaitPriortyInProgress.VerifyAddMultipleAdvice(prop.getProperty("AdditionalInstructionsText1"),
				prop.getProperty("AdditionalInstructionsText2"));
	}

	@Test(priority = 39, description = "IDA4-1751, Verify add test functionality", enabled = true)
	@Description("Test is added to the respective field patient after starting the visit")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1751_StartVisitNote() throws Exception {
		awaitPriortyInProgress.strtVstforAwaitPatient();
		awaitPriortyInProgress.ClickOnAddTest("Juice");
		Thread.sleep(2000);
		awaitPriortyInProgress.ClickOnSubmitTest();
	}

	@Test(priority = 40, description = "IDA4-1752, Verify user is shown automatic selection options once a character is entered", enabled = true)
	@Description("Verify user is shown automatic selection options once a character is entered")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1752_StartVisitNote() throws Exception {
		awaitPriortyInProgress.strtVstforAwaitPatient();
		Assert.assertEquals(awaitPriortyInProgress.getTextOfTest(), prop.getProperty("Testdata1"));
		awaitPriortyInProgress.setTestName(prop.getProperty("Testdata2"));

		Assert.assertTrue(awaitPriortyInProgress.isDisplayedTestsList(prop.getProperty("test.name.one")));
		awaitPriortyInProgress.clickOnDashboard();
	}

	@Test(priority = 41, description = "IDA4-1753, Verify if the selected test appears if choosed", enabled = true)
	@Description("Verify if the selected test appears if choosed")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1753_StartVisitNote() throws Exception {

		awaitPriortyInProgress.strtVstforAwaitPatient();
		Assert.assertEquals(awaitPriortyInProgress.getTextOfTest(), prop.getProperty("Testdata1"));
		awaitPriortyInProgress.setTestName(prop.getProperty("Testdata2"));// blood
		String testName = prop.getProperty("test.blood.one");// blood
		// awaitPriortyInProgress.clickOnTestName(testName);
		awaitPriortyInProgress.clickOnButtons("btnSubmitTest");
		System.out.println(testName);
		Assert.assertEquals(awaitPriortyInProgress.getTextOfSelectedTest(), testName);

	}

	@Test(priority = 42, description = "IDA4-1754, Verify add test functionality", enabled = true)
	@Description("Verify add test functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1754_StartVisitNote() throws Exception {
		awaitPriortyInProgress.strtVstforAwaitPatient();
		Assert.assertEquals(awaitPriortyInProgress.getTextOfTest(), prop.getProperty("Testdata1"));
		awaitPriortyInProgress.setTestName(prop.getProperty("Testdata2"));
		// awaitPriortyInProgress.clickOnTestName(prop.getProperty("test.name.one"));
		Thread.sleep(2000);
		awaitPriortyInProgress.clickOnButtons("btnSubmitTest");
		Assert.assertTrue(awaitPriortyInProgress.isDisplayedDeleteIcon());
		awaitPriortyInProgress.clickOnDashboard();
	}

	@Test(priority = 43, description = "IDA4_1755_StartVisitNote_Verify delete icon functionality", enabled = true)
	@Description("Verify delete icon functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1755_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1755");
		awaitPriortyInProgress.verifyDelFnctninVisitSumPage(prop.getProperty("Testdata2"));
	}

	@Test(priority = 44, description = "IDA4_1758_StartVisitNote_Verify Referral facility and referral specialization drop down", enabled = true)
	@Description("Verify Referral facility and referral specialization drop down")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1758_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1758");
		awaitPriortyInProgress.verifyVisitSumReferSpecialityDrpdwn();
	}

	@Test(priority = 45, description = "IDA4_1760_StartVisitNote_Verify if add item is clickable once a new referral facility/specialization is entered", enabled = true)
	@Description("Verify if add item is clickable once a new referral facility/specialization is entered")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1760_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1760");
		awaitPriortyInProgress.verifyVisitSumReferralyAddBtn();
	}

	@Test(priority = 46, description = "IDA4_1761_StartVisitNote_Verify user is able to enter text in referral reason and remarks textfield", enabled = true)
	@Description("Verify user is able to enter text in referral reason and remarks textfield")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1761_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1761");
		awaitPriortyInProgress.verifyVisitSumReferralyAddBtn();
	}

	@Test(priority = 47, description = "IDA4_1762_StartVisitNote_Verify add button functionality for remarks section", enabled = true)
	@Description("Verify add button functionality for remarks section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1762_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1762");
		awaitPriortyInProgress.verifyVisitSumReferralyAddBtn();
	}

	@Test(priority = 48, description = "IDA4_1763_StartVisitNote_Verify delete icon functionality for remarks section", enabled = true)
	@Description("Verify delete icon functionality for remarks section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1763_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1763");
		awaitPriortyInProgress.verifyVisitSumReferralyAddBtn();
		awaitPriortyInProgress.verifyVisitSumReferralyDelBtn();
	}

	@Test(priority = 49, description = "IDA4_1766_StartVisitNote_Verify only one radio button can be selected in followup section", enabled = true)
	@Description("Verify only one radio button can be selected in followup section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1766_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1766");
		awaitPriortyInProgress.verifyFollowUpsectionRadYesNO();
	}

	@Test(priority = 50, description = "IDA4_1767_StartVisitNote_Verify on clicking Yes in followup section", enabled = true)
	@Description("Verify on clicking Yes in followup section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1767_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1767");
		awaitPriortyInProgress.verifyFollowUpsectionRadYes();
	}

	@Test(priority = 51, description = "IDA4_1770_StartVisitNote_Verify Save button functionality in followup section", enabled = true)
	@Description("Verify Save button functionality in followup section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1770_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1770");
		awaitPriortyInProgress.VerifyFollowupSaveBtn();
	}

	@Test(priority = 52, description = "IDA4_1771_StartVisitNote_Verify Delete button functionality in followup section", enabled = true)
	@Description("Verify delete button functionality in followup section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1771_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1771");
		awaitPriortyInProgress.verifyDelFunctnFollowUpsection();
	}

	@Test(priority = 53, description = "IDA4_1772_StartVisitNote_Verify functionality of Share prescription button", enabled = true)
	@Description("Verify functionality of Share prescription button")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1772_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1772");
		awaitPriortyInProgress.verifySharePrescriptionBtn();
	}

	@Test(priority = 54, description = "IDA4_1773_StartVisitNote_Verify Confirm functionality under share prescription", enabled = true)
	@Description("Verify Confirm functionality under share prescription")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1773_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1773");
		awaitPriortyInProgress.verifyConfBtnSharePrescription();
	}

	@Test(priority = 55, description = "IDA4_1774_StartVisitNote_Verify Confirm functionality under share prescription", enabled = true)
	@Description("Verify Confirm functionality under share prescription")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1774_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1774");

		awaitPriortyInProgress.verifyViewPrescptnSharePrescription();
	}

	@Test(priority = 56, description = "IDA4_1776_StartVisitNote_Verify buttons are changed once prescription is shared to a patient on visit summary page", enabled = true)
	@Description("Verify buttons are changed once prescription is shared to a patient on visit summary page")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1776_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1776");
		awaitPriortyInProgress.verifyUpdateViewPrescptnBtninVisitSumPage();
	}

	@Test(priority = 57, description = "IDA4_1777_StartVisitNote_Verify Update prescription functionality", enabled = true)
	@Description("Verify Update prescription functionality")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1777_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1777");
		awaitPriortyInProgress.verifyViewPrescptnSharePrescription();
		awaitPriortyInProgress.verifyUpdatePrescptnFnctnlty();

	}

	@Test(priority = 58, description = "IDA4_1778_StartVisitNote_Verify doctor should be able to select only one option for question: Have you spoken with patient", enabled = true)
	@Description("Verify doctor should be able to select only one option for question: Have you spoken with patient")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1778_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1778");
		awaitPriortyInProgress.VerifyOneOptionSelected();
	}

	@Test(priority = 59, description = "IDA4_1779_StartVisitNote_Verify diagnosis type, Primary or Secondary under Diagnosis section", enabled = true)
	@Description("Verify diagnosis type, Primary or Secondary under Diagnosis section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1779_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1779");
		awaitPriortyInProgress.VerifyOneDiagnosisOptionSelected(prop.getProperty("diagnosis"));
	}

	@Test(priority = 60, description = "IDA4_1780_StartVisitNote_Verify status, Provisional or Confirmed under Diagnosis section", enabled = true)
	@Description("Verify status, Provisional or Confirmed under Diagnosis section")
	@Severity(SeverityLevel.NORMAL)
	public void IDA4_1780_StartVisitNote() throws Throwable {
		// System.out.println("Started execution of IDA4_1780");
		awaitPriortyInProgress.VerifyOneDiagnosisStatus(prop.getProperty("diagnosis"));
	}

	@DataProvider(name = "dataTestIDProvider")
	public Object[] dataTestIDProvider() {
		return new String[] { prop.getProperty("appointments.id"), prop.getProperty("priority.visit.id"),
				prop.getProperty("awaiting.visit.id"), prop.getProperty("inprogress.visit.id") };
	}

	@DataProvider(name = "dataTestIDProviderOne")
	public Object[] dataTestIDProviderOne() {
		return new String[] { prop.getProperty("appointments.id"), prop.getProperty("priority.visit.id"),
				prop.getProperty("awaiting.visit.id") };
	}

	@DataProvider(name = "additionalInstructions")
	public Object[] addAdditionalInstructions() {
		return new String[] { prop.getProperty("additional.instructions.text.one"),
				prop.getProperty("additional.instructions.text.two"),
				prop.getProperty("additional.instructions.text.three") };
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Throwable {
		basePage.quitDriver(testEnum);
		System.gc();
	}
}
