package logRequestResponse;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class LogResponseInfo {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost/";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void Test001()
	{
		System.out.println("-----------Log Response Header/Body/Status/all/ifError/ifStatusCodeMatch-----------");
		given()
		.when()
		.get("/list")
		.then()
		.log()
		.ifStatusCodeIsEqualTo(201);
		//.headers();
		//.status();
		//.all();
		//.body();
	}

}
