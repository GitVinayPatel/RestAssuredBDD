package dailyOne;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;

public class PatchAPI {
	
	@Test
	public void update() throws JSONException
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		JSONObject json = new JSONObject();
		json.put("name", "morpheus1");
		json.put("job", "zion resident1");
		
		String updatedName = RestAssured.
		given()
		.body(json.toString()).log().all()
		.when()
		.patch()
		.then()
		.log().all()
		.extract().path("updatedAt");
		
		System.out.println("**********"+updatedName);
		
		RestAssured.given().get().then().log().all();
		
}

}
