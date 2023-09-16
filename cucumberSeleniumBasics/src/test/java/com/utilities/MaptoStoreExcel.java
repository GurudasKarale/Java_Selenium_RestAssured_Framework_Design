package com.utilities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MaptoStoreExcel {
	
	static HashMap<String,String> mapy = new HashMap<String,String>();
	public static void setTestDataMap(HashMap<String,String> mapp) {
	
		 mapy.putAll(mapp); 
	}
	
	public static String getTestDataMap(String key) {
		
		return mapy.get(key); 
	}
	

}
