package com.fliplearn.flipapp.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PquizApi {
	

	/* @Test
	   public void subjects() {
		   RestAssured.baseURI = "https://stgpquiz.fliplearn.com";

			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification request = RestAssured.given();

			// JSONObject is a class that represents a Simple JSON.
			// We can add Key - Value pairs using the put method
			
			String payload="{\n" +
			"		\"ayid\":	\"2\",  			\n" +
			"		\"schoolId\":\"15459513\",	\n" +
			"		\"classCode\":\"5\",			\n" +
			"		\"uuid\":\"192923857507\"    \n" +
			"}";
			
		
			System.out.println(payload);
	   
			
			Response  response = given().urlEncodingEnabled(true)
			  		.body(payload)
			
					.header("sessionToken","evdXEnVClkiiw3Rg7LM5tAFP5")
			        .header("loginId","comm.admin")
			        .header("platform","web")
			        
			        .header("SupportedApiVersion","1")
			  		.contentType(ContentType.JSON)
			        .post("/subjects")
			        .then()
			        .statusCode(200)
			        .extract()
			        .response();
			  		
			
			//Response response=request.post("/subjects");
			        int statuscode=response.getStatusCode();
			        System.out.println("xyy"+statuscode);
			        String responseBody = response.getBody().asString();
			        System.out.println("response"+responseBody); 
			

		    }*/
	 @Test
	 public void quizChallengeDetails() {
		 RestAssured.baseURI="https://stgpquiz.fliplearn.com";
		RequestSpecification request=RestAssured.given();
		
		String payload="{\n" +
		"\"ayid\":\"2\",\n"+
		"\"schoolId\":\"15459513\",\n" +
		"\"quizChallengeId\":\"110607\",\n" +
		"\"notificationId\":\"126109\",\n" +
		"\"uuid\":\"211221511306\"\n"+
		"}";
		System.out.println(payload);
		
		Response response = given().urlEncodingEnabled(true)
				.body(payload)
				
				.header("SupportedApiVersion","1")
				.header("loginId","comm.admin")
				.header("sessionToken","0njKWKbOKF95ffhFt5P7ByxlS")
				.header("platform","android")
				.header("appVersion","6.0.7")
				.contentType(ContentType.JSON)
				.post("/quizChallengeDetails")
		        .then()
		        .statusCode(200)
		        .extract()
		        .response();
		
		 int statuscode=response.getStatusCode();
	        System.out.println("xyy"+statuscode);
	        String responseBody = response.getBody().asString();
	        System.out.println("response"+responseBody); 
	
				
				
		
	

}}
