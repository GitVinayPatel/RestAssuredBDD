package restMethods;

import org.junit.BeforeClass;
import org.junit.Test;

import com.RestAssuredBDD.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class PostTestStudent {
	
	@BeforeClass // Kept this method in TestBase Class
	public static void init()
	{
	RestAssured.baseURI="http://localhost/";    //Kept data in application.properties
	RestAssured.port=8085; //Kept data in application.properties and read from application.properties
	RestAssured.basePath="/student";
			
	}
	
	@Test
	public void Test1()
	{
		ArrayList<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("C++");
		
		
		
		Student student = new Student();
		student.setFirstName("Vinni2");
		student.setLastName("Pattu");
		student.setEmail("test@test3.com");
		student.setProgramme("SDET");
		
		student.setCourses(course);
		
		Response response =	given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post();
	
		System.out.println(response.body().asString());
		
	}

}
