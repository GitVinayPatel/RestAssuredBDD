package restMethods;

import org.junit.Test;

import io.restassured.RestAssured;


public class GetTest {
	
	@Test
	public void test001()
	{
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		
		RestAssured.given()
		.log().all()
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}

}
