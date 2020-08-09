package com.test.utils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

	Map<String, Object> contextMap;
	private static TestContext context;

	private TestContext() {
		
	}

	/**
	 * Method returns singleton object for test context
	 */
	public static TestContext getTestContext() {
		if (context == null)
			context = new TestContext();
		return context;
	}
	
	public Object read(String key) {
		if (context.contextMap == null) {
			return null;
		}else{
			return context.contextMap.get(key);
		}
	}

	public void set(String key, String value) {
		if (context.contextMap == null) {
			getTestContext().contextMap = new HashMap<String, Object>();
		}
		context.contextMap.put(key, value);
		
	}

}
