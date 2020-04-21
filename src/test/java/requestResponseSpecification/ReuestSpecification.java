package requestResponseSpecification;

import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.io.StringWriter;

public class ReuestSpecification {
	
	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	
	static ResponseSpecBuilder responsebuilder;
	static  ResponseSpecification responceSpec;
	

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost/";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
		builder = new RequestSpecBuilder();
		builder.addQueryParam("programme", "EEE");
		builder.addQueryParam("limit", 1);
		
		requestSpec = builder.build();
		
		responsebuilder = new ResponseSpecBuilder();
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
		//responsebuilder.expectBody("firstName",hasItem("Pooja"));
		
		responceSpec = responsebuilder.build();
		
		
	}
	
	
	@Test
	public void Test001()
	{
			given()
			.spec(requestSpec)
			.log().all()
			.when()
			.get("/list")
			.then()
			
			.spec(responceSpec);
	}
	

}
