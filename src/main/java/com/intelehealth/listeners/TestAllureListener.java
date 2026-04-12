package com.intelehealth.listeners;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.intelehealth.base.BasePage;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	/*
	 * // Text attachments for Allure
	 * 
	 * @Attachment(value = "Screenshot", type = "image/png") public byte[]
	 * saveScreenshotPNG(WebDriver driver) { return ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); }
	 */

	@Attachment(value = "Page screenshot", type = "image/png")
	public static byte[] saveScreenshotPNG(WebDriver driver) {
		if (driver == null) {
			// return empty byte[] so Allure doesn't crash; alternatively return null
			return new byte[0];
		}
		try {
			// For remote drivers (BrowserStack/LambdaTest) augment if needed
			if (driver instanceof RemoteWebDriver) {
				try {
					driver = new Augmenter().augment(driver);
				} catch (Throwable t) {
					// Augmenter can sometimes fail depending on selenium version — ignore and try
					// normally
				}
			}
			if (driver instanceof TakesScreenshot) {
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			} else {
				return new byte[0];
			}
		} catch (Exception e) {
			// optional: log the exception to Allure or console
			saveTextLog("Failed to capture screenshot: " + e.getMessage());
			return new byte[0];
		}
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

//	@Override
	public void onStart(ITestContext iTestContext) {

		System.out.println("I am in onStart method " + iTestContext.getName());

		// iTestContext.setAttribute("WebDriver", BasePage.getDriver());
	}

//	@Override
	public void onFinish(ITestContext iTestContext) {

		System.out.println("I am in onFinish method " + iTestContext.getName());

	}

//	@Override
	public void onTestStart(ITestResult iTestResult) {

		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");

	}

//	@Override
	public void onTestSuccess(ITestResult iTestResult) {

		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	/*
	 * @Override public void onTestFailure(ITestResult iTestResult) {
	 * 
	 * System.out.println("I am in onTestFailure method " +
	 * getTestMethodName(iTestResult) + " failed");
	 * 
	 * Object testClass = iTestResult.getInstance(); // WebDriver driver =
	 * BasePage.getDriver(); // Allure ScreenShotRobot and SaveTestLog if
	 * (BasePage.getDriver() instanceof WebDriver) {
	 * 
	 * // System.out.println("Screenshot captured for test case:" + //
	 * getTestMethodName(iTestResult));
	 * 
	 * System.out.println("Screenshot captured for test case:" +
	 * getTestMethodName(iTestResult));
	 * 
	 * saveScreenshotPNG(BasePage.getDriver()); } // Save a log on allure.
	 * saveTextLog(getTestMethodName(iTestResult) +
	 * " failed and screenshot taken!"); }
	 */
	@Override
	public void onTestFailure(ITestResult iTestResult) {

		System.out.println("Test Failed: " + getTestMethodName(iTestResult));

		WebDriver driver = BasePage.getDriver();

		if (driver != null) {

			System.out.println("Screenshot captured for test case: " + getTestMethodName(iTestResult));

		//	saveScreenshotPNG(driver);
			byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failure screenshot","image/png",new ByteArrayInputStream(screenshot),".png");

		} else {

			System.out.println("Driver is NULL, screenshot not captured");

		}

		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	    System.out.println("Test Skipped: " + getTestMethodName(result));

	    // ✅ Attach skip reason to Allure
	    if (result.getThrowable() != null) {
	        Allure.addAttachment(
	            "Skip Reason",
	            result.getThrowable().toString()
	        );
	    }
	}
//	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));

	}

}
