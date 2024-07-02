package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// UserEndPoints.java
// Created for perform create,retrive,update,delete request

public class UserEndPoints {

	
	public static Response createUser(User payload)
	{
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		 
		.when()
		   .post(Routes.postuser_url);
		
		return response;
	}
	
	
	public static Response ReadUser(String userName)
	{
		Response response = given()
		   .pathParam("username", userName)
		   
		.when()
		  .get(Routes.getuser_url);
		
		return response;
		
	}
	
	public static Response UpdateUser(User payload,String userName)
	{
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  .pathParam("username", userName)
		 
		.when()
		   .put(Routes.updateuser_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
		   .pathParam("username", userName)
		
		.when()
		   .delete(Routes.deleteuser_url);
		
		
		return response;
	}
	
	
	
	
	
	
}
