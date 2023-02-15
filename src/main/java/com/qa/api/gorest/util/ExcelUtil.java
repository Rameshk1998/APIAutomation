package com.qa.api.gorest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\DELL LATITUDE 7480\\eclipse-workspace\\RestAssured\\src\\"
			+ "main\\java\\com\\qa\\api\\gorest\\testdata\\GoRestData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		
		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int row=0;row<sheet.getLastRowNum();row++) {
			for(int col=0;col<sheet.getRow(0).getLastCellNum();col++) {
				data[row][col] = sheet.getRow(row+1).getCell(col).toString();
			}
		}
		return data;
		
	}
	
}
