package genericUtility.FilesUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility
{
	public String getDataFromJsonFile (String key) throws Throwable
	{
		FileReader fir = new FileReader(".\\src\\test\\resources\\AppCommonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fir);
		JSONObject data = (JSONObject)obj;
		String jData = data.get(key).toString();
		
		return jData;
	}
}
