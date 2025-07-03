package com.api.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
	@Test
	public void sampleGetRequest() {
		Response resp = RestAssured.get("49.249.28.218:8091/count-projects");
		System.out.println(resp.prettyPrint());
	}
}
