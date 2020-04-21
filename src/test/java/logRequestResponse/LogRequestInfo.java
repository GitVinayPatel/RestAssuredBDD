package logRequestResponse;

import org.junit.BeforeClass;
import org.junit.Test;

import com.RestAssuredBDD.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class LogRequestInfo {
	
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
		
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("Course1");
		courses.add("Course2");
		
		Student student = new Student();
		student.setCourses(courses);
		student.setEmail("test@test100.com");
		student.setFirstName("Pooja");
		student.setLastName("w");
		student.setProgramme("EEE");
		
		
		System.out.println("-----------------Logging Header ------------------------");
		given()
		.contentType(ContentType.JSON)
		.log()
		.headers()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(500);
		
	}
	

	@Test
	public void Test002()
	{
		
		System.out.println("-----------------Logging Request Params  ------------------------");
		given()
		.param("programme", "EEE")
		.param("limit",1)
		.log()
		.uri()
		//.parameters()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	@Test
	public void Test003()
	{
		
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("Course1");
		courses.add("Course2");
		
		Student student = new Student();
		student.setCourses(courses);
		student.setEmail("test@test100.com");
		student.setFirstName("Pooja");
		student.setLastName("w");
		student.setProgramme("EEE");
		
		
		System.out.println("-----------------Logging JSON BODY ------------------------");
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(500);
		
	}
	
	@Test
	public void Test004()
	{
		
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("Course1");
		courses.add("Course2");
		
		Student student = new Student();
		student.setCourses(courses);
		student.setEmail("test@test100.com");
		student.setFirstName("Pooja");
		student.setLastName("w");
		student.setProgramme("EEE");
		
		
		System.out.println("-----------------Logging All Info ------------------------");
		given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(500);
		
	}
	
	@Test
	public void Test005()
	{
		
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("Course1");
		courses.add("Course2");
		
		Student student = new Student();
		student.setCourses(courses);
		student.setEmail("test@test100.com");
		student.setFirstName("Pooja");
		student.setLastName("w");
		student.setProgramme("EEE");
		
		
		System.out.println("-----------------Logging if Validation Fails ------------------------");
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(500);
		
	}
	

}
