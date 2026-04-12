package com.intelehealth.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LanguageTest {

	// Define the languages we want to check against the English "text"
	private static final Map<String, String> LANGUAGE_MAP = new HashMap<>();
	static {
		LANGUAGE_MAP.put("display-hi", "Hindi");
		LANGUAGE_MAP.put("display-mr", "Marathi");
		LANGUAGE_MAP.put("display-or", "Odia");
		LANGUAGE_MAP.put("display-gu", "Gujarati");
		LANGUAGE_MAP.put("display-as", "Assamese");
		LANGUAGE_MAP.put("display-bn", "Bengali");
		LANGUAGE_MAP.put("display-kn", "Kannada");
	}

	// Replace with your actual API Key (OpenAI, Gemini, etc.)
	private static final String API_KEY = "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";
	private static final HttpClient httpClient = HttpClient.newHttpClient();

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("patHist.json")));
			JSONObject rootJson = new JSONObject(content);

			System.out.println("Starting Intelligent Semantic Validation...");
			// Start the recursive check, passing "ROOT" as the initial path
			validateNode(rootJson, "ROOT");
			System.out.println("Validation complete!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void validateNode(JSONObject node, String currentPath) {
		// Update the path so we know exactly where we are in the JSON tree
		String nodeId = node.optString("id", "Unknown_ID");
		String pathTracker = currentPath + " -> [" + nodeId + "]";

		// The baseline English text we are comparing against
		String englishText = node.optString("text", "");

		// Only validate if there is actually English text to compare
		if (!englishText.isEmpty()) {
			for (String key : LANGUAGE_MAP.keySet()) {
				if (node.has(key)) {
					String translatedText = node.getString(key);
					String targetLanguage = LANGUAGE_MAP.get(key);

					// Call the AI to evaluate the translation
					boolean isAccurate = evaluateTranslationWithAI(englishText, translatedText, targetLanguage);

					if (!isAccurate) {
						System.out.println("❌ SEMANTIC MISMATCH DETECTED!");
						System.out.println("   Location : " + pathTracker);
						System.out.println("   English  : " + englishText);
						System.out.println("   Found " + targetLanguage + ": " + translatedText);
						System.out.println("--------------------------------------------------");
					}
				}
			}
		}

		// Recursively dig into nested options, updating the path structure
		if (node.has("options")) {
			JSONArray optionsArray = node.getJSONArray("options");
			for (int i = 0; i < optionsArray.length(); i++) {
				validateNode(optionsArray.getJSONObject(i), pathTracker + " -> options[" + i + "]");
			}
		}
	}

	/**
	 * This method sends the English text and the Translation to an AI API. It asks
	 * the AI to return ONLY "true" if the meaning matches, or "false" if it is
	 * wrong.
	 */
	private static boolean evaluateTranslationWithAI(String english, String translation, String language) {
		try {
			// Constructing a strict prompt for the AI
			String prompt = String.format(
					"You are a medical QA tester. Is '%s' a correct or highly related %s translation for the English phrase '%s' in a healthcare mobile app? "
							+ "Ignore minor punctuation or grammatical differences. Focus strictly on semantic meaning. "
							+ "Respond with ONLY the word 'true' or 'false'.",
					translation, language, english);

			// ** IMPORTANT ** // Below is a generic JSON payload structure. You must adapt
			// this
			// to match the exact API documentation of the AI provider you use (OpenAI,
			// Anthropic, etc.)
			String requestBody = "{\n" + "  \"model\": \"gpt-3.5-turbo\",\n"
					+ "  \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt.replace("\"", "\\\"") + "\"}]\n"
					+ "}";

			HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openai.com/v1/chat/completions")) // Example
																															// URL
					.header("Content-Type", "application/json").header("Authorization", "Bearer " + API_KEY)
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			// Parse the response. If the AI says true, the translation is good.
			return response.body().toLowerCase().contains("true");

		} catch (Exception e) {
			System.out.println("API Call failed for text: " + english);
			return false;
		}
	}
}
