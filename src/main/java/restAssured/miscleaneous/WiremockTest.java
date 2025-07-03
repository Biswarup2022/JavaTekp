package restAssured.miscleaneous;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WiremockTest {

	@Test
	public void wiremockTest() {
		
		String body = "{\r\n"
				+ "    \"debitCardNum\": \"1234567887654321\",\r\n"
				+ "    \"cvv\": 543,\r\n"
				+ "    \"expDate\": \"28/30\"\r\n"
				+ "}";
		
		Response resp = given().body(body).contentType(ContentType.JSON)
				 		.when()
				 		.post("http://localhost:9999/debitCard");
		
		resp.then().log().all();
	}
}
