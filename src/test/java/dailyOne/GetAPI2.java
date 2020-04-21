package dailyOne;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPI2 {
	
	@Test
	public void testcase002()
	{
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users?page=2";
	
		Response response = RestAssured.given().get();
		
		System.out.println(response.getBody().asString());
		
	}
	

}
