package restMethods;

import org.junit.BeforeClass;
import org.junit.Test;

import com.RestAssuredBDD.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class PutTest {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost/";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void Test1()
	{
		ArrayList<String> course = new ArrayList<String>();
		course.add("Angular");
		course.add("RestAssured");
		
		
		
		Student student = new Student();
		student.setFirstName("Vinay");
		student.setLastName("Pattu");
		student.setEmail("test@test1.com");
		student.setProgramme("SDET1");
		
		student.setCourses(course);
		
		Response response =	given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/103");
	
		System.out.println(response.body().asString());
	}

}
