package tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								 
{
	private String baseURI= "https://fakerestapi.azurewebsites.net/api/v1/Activities";
	private String baseURI2="https://reqres.in/";

	@Test
	public void testPut ()
	{
		System.out.println("void testPut");
		JSONObject request = new JSONObject();
		
		request.put("id", 0);
		request.put("title", "Caminhada é leeeiii");
		request.put("dueDate", "2024-03-06T21:43:14.823Z");
		request.put("completed", true );
		
		System.out.println(request.toJSONString());
		//"https://gorest.co.in/public/v2/users";	// não funcionou
		
		given().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put(baseURI+"/20").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void testPatch()
	{
		System.out.println("void testPatch");
		JSONObject request = new JSONObject();
			
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
		patch(baseURI2+"api/users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void testDelete()
	{
		System.out.println("void testDelete");
		
		given().
		when().
		delete(baseURI2+"api/users/").
		then().
		statusCode(204).log().all();
	}

}
