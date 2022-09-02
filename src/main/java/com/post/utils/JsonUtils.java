package com.post.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static ObjectMapper jsonUtils = new ObjectMapper();

	public static String toJson(Object object) {
		try {
			return jsonUtils.writeValueAsString(object);
		} catch (Exception e) {
			return null;
		}
	}

	public static <T> T toObject(String json, Class<T> entityClass) {
		try {
			return jsonUtils.readValue(json, entityClass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
