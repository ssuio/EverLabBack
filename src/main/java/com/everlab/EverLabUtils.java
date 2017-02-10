package com.everlab;

import java.io.FileReader;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EverLabUtils {
	private static final Logger logger = LoggerFactory.getLogger("EverLab_Log");
	private static String version;
	
	public EverLabUtils(){
		//this.writeLog(0, "EverLabUtils construct!");
	}

	public String getVersion(){
		return version;
	}
	
	@PostConstruct
	public void init(){
		JSONParser parser = new JSONParser();
		try{
			Object sysconfigObj = parser.parse(new FileReader("src/main/java/settings.json"));
			JSONObject sysconfigJson = (JSONObject)sysconfigObj;
			
			if(sysconfigJson.get("Version") != null){
				this.version = (String)sysconfigJson.get("Version");
				logger.info("=====" + version + "=====");
			}
			
		}catch(Exception ex){
			
		}
	}
	
	public static void writeLog(int severity, String msg){
		switch(severity){
		case 0:
			logger.info(msg);
			break;
		case 1:
			logger.warn(msg);
			break;
		case 2:
			logger.error(msg);
			break;
		}
	}
}
	
	
	
