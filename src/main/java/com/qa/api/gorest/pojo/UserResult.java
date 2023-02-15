package com.qa.api.gorest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.response.Response;

public class UserResult {

	/**
	 * private String first_name;
	private String last_name;
	private String gender;
	private String dob;
	private String email;
	private String phone;
	private String website;
	private String address;
	private String status;
	private Links link;
	 */
	@Test
	public void createUserWithFullJson() {
		String token = "b332a6b5fadd95504a8d62e706c13762b8b24f0a446545d5a40970610c8de114";
		
	Self sf = new Self("https://www.sf.com");
	Edit ed = new Edit("https://www.ed.com");
	Avatar av = new Avatar("https://www.av.com");
	
	Links lk = new Links(sf, ed, av);
	
	UserInfo ui = new UserInfo("James", "Marvel", "Male", "01/01/1990", "jamess1@gmail.com", 
			"+9191919191919", "www.james.com", "United States", "Active", lk);
	
	String UserJsonPayload = TestUtil.getSerializedJson(ui);
	System.out.println(UserJsonPayload);
	
	Map<String, String> authTokenMap = new HashMap<String, String>();
	authTokenMap.put("Authorization", "Bearer "+token);
	
	Response response = RestClient.doPost("JSON", "https://gorest.co.in", "/public/v2/users", authTokenMap, null, true, UserJsonPayload);
	
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	}
}
