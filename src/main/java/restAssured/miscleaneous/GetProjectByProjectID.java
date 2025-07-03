package restAssured.miscleaneous;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetProjectByProjectID {
	
	@Test
	public void getProjectByProjectId() {
		
		String query = "{ findProject(projectId:\"NH_PROJ_***\"){ projectId projectName status createdBy teamSize } }";
		
		Response r = given().body(query).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/getProjectByProjectId");
		r.then().log().all();
	}
}
