package com.intelehealth.pages;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class DashboardPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	VisitSummaryPage vstsum;
	ExtentReportListener extentReport = new ExtentReportListener();

	By loggedInUserName = By.xpath("//*[@data-test-id='greetingUser']");
	By addtohomescreenClosePrompt = By.xpath("//*[@data-test-id='imgSidenavToggleIcon']");
	By dashboardLink = By.xpath("\n" + "//*[@data-test-id='iconDashboard']");
	By messagesLink = By.xpath("//*[@data-test-id='linkMessages']");
	By appointmentLink = By.xpath("//*[@data-test-id='chip-appointments']");
	By calendarLink = By.xpath("//a[@data-test-id='linkCalendar']");
	By prescriptionLink = By.xpath("//a[@data-test-id='linkPrescription']");
	By helpsupportLink = By.xpath("//a[@data-test-id='linkHelp']");
	By logoutLink = By.xpath("//a[@data-test-id='linkLogout']");
	By logoutConfirmYesBtn = By.xpath("//button[@data-test-id='btnSubmitConfirmationModal']");
	By searchpatientTextbox = By.xpath("//input[@data-test-id='etSearchPatient']");
	By searchpatientIcon = By.xpath("//*[@data-test-id='iconSearchPatient']");
	By helpChatBot = By.xpath("//button[@data-test-id='btnHelpMenu']");
	By notificationIcon = By.xpath("//*[@data-test-id='iconNotifNone']");
	// By kebabMenu = By.xpath("//button[@data-test-id='btnProfileDropdown']");
	By appointmentsLabel = By.xpath("//div[@title='Appointments']");
	By priorityvisitLabel = By.xpath("//div[@title='Priority visits']");
	By awaitingvisitLabel = By.xpath("//div[@title='Awaiting visits']");
	By inprogressvisitLabel = By.xpath("//div[@title='In-progress visits']");
	// Locators of Appointment field in Dashboard Page
	By aptPatientField = By.xpath("//th[@data-test-id='colPatientAppointment']");
	By aptAgeField = By.xpath("//th[@data-test-id='hdrAgeAppointment']");
	By aptStartsInField = By.xpath("//th[@data-test-id='hdrStartAppointment']");
	By aptLocationField = By.xpath("//th[@data-test-id='hdrLocationAppointment']");
	By aptChiefComplaintField = By.xpath("//th[@data-test-id='hdrComplaintAppointment']");
	By aptActionsField = By.xpath("//th[@data-test-id='hdrActionsAppointment']");
	By apPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-Appointment-0']");
	// Locator for getting the count of Appointment field patients
	By aptCount = By.xpath("//h6[@data-test-id='Appointments']");
	By aptCountLabel = By.xpath("//h6[@data-test-id='Appointments']");
	By aptCountAtPaginator = By.xpath("(//*[@class='mat-paginator-range-actions']/div)[1]");
	// Locators of Priority Visit
	By prvstPatientField = By.xpath("//th[@data-test-id='th-patient_id-Priority']");
	// By prvstAgeField =
	// By.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Age ']");
	By prvstLocationField = By.xpath("//th[@data-test-id='th-location-Priority']");
	By prvstChiefComplaintField = By.xpath("//th[@data-test-id='th-cheif_complaint-Priority']");
	By prvstVisitUploadedField = By.xpath("//th[@data-test-id='th-visit_created-Priority']");
	By prvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-Priority-0']");
	// Locator for getting the count of Priority Visit field patients
	By prVstCount = By.xpath("//h6[@data-test-id='Priority visits']");
	By prVstCountLabel = By.xpath("//h6[@data-test-id='Priority visits']");
	By prVstCountAtPaginator = By.xpath("(//*[@class='mat-paginator-range-actions']/div)[2]");
	// Locators of Awaiting Patient field in Dashboard Page
	By awtvstPatientField = By.xpath("//th[@data-test-id='th-patient_id-Awaiting']");
	By awtvstAgeField = By.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Age ']");
	By awtvstLocationField = By.xpath("//th[@data-test-id='th-location-Awaiting']");
	By awtvstChiefComplaintField = By.xpath("//th[@data-test-id='th-cheif_complaint-Awaiting']");
	By awtvstVisitUploadedField = By.xpath("//th[@data-test-id='th-visit_created-Awaiting']");
	By awtvstPatient1Name = By.xpath("//th[@data-test-id='th-patient_name-Awaiting']");
	// Locator for getting the count of Awaiting visit field patients
	By awtVstCount = By.xpath("//h6[@data-test-id='Awaiting visits']");
	By awtVstCountLabel = By.xpath("//h6[@data-test-id='Awaiting visits']");
	By awtVstCountAtPaginator = By.xpath("(//*[@class='mat-paginator-range-actions']/div)[3]");
	// Locators of In Progress Patient field in Dashboard Page
	By inprvstPatientField = By.xpath("//th[@data-test-id='th-patient_id-InProgress']");
	// By inprvstAgeField =
	// By.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Age ']");
	By inprvstLocationField = By.xpath("//th[@data-test-id='th-location-InProgress']");
	By inprvstChiefComplaintField = By.xpath("//th[@data-test-id='th-cheif_complaint-InProgress']");
	By inprvstPrescriptionStarted = By.xpath("//th[@data-test-id='th-prescription_started-InProgress']");
	By inprvstPatient1Name = By.xpath("//td[@data-test-id='td-patient_id-InProgress-0']");
	// Locator for getting the count of Awaiting visit field patients
	By inprVstCount = By.xpath("//h6[@data-test-id='In-progress visits']");
	By inprVstCountLabel = By.xpath("//h6[@data-test-id='inprogress-count']");
	By inprVstCountAtPaginator = By.xpath("(//*[@class='mat-paginator-range-actions']/div)[4]");
	By vstsumpatientSectionAge = By.xpath("//p[@data-test-id='etPatientAge']");
	By appointmentCountHeader = By.xpath("//div[@data-test-id='chip-appointments']");
	By priorityCountHeader = By.xpath("//div[@data-test-id='chip-priority']");
	By awaitingCountHeader = By.xpath("//div[@data-test-id='chip-awaiting']");
	By inProgressCountHeader = By.xpath("//div[@data-test-id='chip-inprogress']");
	// Locators of completed visit field in Dashboard Page
	By completePatientField = By.xpath("//th[@data-test-id='th-patient_id-Completed']");
	// By inprvstAgeField =
	// By.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Age ']");
	By completeLocationField = By.xpath("//th[@data-test-id='th-location-Completed']");
	By completeChiefComplaintField = By.xpath("//th[@data-test-id='th-cheif_complaint-Completed']");
	By completevisitcompleted = By.xpath("//th[@data-test-id='th-visit_completed-Completed']");
	By completePatient1Name = By.xpath("//div[@data-test-id='td-patient_name-Completed-0']/div/span");
	// Locator for getting the count of Completed visit field patients
	By completedCount = By.xpath("//h6[@data-test-id='Completed Visits']");
	By completedCountLabel = By.xpath("//h6[@data-test-id='completed-count']");
	By completedCountAtPaginator = By.xpath("(//*[@class='mat-paginator-range-actions']/div)[5]");
