package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = "b332a6b5fadd95504a8d62e706c13762b8b24f0a446545d5a40970610c8de114";
	
	@DataProvider
	public Object[][] getUserData() {
		Object userData[][] = ExcelUtil.getTestData("TestData");
		return userData;
	}
	
	@Description("Create the User Profile")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getUserData")
	public void createUserAPITest(String name, String gender, String email, String status) {
		
		//user = new User("Babu", "Male", "Babu@gmail.com", "Active");
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("Authorization", "Bearer "+token);
		User user = new User(name, gender, email, status);
		Response response = RestClient.doPost("JSON", baseURI, basePath, authToken, null, true, user);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("===================================================");
		
	}
	
}
