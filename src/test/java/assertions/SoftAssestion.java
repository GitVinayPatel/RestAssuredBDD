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


public class SoftAssestion {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";

	}
	
	@Test

	public void Test001()
	{
	given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data.id", hasItem(8));

	}
	
	@Test

	public void Test002()
	{
	given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data[0]", hasEntry("last_name", "Lawson"));

	}
	
	@Test
	
	public void Test003()
	{
	given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data", hasItem(hasEntry("last_name", "Lawson")));

	}
	
@Test
	
	public void Test004()
	{
	given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.body("data.id", hasItems(greaterThan(5),lessThan(13)));

	}
	
@Test

public void Test005()
{
given()
			.param("page", 2)
			.when()
			.get()
			.then()
			.body("data.id", hasItem(greaterThan(50)))
			.body("data", hasItem(hasEntry("last_name", "Lawson")))
			.body("data.id", hasItem(80));

}

//soft assertion
@Test

public void Test006()
{
given()
			.param("page", 2)
			.when()
			.get()
			.then()
			.body("data.id", hasItem(greaterThan(50)),"data", hasItem(hasEntry("last_name", "Lawson")),"data.id", hasItem(80));

}
	

	
}
