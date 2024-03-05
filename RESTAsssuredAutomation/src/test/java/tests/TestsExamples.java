package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestsExamples 
{
	private String baseURI;

	@Test
	public void test1()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 201);
	}
	
	@Test
	public void test2 ()
	{
		baseURI="https://reqres.in/api";
		given().
			get(baseURI+"/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8))
			.log().all();
	}
	
	public void testPost ()
	{
		
	}
}
