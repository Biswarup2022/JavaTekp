package genericUtility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\MobileList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("MobileSheet");
		
//		s.createRow(55).createCell(6).setCellValue("Product");
		
		for(int i = 1; i<=s.getLastRowNum(); i++)
		{
			
			Row r = s.getRow(i);
			Cell c = r.createCell(4);
			c.setCellType(CellType.STRING);
			c.setCellValue("In Stock");
		}
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\MobileList.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("execution successful");
	}
}
