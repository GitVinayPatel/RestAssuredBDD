package requestResponseFilter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;


public class RestFilters {
	
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter resWriter;
	public static PrintStream resCapture;
	

	

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost/";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	


	@Before
	public  void beforeEachTest()
	{
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);		
		
		
		resWriter = new StringWriter();
		resCapture = new PrintStream(new WriterOutputStream(resWriter),true);	
	}
	
	
	@Test
	public void Test001()
	{
			given()
			.filter(new RequestLoggingFilter(requestCapture))
			.filter(new ResponseLoggingFilter(resCapture))
			.when()
			.get("/list");
				
			System.err.println(requestWriter.toString());
				System.out.println(resCapture.toString());
	}
	

}
