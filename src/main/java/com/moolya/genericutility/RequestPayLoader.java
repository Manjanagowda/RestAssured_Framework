package com.moolya.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class RequestPayLoader {

	public static String generatePayload(String filename) throws IOException
	{
		String filePath = "./src/main/java/com/moolya/resource/"+filename;
		//In the following step we are converting json into string and returning 
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static String getEndPointData(String filename , String keyValue) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/main/java/com/moolya/resource/"+filename);
		Properties properties = new Properties() ;
		properties.load(fis);
		String value = properties.getProperty(keyValue);
		return value;
	}
}
