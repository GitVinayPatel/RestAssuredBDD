package restMethods;

import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest 
{
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost/";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}

	@Test
	public void deleteTest()
	{
		Response response = given()
		.when()
		.delete("/105");
		
		System.out.println(response.body().asString());
	}
}
