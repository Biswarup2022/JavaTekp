package genericUtility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataOnConditions
{
	public static void main(String[] args) throws Exception
	{
		String expectedData = "Samsung1";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		boolean flag = false;
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\MobileList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MobileSheet");
		
		for(int i = 0; i<=sh.getLastRowNum(); i++)
		{
			String data = "";
			data = sh.getRow(i).getCell(0).toString();
			if(data.equals(expectedData))
			{
				flag = true;
				data1 = sh.getRow(i).getCell(0).toString();
				data2 = sh.getRow(i).getCell(1).toString();
				data3 = sh.getRow(i).getCell(2).toString();
				data4 = sh.getRow(i).getCell(3).toString();
			}		
		}
		if(flag==true)
		{
			
			System.out.println(data1+" \t "+data2+" \t "+data3+" \t "+ data4);
		}
		else
			System.out.println(expectedData+" data is not available");
	}
}
