package com.api.RestAssured;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.FilesUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDataFromServer {
	@Test
	public void getDataFromServer() {
		String baseURL = "http://49.249.28.218:8091";
		String projectID = "NH_PROJ_32399";
		Response res = RestAssured.get(baseURL+"/projects");
		res.then().assertThat().statusCode(200);
		res.then().log().all();
	}
	
	@Test
	public void postDataToServer() {
		Random r = new Random();
		int rand = r.nextInt(1000);
		String projectName = "Parker"+rand;
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Biswarup");
		jObj.put("projectName", projectName);
		jObj.put("status", "created");
		jObj.put("teamSize", "0");
		
		/* These are the different way to send payload/body to a complex request
		 * 
		 * By HashMap
		 * 
		 * 	HashMap<String, Object> map = new HashMap();
		 * 	map.put("createdBy", "Biswarup");
			map.put("projectName", projectName);
			map.put("status", "created");
			map.put("teamSize", "0");
			
			By External File
			
		File f = new File("json path file");
		 */
		
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj.toJSONString());
		Response res = req.post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().statusCode(201);
		res.then().log().all();
	}
}
