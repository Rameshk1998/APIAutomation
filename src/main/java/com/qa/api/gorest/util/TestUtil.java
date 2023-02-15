package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

	/**
	 * This method is used to convert a POJO Object to a Json String
	 * @param obj
	 * @return
	 */
	
	public static String getSerializedJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
			System.out.println("JSON Body Payload ====> "+jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	
}
