package genericUtility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleData
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\MobileList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MobileSheet");
		for(int i = 0; i<=sh.getLastRowNum(); i++)
		{
//			Row r = sh.getRow(i);
//			Cell c = r.getCell(0);
//			String column1 = r.getCell(0).toString();
//			String column2 = r.getCell(1).toString();
//			String column3 = r.getCell(2).toString();
//			String column4 = r.getCell(3).toString();
//			System.out.println(column1+" \t "+column2+" \t "+column3+" \t "+column4);
			
			String column1value = sh.getRow(i).getCell(0).toString();
			String column2value = sh.getRow(i).getCell(1).toString();
			String column3value = sh.getRow(i).getCell(2).toString();
			String column4value = sh.getRow(i).getCell(3).toString();
			System.out.println(column1value+" \t "+column2value+" \t "+ column3value+" \t "+ column4value);
		}
	}
}
