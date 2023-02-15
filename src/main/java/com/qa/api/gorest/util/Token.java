package com.qa.api.gorest.util;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class Token {
	
	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap;
	public static String clientID = "85a1c35597f323d";

	public static Map<Object, Object> getAccessToken() {
		
		Map<String, String> formparams = new HashMap<String, String>();
		
		formparams.put("refresh_token", "sdsfs");
		formparams.put("client_id", "85a1c35597f323d");
		formparams.put("client_secret", "59269e550402b5c6c59827890067f5acb28fe05c");
		formparams.put("grant_type", "refresh_token");
		
		JsonPath jsonToken = 
		given()
			.formParams(formparams)
				.when()
					.post("https://api.imgur.com/oauth2/token")
						.then()
							.extract().jsonPath(); 
		
		System.out.println(jsonToken.getMap(""));//Here instead of path empty string is given to get the whole path, as we want the key and value also.
		
		appTokenMap = jsonToken.getMap("");
		return appTokenMap;
	}
	
	public static Map<String, String> getAuthToken() {
		
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth Token ==>"+authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
	}
	
	public static Map<String, String> getClientId() {
		System.out.println("Auth Token ==>"+clientID);
		tokenMap.put("Authorization", "Client-ID "+clientID);
		return tokenMap;
	}
	
	
	
}
