package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

//without params test

@Epic("Go Rest API feature implementation")
@Feature("User APIs Feature")
public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = "b332a6b5fadd95504a8d62e706c13762b8b24f0a446545d5a40970610c8de114";

	@Description("Verify all the users list is fetched")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void getAllUserList_API_Test() {

		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("Authorization", "Bearer " + token);

		Response response = RestClient.doGet("JSON", baseURI, basePath, authToken, null, true);

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// with params test

	@Description("Get the list of users given in the params")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void getUserWithParams_API_Test() {

		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("Authorization", "Bearer " + token);

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "Kiran");
		params.put("gender", "male");

		Response response = RestClient.doGet("JSON", baseURI, basePath, authToken, params, true);

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
}
