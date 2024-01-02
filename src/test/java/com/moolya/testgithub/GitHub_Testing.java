package com.moolya.testgithub;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.moolya.basetestclass.BaseTesting;
import com.moolya.genericutility.Authentications;
import com.moolya.genericutility.CommonResponse;
import com.moolya.genericutility.CreateUrl;
import com.moolya.genericutility.RequestPayLoader;

import io.restassured.response.Response;

public class GitHub_Testing {

	public static String bearer_Token = Authentications.getBearerToken();
	public static Response response;
	public static String updatedName;

	// Here we are executing the test cases using the RestAssured framework.
	// In this method we are creating repository .
	@Test(priority = 0)

	public static void createRepo() throws IOException {
		String endPoints = CreateUrl.baseURI("/user/repos");
		String request_payload = RequestPayLoader.generatePayload("RepoData.json");
		response = BaseTesting.postRequest(endPoints, request_payload, bearer_Token);
		String responseBody = response.getBody().asString();

		Assert.assertEquals(CommonResponse.getResponseValue(request_payload, "name"),
				CommonResponse.getResponseValue(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getstatuscode(response), 201);
	}

	// In this method we are retrieving the created repository
	@Test(priority = 1)

	public static void getRepository() throws IOException {
		String endPoints = CreateUrl
				.baseURI("/repos/" + RequestPayLoader.getEndPointData("RepoData.properties", "owner") + "/"
						+ RequestPayLoader.getEndPointData("RepoData.properties", "repo"));
		String request_Body = RequestPayLoader.generatePayload("RepoData.json");
		response = BaseTesting.getRequest(endPoints, bearer_Token);
		String response_Body = response.getBody().asString();
		Assert.assertEquals(CommonResponse.getResponseValue(response_Body, "name"),
				CommonResponse.getResponseValue(request_Body, "name"));
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
	}

	// In this method we are updating the created repository.
	@Test(priority = 2)

	public static void updateRepository() throws IOException {
		String endPoints = CreateUrl
				.baseURI("/repos/" + RequestPayLoader.getEndPointData("UpdateRepo.properties", "owner") + "/"
						+ RequestPayLoader.getEndPointData("UpdateRepo.properties", "repo"));
		String request_Body = RequestPayLoader.generatePayload("UpdateRepoData.json");
		System.out.println(endPoints);
		System.out.println(request_Body);
		response = BaseTesting.patchRequest(endPoints, request_Body, bearer_Token);
		String response_Body = response.getBody().asString();
		System.out.println(response_Body);
		updatedName = CommonResponse.getResponseValue(response_Body, "name");
		System.out.println(updatedName);
		Assert.assertEquals(CommonResponse.getResponseValue(response_Body, "name"),
				CommonResponse.getResponseValue(request_Body, "name"));
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
	}

	// In this method we are retrieving the Updated repository
	@Test(priority = 3)

	public static void getUpdatedRepository() throws IOException {
		String endPoints = CreateUrl.baseURI(
				"/repos/" + RequestPayLoader.getEndPointData("RepoData.properties", "owner") + "/" + updatedName);
		response = BaseTesting.getRequest(endPoints, bearer_Token);
		String response_Body = response.getBody().asString();
		Assert.assertEquals(CommonResponse.getResponseValue(response_Body, "name"), updatedName);
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
	}

	//In this method we are deleting the created and updated repository.
	 
	  @Test(priority = 4)
	  
	  public static void deleteRepository() throws IOException { String endPoints =
	  CreateUrl.baseURI("/repos/"+RequestPayLoader.getEndPointData(
	  "UpdateRepo.properties","owner")+"/"+updatedName); response =
	  BaseTesting.deleteRequest(endPoints, bearer_Token);
	  Assert.assertEquals(CommonResponse.getstatuscode(response), 204); }
	 

	// This method is used to list the user repositories
	@Test(priority = 5)

	public static void listUserRepositories() {
		String endpoints = CreateUrl.baseURI("/users/" + "Manjanagowda" + "/repos");
		response = BaseTesting.getRequest(endpoints, bearer_Token);
		String response_body = response.getBody().asString();
		System.out.println(response_body);
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
	}

	// This method used to list the repositories tags
	@Test(priority = 6)

	public static void listRepositoriestags() {
		String endpoints = CreateUrl.baseURI("/repos/Manjanagowda/RestAssured_Framework/tags");
		response = BaseTesting.getRequest(endpoints, bearer_Token);
		String response_body = response.getBody().asString();
		System.out.println(response_body);
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
	}

	// This method used to create fork
	/*
	 * @Test(priority = 7)
	 * 
	 * public static void createFork() throws IOException { String endpoints =
	 * CreateUrl.baseURI("/repos/"+"sachinzade"+"/FirstProject"+"/forks"); String
	 * request_Body = RequestPayLoader.generatePayload("Fork.json"); response =
	 * BaseTesting.postRequest(endpoints, request_Body,
	 * "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"); String response_Body =
	 * response.getBody().asString(); System.out.println(response_Body); }
	 */
	// This method is used to enable vulnerability alerts
	/*
	 * @Test
	 * 
	 * public static void enableVulnerabilityAlerts() {
	 * 
	 * } }
	 */
}
