package genericUtility.Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FetchDataFromJSON
{

	public static void main(String[] args) throws Exception, Throwable, ParseException
	{
		/**
		 * Step 1 : Parse JSON Physical file into Java Object using JSONPARSER Class
		 * It will load the JSON file into the IDE Script and then we have to Parse the data
		 * Parse means it'll convert the JSON file into JAVA Object
		 */
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(".\\src\\test\\resources\\AppCommonData.json"));
		
		/**
		 * Step 2 : Now we have to perform down-casting operation on the JAVA Object
		 * Then we'll convert JAVA Object to JSON Object by using JSONObject Class
		 */
		JSONObject map = (JSONObject)obj;
		
		/**
		 * Step 3 : Get the value from JSON file by using the Key
		 */
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeouts"));
	}

}
