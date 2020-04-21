package restMethods;

import org.junit.BeforeClass;
import org.junit.Test;

import com.RestAssuredBDD.model.Employee;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostTest {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/";
	}
	
	@Test
	public void Test1()
	{
		Employee employee = new Employee();
		employee.setJob("leader");
		employee.setName("Vinay");
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(employee)
		.post("users");
		
		System.out.println(response.body().asString());
	}
	
	@Test
	public void Test2()
	{
		Employee employee = new Employee();
		employee.setEmail("eve.holt@reqres.in");
		employee.setPassword("pistol");
		
		ValidatableResponse response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(employee)
		.post("users")
		.then()
		.statusCode(201);
		
		
		
		
	}

}
