package restAssured.miscleaneous;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Graphql {
	
	@Test
	public void graphqlTest() {
		
		String query = "{ getAllProjects{ projectId projectName status } }";
		
		Response r = given().body(query).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091//getAll");
		
		r.then().log().all();
	}
}
