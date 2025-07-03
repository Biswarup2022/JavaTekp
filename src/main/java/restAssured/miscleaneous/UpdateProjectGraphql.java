package restAssured.miscleaneous;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProjectGraphql {
	
	@Test
	public void updateProjectGraphql() {
		
		String query = "mutation { updateProject( projectId: \"NH_PROJ_***\" projectName: \"Updated Project Name\", teamSize: 1, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		Response r = given().body(query).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/updateProject-graphql");
		
		r.then().log().all();
	}
}
