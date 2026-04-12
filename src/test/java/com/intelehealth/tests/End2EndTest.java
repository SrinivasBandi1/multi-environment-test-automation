package com.intelehealth.tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intelehealth.base.BasePage;
import com.intelehealth.pages.End2EndPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class End2EndTest extends BasePage {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	End2EndPage end2endPage;
	Credentials credentials;
	String testEnum;

	@BeforeMethod
	public void setUp(Method method) throws Throwable {
		basePage = new BasePage();
		prop = basePage.init_prop();
		testEnum = method.getName().toUpperCase();
		// driver = basePage.init_driver(prop);
		driver = basePage.init_driver1(prop, testEnum);
		loginPage = new LoginPage(driver);
		end2endPage = new End2EndPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.doLogin(credentials);
	}

	@Test(priority = 1, description = "IDA4_1668_End2End_Login, Reschedule appointment, logout", enabled = true)
	@Description("Login, Reschedule appointment, logout")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1668_End2End() throws Throwable {

		end2endPage.LoginRescheduleAppointmentLogout();
	}

	@Test(priority = 2, description = "IDA4_1669_End2End_Login, Cancel appointment, logout", enabled = true)
	@Description("Login, Cancel appointment, logout")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1669_End2End() throws Throwable {

		end2endPage.LoginCancelAppointmentLogout();
	}

	@Test(priority = 3, description = "IDA4_1670_End2End_Login, appointment, visit summary, view prescription", enabled = true)
	@Description("Login, appointment, visit summary, view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1670_End2End() throws Throwable {

		end2endPage.LoginAppointmentVisitSummaryViewPrescription();
	}

	@Test(priority = 4, description = "IDA4_1671_End2End_Login, priority visit, visit summary, start visit note, share/update/view prescription", enabled = true)
	@Description("Login, priority visit, visit summary, start visit note, share/update/view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1671_End2End() throws Throwable {

		end2endPage.LoginPriorityVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription();
	}

	@Test(priority = 5, description = "IDA4_1672_End2End_Login, awaiting visit, visit summary, start visit note, share/update/view prescription", enabled = true)
	@Description("Login, awaiting visit, visit summary, start visit note, share/update/view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1672_End2End() throws Throwable {

		end2endPage.LoginAwaitingVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription();
	}

	@Test(priority = 6, description = "IDA4_1673_End2End_Login, in-progress visit, visit summary, start visit note, share/update/view prescription", enabled = true)
	@Description("Login, in-progress visit, visit summary, start visit note, share/update/view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1673_End2End() throws Throwable {

		end2endPage.LoginInProgressVisitVisitSummaryStartVisitNoteShareUpdateViewPrescription();
	}

	@Test(priority = 7, description = "IDA4_1674_End2End_Login, awaiting/appointment/in-progress/priority, visit summary, past visit history, view visit summary", enabled = true)

	@Description("Login, awaiting/appointment/in-progress/priority, visit summary, past visit history, view visit summary")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1674_End2End() throws Throwable {

		end2endPage.LoginAwaitingAppointmentInProgressPriorityVisitSummaryPastVisitHistoryViewVisitSummary();
	}

	@Test(priority = 8, description = "IDA4_1675_End2End_Login, search patient, view, visit summary, call patient no", enabled = true)
	@Description("Login, search patient, view, visit summary, call patient no")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1675_End2End() throws Throwable {

		end2endPage.LoginSearchPatientViewVisitSummaryCallPatientNo();
	}

	@Test(priority = 9, description = "IDA4_1676_End2End_Login, search patient, view, visit summary, whatsapp patient no", enabled = true)
	@Description("Login, search patient, view, visit summary, whatsapp patient no")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1676_End2End() throws Throwable {

		end2endPage.LoginSearchPatientViewVisitSummaryWhatsappPatientNo();
	}

	@Test(priority = 10, description = "IDA4_1677_End2End_Login, search patient, view, visit summary, chat with healthworker", enabled = true)
	@Description("Login, search patient, view, visit summary, chat with healthworker")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1677_End2End() throws Throwable {

		end2endPage.LoginSearchPatientViewVisitSummaryChatWithHealthworker();
	}

	@Test(priority = 11, description = "IDA4_1678_End2End_Login, search patient, view, visit summary, video call with healthworker", enabled = true)
	@Description("Login, search patient, view, visit summary, video call with healthworker")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1678_End2End() throws Throwable {

		end2endPage.LoginSearchPatientViewVisitSummaryVideoCallWithHealthworker();
	}

	@Test(priority = 19, description = "IDA4_1679_End2End_Login, calendar, setup calendar [manage calendar]", enabled = true)
	@Description("Login, calendar, setup calendar [manage calendar]")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1679_End2End() throws Throwable {

		end2endPage.LoginCalendarSetupCalendarManageCalendar();
	}

	@Test(priority = 13, description = "IDA4_1680_End2End_Login, calendar, view calendar, followup, mark as day off/hourly off", enabled = true)
	@Description("Login, calendar, view calendar, followup, mark as day off/hourly off")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1680_End2End() throws Throwable {

		end2endPage.LoginCalendarViewCalendarFollowupMarkAsDayOffHourlyOff();
	}

	@Test(priority = 14, description = "IDA4_1681_End2End_Login, calendar, view calendar, appointment, mark as hourly off", enabled = true)
	@Description("Login, calendar, view calendar, appointment, mark as hourly off")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1681_End2End() throws Throwable {

		end2endPage.LoginCalendarViewCalendarAppointmentMarkAsHourlyOff();
	}

	@Test(priority = 15, description = "IDA4_1682_End2End_Login, calendar, view calendar, followup visit, provide prescription", enabled = true)
	@Description("Login, calendar, view calendar, followup visit, provide prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1682_End2End() throws Throwable {

		end2endPage.LoginCalendarViewCalendarFollowupVisitProvidePrescription();
	}

	@Test(priority = 16, description = "IDA4_1683_End2End_Login, prescription sent, visit summary, update prescription", enabled = true)
	@Description("Login, prescription sent, visit summary, update prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1683_End2End() throws Throwable {

		end2endPage.LoginPrescriptionSentVisitSummaryUpdatePrescription();
	}

	@Test(priority = 17, description = "IDA4_1684_End2End_Login, prescription sent, visit summary, view prescription", enabled = true)

	@Description("Login, prescription sent, visit summary, view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1684_End2End() throws Throwable {

		end2endPage.LoginPrescriptionSentVisitSummaryViewPrescription();
	}

	@Test(priority = 18, description = "IDA4_1685_End2End_Login, prescription sent, visit summary, share prescription", enabled = true)
	@Description("Login, prescription sent, visit summary, share prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1685_End2End() throws Throwable {

		end2endPage.LoginPrescriptionSentVisitSummarySharePrescription();
	}

	@Test(priority = 12, description = "IDA4_1686_End2End_Login, completed visit sent, visit summary, view prescription", enabled = true)
	@Description("Login, completed visit sent, visit summary, view prescription")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1686_End2End() throws Throwable {

		end2endPage.LoginCompletedVisitSentVisitSummaryViewPrescription();
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		Thread.sleep(1000);
		basePage.quitDriver(testEnum);
		System.gc();
	}
}
