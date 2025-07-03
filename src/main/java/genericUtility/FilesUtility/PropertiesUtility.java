package genericUtility.FilesUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtility
{
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TekPyramidCommonTC.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String pData = prop.getProperty(key);
		return pData;
	}
}
