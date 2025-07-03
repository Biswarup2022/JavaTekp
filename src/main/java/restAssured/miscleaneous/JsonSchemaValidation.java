package restAssured.miscleaneous;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.FilesUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class JsonSchemaValidation {
	
	
	@Test
	public void postPorjectToServer() {
		
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("createdBy", "Biswarup");
//		jsonObj.put("projectName", "TP_QSP11");
//		jsonObj.put("status", "Created");
//		jsonObj.put("teamSize", 0);
		
		JavaUtility jLib = new JavaUtility();
		
		String projectName = "Parker"+jLib.getRandomNumber(9999);
		
		ProjectPojo pObj = new ProjectPojo("Biswarup", projectName, "created", 0);
		
		Response r = given()
				.body(pObj).contentType(ContentType.JSON)
				.when().post("http://49.249.28.218:8091/addProject");
		
		r.then().log().all();
		
		r.then()
		.body(JsonSchemaValidator.matchesJsonSchema(new File(".\\src\\test\\resources\\JsonSchemaDocumentForAddProject")));
		
	}
}
