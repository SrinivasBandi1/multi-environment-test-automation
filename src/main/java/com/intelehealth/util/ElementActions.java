package com.intelehealth.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
//import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intelehealth.listeners.ExtentReportListener;

public class ElementActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	ExtentReportListener extentReport = new ExtentReportListener();

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(this.driver);
	}

	public WebElement getElement(By locator) throws StaleElementReferenceException {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
		}
		return element;
	}

	/*
	 * Description : To handle multiple web elements Date : 14/09/2023
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {

		}
		return element;
	}

	public void doClick(By locator) {
		// Wait for the element to be clickable before clicking
//		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		int maxRetries = 5;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				WebElement ele = getElement(locator);
				WebElement click = wait.until(ExpectedConditions.elementToBeClickable(ele));
				click.click();
				// If click succeeds, break out of the loop
				break;
			} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
				extentReport.logToExtentReport("Caught exception: " + e.getMessage());
				extentReport.logToExtentReport("Retrying...");
				retryCount++;

			}
		}
	}

	public void switchToTabByTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			driver.switchTo().window(handle);
			String actualTitle = driver.getTitle();
			if (expectedTitle.equals(actualTitle)) {
				TestUtils.log().info("Switched to tab with title: " + actualTitle);
				return;
			}
		}
	}

	public void switchToTabByUrl(String expectedUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			driver.switchTo().window(handle);
			String actualUrl = driver.getCurrentUrl();
			if (expectedUrl.equals(actualUrl)) {
				TestUtils.log().info("Switched to tab with URL: " + actualUrl);
				return;
			}
		}

		throw new RuntimeException("No tab with URL '" + expectedUrl + "' found.");
	}

	public String getAttributeByKey(By by, String attributeName) {
		try {
			WebElement element = driver.findElement(by);
			return element.getAttribute(attributeName);
		} catch (Exception e) {
			TestUtils.log().info("Error retrieving attribute value: " + e.getMessage());
			return null;
		}
	}

	/*
	 * Description : To select Date : 14/09/2023
	 */
	public void doSelect(By locator) {
		getElement(locator).isSelected();
		if (!getElement(locator).isSelected()) {
			getElement(locator).click();
		}
	}

	/*
	 * Description : To select multiple elements Date : 14/09/2023
	 */
	public void doSelectMultipleElements(By locator) {

		try {
			List<WebElement> variable = getElements(locator);
			for (WebElement element : getElements(locator)) {
				if (element.isEnabled()) {
					element.click();
				}
			}
		} catch (Exception e) {

		}
	}

	/*
	 * Description : To iterate Date : 14/09/2023
	 */
	public void doIterate(By locator) {
		int numberOfIterations = 3;

		for (int i = 0; i <= numberOfIterations; i++) {
			getElement(locator).click();
		}
	}

	public void doActionsClick(By locator) {
		action.click(getElement(locator)).build().perform();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doSendActionKeys(By locator, Keys keys) {
		getElement(locator).sendKeys(keys);
	}

	/*
	 * Description : Right arrow Created Date : 08/09/2023
	 */
	public void doSendKeysRightArrow(By locator) {
		getElement(locator).sendKeys(Keys.ARROW_RIGHT);
	}

	// to get the last character from a string
	public String getLastChar(By locator, int i) {
		String text = driver.findElement(locator).getText();
		if (text.length() < 3) {
			throw new IllegalArgumentException("The text is too short to extract the last 2nd and 3rd characters.");
		}
		// Extract the last 2nd and 3rd characters
		char lastSecondChar = text.charAt(text.length() - 2);
		char lastThirdChar = text.charAt(text.length() - 3);
		return String.valueOf(lastThirdChar) + lastSecondChar;
	}

	// to get the last character from a string
	public String getLastChar1(By locator, int i) {
		String text = driver.findElement(locator).getText();
		if (text.length() < 3) {
			throw new IllegalArgumentException("The text is too short to extract the last 2nd and 3rd characters.");
		}
		char lastSecondChar = text.charAt(text.length() - 1);
		char lastThirdChar = text.charAt(text.length() - 2);
		return String.valueOf(lastThirdChar) + lastSecondChar;
	}

	/*
	 * Description : Get the current time Created Date : 28/09/2023
	 */

	public Object GetCurrentTime() throws Throwable {

		// Define the time format
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh");

		// Get the current time
		Date currentTime = new Date();

		// Parse the rescheduled time
		Date rescheduledTime = timeFormat.parse("12");

		// Calculate the time difference in milliseconds
		long timeDifference = rescheduledTime.getTime() - currentTime.getTime();

		// Calculate hours and minutes
		long roundedHours = Math.round((double) timeDifference / 3600000); // 3600000 milliseconds = 1 hour
		// long minutes = (timeDifference % 3600000) / 60000; // 60000 milliseconds = 1
		// minute

		// Ensure a minimum of 1 hour
		if (roundedHours == 0) {
			roundedHours = 1;
		}

		// Print or use the time difference
		TestUtils.log().info("Time Difference: " + roundedHours + " hours");
		return timeDifference;

	}

	/*
	 * Description : Click Enter Created Date : 08/09/2023
	 */

	public void doSendKeysEnter(By locator) {
		getElement(locator).sendKeys(Keys.ENTER);
	}

	/*
	 * Description : Click Enter Created Date : 08/09/2023
	 */

	public void doClearTextbox(By locator) {
		getElement(locator).clear();
		;
	}

	public void doActionsSendKeys(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}

	/*
	 * Description : To select second next of current date Created Date : 08/09/2023
	 */
	public By doActionsSendKeysRightEnter(By locator) {
		getElement(locator).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER);
		return locator;
	}

	/*
	 * Description : Element is displayed or not Created Date : 08/09/2023
	 */
	public boolean doIsDisplayed2(By locator) throws StaleElementReferenceException {
		WebElement element = getElement(locator);

		if (element != null && element.isDisplayed()) {
			TestUtils.log().info("Element is displayed");
			return true;
		} else {
			TestUtils.log().info("Element is not displayed");
			return false;
		}
	}

	public boolean doIsDisplayedElementList(By locator) throws StaleElementReferenceException {
		List<WebElement> elements = getElements(locator);
		for (WebElement element : elements) {
			if (element != null && element.isDisplayed()) {
				TestUtils.log().info("Element is displayed");
				return true;
			} else {
				TestUtils.log().info("Element is not displayed");
				return false;
			}
		}
		return false;
	}
	

	/*
	 * Description : To check the element us enable or not Created Date : 09/10/2023
	 */

	public boolean doIsEnabled(By locator) {

		boolean value = getElement(locator).isEnabled();
		return value;

	}

	/*
	 * Description : String is displayed or not Created Date : 08/09/2023
	 */
	public boolean doIsDisplayedString(By value) {
		WebElement element = driver.findElement(value);

		if (element != null && element.isDisplayed()) {
			TestUtils.log().info("Value is not displayed");
			return true;
		} else {
			TestUtils.log().info("Value is displayed");
			return false;
		}
	}

	/*
	 * Description : Element is displayed or not Created Date : 08/09/2023
	 */
	/**
	 * Updated By @SrinivasBandi o 1st OCtober 2024 <<<<<<< HEAD =======
	 * 
	 * >>>>>>> e7700028832757d314125df4aee25f8108ab7ac8
	 * 
	 * @param locator
	 * @param string
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element.isDisplayed();
		} catch (Exception e) {
			
			System.out.println(e);
			return false;
		}

	}

	public boolean isToastMessagePresent(By locator) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			TestUtils.log().info("Element is displayed");
			return true;
		} else {
			TestUtils.log().info("Element is not displayed");
			return false;
		}

	}


	public String doGetAttributebyValue(By locator) {
		return getElement(locator).getAttribute("value");
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	/*
	 * Description : To verify the text of Expected and Actual Created Date :
	 * 08/09/2023
	 */
	public boolean VerifyText(By locator, By string) {
		String Expected = getElement(locator).getText();
		String Actual = getElement(locator).getText();
		if (Actual.contains(Expected)) {
			TestUtils.log().info("Text verified successfully");
		} else {
			TestUtils.log().info("Text verification failed");
		}
		return true;
	}

	/*
	 * Description : To verify the text of Actual and value Created Date :
	 * 29/09/2023
	 */
	public boolean VerifyText2(By locator, String value) {
		String Actual = getElement(locator).getText();
		if (Actual.equalsIgnoreCase(value)) {
			TestUtils.log().info("Text verified successfully");
			return true;
		} else {
			TestUtils.log().info("Text verification failed");
			return false;
		}

	}

	/*
	 * Description : To verify the text of Expected and Actual Created Date :
	 * 08/09/2023
	 */

	public void VerifyTextString(By locator, String currentDate) {
		String Expected = getElement(locator).getText();
		String Actual = getElement(locator).getText();
		if (Actual.equalsIgnoreCase(Expected)) {
			TestUtils.log().info("Text verified successfully");
		} else {
			TestUtils.log().info("Text verification failed");
		}
		return;
	}

	/*
	 * Description : Scroll by using Javascript executor Created Date : 11/09/2023
	 */
	public void doScrollByJavaScriptExecutor(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView", getElement(locator));
		getElement(locator).click();
	}

	/*
	 * Description : Right arrow and Enter by using Robot class Created Date :
	 * 11/09/2023
	 */
	public Object doRightArrowEnterByRobot(By locator) throws Throwable {
		Robot robot = new Robot();

		for (int i = 0; i < 8; i++) {
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
		}
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return locator;
	}

	/*
	 * Description : Scroll by using Robot class(one va;lue) Created Date :
	 * 11/09/2023
	 */
	public void doTabEnterByRobot(By locator) throws Throwable {
		Robot robot = new Robot();

		for (int i = 0; i < 1; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

		}

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/*
	 * Description : Get Attribute value by class Created Date : 08/09/2023
	 */
	public boolean dogetAttributeEmptybyClass(By locator) {
		boolean value = getElement(locator).getAttribute("class").isEmpty();
		// TestUtils.log().info(value);
		if (value == true) {
			TestUtils.log().info("The field is empty");
		}
		if (value == false) {
			TestUtils.log().info("The field is not empty");
		}
		return value;
	}	
	public String dogetAttributebyValue(By locator) {
		return getElement(locator).getAttribute("value");
	}

	/*
	 * Description : To verify the selected or not Created Date : 08/09/2023
	 */
	public boolean doIsSelected(By locator) {

		boolean value = getElement(locator).isSelected();
		if (value == true) {
			TestUtils.log().info("Selected");
		}
		if (value == false) {
			TestUtils.log().info("Not selected");
		}
		return value;
	}

	/*
	 * Description : Get Attribute value by id Created Date : 08/09/2023
	 */
	public boolean dogetAttributeEmptybyId(By locator) {
		boolean value = getElement(locator).getAttribute("id").isEmpty();
		// TestUtils.log().info(value);
		if (value == true) {
			TestUtils.log().info("The field is empty");
		}
		if (value == false) {
			TestUtils.log().info("The field is not empty");
		}
		return value;
	}

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/*
	 * Description : Wait for the element to be visible and then click Created Date
	 * : 12/09/2023
	 */
	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		WebElement click = wait.until(ExpectedConditions.visibilityOf(ele));
		click.click();
	}

	/*
	 * Description : Wait for the element to be clickable Created Date : 11/09/2023
	 */


	public void waitForElementClickable(By locator) throws InterruptedException {
		int maxRetries = 5;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				WebElement ele = getElement(locator);
				WebElement click = wait.until(ExpectedConditions.elementToBeClickable(ele));
				click.click();
				// If click succeeds, break out of the loop
				break;
			} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
				extentReport.logToExtentReport("Caught exception: " + e.getMessage());
				extentReport.logToExtentReport("Retrying...");
				retryCount++;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Thread.sleep(2000);
			}
		}
	}

	/*
	 * Description : move for the web element and to be click Created Date :
	 * 11/09/2023
	 */
	public void moveToWebElementAndClick(WebElement element) throws Throwable {
		Actions act = new Actions(driver);
		int maxRetries = 5;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				act.moveToElement(element).click().perform();
				// If click succeeds, break out of the loop
				break;
			} catch (ElementClickInterceptedException e) {
				extentReport.logToExtentReport("Element click intercepted. Retrying...");
				retryCount++;
				Thread.sleep(2000);
			}
		}
	}

	/*
	 * Description : to verify the gender and age - ID-1896 Created Date :
	 * 20/09/2023
	 */
	public char[] doGetLastChar(By locator) {
		String text = driver.findElement(locator).getText();
		char Age = text.charAt(text.length() - 2);
		char Age1 = text.charAt(text.length() - 3);
		char Gender1 = text.charAt(text.length() - 6);
		char Gender2 = text.charAt(text.length() - 5);

		if (Character.isDigit(Age1)) {
			if (Character.isLetter(Gender1)) {
				return new char[] { Gender1, Gender2 };
			}
		} else if (Character.isDigit(Age)) {
			if (Character.isLetter(Gender2)) {
				return new char[] { Gender1, Gender2 };
			}
		}
		// Handle the case where the conditions are not met
		return new char[0];
	}

	/*
	 * Description : to verify the first character is digit Created Date :
	 * 24/09/2023
	 */
	public char doGetFirstChar(By locator) {
		String text = driver.findElement(locator).getText();
		char FollwUpVisit = text.charAt(0);
		char Appointment = text.charAt(0);
		if (Character.isDigit(Appointment)) {
			TestUtils.log().info("No. of appointments are displayed");
		}
		if (Character.isDigit(FollwUpVisit)) {
			TestUtils.log().info("No. of follow-up visits are displayed");
		}
		return Appointment;
	}

	public char doGetLastOneChar(By locator) {
		String text = driver.findElement(locator).getText();
		char FollwUps = text.charAt(12);
		char Appointment = text.charAt(12);
		try {
			char Appointments = text.charAt(14);
			if (Character.isDigit(Appointments)) {
				return Appointments;
			}
		} catch (Exception e) {
		}
		if (Character.isDigit(Appointment)) {
			return Appointment;
		}
		if (Character.isDigit(FollwUps)) {
			return FollwUps;
		}
		return Appointment;
	}

	/*
	 * Description : to get the background color Created Date : 25/09/2023
	 */
	public String doGetHighlightedInBlueColor(WebElement dateElement) {
		String backgroundColor = dateElement.getCssValue("background-color");
		TestUtils.log().info("Background Color: " + backgroundColor);
		if (backgroundColor.contains("rgba(75, 57, 183, 1)")) {
			TestUtils.log().info("Current date is highlighted with blue color.");

		} else {
			TestUtils.log().info("Current date is NOT highlighted with blue color.");
		}

		return backgroundColor;
	}

	/*
	 * Description : format and get current date Created Date : 25/09/2023
	 */
	public CharSequence doGetFormattedCurrentDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd EEE");
		String formattedDate = dateformat.format(currentDate).toUpperCase();
		TestUtils.log().info("Current Date:" + formattedDate);
		return formattedDate;
	}

	/*
	 * Description : format and get current date Created Date : 25/09/2023
	 */
	public CharSequence doGetFormattedCurrentDDMMYYYY() {
		Date currentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd EEE, YYYY");
		String formattedDate = dateformat.format(currentDate);
		TestUtils.log().info("Current Date:" + formattedDate);
		return formattedDate;
	}

	/*
	 * Description : format and get current date Created Date : 27/09/2023
	 */
	public String doGetFormattedCurrentDDMonYYYY() {
		Date currentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
		String formattedDate = dateformat.format(currentDate);
		TestUtils.log().info("Current Date: " + formattedDate);
		return formattedDate;
	}

	/*
	 * Description : to get the background color Created Date : 25/09/2023
	 */
	public String doGetHighlightedInBlueColorOnlyDate(WebElement dateElement) {
		String backgroundColor = dateElement.getCssValue("color");
		TestUtils.log().info("Background Color: " + backgroundColor);
		if (backgroundColor.contains("rgba(255, 255, 255, 1)")) {
			TestUtils.log().info("Current date is highlighted with blue color.");

		} else {
			TestUtils.log().info("Current date is NOT highlighted with blue color.");
		}

		return backgroundColor;
	}

	/*
	 * Description : format and get current date Created Date : 25/09/2023
	 */
	public CharSequence doGetFormattedCurrentOnlyDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd");
		String formattedDate = dateformat.format(currentDate).toUpperCase();
		TestUtils.log().info("Current Date:" + formattedDate);
		return formattedDate;
	}

	/*
	 * Description : to get the current week Created Date : 20/09/2023
	 */
	public List<String> CurrentWeekDatesAndDays() {

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Calculate the start date (Monday) of the current week
		LocalDate startDate = currentDate.with(DayOfWeek.MONDAY);

		// Create a list to store dates and days
		List<String> datesAndDays = new ArrayList<>();

		// Iterate through the week and add each date and day to the list
		for (int i = 0; i < 7; i++) {
			// Format the date to "d MMM"
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d EEE", Locale.ENGLISH);
			String formattedDate = startDate.format(formatter).toUpperCase(); // Converting to Uppercase

			// Add the formatted date and day to the list
			datesAndDays.add(formattedDate + " ");

			// Move to the next day
			startDate = startDate.plusDays(1);
			// break;
		}
		return datesAndDays;
	}

	/*
	 * Description : to get the next week Created Date : 07/15/2024
	 */
	public List<String> NextWeekDatesAndDays() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Calculate the start date (Monday) of the next week
		LocalDate startDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

		// Create a list to store dates and days
		List<String> datesAndDays = new ArrayList<>();

		// Iterate through the next week and add each date and day to the list
		for (int i = 0; i < 7; i++) {
			// Format the date to "d EEE"
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d EEE", Locale.ENGLISH);
			String formattedDate = startDate.format(formatter).toUpperCase(); // Converting to Uppercase

			// Add the formatted date and day to the list
			datesAndDays.add(formattedDate);

			// Move to the next day
			startDate = startDate.plusDays(1);
		}
		return datesAndDays;
	}

	/*
	 * Description : to get the previous week Created Date : 07/15/2024
	 */
	public List<String> PreviousWeekDatesAndDays() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Calculate the start date (Monday) of the previous week
		LocalDate startDate = currentDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));

		// Create a list to store dates and days
		List<String> datesAndDays = new ArrayList<>();

		// Iterate through the previous week and add each date and day to the list
		for (int i = 0; i < 7; i++) {
			// Format the date to "d EEE"
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d EEE", Locale.ENGLISH);
			String formattedDate = startDate.format(formatter).toUpperCase(); // Converting to Uppercase

			// Add the formatted date and day to the list
			datesAndDays.add(formattedDate);

			// Move to the next day
			startDate = startDate.plusDays(1);
		}
		return datesAndDays;
	}

	/*
	 * Description : to handle alert popup Created Date : 14/09/2023
	 */
	public void AlertPopup() {
		Alert alert = driver.switchTo().alert();
		String popupText = alert.getText();
		TestUtils.log().info("Confirm Popup Text: " + popupText);
	}

	public String doGetPageTitle(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	/*
	 * Description : Get Attribute value by id Created Date : 08/09/2023
	 */
	public boolean doIsNotSelected(By locator) {

		boolean value = getElement(locator).isSelected();
		if (value == false) {
			TestUtils.log().info("Not selected");
		}
		return value;
	}

	/*
	 * Description : Element is displayed or not Created Date : 08/09/2023
	 */
	public void doIsNotDisplayed(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			if (!element.isDisplayed()) {
				TestUtils.log().info("Element is not displayed");
			}
		} catch (Exception e) {
			TestUtils.log().info("Element is not displayed");
		}
	}

	/*
	 * Description :Click WebElement using JavascriptExecutor Click Created Date :
	 * 18/09/2023
	 */
	public void JavaScriptExecutorClickWebElement(WebElement webElement) throws StaleElementReferenceException {
		WebElement element = webElement;
		int maxRetries = 5;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				// If click succeeds, break out of the loop
				break;
			} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
				extentReport.logToExtentReport("Caught exception: " + e.getMessage());
				extentReport.logToExtentReport("Retrying...");
				retryCount++;
			}
		}
	}

	/*
	 * Description : JavascriptExecutor Click Created Date : 18/09/2023
	 */
	public void JavaScriptExecutorClick(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	/*
	 * Description : Right Arrow by using Robot class Created Date : 11/09/2023
	 */

	public boolean doRightArrowByRobot(By locator) throws Throwable {
//		String Expected = getElement(locator).getDomAttribute("area-selected");
		Robot robot = new Robot();
		for (int i = 0; i < 8; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			return true;
		}
		return false;
	}

	/*
	 * Description : To verify the text of two values Created Date : 29/09/2023
	 */
	public boolean ComparingValues(String value, String value2) {
		if (value.equals(value2)) {
			TestUtils.log().info("Value matches");
			return true;
		} else {
			TestUtils.log().info("Value doesn't match");
			return false;
		}

	}

	public String doHighlightedInBlueColorDaysOff(WebElement element) throws StaleElementReferenceException {
		int attempts = 0;
		String backgroundColor = null;

		while (attempts < 5) {
			try {
				backgroundColor = element.getCssValue("background-color");
				if (backgroundColor.contains("rgba(239, 232, 255, 1)")) {
				} else {
					extentReport.logToExtentReport("NOT highlighted in blue color");
				}
				break; // exit the loop if no exception is thrown
			} catch (StaleElementReferenceException e) {
				attempts++;
				// Optionally, add a short delay between attempts
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
		}

		if (backgroundColor == null) {
			extentReport.logToExtentReport("Failed to get the background color after multiple attempts.");
		}

		return backgroundColor;
	}

	/*
	 * Description : to verify the first character is digit Created Date :
	 * 24/09/2023
	 */
	public char doGetFirstCharAppointments(By locator) {
		String text = driver.findElement(locator).getText();
		char Appointment = text.charAt(0);
		if (Character.isDigit(Appointment)) {
			TestUtils.log().info("No. of appointments are displayed");
		}
		return Appointment;
	}



	
	/*
	 * Description : to verify the first character is digit Created Date :
	 * 24/09/2023
	 */
	public char doGetFirstCharFollowUp(By locator) {
		String text = driver.findElement(locator).getText();
		char FollwUpVisit = text.charAt(0);
		if (Character.isDigit(FollwUpVisit)) {
			TestUtils.log().info("No. of follow-up visits are displayed");
		}
		return FollwUpVisit;
	}

	/*
	 * Description : WebElement is displayed or not Created Date : 17/10/2023
	 */
	public boolean doIsDisplayedWebelement(WebElement webElement) {
		WebElement element = webElement;

		if (element.isDisplayed()) {
			TestUtils.log().info("Element is displayed");
			return true;
		} else {
			TestUtils.log().info("Element is not displayed");
			return false;
		}
	}

	public void doActionsSendKeysValue(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}

	/*
	 * Description : to split Created Date : 17/10/2023
	 */
	public String splitString(String input, char splitCharacter) {
		// Find the index of the split character
		int splitIndex = input.indexOf(splitCharacter);

		// If the split character is found, extract the substring up to that index
		if (splitIndex != -1) {
			return input.substring(0, splitIndex).trim();
		}

		// If the split character is not found, return the original string
		return input.trim();
	}

	public boolean checkAllElementsWithText(By locator, String containsText) {

		for (WebElement webElement : getElements(locator)) {
			TestUtils.log().info(webElement.getText());
			if (!webElement.getText().equals(containsText)) {
				return false;
			}
		}
		return true;
	}

	public boolean getTextFromElements(By webElements, String containsText) {

		List<WebElement> e = getElements(webElements);
		for (int i = 0; i <= e.size(); i++) {
			if (e.get(i).getText().contains(containsText)) {
				getElements(webElements).get(i).click();
			}
		}
		return false;
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method to scroll to an element by its text content
	public void scrollToElementByText(String text) {
		String script = "arguments[0].scrollIntoView(true);";
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));

		((JavascriptExecutor) driver).executeScript(script, element);
		return;
	}

	public void scrollIntoView(By locator) {

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));

	}

	public WebElement getPatientInformationText(String xpaths, String s) {
		WebElement element = driver.findElement(By.xpath(xpaths.replace("${lblSections}", s)));

		return element;
	}

	public WebElement createElementReplacingString(String s) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(s));
		} catch (Exception e) {

		}
		return element;
	}

	public void moveToElementAndClick(By locator) throws Throwable {
		Actions act = new Actions(driver);
		WebElement WebElementElement = driver.findElement(locator);
		act.moveToElement(WebElementElement).click().perform();
	}

	public void verifyBrackets(By locator) {
		String text = driver.findElement(locator).getText();
		char StartBracket = text.charAt(13);
		char LastBracket = text.charAt(16);
		try {
			TestUtils.log().info(StartBracket);
			TestUtils.log().info(LastBracket);
			if (StartBracket == '(' && LastBracket == ')') {
				TestUtils.log().info("Appointment Count is enclosed with Brackets");
			}
		} catch (Exception e) {

		}
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void clickOnElemenEqualsString(By element, String timing) {
		for (int i = 0; i < getElements(element).size(); i++) {
			if (getElements(element).get(i).getText().equals(timing)) {
				getElements(element).get(i).click();
			}
		}
	}

	
}