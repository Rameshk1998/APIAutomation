package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class GetImgurTest {

	Map<Object, Object> tokenMap;
	String accessToken;
	String userName;
	String refreshToken;
	
	@BeforeMethod
	public void setUp() {
		tokenMap = Token.getAccessToken();
		accessToken = tokenMap.get("access_token").toString();
		userName = tokenMap.get("account_username").toString();
		refreshToken = tokenMap.get(refreshToken).toString();
	}
	
	
	@Test
	public void getAccountBlockStatus() {
		
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/account/v1/"+userName+"/block", authTokenMap, null, true);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void uploadImagePOSTAPITest() {
		
		Map<String, String> clientIdMap = Token.getClientId();
		
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "imgur pics");
		formMap.put("description", "This is an image to be uploaded");
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/upload", clientIdMap, null, true, formMap);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
}
