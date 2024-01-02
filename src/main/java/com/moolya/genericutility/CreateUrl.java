package com.moolya.genericutility;

public class CreateUrl {

	public static final String baseURL = "https://api.github.com";
	
	public static String getBaseURL()
	{
		return baseURL;
	}
	
	public static String baseURI(String endpoint)
	{
		return baseURL+endpoint;
	}
}
