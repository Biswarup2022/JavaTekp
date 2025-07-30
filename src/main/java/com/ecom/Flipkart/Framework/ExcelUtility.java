package com.ecom.Flipkart.Framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\FlipkartData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String eData = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return eData;
	}
	
	public void printDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\FlipkartData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\FlipkartData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
