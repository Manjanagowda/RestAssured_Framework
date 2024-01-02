package com.moolya.genericutility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonResponse {

	public static JsonPath jsonPath;
	
	public static String getResponseValue(String response_Body,String response_Object)
	{
		jsonPath = new JsonPath(response_Body);
		String response_Value = jsonPath.get(response_Object);
		return response_Value;
	}
	
	public static int getstatuscode(Response response)
	{
		int status_code = response.getStatusCode();
		return status_code;
	}
	
}
