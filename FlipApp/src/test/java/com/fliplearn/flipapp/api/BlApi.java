package com.fliplearn.flipapp.api;

import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class BlApi {
	
	@Test
	public void getUserByUuid() {
		// Specify the base URL to the RESTful web service
				RestAssured.baseURI = "https://bl.fliplearn.com/user/getUserByUuid/";

				// Get the RequestSpecification of the request that you want to sent
				// to the server. The server is specified by the BaseURI that we have
				// specified in the above step.
				RequestSpecification httpRequest = RestAssured.given();

				// Make a request to the server by specifying the method Type and the method URL.
				// This will return the Response from the server. Store the response in a variable.
				Response response = httpRequest.request(Method.GET, "305243165081");

				// Now let us print the body of the message to see what response
				// we have recieved from the server
				String responseBody = response.getBody().asString();
				int statuscode=response.getStatusCode();
				Assert.assertEquals(statuscode, 200);
				System.out.println("Response Body is =>  " + responseBody);
				System.out.println(response.getStatusLine());
				JsonPath jsonEval=response.jsonPath();
				System.out.println(jsonEval);
//				String board=jsonEval.get("user");
				//Assert.assertEquals(board, "CBSE");
				Map<String,String>  user=response.jsonPath().getMap("user[0]");
				String board=user.get("boardCode");
				System.out.println("xyz"+user.get("boardCode"));
				Assert.assertEquals(board, "CBSE");
				 // Reader header of a give name. In this line we will get
				 // Header named Content-Type
				 String contentType = response.header("Content-Type");
				 System.out.println("Content-Type value: " + contentType);
				 
				 // Reader header of a give name. In this line we will get
				 // Header named Server
				 String serverType =  response.header("Server");
				 System.out.println("Server value: " + serverType);
				 
				 // Reader header of a give name. In this line we will get
				 // Header named Content-Encoding
				 String acceptLanguage = response.header("Content-Encoding");
				 System.out.println("Content-Encoding: " + acceptLanguage);
				}
				
	
	  
	}
 
 
 

