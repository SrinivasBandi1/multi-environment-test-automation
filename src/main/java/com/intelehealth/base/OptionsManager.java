package com.intelehealth.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	public EdgeOptions eo;
	Properties prop;

	// Constructor to initialize the class with properties
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	// Get ChromeOptions based on properties
	/*
	 * public ChromeOptions getChromeOptions() { co = new ChromeOptions();
	 * co.addArguments("--use-fake-ui-for-media-stream"); // Automatically allow or
	 * block camera and // microphone co.addArguments("--disable-media-stream"); //
	 * Disable media stream co.addArguments("--remote-allow-origins=*");
	 * co.addArguments("--use-fake-ui-for-media-stream");
	 * co.addArguments("--disable-media-stream"); co.addArguments("--incognito");
	 * co.addArguments("--window-size=1920,1080");
	 * 
	 * REQUIRED FOR GITHUB ACTIONS / LINUX / CI co.addArguments("--headless=new");
	 * co.addArguments("--no-sandbox"); co.addArguments("--disable-dev-shm-usage");
	 * co.addArguments("--disable-gpu"); co.addArguments("--disable-extensions"); //
	 * Check if "headless" property is set to true, and if so, add the "--headless"
	 * // argument if (Boolean.parseBoolean(prop.getProperty("headless"))) {
	 * co.addArguments("--headless"); co.addArguments("--window-size=1920,1080");
	 * return co; }
	 * 
	 * // Check if "incognito" property is set to true, and if so, add the //
	 * "--incognito" argument if
	 * (Boolean.parseBoolean(prop.getProperty("incognito"))) {
	 * co.addArguments("--incognito"); co.addArguments("--window-size=1920,1080"); }
	 * 
	 * return co; // Return the configured ChromeOptions }
	 */
	public ChromeOptions getChromeOptions() {

		ChromeOptions co = new ChromeOptions();

		// Always required
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--use-fake-ui-for-media-stream");
		co.addArguments("--disable-media-stream");

		// Optional from config
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}

		// Detect CI environment automatically
		boolean isCI = System.getenv("CI") != null;

		// Detect headless from property
		boolean isHeadlessFromProp = Boolean.parseBoolean(prop.getProperty("headless"));

		// Apply headless if CI OR property enabled
		if (isCI || isHeadlessFromProp) {

			System.out.println("Running in HEADLESS mode");

			co.addArguments("--headless=new");
			co.addArguments("--no-sandbox");
			co.addArguments("--disable-dev-shm-usage");
			co.addArguments("--disable-gpu");
			co.addArguments("--disable-extensions");

		} else {

			System.out.println("Running in NORMAL mode");

		}

		return co;
	}

	// Get FirefoxOptions based on properties
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();

		// Check if "headless" property is set to true, and if so, add the "--headless"
		// argument
		fo.setAcceptInsecureCerts(true);

		// Headless execution
		if (prop != null && Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
			fo.addArguments("--width=1920");
			fo.addArguments("--height=1080");
		}
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
			fo.addArguments("--window-size=1920,1080");
		}

		return fo;
	}// Return the configured FirefoxOptions

	// Get EdgeOptions based on properties
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();

		// Check if "headless" property is set to true, and if so, add the "--headless"
		// argument
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
			eo.addArguments("--window-size=1920,1080");
		}

		return eo; // Return the configured EdgeOptions
	}
}