///////////Filters/////////
	By icnFilter = By.xpath("(//button[@data-test-id='btnFilterAppointment'])[3]");
	By popupFilter = By.xpath("//div[@class='cdk-overlay-pane']");
	By btnDate = By.xpath("//button[@data-test-id='btnDateModeAppointment']");
	By btnRange = By.xpath("//button[@data-test-id='btnRangeModeAppointment']");
	By btnReset = By.xpath("//button[@data-test-id='btnResetFilterAppointment']");
	By btnApply = By.xpath("//button[@data-test-id='btnApplyFilterAppointment']");
	By txtDateField = By.xpath("//input[@data-test-id='etDate']");
	By icnCalendar = By.xpath("//mat-datepicker-toggle[@data-test-id='dpDate']");
	By icnPreviuosDate = By.xpath("//button[@data-test-id='calendarNavPrevious']");
	By selectDate = By.xpath("//td/div[text()=' 30 ']");
	// Range
	By inpSelectStartDateInRange = By.xpath("//input[@data-test-id='etSelStartDate']");
	By inpSelectEndDateInRange = By.xpath("//input[@data-test-id='etSelEndDate']");
	By icnCalendarStartDate = By.xpath("//mat-datepicker-toggle[@data-test-id='dpStartDate']");
	By icnCalendarEndDate = By.xpath("//mat-datepicker-toggle[@data-test-id='dpEndDate']");
	By icnPreviousInStartDate = By.xpath("//button[@data-test-id='calendarNavPrevious']");
	By selectStartDate = By.xpath("(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[1]");
	By icnNextEndDate = By.xpath("//button[@data-test-id='calendarNavNext']");
	By selectEndDate = By.xpath("(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[1]");
	By searchAwaitingVisits = By.xpath("//input[@data-test-id='etSearch_Awaiting visits']");
	By icnSearchAwaitingVisits = By.xpath("(//span[@data-test-id='icoSearchAppointment'])[3]");
	By lstAwaitingVisitsDates = By.xpath("//td[contains(@data-test-id,'td-visit_created-Awaiting')]");
	By txtNoVisitFound = By.xpath("//td[@class='mat-cell text-center']");
	By lblPatientName = By.xpath("//td[@data-test-id='td-patient_name-Awaiting-0']//span");
	By lblPatientOpenMRSId = By.xpath("//td[@data-test-id='td-patient_id-Awaiting-2']//span");
	By selectFutureDate = By.xpath("(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[30]");
	By icnNext = By.xpath("//span[@data-test-id='spanDateErrorMessageAppointment']");
	By errorMessageWithoutDate = By.xpath("//span[@data-test-id='spanDateErrorMessageAppointment']");
	By errorMessageWithoutFromDate = By.xpath("//span[@data-test-id='spanStartDateErrorMessageAppointment']");
	By errorMessageWithoutToDate = By.xpath("//span[@data-test-id='spanEndDateErrorMessageAppointment']");
	By selectVisitsDate = By.xpath("//span[contains(@id,'mat-calendar-button')]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	@Step("verify Filter Popup")
	public boolean verifyFilterPopup() {
		elementActions.doClick(icnFilter);
		extentReport.logToExtentReport("Clicked on Filters");
		return elementActions.doIsDisplayed(popupFilter) && elementActions.doIsDisplayed(btnDate)
				&& elementActions.doIsDisplayed(btnRange) && elementActions.doIsDisplayed(btnReset)
				&& elementActions.doIsDisplayed(btnApply);
	}

	@Step("verify Filtering Visits By Single Date")
	public boolean verifyFilteringVisitsBySingleDate(String noVisitsFound) {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		// elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doActionsClick(selectDate);
		String selectedDate = elementActions.getAttributeByKey(txtDateField, "placeholder");
		// String inputDate = "30/10/2025";
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");
		LocalDate date = LocalDate.parse(selectedDate, inputFormatter);
		String formattedDate = date.format(outputFormatter);
		elementActions.doClick(btnApply);
		boolean displayedDatesTrue = true;
		if (elementActions.getElements(lstAwaitingVisitsDates).size() != 0) {
			List<WebElement> dates = elementActions.getElements(lstAwaitingVisitsDates);
			for (int i = 0; i < dates.size(); i++) {
				if (!(dates.get(i).getText().equals(formattedDate))) {
					displayedDatesTrue = false;
				}
			}
		} else {
			System.out.println(elementActions.doGetText(txtNoVisitFound).trim());
			System.out.println(noVisitsFound.trim());
			System.out.println(elementActions.doGetText(txtNoVisitFound).trim().equals(noVisitsFound.trim()));

			displayedDatesTrue = elementActions.doGetText(txtNoVisitFound).trim().equals(noVisitsFound.trim());

		}
		return displayedDatesTrue;

	}

	@Step("verify Filtering Visits By Range")
	public boolean verifyFilteringVisitsByRange(String noVisitsFound) {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(icnCalendarEndDate);
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");
		String fromdateone = elementActions.getAttributeByKey(inpSelectStartDateInRange, "placeholder");
		String todateone = elementActions.getAttributeByKey(inpSelectEndDateInRange, "placeholder");
		LocalDate date = LocalDate.parse(fromdateone, inputFormatter);
		LocalDate enddate = LocalDate.parse(todateone, inputFormatter);
		String formattedFromDate = date.format(outputFormatter);
		String formattedToDate = enddate.format(outputFormatter);

		// From & To dates selected in UI
		/*
		 * LocalDate fromDate =
		 * LocalDate.parse(elementActions.getAttributeByKey(inpSelectStartDateInRange,
		 * "placeholder"), formatter); LocalDate toDate =
		 * LocalDate.parse(elementActions.getAttributeByKey(inpSelectEndDateInRange,
		 * "placeholder"), formatter);
		 */
		elementActions.doClick(btnApply);
		// Dates displayed in UI
		boolean displayedDatesTrue = true;
		List<WebElement> dates = elementActions.getElements(lstAwaitingVisitsDates);
		if (elementActions.getElements(lstAwaitingVisitsDates).size() != 0) {
			for (WebElement visitDateElement : dates) {
				String visitDateText = visitDateElement.getText().trim();
				LocalDate visitDate = LocalDate.parse(visitDateText, formatter);
				if (visitDate.isBefore(date) || visitDate.isAfter(enddate)) {
					throw new AssertionError("Visit date out of range: " + visitDateText);
				}
			}
			// verify the visits are present in this dates.... write code
		} else {
			System.out.println(elementActions.doGetText(txtNoVisitFound).trim());
			System.out.println(noVisitsFound.trim());
			System.out.println(elementActions.doGetText(txtNoVisitFound).trim().equals(noVisitsFound.trim()));
			return displayedDatesTrue = elementActions.doGetText(txtNoVisitFound).trim().equals(noVisitsFound.trim());
		}
		return displayedDatesTrue;
	}

	@Step("verify Reset Button Functionality AfterApplying Filter In Date")
	public String verifyResetButtonFunctionalityAfterApplyingFilterInDate() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(selectDate);
		elementActions.doClick(btnApply);
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnReset);
		elementActions.doClick(icnFilter);
		return elementActions.getAttributeByKey(txtDateField, "placeholder");
	}

	@Step("verify Reset Button Functionality")
	public String verifyResetButtonFunctionality() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(selectDate);
		elementActions.doClick(btnReset);
		return elementActions.getAttributeByKey(txtDateField, "placeholder");
	}

	@Step("verify ResetButton Functionality In Range After Applying Filter")
	public List<String> verifyResetButtonFunctionalityInRangeAfterApplyingFilter() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(icnCalendarEndDate);
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		elementActions.doClick(btnApply);
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnReset);
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);

		return Arrays.asList(elementActions.getAttributeByKey(inpSelectStartDateInRange, "placeholder"),
				elementActions.getAttributeByKey(inpSelectEndDateInRange, "placeholder"));
	}

	@Step("verify Reset Button Functionality In Range")
	public List<String> verifyResetButtonFunctionalityInRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(icnCalendarEndDate);
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		elementActions.doClick(btnReset);

		return Arrays.asList(elementActions.getAttributeByKey(inpSelectStartDateInRange, "placeholder"),
				elementActions.getAttributeByKey(inpSelectEndDateInRange, "placeholder"));
	}

	@Step("verify Apply Button Functionality Without Selecting Date")
	public String verifyApplyButtonFunctionalityWithoutSelectingDate() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(btnApply);

		return elementActions.doGetText(errorMessageWithoutDate);

	}

	@Step("verify Apply Button Functionality Without Selecting Range")
	public List<String> verifyApplyButtonFunctionalityWithoutSelectingRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(btnApply);
		return Arrays.asList(elementActions.doGetText(errorMessageWithoutFromDate),
				elementActions.doGetText(errorMessageWithoutToDate));

	}

	@Step("verifyApplyButtonFunctionalityWithoutSelectingFromDAteINRange")
	public String verifyApplyButtonFunctionalityWithoutSelectingFromDAteINRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarEndDate);
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		elementActions.doClick(btnApply);
		// add code for error message
		return elementActions.doGetText(errorMessageWithoutFromDate);

	}

	@Step("verifyApplyButtonFunctionalityWithoutSelectingTODAteINRange")
	public String verifyApplyButtonFunctionalityWithoutSelectingTODAteINRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(btnApply);
		return elementActions.doGetText(errorMessageWithoutToDate);

	}

	@Step("verifyResetButtonFunctionalityWithoutSelectingDate")
	public boolean verifyResetButtonFunctionalityWithoutSelectingDate() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(btnReset);
		return elementActions.doIsDisplayed(icnFilter);

	}

	@Step("verifyResetButtonFunctionalityWithoutSelectingRange")
	public boolean verifyResetButtonFunctionalityWithoutSelectingRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(btnReset);
		return elementActions.doIsDisplayed(icnFilter);

	}

	@Step("verify Filter Date When No Visits")
	public String verifyFilterDateWhenNoVisits() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		selectDateInFilter("NOV");
		elementActions.doClick(btnApply);
		
		return elementActions.doGetText(txtNoVisitFound);
	}

	public void selectDateInFilter(String monthToSelect) {
		// Logic to select the date based on the input string
		// This is a placeholder implementation; actual implementation may vary
		while (true) {
			String displayedMonthYear = elementActions.doGetText(selectVisitsDate);
			if (displayedMonthYear.contains(monthToSelect)) {
				elementActions.doClick(selectDate);
				break;
			} else {
				elementActions.doClick(icnPreviuosDate);
			}
		}

		/*
		 * for (int i = 0; i < 10; i++) { if
		 * (elementActions.doGetText(selectVisitsDate).contains(monthToSelect)) {
		 * elementActions.doClick(selectDate); break; } else {
		 * elementActions.doClick(icnPreviuosDate); }
		 * 
		 * }
		 */
	}

	@Step("verify Filter Range When No Visits")
	public String verifyFilterRangeWhenNoVisits() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		selectDateInFilter("NOV");
		elementActions.doClick(icnCalendarEndDate);
		selectDateInFilter("NOV");
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(btnApply);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(icnCalendarEndDate);
		// elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		// elementActions.doClick(btnReset);
		return elementActions.doGetText(txtNoVisitFound);
	}

	@Step("verify Filter PopupClosesAfterApply")
	public boolean verifyFilterPopupClosesAfterApply() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(selectDate);
		elementActions.doClick(btnApply);
		return elementActions.doIsDisplayed(popupFilter);
	}

	@Step("verify Filter Works Along With Search VisitBy OpenMRSId")
	public boolean verifyFilterWorksAlongWithSearchVisitByOpenMRSId() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(icnPreviuosDate);
		elementActions.doClick(selectDate);
		elementActions.doClick(btnApply);
		String searchVisit = elementActions.doGetText(lblPatientOpenMRSId);
		elementActions.doSendKeys(searchAwaitingVisits, searchVisit);
		String resultOfSearchVisit = elementActions.doGetText(lblPatientOpenMRSId);
		if (searchVisit.equals(resultOfSearchVisit)) {
			return true;

		} else {
			return false;
		}
	}

	@Step("verifyFilterWorksAlongWithSearchVisitByName")
	public boolean verifyFilterWorksAlongWithSearchVisitByName() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendar);

		for (int i = 0; i < 10; i++) {
			System.out.println(elementActions.doGetText(selectVisitsDate));
			if (elementActions.doGetText(selectVisitsDate).contains("OCT")) {
				elementActions.doClick(selectDate);
				break;
			} else {
				elementActions.doClick(icnPreviuosDate);
			}
		}
		elementActions.doClick(btnApply);
		String searchVisit = elementActions.doGetText(lblPatientName);
		System.out.println(searchVisit);
		elementActions.doSendKeys(searchAwaitingVisits, searchVisit.split(" ")[0]);
		// elementActions.doClick(icnSearchAwaitingVisits);
		String resultOfSearchVisit = elementActions.doGetText(lblPatientName);
		if (searchVisit.equals(resultOfSearchVisit)) {
			return true;
		} else {
			return false;
		}
	}

	@Step("VerifyApplyButtonBySelectingFromDateInRange")
	public void VerifyApplyButtonBySelectingFromDateInRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnPreviousInStartDate);
		elementActions.doClick(selectStartDate);
		elementActions.doClick(btnApply);

		// add code for error message
	}

	@Step("VerifyApplyButtonBySelectingToDateInRange")
	public void VerifyApplyButtonBySelectingToDateInRange() {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnRange);
		elementActions.doClick(icnCalendarEndDate);
		elementActions.doClick(icnNextEndDate);
		elementActions.doClick(selectEndDate);
		elementActions.doClick(btnApply);

		// add code for error message
	}

	@Step("Verify Filtering Appointments By Selecting FutureDate")
	public boolean verifyFilteringVisitsBySelectingFutureDate(String noVisitsFound) {
		elementActions.doClick(icnFilter);
		elementActions.doClick(btnDate);
		elementActions.doClick(icnCalendarStartDate);
		elementActions.doClick(icnNext);
		elementActions.doClick(selectFutureDate);
		String selectedDate = elementActions.doGetText(txtDateField);
		elementActions.doClick(btnApply);
		boolean displayedDatesTrue = true;
		if (elementActions.getElements(lstAwaitingVisitsDates).size() != 0) {
			List<WebElement> dates = elementActions.getElements(lstAwaitingVisitsDates);
			for (int i = 0; i < dates.size(); i++) {
				if (!(dates.get(i).getText().equals(selectedDate))) {
					displayedDatesTrue = false;
				}
			}
		} else {
			displayedDatesTrue = elementActions.doGetText(txtNoVisitFound).equals(noVisitsFound);

		}
		return displayedDatesTrue;

	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to verify if the user is logged in successfully
	 */
	public String isUSerLoggedIn() {
		elementActions.waitForElementPresent(loggedInUserName);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		if (elementActions.doIsDisplayed(loggedInUserName)) {
			return elementActions.doGetText(loggedInUserName);
		}
		return null;
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to log out from application successfully
	 */
	@Step("Logout from application")
	public void dologout() {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from left panel");
		elementActions.doClick(logoutConfirmYesBtn);
		extentReport.logToExtentReport("Clicked on Yes button from Logout confirm popup");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to verify the elements displayed in Dashboard.
	 */
//	@Step("verify dashboard page contents")
	public void verifyDashboardComponents() {
		extentReport.logToExtentReport("User Profile is displayed");
		elementActions.doIsDisplayed(loggedInUserName);
		extentReport.logToExtentReport("Logged in Username is displayed");
		elementActions.doIsDisplayed(dashboardLink);
		extentReport.logToExtentReport("Dashboard is displayed in left panel");
		extentReport.logToExtentReport("Dashboard link is displayed in left panel");
		elementActions.doIsDisplayed(messagesLink);
		extentReport.logToExtentReport("Messages link is displayed in left panel");
		elementActions.doIsDisplayed(appointmentLink);
		extentReport.logToExtentReport("Appointment link is displayed in left panel");
		elementActions.doIsDisplayed(calendarLink);
		extentReport.logToExtentReport("Claendar link is displayed in left panel");
		elementActions.doIsDisplayed(prescriptionLink);
		extentReport.logToExtentReport("Prescription link is displayed in left panel");
		elementActions.doIsDisplayed(helpsupportLink);
		extentReport.logToExtentReport("Help Support link is displayed");
		elementActions.doIsDisplayed(logoutLink);
		extentReport.logToExtentReport("Logout link is displayed");
		elementActions.doIsDisplayed(searchpatientTextbox);
		extentReport.logToExtentReport("Search Patient textbox is displayed");
		elementActions.doIsDisplayed(searchpatientIcon);
		extentReport.logToExtentReport("Search Patient icon is displayed");
		elementActions.doIsDisplayed(helpChatBot);
		extentReport.logToExtentReport("Help Chat bot is displayed");
		elementActions.doIsDisplayed(notificationIcon);
		extentReport.logToExtentReport("Notification icon is displayed");
		// elementActions.doIsDisplayed(kebabMenu);
		extentReport.logToExtentReport("Menu is displayed");
		elementActions.doIsDisplayed(appointmentsLabel);
		extentReport.logToExtentReport("Appointment label is displayed");
		elementActions.doIsDisplayed(priorityvisitLabel);
		extentReport.logToExtentReport("Priority visit label is displayed");
		elementActions.doIsDisplayed(awaitingvisitLabel);
		extentReport.logToExtentReport("Awaiting visit label is displayed");
		elementActions.doIsDisplayed(inprogressvisitLabel);
		extentReport.logToExtentReport("In progress visit label is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Priority visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void VerificationLog() {
		extentReport.logToExtentReport("All Dashboard components are displayed correctly");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Priority visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void verifyDashboardPriorityVisitField() {
		elementActions.doIsDisplayed(prvstPatientField);
		extentReport.logToExtentReport("priority visit patient field is displayed");
		// elementActions.doIsDisplayed(prvstAgeField);
		// extentReport.logToExtentReport("priority visit age field is displayed");
		elementActions.doIsDisplayed(prvstLocationField);
		extentReport.logToExtentReport("priority visit location field is displayed");
		elementActions.doIsDisplayed(prvstChiefComplaintField);
		extentReport.logToExtentReport("priority visit Chief Complaint field is displayed");
		elementActions.doIsDisplayed(prvstVisitUploadedField);
		extentReport.logToExtentReport("priority visit Uploaded field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Awaiting visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void verifyDashboardAwaitingVisitField() {
		elementActions.doIsDisplayed(awtvstPatientField);
		extentReport.logToExtentReport("awaiting visit Uploaded field is displayed");
		elementActions.doIsDisplayed(awtvstAgeField);
		extentReport.logToExtentReport("awaiting visit age field is displayed");
		elementActions.doIsDisplayed(awtvstLocationField);
		extentReport.logToExtentReport("awaiting visit location field is displayed");
		elementActions.doIsDisplayed(awtvstChiefComplaintField);
		extentReport.logToExtentReport("awaiting visit Chief Complaint field is displayed");
		elementActions.doIsDisplayed(awtvstVisitUploadedField);
		extentReport.logToExtentReport("awaiting visit Uploaded field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Appointment visit table
	 */
	@Step("verify dashboard page Appointments field contents")
	public void verifyDashboardAppointmentVisitField() {
		elementActions.doIsDisplayed(aptPatientField);
		extentReport.logToExtentReport("appointment patient field is displayed");
		elementActions.doIsDisplayed(aptAgeField);
		extentReport.logToExtentReport("appointment patient age field is displayed");
		elementActions.doIsDisplayed(aptStartsInField);
		extentReport.logToExtentReport("appointment patient Starts in field is displayed");
		elementActions.doIsDisplayed(aptLocationField);
		extentReport.logToExtentReport("appointment patient Location field is displayed");
		elementActions.doIsDisplayed(aptChiefComplaintField);
		extentReport.logToExtentReport("appointment patient Chief Complaint field is displayed");
		elementActions.doIsDisplayed(aptActionsField);
		extentReport.logToExtentReport("appointment patient Actions field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of InProgress visit table
	 */
	@Step("verify dashboard page Inprogress field contents")
	public void verifyDashboardInProgressVisitField() {
		elementActions.doIsDisplayed(inprvstPatientField);
		extentReport.logToExtentReport("in progress patient field is displayed");
		// elementActions.doIsDisplayed(inprvstAgeField);
		// extentReport.logToExtentReport("in progress patient Age field is displayed");
		elementActions.doIsDisplayed(inprvstLocationField);
		extentReport.logToExtentReport("in progress patient Location field is displayed");
		elementActions.doIsDisplayed(inprvstChiefComplaintField);
		extentReport.logToExtentReport("in progress patient Chief Complaint field is displayed");
		elementActions.doIsDisplayed(inprvstPrescriptionStarted);
		extentReport.logToExtentReport("in progress patient Prescriptions field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointment navigate to Visit summary page
	 */
	@Step("verify click on appointments Patient navigate to Visit summary page")
	public void verifyPatientCountHeader() {

		elementActions.doIsDisplayed(appointmentCountHeader);
		extentReport.logToExtentReport("Appointment Patient count is displayed in Header");
		elementActions.doIsDisplayed(priorityCountHeader);
		extentReport.logToExtentReport("Priority Visit Count is displayed in Header");
		elementActions.doIsDisplayed(awaitingCountHeader);
		extentReport.logToExtentReport("Awaiting visit count is displayed in Header");
		elementActions.doIsDisplayed(inProgressCountHeader);
		extentReport.logToExtentReport("In Progress Visit count is displayed in header");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointment navigate to Visit summary page
	 */
	@Step("verify click on appointments Patient navigate to Visit summary page")
	public void clickAptPatient() {
		if (elementActions.doIsDisplayed(apPatient1Name) == true) {
			elementActions.doClick(apPatient1Name);
			extentReport.logToExtentReport("Clicked on 1st Appointment Patient");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit Summary Patient page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointments visit count displayed correctly
	 */
	@Step("Verify that Appointments visits header shows the correct count of Apointment visits")
	public void ApntmtsCount() {
		String AptCtAtPaginator = elementActions.getLastChar1(aptCountAtPaginator, 1).trim();
		extentReport.logToExtentReport("Count displayed at Paginator" + AptCtAtPaginator);
		String aptCTAtLabel = elementActions.getLastChar(aptCountLabel, 1).replace("(", "").replace(")", "");
		extentReport.logToExtentReport("Count displayed at Label" + aptCTAtLabel);
		if (AptCtAtPaginator.equals(aptCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Priority visit patient navigate to visit summary page
	 */
	@Step("verify click on Priority Visit Patient navigate to Visit summary page")
	public void clickPrPatient() {
		if (elementActions.doIsDisplayed(prvstPatient1Name) == true) {
			elementActions.doClick(prvstPatient1Name);
			extentReport.logToExtentReport("Clicked on Priority visit 1st patient from the table");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit Summary Patient page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Priority visits header shows the correct count of Priority visits
	 */
	@Step("Verify that Priority visits header shows the correct count of Priority visits")
	public void PrVstCount() {
		String prVstCtAtPaginator = elementActions.getLastChar1(prVstCountAtPaginator, 1).trim();
		extentReport.logToExtentReport("Count displayed at Paginator" + prVstCtAtPaginator);
		String prVstCTAtLabel = elementActions.getLastChar(prVstCountLabel, 1).replace("(", "").replace(")", "");
		extentReport.logToExtentReport("Count displayed at Label" + prVstCTAtLabel);
		if (prVstCtAtPaginator.equals(prVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Awaiting visits header shows the correct count of Awaiting visits
	 */
	@Step("Verify that Awaiting visits header shows the correct count of Awaiting visits")
	public void awVstCount() {
		String awtVstCtAtPaginator = elementActions.getLastChar1(awtVstCountAtPaginator, 1).trim();
		extentReport.logToExtentReport("Count displayed at Paginator" + awtVstCtAtPaginator);
		String awtVstCTAtLabel = elementActions.getLastChar(awtVstCountLabel, 1).replace("(", "").replace(")", "");
		extentReport.logToExtentReport("Count displayed at Label" + awtVstCTAtLabel);
		if (awtVstCtAtPaginator.equals(awtVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Awaiting Visit Patient navigate to Visit summary page
	 */
	@Step("verify click on Awaiting Visit Patient navigate to Visit summary page")
	public void clickawtVstPatient() {
		if (elementActions.doIsDisplayed(awtvstPatient1Name) == true) {
			elementActions.doClick(awtvstPatient1Name);
			extentReport.logToExtentReport("Clicked on 1st Awaiting visit patient from the table");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit summary page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify In-progress visits header shows the correct count of In-progress
	 * visits
	 */
	@Step("Verify that In-progress visits header shows the correct count of In-progress visits")
	public void inprVstCount() {
		String inprVstCtAtPaginator = elementActions.doGetText(inprVstCountAtPaginator).trim();
		extentReport.logToExtentReport("Count displayed at Paginator" + inprVstCtAtPaginator);
		String inprVstCTAtLabel = elementActions.doGetText(inprVstCountLabel).replace("(", "").replace(")", "");
		extentReport.logToExtentReport("Count displayed at Label" + inprVstCTAtLabel);
		if (inprVstCtAtPaginator.contains(inprVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify in progress Visit Patient navigate to Visit summary page
	 */
	@Step("verify click on in progress Visit Patient navigate to Visit summary page")
	public void clickInprPatient() {
		if (elementActions.doIsDisplayed(inprvstPatient1Name) == true) {
			elementActions.doClick(inprvstPatient1Name);
			extentReport.logToExtentReport("Clicked on in progress Visit 1st patient");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit summary page is displayed");
		} else {
			fail();
		}
	}

	@Step("verify click on complete Visit Patient navigate to Visit summary page")
	public void clickcompletePatient() {
		if (elementActions.doIsDisplayed(completePatient1Name) == true) {
			elementActions.doClick(completePatient1Name);
			extentReport.logToExtentReport("Clicked on complete 1st patient");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit summary page is displayed");
		} else {
			fail();
		}
	}
}