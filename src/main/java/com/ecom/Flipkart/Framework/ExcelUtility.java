package com.ecom.Flipkart.Framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
	
	public void printDataToExcel(String sheetName, int rowNum, int cellNum, String data1, String data2) throws Throwable {

	    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\FlipkartData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    
	    Sheet sheet = wb.getSheet(sheetName);
	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }

	    Cell cell1 = row.createCell(cellNum, CellType.STRING);
	    cell1.setCellValue(data1);

	    Cell cell2 = row.createCell(cellNum + 1, CellType.STRING);
	    cell2.setCellValue(data2);

	    fis.close();

	    FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\FlipkartData.xlsx");
	    wb.write(fos);
	    wb.close();
	    fos.close();
	}

}
