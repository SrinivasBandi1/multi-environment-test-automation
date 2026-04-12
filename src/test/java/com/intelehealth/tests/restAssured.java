package com.intelehealth.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class restAssured {

	private final String username = "nurse1";
	private final String password = "Nurse123";

	private final String webUsername = "doctor1";
	private final String webPassword = "Doctor@123";

	// Function to generate UUID
	private String generateUUID() {
		return UUID.randomUUID().toString();
	}

	// Function to generate timestamp
	private String generateTimestamp(int secondsAgo) {
		Date currentDate = new Date();
		long timestamp = currentDate.getTime() - (secondsAgo * 1000L);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
		return dateFormat.format(new Date(timestamp));
	}

	private String generateUtcTimestamp(int secondsAgo) {
		Date currentDate = new Date();
		long timestamp = currentDate.getTime() - (secondsAgo * 1000L);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		return dateFormat.format(new Date(timestamp));
	}

	// Function to generate time with 30mins gap from 9AM to 9PM
	private static List<String> generateTimewith30MinGap() {
		// Set the initial time to 9:00 AM
		LocalTime startTime = LocalTime.of(9, 0);
		// Set the time gap to 30 minutes
		int timeGapMinutes = 30;
		// Set the end time to 9:00 PM
		LocalTime endTime = LocalTime.of(21, 0);
		// Create a list to store the formatted times
		List<String> timesList = new ArrayList<String>();
		// Generate times with a 30-minute gap from 9:00 AM to 9:00 PM
		while (startTime.isBefore(endTime)) {
			// Add the formatted time to the list
			timesList.add(startTime.format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a")));
			// Move to the next time with a 30-minute gap
			startTime = startTime.plusMinutes(timeGapMinutes);
		}
		// Return the list of generated times
		return timesList;
	}

	public void createPatientAwaiting() throws InterruptedException, IOException {

		String randomUUID = generateUUID();
		String visitID = generateUUID();
		String encounterID1 = generateUUID();
		String encounterID2 = generateUUID();
		String myTimestamp = generateTimestamp(4);
		String newTimestamp = generateTimestamp(3);
		String utcTimeStamp = generateUtcTimestamp(1);
		String base64CredentialsCreatePatient = "bnVyc2UxOk51cnNlMTIz";
		String base64CredentialsCreateVisit = "bnVyc2UxOk51cnNlMTIz";

		// Generate a new UUID
		String patientID = UUID.randomUUID().toString();
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Define the date format
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Define the day of the week format
		DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
		// Format the current date
		String formattedDate = currentDate.format(formatterDate);
		String formattedDayOfWeek = currentDate.format(dayOfWeekFormat);

		// Your existing request body
		String createPatientRequestBody = "{\r\n" + "  \"appointments\": [],\r\n" + "  \"encounters\": [],\r\n"
				+ "  \"patients\": [\r\n" + "    {\r\n" + "      \"identifiers\": [\r\n" + "        {\r\n"
				+ "          \"identifierType\": \"05a29f94-c0ed-11e2-94be-8c13b969e334\",\r\n"
				+ "          \"location\": \"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
				+ "          \"preferred\": true\r\n" + "        }\r\n" + "      ],\r\n" + "      \"person\": \""
				+ patientID + "\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"persons\": [\r\n" + "    {\r\n"
				+ "      \"addresses\": [\r\n" + "        {\r\n" + "          \"address1\": \"\",\r\n"
				+ "          \"address2\": \"\",\r\n" + "          \"cityVillage\": \"Anantapur:NELLORE\",\r\n"
				+ "          \"country\": \"India\",\r\n" + "          \"postalCode\": \"\",\r\n"
				+ "          \"stateProvince\": \"Andhra Pradesh\"\r\n" + "        }\r\n" + "      ],\r\n"
				+ "      \"attributes\": [\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"1b2f34f7-2bf8-4ef7-9736-f5b858afc160\",\r\n"
				+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"f0171ab9-d76e-4fe8-ae9f-f9d3bf38acc7\",\r\n"
				+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"ecdaadb6-14a0-4ed9-b5b7-cfed87b44b87\",\r\n"
				+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"5a889d96-0c84-4a04-88dc-59a6e37db2d3\",\r\n"
				+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"1c718819-345c-4368-aad6-d69b4c267db7\",\r\n"
				+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"f4af0ef3-579c-448a-8157-750283409122\",\r\n"
				+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"ffc8ebee-f70c-4743-bc3c-2fe4ac843245\",\r\n"
				+ "          \"value\": \"06 November, 2023\"\r\n" + "        },\r\n" + "        {\r\n"
				+ "          \"attributeType\": \"84f94425-789d-4293-a0d8-9dc01dbb4f07\",\r\n"
				+ "          \"value\": \"28cea4ab-3188-434a-82f0-055133090a38\"\r\n" + "        }\r\n" + "      ],\r\n"
				+ "      \"birthdate\": \"2012-11-01\",\r\n" + "      \"gender\": \"M\",\r\n" + "      \"names\": [\r\n"
				+ "        {\r\n" + "          \"familyName\": \"Rajesh\",\r\n"
				+ "          \"givenName\": \"Automation\",\r\n" + "          \"middleName\": \"\"\r\n"
				+ "        }\r\n" + "      ],\r\n" + "      \"uuid\": \"" + patientID + "\"\r\n" + "    }\r\n"
				+ "  ],\r\n" + "  \"providers\": [],\r\n" + "  \"visits\": []\r\n" + "}";

		String createVisitRequestBody = "{\r\n" + "   \"appointments\":[\r\n" + "      \r\n" + "   ],\r\n"
				+ "   \"encounters\":[\r\n" + "      {\r\n" + "         \"encounterDatetime\":\"" + myTimestamp
				+ "\",\r\n" + "         \"encounterProviders\":[\r\n" + "            {\r\n"
				+ "               \"encounterRole\":\"73bbb069-9781-4afc-a9d1-54b6b2270e04\",\r\n"
				+ "               \"provider\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
				+ "         ],\r\n" + "         \"encounterType\":\"67a71486-1a54-468f-ac3e-7091a9a79584\",\r\n"
				+ "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n" + "         \"obs\":[\r\n"
				+ "            {\r\n" + "               \"concept\":\"5090AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"100\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5089AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"6\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5087AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"72\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5085AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"100\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5086AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"60\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5088AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"36.7\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5242AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"24\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"5092AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"98\"\r\n"
				+ "            }\r\n" + "         ],\r\n" + "         \"patient\":\"" + patientID + "\",\r\n"
				+ "         \"uuid\":\"" + encounterID1 + "\",\r\n" + "         \"visit\":\"" + visitID + "\",\r\n"
				+ "         \"voided\":0\r\n" + "      },\r\n" + "      {\r\n" + "         \"encounterDatetime\":\""
				+ newTimestamp + "\",\r\n" + "         \"encounterProviders\":[\r\n" + "            {\r\n"
				+ "               \"encounterRole\":\"73bbb069-9781-4afc-a9d1-54b6b2270e04\",\r\n"
				+ "               \"provider\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
				+ "         ],\r\n" + "         \"encounterType\":\"8d5b27bc-c2cc-11de-8d13-0010c6dffd0f\",\r\n"
				+ "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n" + "         \"obs\":[\r\n"
				+ "            {\r\n" + "               \"concept\":\"3edb0e09-9135-481e-b8f0-07a26fa9a5ce\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
				+ "               \"value\":\"{\\\"en\\\":\\\"'\\u25BA'\\u003cb\\u003eAbdominal Pain\\u003c\\\\/b\\u003e: \\u003cbr\\\\/\\u003e'\\u2022' Site - Upper (R) - Right Hypochondrium.\\u003cbr\\\\/\\u003e'\\u2022' Pain does not radiate.\\u003cbr\\\\/\\u003e'\\u2022'  10 Hours.\\u003cbr\\\\/\\u003e'\\u2022' Onset - Rapidly increasing.\\u003cbr\\\\/\\u003e'\\u2022' Timing - Not linked to any particular time of day.\\u003cbr\\\\/\\u003e'\\u2022' Character of the pain - Cramping.\\u003cbr\\\\/\\u003e'\\u2022' Severity - Mild, 1-3.\\u003cbr\\\\/\\u003e'\\u2022' Exacerbating Factors - Hunger.\\u003cbr\\\\/\\u003e'\\u2022' Relieving Factors - Food.\\u003cbr\\\\/\\u003e'\\u2022' Prior treatment sought - None.\\u003cbr\\\\/\\u003e'\\u25BA'\\u003cb\\u003e Associated symptoms\\u003c\\\\/b\\u003e:  \\u003cbr\\\\/\\u003e'\\u2022' Patient denies -\\u003cbr\\\\/\\u003e Abdominal distention\\\\/Bloating,  Anorexia,  Belching\\\\/Burping,  Blood in stool,  Breathlessness,  change in frequency of urination,  Color change in stool [describe],  Color change in urine,  Constipation,  Diarrhea,  Fever,  Hiccups,  Injury,  Nausea,  Passing gas,  Restlessness,  Vomiting\\u003cbr\\\\/\\u003e \\\",\\\"l-en\\\":\\\"'\\u25BA'Abdominal Pain::'\\u25CF' Which part of the abdomen do you feel pain?\\u003cbr\\\\/\\u003e'\\u2022'Upper (R) - Right Hypochondrium\\u003cbr\\\\/\\u003e'\\u25CF' Does the pain move to other parts of the body?\\u003cbr\\\\/\\u003e'\\u2022'Does not move\\u003cbr\\\\/\\u003e'\\u25CF' Since when have you had this symptom?\\u003cbr\\\\/\\u003e'\\u2022' 10 Hours\\u003cbr\\\\/\\u003e'\\u25CF' How did the pain start?\\u003cbr\\\\/\\u003e'\\u2022'Rapidly increasing\\u003cbr\\\\/\\u003e'\\u25CF' What time of the day do you feel the pain?\\u003cbr\\\\/\\u003e'\\u2022'Not linked to any particular time of day\\u003cbr\\\\/\\u003e'\\u25CF' Character of the pain\\u003cbr\\\\/\\u003e'\\u2022'Cramping\\u003cbr\\\\/\\u003e'\\u25CF' How severe is the pain?\\u003cbr\\\\/\\u003e'\\u2022'Mild, 1-3\\u003cbr\\\\/\\u003e'\\u25CF' What worsens the pain?\\u003cbr\\\\/\\u003e'\\u2022'Hunger\\u003cbr\\\\/\\u003e'\\u25CF' What relieves\\\\/lessens the pain?\\u003cbr\\\\/\\u003e'\\u2022'Food\\u003cbr\\\\/\\u003e'\\u25CF' Have you taken any treatment (including self-medication or home remedies) or seen any health provider for this problem before coming here today?\\u003cbr\\\\/\\u003e'\\u2022'None\\u003cbr\\\\/\\u003e'\\u25BA'Do you have the following symptom(s)?::Patient denies -\\u003cbr\\\\/\\u003e'\\u2022'Abdominal distention\\\\/Bloating\\u003cbr\\\\/\\u003e'\\u2022'Anorexia\\u003cbr\\\\/\\u003e'\\u2022'Belching\\\\/Burping\\u003cbr\\\\/\\u003e'\\u2022'Blood in stool\\u003cbr\\\\/\\u003e'\\u2022'Breathlessness\\u003cbr\\\\/\\u003e'\\u2022'Change in appetite\\u003cbr\\\\/\\u003e'\\u2022'Change in frequency of urination [describe]\\u003cbr\\\\/\\u003e'\\u2022'Color change in stool [describe]\\u003cbr\\\\/\\u003e'\\u2022'Color change in urine [describe]\\u003cbr\\\\/\\u003e'\\u2022'Constipation\\u003cbr\\\\/\\u003e'\\u2022'Diarrhea\\u003cbr\\\\/\\u003e'\\u2022'Fever\\u003cbr\\\\/\\u003e'\\u2022'Hiccups\\u003cbr\\\\/\\u003e'\\u2022'Injury\\u003cbr\\\\/\\u003e'\\u2022'Nausea\\u003cbr\\\\/\\u003e'\\u2022'Other [describe]\\u003cbr\\\\/\\u003e'\\u2022'Passing gas\\u003cbr\\\\/\\u003e'\\u2022'Restlessness\\u003cbr\\\\/\\u003e'\\u2022'Vomiting\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"e1761e85-9b50-48ae-8c4d-e6b7eeeba084\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
				+ "               \"value\":\"{\\\"en\\\":\\\"\\u003cbr\\\\/\\u003e'\\u25BA'\\u003cb\\u003eGeneral exams: \\u003c\\\\/b\\u003e\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Jaundice-no jaundice seen. \\u003cbr\\\\/\\u003e'\\u2022' Eyes: Pallor-normal pallor. \\u003cbr\\\\/\\u003e'\\u2022' Arm-Pinch skin* - appears slow on pinch test. \\u003cbr\\\\/\\u003e'\\u2022' Nail abnormality-nails normal. \\u003cbr\\\\/\\u003e'\\u2022' Nail anemia-Nails are normal. \\u003cbr\\\\/\\u003e'\\u2022' Ankle-no pedal oedema.\\\",\\\"l-en\\\":\\\"'\\u25BA'\\u003cb\\u003eGeneral exams: \\u003c\\\\/b\\u003e\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Jaundice-'\\u25CF' Is there jaundice?*\\u003cbr\\\\/\\u003e'\\u2022'No-\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Pallor-'\\u25CF' Is there pallor?*\\u003cbr\\\\/\\u003e'\\u2022'Normal-\\u003cbr\\\\/\\u003e'\\u2022' Arm-'\\u25CF' Pinch skin*\\u003cbr\\\\/\\u003e'\\u2022'Slow-\\u003cbr\\\\/\\u003e'\\u2022' Nail abnormality-'\\u25CF' Is there any nail abnormality?*\\u003cbr\\\\/\\u003e'\\u2022'Nails are normal-\\u003cbr\\\\/\\u003e'\\u2022' Nail anemia-'\\u25CF' Are the nails pale?*\\u003cbr\\\\/\\u003e'\\u2022'Nails are normal-\\u003cbr\\\\/\\u003e'\\u2022' Ankle-'\\u25CF' Is there ankle oedema?*\\u003cbr\\\\/\\u003e'\\u2022'No oedema--\\\"}\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"62bff84b-795a-45ad-aae1-80e7f5163a82\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
				+ "               \"value\":\"{\\\"en\\\":\\\"'\\u2022' Current Vaccinations status - Complete.\\u003cbr\\\\/\\u003e'\\u2022' Medical History - None.\\u003cbr\\\\/\\u003e'\\u2022' Drug history - No recent medication.\\u003cbr\\\\/\\u003e'\\u2022' Allergies - No known allergies.\\u003cbr\\\\/\\u003e\\\",\\\"l-en\\\":\\\"'\\u25CF' Has your child been vaccinated?\\u003cbr\\\\/\\u003e'\\u2022'Complete\\u003cbr\\\\/\\u003e'\\u25CF' Do you have a history of any of the following?*\\u003cbr\\\\/\\u003e'\\u2022'None\\u003cbr\\\\/\\u003e'\\u25CF' Have you recently taken any kind of medicine (including ayurvedic\\\\/homeopathic\\\\/unani\\\\/herbal)?*\\u003cbr\\\\/\\u003e'\\u2022'No\\u003cbr\\\\/\\u003e'\\u25CF' Do you have any allergies?*\\u003cbr\\\\/\\u003e'\\u2022'No known allergies\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
				+ "            },\r\n" + "            {\r\n"
				+ "               \"concept\":\"d63ae965-47fb-40e8-8f08-1f46a8a60b2b\",\r\n"
				+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
				+ "               \"value\":\"{\\\"en\\\":\\\"'\\u2022'Do you have a family history of any of the following?* : '\\u2022' None.\\u003cbr\\\\/\\u003e\\\",\\\"l-en\\\":\\\"'\\u2022'Do you have a family history of any of the following?* : '\\u2022'None.\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
				+ "            }\r\n" + "         ],\r\n" + "         \"patient\":\"" + patientID + "\",\r\n"
				+ "         \"uuid\":\"" + encounterID2 + "\",\r\n" + "         \"visit\":\"" + visitID + "\",\r\n"
				+ "         \"voided\":0\r\n" + "      }\r\n" + "   ],\r\n" + "   \"patients\":[\r\n" + "      {\r\n"
				+ "         \"identifiers\":[\r\n" + "            {\r\n"
				+ "               \"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\",\r\n"
				+ "               \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
				+ "               \"preferred\":true\r\n" + "            }\r\n" + "         ],\r\n"
				+ "         \"person\":\"" + patientID + "\"\r\n" + "      }\r\n" + "   ],\r\n" + "   \"persons\":[\r\n"
				+ "      {\r\n" + "         \"addresses\":[\r\n" + "            {\r\n"
				+ "               \"address1\":\"Address 1\",\r\n" + "               \"address2\":\"Addesss 2\",\r\n"
				+ "               \"cityVillage\":\"East Singhbhum:Village\",\r\n"
				+ "               \"country\":\"India\",\r\n" + "               \"postalCode\":\"831005\",\r\n"
				+ "               \"stateProvince\":\"Jharkhand\"\r\n" + "            }\r\n" + "         ],\r\n"
				+ "         \"attributes\":[\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"14d4f066-15f5-102d-96e4-000c29c2a5d7\",\r\n"
				+ "               \"value\":\"\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"1b2f34f7-2bf8-4ef7-9736-f5b858afc160\",\r\n"
				+ "               \"value\":\"\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"f0171ab9-d76e-4fe8-ae9f-f9d3bf38acc7\",\r\n"
				+ "               \"value\":\"NATIONALADDRESS\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"ecdaadb6-14a0-4ed9-b5b7-cfed87b44b87\",\r\n"
				+ "               \"value\":\"Occupation \"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"5a889d96-0c84-4a04-88dc-59a6e37db2d3\",\r\n"
				+ "               \"value\":\"General\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"1c718819-345c-4368-aad6-d69b4c267db7\",\r\n"
				+ "               \"value\":\"Illiterate\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"f4af0ef3-579c-448a-8157-750283409122\",\r\n"
				+ "               \"value\":\"APL\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"ffc8ebee-f70c-4743-bc3c-2fe4ac843245\",\r\n"
				+ "               \"value\":\"07 November, 2023\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"84f94425-789d-4293-a0d8-9dc01dbb4f07\",\r\n"
				+ "               \"value\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
				+ "         ],\r\n" + "         \"birthdate\":\"2023-11-07\",\r\n" + "         \"gender\":\"M\",\r\n"
				+ "         \"names\":[\r\n" + "            {\r\n" + "               \"familyName\":\"Auto\",\r\n"
				+ "               \"givenName\":\"Testing\",\r\n" + "               \"middleName\":\"\"\r\n"
				+ "            }\r\n" + "         ],\r\n" + "         \"uuid\":\"" + patientID + "\"\r\n"
				+ "      }\r\n" + "   ],\r\n" + "   \"providers\":[\r\n" + "      \r\n" + "   ],\r\n"
				+ "   \"visits\":[\r\n" + "      {\r\n" + "         \"attributes\":[\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"3f296939-c6d3-4d2e-b8ca-d7f4bfd42c2d\",\r\n"
				+ "               \"uuid\":\"" + randomUUID + "\",\r\n"
				+ "               \"value\":\"General Physician\"\r\n" + "            },\r\n" + "            {\r\n"
				+ "               \"attributeType\":\"64aa50c8-e913-48c6-b8ad-dfa0bccb202b\",\r\n"
				+ "               \"uuid\":\"" + randomUUID + "\",\r\n"
				+ "               \"value\":\"No notes added for Doctor.\"\r\n" + "            }\r\n"
				+ "         ],\r\n" + "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
				+ "         \"patient\":\"" + patientID + "\",\r\n" + "         \"startDatetime\":\"" + myTimestamp
				+ "\",\r\n" + "         \"uuid\":\"" + visitID + "\",\r\n"
				+ "         \"visitType\":\"a86ac96e-2e07-47a7-8e72-8216a1a75bfd\"\r\n" + "      }\r\n" + "   ]\r\n"
				+ "}";

		// Generate UUIDs and timestamps
		String credentials = username + ":" + password;

		// Convert the string to byte array
		byte[] credentialsBytes = credentials.getBytes();
		Base64.getEncoder().encodeToString(credentialsBytes);

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");

		RequestBody body = RequestBody.create(mediaType, createPatientRequestBody);
		Request request = new Request.Builder().url("https://tf.intelehealth.org/EMR-Middleware/webapi/push/pushdata")
				.method("POST", body).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Basic bnVyc2UyOk51cnNlMTIz").build();
		okhttp3.Response response = client.newCall(request).execute();
		System.out.println("Request body of Create Patient:: " + body);
		System.out.println("Request of Create patient:: " + request);
		System.out.println("response of Create patient:: " + response.body().string());

		/*
		 * Create Patients Visit test data using Rest API
		 */
		RequestBody body1 = RequestBody.create(mediaType, createVisitRequestBody);
		Request request1 = new Request.Builder().url("https://tf.intelehealth.org/EMR-Middleware/webapi/push/pushdata")
				.method("POST", body1).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Basic bnVyc2UyOk51cnNlMTIz").build();
		okhttp3.Response response1 = client.newCall(request1).execute();
		System.out.println("Request body of Create Visit:: " + body1);
		System.out.println("Request of Create Visit:: " + request1);
		System.out.println("Response of Create Visit:: " + response1.body().string());
		Thread.sleep(6000);
	}

	/*
	 * This method creates patient and select the appointment slot available Make
	 * sure Appointment slots should be available from Calendar Web app (Doctor
	 * Portal)
	 */
	public void createPatientAppointment() throws InterruptedException {

		// Set the start time to now
		LocalTime startTime = LocalTime.now();

		// Set the end time to the next day 12:00 AM
		LocalDateTime endDateTime = LocalDateTime.of(LocalDateTime.now().plusDays(1).toLocalDate(), LocalTime.MIDNIGHT);

		// Set the time interval (30 minutes)
		int intervalMinutes = 30;

		// Define a DateTimeFormatter for formatting the time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

		for (LocalDateTime currentDateTime = LocalDateTime.of(LocalDateTime.now().toLocalDate(),
				startTime); currentDateTime
						.isBefore(endDateTime); currentDateTime = currentDateTime.plusMinutes(intervalMinutes)) {

			String randomUUID = generateUUID();
			String visitID = generateUUID();
			String encounterID1 = generateUUID();
			String encounterID2 = generateUUID();
			String myTimestamp = generateTimestamp(4);
			String newTimestamp = generateTimestamp(3);
			// Generate a new UUID
			String patientID = UUID.randomUUID().toString();

			// Get the current date
			LocalDate currentDate = LocalDate.now();
			// Define the date format
			DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// Define the day of the week format
			DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
			// Format the current date
			// Get the next day's date
			LocalDate nextDate = currentDate.plusDays(1);
			// Format the next day's date
			String formattedDate = nextDate.format(formatterDate);
//		String formattedDate = currentDate.format(formatterDate);
			String formattedDayOfWeek = currentDate.format(dayOfWeekFormat);

			// Your existing request body
			String createPatientRequestBody = "{\r\n" + "  \"appointments\": [],\r\n" + "  \"encounters\": [],\r\n"
					+ "  \"patients\": [\r\n" + "    {\r\n" + "      \"identifiers\": [\r\n" + "        {\r\n"
					+ "          \"identifierType\": \"05a29f94-c0ed-11e2-94be-8c13b969e334\",\r\n"
					+ "          \"location\": \"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
					+ "          \"preferred\": true\r\n" + "        }\r\n" + "      ],\r\n" + "      \"person\": \""
					+ patientID + "\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"persons\": [\r\n" + "    {\r\n"
					+ "      \"addresses\": [\r\n" + "        {\r\n" + "          \"address1\": \"\",\r\n"
					+ "          \"address2\": \"\",\r\n" + "          \"cityVillage\": \"Anantapur:NELLORE\",\r\n"
					+ "          \"country\": \"India\",\r\n" + "          \"postalCode\": \"\",\r\n"
					+ "          \"stateProvince\": \"Andhra Pradesh\"\r\n" + "        }\r\n" + "      ],\r\n"
					+ "      \"attributes\": [\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"1b2f34f7-2bf8-4ef7-9736-f5b858afc160\",\r\n"
					+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"f0171ab9-d76e-4fe8-ae9f-f9d3bf38acc7\",\r\n"
					+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"ecdaadb6-14a0-4ed9-b5b7-cfed87b44b87\",\r\n"
					+ "          \"value\": \"\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"5a889d96-0c84-4a04-88dc-59a6e37db2d3\",\r\n"
					+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"1c718819-345c-4368-aad6-d69b4c267db7\",\r\n"
					+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"f4af0ef3-579c-448a-8157-750283409122\",\r\n"
					+ "          \"value\": \"Not provided\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"ffc8ebee-f70c-4743-bc3c-2fe4ac843245\",\r\n"
					+ "          \"value\": \"06 November, 2023\"\r\n" + "        },\r\n" + "        {\r\n"
					+ "          \"attributeType\": \"84f94425-789d-4293-a0d8-9dc01dbb4f07\",\r\n"
					+ "          \"value\": \"28cea4ab-3188-434a-82f0-055133090a38\"\r\n" + "        }\r\n"
					+ "      ],\r\n" + "      \"birthdate\": \"2012-11-01\",\r\n" + "      \"gender\": \"M\",\r\n"
					+ "      \"names\": [\r\n" + "        {\r\n" + "          \"familyName\": \"Rajesh\",\r\n"
					+ "          \"givenName\": \"Automation\",\r\n" + "          \"middleName\": \"\"\r\n"
					+ "        }\r\n" + "      ],\r\n" + "      \"uuid\": \"" + patientID + "\"\r\n" + "    }\r\n"
					+ "  ],\r\n" + "  \"providers\": [],\r\n" + "  \"visits\": []\r\n" + "}";

			String createVisitRequestBody = "{\r\n" + "   \"appointments\":[\r\n" + "      \r\n" + "   ],\r\n"
					+ "   \"encounters\":[\r\n" + "      {\r\n" + "         \"encounterDatetime\":\"" + myTimestamp
					+ "\",\r\n" + "         \"encounterProviders\":[\r\n" + "            {\r\n"
					+ "               \"encounterRole\":\"73bbb069-9781-4afc-a9d1-54b6b2270e04\",\r\n"
					+ "               \"provider\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
					+ "         ],\r\n" + "         \"encounterType\":\"67a71486-1a54-468f-ac3e-7091a9a79584\",\r\n"
					+ "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n" + "         \"obs\":[\r\n"
					+ "            {\r\n" + "               \"concept\":\"5090AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"100\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5089AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"6\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5087AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"72\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5085AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"100\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5086AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"60\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5088AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
					+ "               \"value\":\"36.7\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5242AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"24\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"5092AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n" + "               \"value\":\"98\"\r\n"
					+ "            }\r\n" + "         ],\r\n" + "         \"patient\":\"" + patientID + "\",\r\n"
					+ "         \"uuid\":\"" + encounterID1 + "\",\r\n" + "         \"visit\":\"" + visitID + "\",\r\n"
					+ "         \"voided\":0\r\n" + "      },\r\n" + "      {\r\n" + "         \"encounterDatetime\":\""
					+ newTimestamp + "\",\r\n" + "         \"encounterProviders\":[\r\n" + "            {\r\n"
					+ "               \"encounterRole\":\"73bbb069-9781-4afc-a9d1-54b6b2270e04\",\r\n"
					+ "               \"provider\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
					+ "         ],\r\n" + "         \"encounterType\":\"8d5b27bc-c2cc-11de-8d13-0010c6dffd0f\",\r\n"
					+ "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n" + "         \"obs\":[\r\n"
					+ "            {\r\n" + "               \"concept\":\"3edb0e09-9135-481e-b8f0-07a26fa9a5ce\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
					+ "               \"value\":\"{\\\"en\\\":\\\"'\\u25BA'\\u003cb\\u003eAbdominal Pain\\u003c\\\\/b\\u003e: \\u003cbr\\\\/\\u003e'\\u2022' Site - Upper (R) - Right Hypochondrium.\\u003cbr\\\\/\\u003e'\\u2022' Pain does not radiate.\\u003cbr\\\\/\\u003e'\\u2022'  10 Hours.\\u003cbr\\\\/\\u003e'\\u2022' Onset - Rapidly increasing.\\u003cbr\\\\/\\u003e'\\u2022' Timing - Not linked to any particular time of day.\\u003cbr\\\\/\\u003e'\\u2022' Character of the pain - Cramping.\\u003cbr\\\\/\\u003e'\\u2022' Severity - Mild, 1-3.\\u003cbr\\\\/\\u003e'\\u2022' Exacerbating Factors - Hunger.\\u003cbr\\\\/\\u003e'\\u2022' Relieving Factors - Food.\\u003cbr\\\\/\\u003e'\\u2022' Prior treatment sought - None.\\u003cbr\\\\/\\u003e'\\u25BA'\\u003cb\\u003e Associated symptoms\\u003c\\\\/b\\u003e:  \\u003cbr\\\\/\\u003e'\\u2022' Patient denies -\\u003cbr\\\\/\\u003e Abdominal distention\\\\/Bloating,  Anorexia,  Belching\\\\/Burping,  Blood in stool,  Breathlessness,  change in frequency of urination,  Color change in stool [describe],  Color change in urine,  Constipation,  Diarrhea,  Fever,  Hiccups,  Injury,  Nausea,  Passing gas,  Restlessness,  Vomiting\\u003cbr\\\\/\\u003e \\\",\\\"l-en\\\":\\\"'\\u25BA'Abdominal Pain::'\\u25CF' Which part of the abdomen do you feel pain?\\u003cbr\\\\/\\u003e'\\u2022'Upper (R) - Right Hypochondrium\\u003cbr\\\\/\\u003e'\\u25CF' Does the pain move to other parts of the body?\\u003cbr\\\\/\\u003e'\\u2022'Does not move\\u003cbr\\\\/\\u003e'\\u25CF' Since when have you had this symptom?\\u003cbr\\\\/\\u003e'\\u2022' 10 Hours\\u003cbr\\\\/\\u003e'\\u25CF' How did the pain start?\\u003cbr\\\\/\\u003e'\\u2022'Rapidly increasing\\u003cbr\\\\/\\u003e'\\u25CF' What time of the day do you feel the pain?\\u003cbr\\\\/\\u003e'\\u2022'Not linked to any particular time of day\\u003cbr\\\\/\\u003e'\\u25CF' Character of the pain\\u003cbr\\\\/\\u003e'\\u2022'Cramping\\u003cbr\\\\/\\u003e'\\u25CF' How severe is the pain?\\u003cbr\\\\/\\u003e'\\u2022'Mild, 1-3\\u003cbr\\\\/\\u003e'\\u25CF' What worsens the pain?\\u003cbr\\\\/\\u003e'\\u2022'Hunger\\u003cbr\\\\/\\u003e'\\u25CF' What relieves\\\\/lessens the pain?\\u003cbr\\\\/\\u003e'\\u2022'Food\\u003cbr\\\\/\\u003e'\\u25CF' Have you taken any treatment (including self-medication or home remedies) or seen any health provider for this problem before coming here today?\\u003cbr\\\\/\\u003e'\\u2022'None\\u003cbr\\\\/\\u003e'\\u25BA'Do you have the following symptom(s)?::Patient denies -\\u003cbr\\\\/\\u003e'\\u2022'Abdominal distention\\\\/Bloating\\u003cbr\\\\/\\u003e'\\u2022'Anorexia\\u003cbr\\\\/\\u003e'\\u2022'Belching\\\\/Burping\\u003cbr\\\\/\\u003e'\\u2022'Blood in stool\\u003cbr\\\\/\\u003e'\\u2022'Breathlessness\\u003cbr\\\\/\\u003e'\\u2022'Change in appetite\\u003cbr\\\\/\\u003e'\\u2022'Change in frequency of urination [describe]\\u003cbr\\\\/\\u003e'\\u2022'Color change in stool [describe]\\u003cbr\\\\/\\u003e'\\u2022'Color change in urine [describe]\\u003cbr\\\\/\\u003e'\\u2022'Constipation\\u003cbr\\\\/\\u003e'\\u2022'Diarrhea\\u003cbr\\\\/\\u003e'\\u2022'Fever\\u003cbr\\\\/\\u003e'\\u2022'Hiccups\\u003cbr\\\\/\\u003e'\\u2022'Injury\\u003cbr\\\\/\\u003e'\\u2022'Nausea\\u003cbr\\\\/\\u003e'\\u2022'Other [describe]\\u003cbr\\\\/\\u003e'\\u2022'Passing gas\\u003cbr\\\\/\\u003e'\\u2022'Restlessness\\u003cbr\\\\/\\u003e'\\u2022'Vomiting\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"e1761e85-9b50-48ae-8c4d-e6b7eeeba084\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
					+ "               \"value\":\"{\\\"en\\\":\\\"\\u003cbr\\\\/\\u003e'\\u25BA'\\u003cb\\u003eGeneral exams: \\u003c\\\\/b\\u003e\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Jaundice-no jaundice seen. \\u003cbr\\\\/\\u003e'\\u2022' Eyes: Pallor-normal pallor. \\u003cbr\\\\/\\u003e'\\u2022' Arm-Pinch skin* - appears slow on pinch test. \\u003cbr\\\\/\\u003e'\\u2022' Nail abnormality-nails normal. \\u003cbr\\\\/\\u003e'\\u2022' Nail anemia-Nails are normal. \\u003cbr\\\\/\\u003e'\\u2022' Ankle-no pedal oedema.\\\",\\\"l-en\\\":\\\"'\\u25BA'\\u003cb\\u003eGeneral exams: \\u003c\\\\/b\\u003e\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Jaundice-'\\u25CF' Is there jaundice?*\\u003cbr\\\\/\\u003e'\\u2022'No-\\u003cbr\\\\/\\u003e'\\u2022' Eyes: Pallor-'\\u25CF' Is there pallor?*\\u003cbr\\\\/\\u003e'\\u2022'Normal-\\u003cbr\\\\/\\u003e'\\u2022' Arm-'\\u25CF' Pinch skin*\\u003cbr\\\\/\\u003e'\\u2022'Slow-\\u003cbr\\\\/\\u003e'\\u2022' Nail abnormality-'\\u25CF' Is there any nail abnormality?*\\u003cbr\\\\/\\u003e'\\u2022'Nails are normal-\\u003cbr\\\\/\\u003e'\\u2022' Nail anemia-'\\u25CF' Are the nails pale?*\\u003cbr\\\\/\\u003e'\\u2022'Nails are normal-\\u003cbr\\\\/\\u003e'\\u2022' Ankle-'\\u25CF' Is there ankle oedema?*\\u003cbr\\\\/\\u003e'\\u2022'No oedema--\\\"}\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"62bff84b-795a-45ad-aae1-80e7f5163a82\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
					+ "               \"value\":\"{\\\"en\\\":\\\"'\\u2022' Current Vaccinations status - Complete.\\u003cbr\\\\/\\u003e'\\u2022' Medical History - None.\\u003cbr\\\\/\\u003e'\\u2022' Drug history - No recent medication.\\u003cbr\\\\/\\u003e'\\u2022' Allergies - No known allergies.\\u003cbr\\\\/\\u003e\\\",\\\"l-en\\\":\\\"'\\u25CF' Has your child been vaccinated?\\u003cbr\\\\/\\u003e'\\u2022'Complete\\u003cbr\\\\/\\u003e'\\u25CF' Do you have a history of any of the following?*\\u003cbr\\\\/\\u003e'\\u2022'None\\u003cbr\\\\/\\u003e'\\u25CF' Have you recently taken any kind of medicine (including ayurvedic\\\\/homeopathic\\\\/unani\\\\/herbal)?*\\u003cbr\\\\/\\u003e'\\u2022'No\\u003cbr\\\\/\\u003e'\\u25CF' Do you have any allergies?*\\u003cbr\\\\/\\u003e'\\u2022'No known allergies\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
					+ "            },\r\n" + "            {\r\n"
					+ "               \"concept\":\"d63ae965-47fb-40e8-8f08-1f46a8a60b2b\",\r\n"
					+ "               \"uuid\":\"" + generateUUID() + "\",\r\n"
					+ "               \"value\":\"{\\\"en\\\":\\\"'\\u2022'Do you have a family history of any of the following?* : '\\u2022' None.\\u003cbr\\\\/\\u003e\\\",\\\"l-en\\\":\\\"'\\u2022'Do you have a family history of any of the following?* : '\\u2022'None.\\u003cbr\\\\/\\u003e\\\"}\"\r\n"
					+ "            }\r\n" + "         ],\r\n" + "         \"patient\":\"" + patientID + "\",\r\n"
					+ "         \"uuid\":\"" + encounterID2 + "\",\r\n" + "         \"visit\":\"" + visitID + "\",\r\n"
					+ "         \"voided\":0\r\n" + "      }\r\n" + "   ],\r\n" + "   \"patients\":[\r\n"
					+ "      {\r\n" + "         \"identifiers\":[\r\n" + "            {\r\n"
					+ "               \"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\",\r\n"
					+ "               \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
					+ "               \"preferred\":true\r\n" + "            }\r\n" + "         ],\r\n"
					+ "         \"person\":\"" + patientID + "\"\r\n" + "      }\r\n" + "   ],\r\n"
					+ "   \"persons\":[\r\n" + "      {\r\n" + "         \"addresses\":[\r\n" + "            {\r\n"
					+ "               \"address1\":\"Address 1\",\r\n"
					+ "               \"address2\":\"Addesss 2\",\r\n"
					+ "               \"cityVillage\":\"East Singhbhum:Village\",\r\n"
					+ "               \"country\":\"India\",\r\n" + "               \"postalCode\":\"831005\",\r\n"
					+ "               \"stateProvince\":\"Jharkhand\"\r\n" + "            }\r\n" + "         ],\r\n"
					+ "         \"attributes\":[\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"14d4f066-15f5-102d-96e4-000c29c2a5d7\",\r\n"
					+ "               \"value\":\"+919133116015\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"1b2f34f7-2bf8-4ef7-9736-f5b858afc160\",\r\n"
					+ "               \"value\":\"\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"f0171ab9-d76e-4fe8-ae9f-f9d3bf38acc7\",\r\n"
					+ "               \"value\":\"NATIONALADDRESS\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"ecdaadb6-14a0-4ed9-b5b7-cfed87b44b87\",\r\n"
					+ "               \"value\":\"Occupation \"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"5a889d96-0c84-4a04-88dc-59a6e37db2d3\",\r\n"
					+ "               \"value\":\"General\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"1c718819-345c-4368-aad6-d69b4c267db7\",\r\n"
					+ "               \"value\":\"Illiterate\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"f4af0ef3-579c-448a-8157-750283409122\",\r\n"
					+ "               \"value\":\"APL\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"ffc8ebee-f70c-4743-bc3c-2fe4ac843245\",\r\n"
					+ "               \"value\":\"07 November, 2023\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"84f94425-789d-4293-a0d8-9dc01dbb4f07\",\r\n"
					+ "               \"value\":\"13a95b17-6dcc-4087-b447-66dfc96b4e00\"\r\n" + "            }\r\n"
					+ "         ],\r\n" + "         \"birthdate\":\"2023-11-07\",\r\n"
					+ "         \"gender\":\"M\",\r\n" + "         \"names\":[\r\n" + "            {\r\n"
					+ "               \"familyName\":\"Auto\",\r\n" + "               \"givenName\":\"Testing\",\r\n"
					+ "               \"middleName\":\"\"\r\n" + "            }\r\n" + "         ],\r\n"
					+ "         \"uuid\":\"" + patientID + "\"\r\n" + "      }\r\n" + "   ],\r\n"
					+ "   \"providers\":[\r\n" + "      \r\n" + "   ],\r\n" + "   \"visits\":[\r\n" + "      {\r\n"
					+ "         \"attributes\":[\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"3f296939-c6d3-4d2e-b8ca-d7f4bfd42c2d\",\r\n"
					+ "               \"uuid\":\"" + randomUUID + "\",\r\n"
					+ "               \"value\":\"General Physician\"\r\n" + "            },\r\n" + "            {\r\n"
					+ "               \"attributeType\":\"64aa50c8-e913-48c6-b8ad-dfa0bccb202b\",\r\n"
					+ "               \"uuid\":\"" + randomUUID + "\",\r\n"
					+ "               \"value\":\"No notes added for Doctor.\"\r\n" + "            }\r\n"
					+ "         ],\r\n" + "         \"location\":\"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
					+ "         \"patient\":\"" + patientID + "\",\r\n" + "         \"startDatetime\":\"" + myTimestamp
					+ "\",\r\n" + "         \"uuid\":\"" + visitID + "\",\r\n"
					+ "         \"visitType\":\"a86ac96e-2e07-47a7-8e72-8216a1a75bfd\"\r\n" + "      }\r\n" + "   ]\r\n"
					+ "}";

//			for (int i = 1; i <= 10; i++) {
			// Generate UUIDs and timestamps
			String credentials = username + ":" + password;

			// Convert the string to byte array
			byte[] credentialsBytes = credentials.getBytes();
			Base64.getEncoder().encodeToString(credentialsBytes);

//			for (int i = 1; i <= 10; i++) {
			try {
				OkHttpClient client = new OkHttpClient().newBuilder().build();
				MediaType mediaType = MediaType.parse("application/json");

				/*
				 * Create Patients test data using Rest API
				 */
				RequestBody body = RequestBody.create(mediaType, createPatientRequestBody);
				Request request = new Request.Builder()
						.url("https://tf.intelehealth.org/EMR-Middleware/webapi/push/pushdata").method("POST", body)
						.addHeader("Content-Type", "application/json")
						.addHeader("Authorization", "Basic bnVyc2UyOk51cnNlMTIz").build();
				okhttp3.Response response = client.newCall(request).execute();
				System.out.println("Request body of Create Patient:: " + body);
				System.out.println("");
				System.out.println("Request of Create patient:: " + request);
				System.out.println("");
				System.out.println("response of Create patient:: " + response.body().string());
				System.out.println("");

				// Create Patients Visit test data using Rest API
				RequestBody body1 = RequestBody.create(mediaType, createVisitRequestBody);
				Request request1 = new Request.Builder()
						.url("https://tf.intelehealth.org/EMR-Middleware/webapi/push/pushdata").method("POST", body1)
						.addHeader("Content-Type", "application/json")
						.addHeader("Authorization", "Basic bnVyc2UyOk51cnNlMTIz").build();

				okhttp3.Response response1 = client.newCall(request1).execute();
				String responseBodyString1 = response1.body().string(); // Read the response body only once
				System.out.println("Request body of Create Visit:: " + body1);
				System.out.println("");
				System.out.println("Request of Create Visit:: " + request1);
				System.out.println("");
				System.out.println("Response of Create Visit:: " + responseBodyString1);
				System.out.println("");

//				createPatientAwaiting();
				// Parse JSON response
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode = objectMapper.readTree(responseBodyString1);
				// Traverse to reach the "openmrs_id" value
				JsonNode openmrsIdNode = rootNode.path("data").path("patientlist").get(0).path("openmrs_id");
				// Extract and print the value
				String openmrsIdValue = openmrsIdNode.asText();
				System.out.println("Extracted OpenMRS ID: " + openmrsIdValue);

				String CreateAppointment = "{\r\n" + "  \"appointments\": [\r\n" + "    {\r\n"
						+ "      \"appointmentId\": 0,\r\n"
						+ "      \"drName\": \"Automation Testing intelehealth\",\r\n"
						+ "      \"hwAge\": \"78 10 27\",\r\n" + "      \"hwGender\": \"F\",\r\n"
						+ "      \"hwName\": \"nurse tester one\",\r\n"
						+ "      \"hwUUID\": \"28cea4ab-3188-434a-82f0-055133090a38\",\r\n"
						+ "      \"locationUuid\": \"9172f0c5-2a6d-43ba-84f8-37276a2db14b\",\r\n"
						+ "      \"openMrsId\": \"" + openmrsIdValue + "\",\r\n" + "      \"patientAge\": \"\",\r\n"
						+ "      \"patientGender\": \"M\",\r\n" + "      \"patientId\": \"" + patientID + "\",\r\n"
						+ "      \"patientName\": \"API User\",\r\n" + "      \"patientPic\": \"\",\r\n"
						+ "      \"slotDate\": \"" + formattedDate + "\",\r\n" + "      \"slotDay\": \""
						+ formattedDayOfWeek + "\",\r\n" + "      \"slotDuration\": 30,\r\n"
						+ "      \"slotDurationUnit\": \"minutes\",\r\n" + "      \"slotTime\": \""
						+ currentDateTime.toLocalTime().format(formatter) + "\",\r\n"
						+ "      \"speciality\": \"General Physician\",\r\n" + "      \"sync\": \"0\",\r\n"
						+ "      \"userUuid\": \"9eb2dd7c-93f5-4578-8031-de1fcef1ac68\",\r\n" + "      \"uuid\": \""
						+ generateUUID() + "\",\r\n" + "      \"visitUuid\": \"" + visitID + "\"\r\n" + "    }\r\n"

						+ "  ],\r\n" + "  \"encounters\": [],\r\n" + "  \"patients\": [],\r\n"
						+ "  \"persons\": [],\r\n" + "  \"providers\": [],\r\n" + "  \"visits\": []\r\n" + "}";

				// Create Patients appointment test data using Rest API
				RequestBody bodyAppointment = RequestBody.create(mediaType, CreateAppointment);
				Request requestappointment = new Request.Builder()
						.url("https://tf.intelehealth.org/EMR-Middleware/webapi/push/pushdata")
						.method("POST", bodyAppointment).addHeader("Content-Type", "application/json")
						.addHeader("Authorization", "Basic bnVyc2UyOk51cnNlMTIz").build();

				okhttp3.Response responseAppointment = client.newCall(requestappointment).execute();
				String responseBodyStringAppointment = responseAppointment.body().string();
				System.out.println("Request body of Create Appointment:: " + bodyAppointment.toString());
				System.out.println("");
				System.out.println("Request of Create Appointment:: " + requestappointment.body().toString());
				System.out.println("");
				System.out.println("Response of Create Appointment:: " + responseBodyStringAppointment);

				System.out.println(formattedDate);
				System.out.println(formattedDayOfWeek);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void createPatientAwaitingVisit() throws InterruptedException, IOException {

		for (int i = 1; i <= 10; i++) {
			createPatientAwaiting();
			createPatientAppointment();
		}
	}

	@Test
	public void createPatientAppointments() throws InterruptedException {

		createPatientAppointment();

	}
}

//	@Test
//	public void createPatientSt() throws InterruptedException {
//
//		// Generate UUIDs and timestamps
//		String webCredentials = webUsername + ":" + webPassword;
//
//		// Convert the string to byte array
//		byte[] webCredentialsBytes = webCredentials.getBytes();
//		Base64.getEncoder().encodeToString(webCredentialsBytes);
//
//		OkHttpClient client = new OkHttpClient().newBuilder().build();
//		MediaType mediaType = MediaType.parse("application/json");
//
//		/*
//		 * Create Patients Start Visit test data using Rest API
//		 */
//		RequestBody bodyStartVisit = RequestBody.create(mediaType, "{\r\n  \"patient\": \"" + patientID
//				+ "\",\r\n  \"encounterType\": \"d7151f82-c1f3-4152-a605-2f9ea7414a79\",\r\n  \"encounterProviders\": [\r\n    {\r\n      \"provider\": \"6dea2d57-e84f-482c-9d3b-2e7dcc3501b3\",\r\n      \"encounterRole\": \"73bbb069-9781-4afc-a9d1-54b6b2270e03\"\r\n    }\r\n  ],\r\n  \"visit\": \""
//				+ visitID + "\",\r\n  \"encounterDatetime\": \"" + generateUtcTimestamp(1) + "\"\r\n}");
//		Request requestStVst = new Request.Builder().url("https://tf.intelehealth.org/openmrs/ws/rest/v1/encounter")
//				.method("POST", bodyStartVisit)
//				.addHeader("sec-ch-ua", "\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"")
//				.addHeader("Accept", "application/json, text/plain, */*").addHeader("Content-Type", "application/json")
//				.addHeader("Referer", "https://tf.intelehealth.org/intelehealth/index.html")
//				.addHeader("sec-ch-ua-mobile", "?0")
//				.addHeader("User-Agent",
//						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
//				.addHeader("sec-ch-ua-platform", "\"Windows\"")
//				.addHeader("Authorization", "Basic ZG9jdG9yMTpEb2N0b3JAMTIz")
//				.addHeader("Cookie", "JSESSIONID=4A01C2038B297AECE8848903A287313A").build();
//		okhttp3.Response responseStVst = client.newCall(requestStVst).execute();
//		System.out.println("Request body of StVst:: " + bodyStartVisit.toString());
//		System.out.println("Request of StVst:: " + requestStVst.body().toString());
//		System.out.println("Response of StVst:: " + responseStVst.body().string());
//		Thread.sleep(6000);
//
//		/*
//		 * Create Patients Prescription test data using Rest API
//		 */
//		RequestBody bodyPresc = RequestBody.create(mediaType, "{\r\n  \"patient\": \"" + patientID
//				+ "\",\r\n  \"encounterType\": \"bd1fbfaa-f5fb-4ebd-b75c-564506fc309e\",\r\n  \"encounterProviders\": [\r\n    {\r\n      \"provider\": \"6dea2d57-e84f-482c-9d3b-2e7dcc3501b3\",\r\n      \"encounterRole\": \"73bbb069-9781-4afc-a9d1-54b6b2270e03\"\r\n    }\r\n  ],\r\n  \"visit\": \""
//				+ visitID + "\",\r\n  \"encounterDatetime\": \"" + generateUtcTimestamp(1)
//				+ "\",\r\n  \"obs\": [\r\n    { \r\n        \"concept\": \"537bb20d-d09d-4f88-930b-cc45c7d662df\",\r\n        \"value\": \"Functional intestinal disorders, other:Primary & Confirmed\"\r\n    },\r\n    {\r\n      \"concept\": \"7a9cb7bc-9ab9-4ff0-ae82-7a1bd2cca93e\",\r\n      \"value\": \"{\\\"name\\\":\\\"Automation Testing intelehealth\\\",\\\"uuid\\\":\\\"6dea2d57-e84f-482c-9d3b-2e7dcc3501b3\\\",\\\"qualification\\\":\\\"MBBS, MD\\\",\\\"fontOfSign\\\":\\\"Arty\\\",\\\"whatsapp\\\":\\\"1987654321\\\",\\\"registrationNumber\\\":\\\"89797390321as\\\",\\\"consultationLanguage\\\":\\\"English\\\",\\\"typeOfProfession\\\":\\\"MBBS, MD\\\",\\\"workExperience\\\":\\\"General Physician\\\",\\\"researchExperience\\\":\\\"Gujrati\\\",\\\"textOfSign\\\":\\\"Dr Automation\\\",\\\"specialization\\\":\\\"General Physician\\\",\\\"phoneNumber\\\":\\\"1233567890\\\",\\\"countryCode\\\":\\\"+91\\\",\\\"emailId\\\":\\\"doctor1@gmail.com\\\",\\\"workExperienceDetails\\\":\\\"10 years\\\",\\\"signatureType\\\":\\\"Generate\\\",\\\"signature\\\":\\\"data:application/octet-stream;base64,\\\"}\"\r\n    },\r\n    {\r\n        \"concept\":\"c38c0c50-2fd2-4ae3-b7ba-7dd25adca4ca\",\r\n        \"value\":\"Azithromycin Tablet 500 mg:500 Mg:3:1 - 0 - 0:TestRemark\"\r\n    }\r\n  ]\r\n}");
//		Request requestPresc = new Request.Builder().url("https://tf.intelehealth.org/openmrs/ws/rest/v1/encounter")
//				.method("POST", bodyPresc)
//				.addHeader("sec-ch-ua", "\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"")
//				.addHeader("Accept", "application/json, text/plain, */*").addHeader("Content-Type", "application/json")
//				.addHeader("Referer", "https://tf.intelehealth.org/intelehealth/index.html")
//				.addHeader("sec-ch-ua-mobile", "?0")
//				.addHeader("User-Agent",
//						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
//				.addHeader("sec-ch-ua-platform", "\"Windows\"")
//				.addHeader("Authorization", "Basic ZG9jdG9yMTpEb2N0b3JAMTIz")
//				.addHeader("Cookie", "JSESSIONID=4A01C2038B297AECE8848903A287313A").build();
//		okhttp3.Response responsePresc = client.newCall(requestPresc).execute();
//		System.out.println("Request body of Prescription:: " + bodyPresc.toString());
//		System.out.println("Request of Prescription:: " + requestPresc.body().toString());
//		System.out.println("Response of Prescription:: " + responsePresc.body().string());
//	}
//}
