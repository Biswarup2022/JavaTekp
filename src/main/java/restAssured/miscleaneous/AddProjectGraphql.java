package restAssured.miscleaneous;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectGraphql {
	
	@Test
	public void addProject() {
		String query = "mutation { addProject( projectName: \"Project Name\", teamSize: 5, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		Response r = given().body(query).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/addProject-graphql");
		
		r.then().log().all();
	}
}
