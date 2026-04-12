package com.intelehealth.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

//This class implements the TestNG interface IInvokedMethodListener
public class GlobalExceptionHandler implements IInvokedMethodListener {

	// This method is invoked before each test method is executed
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// This method runs before each test method is invoked.
		// You can add common setup code here if needed.
		// Currently, it's empty as there's no common setup logic implemented.
	}

	// This method is invoked after each test method is executed
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// This method runs after each test method is invoked.
		// Check if the test method failed.

		if (testResult.getStatus() == ITestResult.FAILURE) {
			// If the test method failed, handle the exception.
			// Retrieve the exception thrown during the test method execution.

			Throwable exception = testResult.getThrowable();
			// System.err.println("Test Method: " + method.getTestMethod().getMethodName() +
			// " failed.");

			System.err.println("Test Method: " + method.getTestMethod().getMethodName() + " failed.");

			// Print the stack trace of the exception.

			exception.printStackTrace();
			// You can choose to log the exception or perform any other actions.
		}
	}
}
