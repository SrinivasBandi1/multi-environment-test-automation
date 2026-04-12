package com.intelehealth.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.VisitSummaryPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class VisitSummaryPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials;
	VisitSummaryPage vstSummaryPage;

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
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		vstSummaryPage = new VisitSummaryPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1805_VisitSummary_Verify the visit summary page", enabled = true)
	@Description("Verify the visit summary page")
	@Severity(SeverityLevel.BLOCKER)

	public void IDA4_1805_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1805");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyVstSummaryUI();
	}

	@Test(priority = 2, description = "IDA4_1806_VisitSummary_Verify Appointment Starts in section under visit summary page", enabled = true)
	@Description("Verify Appointment Starts in section under visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1806_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1806");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyAptStartinInDateTime();
	}

	/*
	 * Please add verification for call Verification is pending
	 */
	@Test(priority = 3, description = "IDA4_1807_VisitSummary_Verify the functionality of Start call button in visit summary page", enabled = true)
	@Description("Verify the functionality of Start call button in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1807_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1807");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyStartCallOption();
	}

	@Test(priority = 4, description = "IDA4_1809_VisitSummary_Verify chat option in visit summary page", enabled = true)
	@Description("Verify chat option in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1809_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1809");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyChatOption();
	}

	@Test(priority = 5, description = "IDA4_1810_VisitSummary_Verify whether user able to chat and send to healthworker on visit summary page", enabled = true)
	@Description("Verify whether user able to chat and send to healthworker on visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1810_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1810");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyMessageSent();
	}

	@Test(priority = 6, description = "IDA4_1811_VisitSummary_Verify video call option in visit summary page", enabled = true)
	@Description("Verify video call option in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1811_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1811");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvideoCall();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 7, description = "IDA4_1812_VisitSummary_Verify Current visit summary in visit summary page", enabled = true)
	@Description("Verify Current visit summary in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1812_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1812");
		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifycurrentVisitSummaryField();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 8, description = "IDA4_1814_VisitSummary_Verify the Update prescription and View prescription buttons before updating any changes in visit summary page", enabled = true)
	@Description("Verify the Update prescription and View prescription buttons before updating any changes in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1814_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1814");
		// vstSummaryPage.goToVisitSummaryPage();
		// vstSummaryPage.VerifyAddDiagnosisAndFollowupFunctionality();
		vstSummaryPage.verifyvstsumPrescription();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 9, description = "IDA4_1815_VisitSummary_Verify doing any changes in any of the section in visit summary page", enabled = true)
	@Description("Verify doing any changes in any of the section in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1815_VisitSummary() throws Throwable {

		// System.out.println("Started execution of IDA4_1815");
//		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvsprescrptionChanges();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 10, description = "IDA4_1816_VisitSummary_Verify the functionality of share prescription button in visit summary page", enabled = true)
	@Description("Verify the functionality of share prescription button in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1816_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1816");
		// vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvsprescrptionChangesSharePrescButton();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 11, description = "IDA4_1817_VisitSummary_Verify the functionality of view prescription button in visit summary page", enabled = true)
	@Description("Verify the functionality of view prescription button in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1817_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1817");
		// vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvsprescrptionChangesViewPrescButton();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 12, description = "IDA4_1818_VisitSummary_Verify the functionality of update prescription button in visit summary page", enabled = true)
	@Description("Verify the functionality of update prescription button in visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1818_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1818");
//		vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvsprescrptionChangesUpdateButton();
	}

	/*
	 * Add verification for prescription contents. Check in the testcase.
	 */
	@Test(priority = 13, description = "IDA4_1819_VisitSummary_Verify functionality of confirm button in share prescription popup", enabled = true)
	@Description("Verify functionality of confirm button in share prescription popup")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1819_VisitSummary() throws InterruptedException {

		// System.out.println("Started execution of IDA4_1819");
		// vstSummaryPage.goToVisitSummaryPage();
		vstSummaryPage.verifyvsprescrptionChangesConfButton();
	}

	@Test(priority = 14, description = "IDA4_1820_VisitSummary_Verify past visit history section on Visit summary page", enabled = true)
	@Description("Verify past visit history section on Visit summary page")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1820_VisitSummary() {

		// System.out.println("Started execution of IDA4_1820");
		vstSummaryPage.verifyvsprescrptionNoPastVstHistory();
	}

	@Test(priority = 15, description = "IDA4_1821_VisitSummary_Verify if there are past visits in the patient profile", enabled = true)
	@Description("Verify if there are past visits in the patient profile")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1821_VisitSummary() {

		// System.out.println("Started execution of IDA4_1821");
		vstSummaryPage.verifyvsprescrptionPastVstHistory();
	}

	@Test(priority = 16, description = "IDA4_1823_VisitSummary_Verify the details in past visit summary/prescription popup is correct", enabled = true)
	@Description("Verify the details in past visit summary/prescription popup is correct")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1823_VisitSummary() {

		// System.out.println("Started execution of IDA4_1823");
		vstSummaryPage.verifyvsprescrptionPastVstHistory();
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
