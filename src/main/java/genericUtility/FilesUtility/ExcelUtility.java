package genericUtility.FilesUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\vTigerTekP.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
//		Sheet sh = wb.getSheet(sheetName);
//		Row r = sh.getRow(rowNum);
//		Cell c = r.getCell(cellNum);
		String eData = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		
		return eData;
	}
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\vTigerTekP.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetName);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		
		return rowCount;		
	}
	
	public void writeDataToExcelFile(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\vTigerTekP.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetName);
//		Row r = sh.getRow(rowNum);
//		Cell c = r.createCell(cellNum);
		Cell c = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\vTigerTekP.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
