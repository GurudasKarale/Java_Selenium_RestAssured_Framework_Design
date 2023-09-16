package com.utilities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



public class StepStatus {
	
	static HashMap<String, String> mapK
    = new HashMap<String, String>();
	
	public static void setKeywordMap(String keyword,String value) {
		
        mapK.put(keyword,value);
		System.out.println(mapK);
	}
	
	public static void getKeywordMap(String keyy) {
		
        mapK.get(keyy);
		
	}

}
