package com.everlab;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EverLabUtils {
	private static String version;
	
	public EverLabUtils(){}

	public String getVersion(){
		return version;
	}
	
	public void init(){
		JSONParser parser = new JSONParser();
		try{
			Object sysconfigObj = parser.parse(new FileReader("src/main/java/settings.json"));
			JSONObject sysconfigJson = (JSONObject)sysconfigObj;
			
			if(sysconfigJson.get("Version") != null){
				this.version = (String)sysconfigJson.get("Version");
				System.out.println("EverLabBack Version: " + "=====" + version + "=====");
			}
			
		}catch(Exception ex){
			
		}
	}
	
	
}
