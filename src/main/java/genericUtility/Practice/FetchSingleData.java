package genericUtility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchSingleData
{
	public static void main(String[] args) throws Exception
	{
		Random rd = new Random();
		int rdInt = rd.nextInt(1000);
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\MobileList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MobileSheet");
		Row r = sh.getRow(8);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue().toString()+rdInt;
		System.out.println(value);
	}

}
