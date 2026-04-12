package com.intelehealth.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.intelehealth.base.BasePage;

public class ExtentReportListener extends BasePage implements ITestListener {

	public static String getCurrentDateTime() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// Define a DateTimeFormatter for formatting the date and time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format the current date and time
		return now.format(formatter);
	}

	private static String FILE_NAME = "TestExecutionReport";
	private static final String OUTPUT_FOLDER = "./TestReports/";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}


		// Include date and time in the file name
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		FILE_NAME += "_" + LocalDateTime.now().format(formatter) + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
		htmlReporter.config().setDocumentTitle("intelehealth - WebApplication - Automation -TestExecution results");
		htmlReporter.config().setReportName("intelehealth - WebApplication - Automation -TestExecution results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);

		return extent;
	}


	public synchronized void logToExtentReport(String message) {
		// Check if the test instance is available
		if (test.get() != null) {
			// Log message to the Extent Report with the specified status
			test.get().log(Status.INFO, message);
		}
	}

	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();
	}

	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);
		System.out.println(methodName + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest); // Set the ThreadLocal variable
		extentTest.assignCategory(result.getTestContext().getSuite().getName());

		// Add a custom log when the test starts
		extentTest.log(Status.INFO, "Test started.");

		// Add a custom log when the test starts
		extentTest.log(Status.INFO, "Test started.");

		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		try {
			test.get().pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		} catch (IOException e) {
			System.err
					.println("Exception thrown while updating test pass status " + Arrays.toString(e.getStackTrace()));
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		try {
			test.get().fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		} catch (IOException e) {
			System.err
					.println("Exception thrown while updating test fail status " + Arrays.toString(e.getStackTrace()));
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		try {
			test.get().skip(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		} catch (IOException e) {
			System.err
					.println("Exception thrown while updating test skip status " + Arrays.toString(e.getStackTrace()));
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}