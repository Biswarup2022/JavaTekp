package com.ecom.Flipkart.Framework;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\FlipkartCommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String pData = prop.getProperty(key);
		
		return pData;
	}
}
