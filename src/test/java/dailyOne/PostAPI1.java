package dailyOne;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostAPI1 {
	
	RequestSpecification request;
	RequestSpecBuilder builder;
	
	ResponseSpecification responsespec;
	ResponseSpecBuilder resbuilder;
	
	@Test
	public void testcase001() throws JSONException
	{
		RestAssured.baseURI="https://reqres.in/api/register";
		RestAssured.basePath="/register";
		
		JSONObject json = new JSONObject();
		json.put("email", "eve.holt@reqres.in");
		json.put("password", "pistol");
		
		builder = new RequestSpecBuilder();
		builder.setBody(json.toString());
		request=builder.build();
		
		Response resp=RestAssured.given(request).post();
		
		resbuilder= new ResponseSpecBuilder();
		resbuilder.expectStatusCode(201);
		
		responsespec = resbuilder.build();
		
		
		resp.then().spec(responsespec).log().all();
		
		System.out.println(resp.asString());
		int statusCode=resp.getStatusCode();
		System.out.println(statusCode);
		
		
	}

}
