package com.moolya.basetestclass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//We use HTTP methods repeatedly so we are making this separate class so that we can  just call the method and 
//-perform specific request actions .
//Here I'm creating GET,PUT,POST,PATCH,DELETE request methods

public class BaseTesting {

	//This method is used to perform get request
	public static Response getRequest(String requestUrl,String bearer_Token)
	{
		//Request specification contains the resources which we needed to send the request.
		RequestSpecification requestSpecification = RestAssured.given().header("Authorization","Bearer "+bearer_Token);
		requestSpecification.contentType(ContentType.JSON);
		//In the following step we are storing the response from get method.
		Response response = requestSpecification.get(requestUrl);
		return response;
	}
	
	//This method is used to perform post request with body
	public static Response postRequest(String requestUrl,String request_Payload,String bearer_Token)
	{
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON).header("Authorization","Bearer "+bearer_Token).body(request_Payload);
		Response response = requestSpecification.post(requestUrl);
		return response;		
	}
	
	//This method is used to perform post request without body
	public static Response postRequest(String requestUrl,String bearer_Token)
	{
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON).header("Authorization","Bearer "+bearer_Token);
		Response response = requestSpecification.post(requestUrl);
		return response;		
	}
	
	//This method is used to perform put request with body and bearer token
	public static Response putRequest(String requestUrl,String request_Payload,String bearer_Token)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(request_Payload);
		requestSpecification.header("Content-Type" ,"application/json").header("Authorization", "Bearer "+bearer_Token);
		Response response = requestSpecification.put(requestUrl);
		return response;
	}
	
	//This method is used to perform put request with body and bearer token
	public static Response putRequest(String requestUrl,String bearer_Token)
	{
	    RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type" ,"application/json").header("Authorization", "Bearer "+bearer_Token);
		Response response = requestSpecification.put(requestUrl);
		return response;
	}
	
	//This method is used to perform patch request with body and bearer token.
	public static Response patchRequest(String requestURL,String request_Payload,String bearer_Token)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(request_Payload).header("Content-Type","application/json").header("Authorization","Bearer "+bearer_Token);
		Response response = requestSpecification.patch(requestURL);
		return response ;
	}
	
	public static Response deleteRequest(String requestURL,String bearer_Token)
	{
		RequestSpecification requestspecification = RestAssured.given().header("Content-Type","application/json").header("Authorization","Bearer "+bearer_Token);
	    Response response = requestspecification.delete(requestURL);
	    return response;
	}
		
	
}
