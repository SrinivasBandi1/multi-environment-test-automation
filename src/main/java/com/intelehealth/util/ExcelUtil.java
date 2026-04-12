package com.intelehealth.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "./src/main/java/com/intelehealth/testdata/LoginCredentialsTestData.xlsx";

	@Test
	public void myTest() {
		Object[][] data = getTestData("Sheet1");

		for (Object[] row : data) {
			for (Object cellData : row) {
				System.out.print(cellData + "\t");
			}
			System.out.println();
		}
	}

	public static Object[][] getTestData(String sheetName) {
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
