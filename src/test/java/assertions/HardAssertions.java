package assertions;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
//import junit.framework.Assert;
import static org.junit.Assert.*;

//import org.hamcrest.core.IsEqual;

//import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;


public class HardAssertions {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";

	}
	
	@Test

	public void Test001()
	{
		int id = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data[0].id");

		System.out.println("------Junit assertion----------");
		assertEquals(7, id);


	}
	
	@Test

	public void Test002()
	{
		given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data[0].id", equalTo(7));
				//.extract().path("data[0].id");

		System.out.println("------hamcrest assertion----------");
		

	}

	@Test

	public void Test003()
	{
		given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data[0].id", equalTo(7));
				//.extract().path("data[0].id");

		System.out.println("------hamcrest assertion----------");
		}

	
}
