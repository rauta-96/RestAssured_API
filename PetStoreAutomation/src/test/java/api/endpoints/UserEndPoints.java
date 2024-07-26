package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java 
//This is created for performing the CRUD(Create, Read, Update, Delete) applications to  
public class UserEndPoints {
	
	
	//Create User
	public static Response createUser(User payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	//Read User
	public static Response readUser(String userName)
	{
		Response response=given()
			.pathParam("username",userName)
		.when()
			.get(Routes.get_url);
		
		return response;
	}
	
	
	//Update User
	public static Response updateUser(String userName, User payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName)
			.body(payload)
		.when()
			.put(Routes.update_url);
		
		return response;
	}
	
	//Delete User
	public static Response deleteUser(String userName)
	{
		Response response=given()
			.pathParam("username",userName)
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	

}
