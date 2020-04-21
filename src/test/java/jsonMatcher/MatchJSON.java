package jsonMatcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.JSONComparator;

import io.restassured.RestAssured;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class MatchJSON {
	
	
	@Test
	public void Test001() throws IOException, JSONException
	{
		//RestAssured.rootPath
		String expected = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+File.separator+"expected.txt")));
		System.out.println("********"+expected);
		
		String actual = given().when().get("https://reqres.in/api/users/2").asString();
		System.out.println("******"+actual);
		
		//Assert.assertEquals(expected, actual);
		
		//JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
		
		JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);
	}

}