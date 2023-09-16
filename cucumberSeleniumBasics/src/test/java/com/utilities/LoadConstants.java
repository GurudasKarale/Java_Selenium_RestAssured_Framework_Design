package com.utilities;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//returns the value of config property
public class LoadConstants {

	public static String getConfigValue(String propertyname) throws IOException {
		
		FileReader reader=new FileReader(AppConstants.configpropPath);  
	      
		Properties p=new Properties();  
		p.load(reader);  
		
		//System.out.println(p.getProperty("propertyname"));
		return p.getProperty(propertyname);
	}
	
public static String getPageObjectValue(String propertyname) throws IOException {
		
		FileReader reader=new FileReader(AppConstants.pageobjectPath);  
	      
		Properties p=new Properties();  
		p.load(reader);  
		
		//System.out.println(p.getProperty("propertyname"));
		return p.getProperty(propertyname);
	}
	
}
