package dailyOne;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;

public class putAPI {
	
	
	@Test
	public void test002() throws JSONException
	{
		JSONObject emp = new JSONObject();
		emp.put("name", "morpheus");
		emp.put("job", "zion resident");
		
		System.out.println();
		
		
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RestAssured.given()
		.when()
		.body(emp.toString())
		.put()
		.then()
		.log()
		.all();
		
	}

}
