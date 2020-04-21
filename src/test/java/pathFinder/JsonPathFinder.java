package pathFinder;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonPathFinder {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";

	}
	
	//@Test

	public void Test000()
	{
		given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.log().all();

		System.out.println("--------Full Response--------");
		//System.out.println(id);


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

		System.out.println("--------Extract from JSON Array--------");
		System.out.println(id);


	}

	@Test

	public void Test002()
	{
		int page = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("page");

		System.out.println("--------Extract from JSON Object--------");
		System.out.println(page);


	}

	@Test

	public void Test003()
	{
		HashMap<String, String> data = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data[0]");

		System.out.println("--------Extract the HashMap--------");
		System.out.println(data);


	}

	@Test
	public void Test004()
	{
		List<HashMap<String, String>>  data1 = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data");

		System.out.println("--------Extract  List<HashMap<String, String>>--------");
		System.out.println(data1);
	}
	
	@Test
	public void Test005()
	{
		ArrayList<String> data = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data.findAll{it.id==10}.first_name");

				System.out.println("--------Extract id is equals to 10--------");
		System.out.println(data);
	}
	
	@Test
	public void Test006()
	{
		ArrayList<String> data = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data.findAll{it.id>10}.first_name");

				System.out.println("--------Extract id greater than 10--------");
		System.out.println(data);
	}
	
	@Test
	public void Test007()
	{
		List<HashMap<String, Object>> data = given()
				.param("page", 2)
				
				.when()
				
				.get()
				.then()
				.extract().path("data.findAll{it.last_name==~/.*s/}.first_name");

				System.out.println("--------Extract last name ends with s--------");
		System.out.println(data);
	}

	@Test
	public void Test008()
	{
		int data = given()
				.param("page", 2)
				.when()
				.get()
				.then()
				.extract().path("data.size()");

				System.out.println("--------Extract array size--------");
		System.out.println(data);
	}
	
	@Test
	public void Test009()
	{
		String response = given()
				.param("page", 2)
				.when()
				.get().asString();
				
		
//	String response=with(response).get
				System.out.println(response);
		
	}

}
