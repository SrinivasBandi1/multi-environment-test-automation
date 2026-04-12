package com.intelehealth.config;

import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.io.InputStream;

public class BrowserStackConfig {

	public String userName;
	public String accessKey;
	public String projectName;
	public String buildName;
	// Add other fields that match your YAML settings.

	public static BrowserStackConfig loadConfig(String configFile) {
		Yaml yaml = new Yaml();
		try (InputStream inputStream = BrowserStackConfig.class.getResourceAsStream(configFile)) {
			if (inputStream != null) {
				return yaml.loadAs(inputStream, BrowserStackConfig.class);
			} else {

				// System.err.println("Could not find the YAML configuration file: " +
				// configFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// System.err.println("Error loading the YAML configuration file: " +
			// e.getMessage());

			System.err.println("Could not find the YAML configuration file: " + configFile);
		}

		return null;
	}
}
