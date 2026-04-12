package com.intelehealth.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class VideoFunctionalityPage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By appointmentLink = By.xpath("//h6[@data-test-id='appointment-count']");
	By FirstAppointmentPatient = By.xpath("//td[@data-test-id='td-patient_id-Appointment-0']");
	By vstsumpatientVideoIcon = By.xpath("//img[@data-test-id='imgStartVideoCall']");
	By startvisitnote = By.xpath("//button[@data-test-id='btnStartVisitNote']");
	By videoCallDialog = By.xpath("//mat-dialog-container");
	By videoCallDialogAudioButton = By.xpath("//button[@data-test-id='btnToggleAudio']");
	By videoCallDialogVideoButton = By.xpath("//button[@data-test-id='btnToggleVideo']");
	
	// Constructor of page class:
		public VideoFunctionalityPage(WebDriver driver) {
			this.driver = driver;
			elementActions = new ElementActions(this.driver);
		}
					
		/*
		 * Author: Rajesh HS Created: 31/10/2023 
		 * Description: Verify that user can make the video call
		 */
		@Step("Verify that user can make the video call")
		public void verifyVideoCall() throws InterruptedException{
			elementActions.doClick(appointmentLink);
			extentReport.logToExtentReport("Clicked on Appointment link from side panel");
			Thread.sleep(3000);
			elementActions.doClick(FirstAppointmentPatient);
			extentReport.logToExtentReport("Clicked on  first Appointment patient from table");
			Thread.sleep(3000);
			//elementActions.doClick(startvisitnote);
			elementActions.doClick(vstsumpatientVideoIcon);
			extentReport.logToExtentReport("Clicked on  video icon from visit summary page");
			Thread.sleep(5000);
//			driver.switchTo().alert().dismiss();
//			Thread.sleep(5000);
			elementActions.doIsDisplayed(videoCallDialog);
			extentReport.logToExtentReport("video call dialog is displayed");
		}

		/*
		 * Author: Rajesh HS Created: 31/10/2023 
		 * Description: Verify that user can make the video call
		 */
		@Step("Verify that user can make the video call")
		public void verifyVideoCallButton() throws InterruptedException{
			elementActions.doClick(appointmentLink);
			extentReport.logToExtentReport("Clicked on Appointment link from side panel");
			Thread.sleep(5000);
			elementActions.doClick(FirstAppointmentPatient);
			extentReport.logToExtentReport("Clicked on  first Appointment patient from table");
			Thread.sleep(5000);
			//elementActions.doClick(startvisitnote);
			elementActions.doClick(vstsumpatientVideoIcon);
			extentReport.logToExtentReport("Clicked on  video icon from visit summary page");
			Thread.sleep(3000);
//			driver.switchTo().alert().dismiss();
//			Thread.sleep(5000);
			elementActions.doIsDisplayed(videoCallDialog);
			extentReport.logToExtentReport("video call dialog is displayed");
			elementActions.doIsEnabled(videoCallDialogAudioButton);
			extentReport.logToExtentReport("audio call button is enabled");
			elementActions.doIsEnabled(videoCallDialogVideoButton);
			extentReport.logToExtentReport("video call button is enabled");
		}
		
		
}
