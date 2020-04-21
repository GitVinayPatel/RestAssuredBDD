package assertions;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
//import junit.framework.Assert;
import static org.junit.Assert.*;

import java.util.ArrayList;

//import org.hamcrest.core.IsEqual;

//import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;


public class HardAssertions2 {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8085/student/list";
		//RestAssured.basePath="/api/users";

	}
	
	@Test

	public void Test001()
	{
		 given()
		.param("programme", "EEE")
		.param("limit", 1)
			.when()
				.get()
				.then();
				//.body("courses",hasKey(key));
				//.body("courses", hasItem(itemMatcher))
				//.body("courses", hasEntry(key, value))
				//.body(arguments, equalTo(operand),equalToIgnoringCase(expectedString),greaterThanOrEqualTo(value))
				
				//.extract().path("courses");
		
		//System.out.println(a);


	}
	
	

	
	
}
