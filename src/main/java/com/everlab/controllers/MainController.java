package com.everlab.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
	public String HomePage(){
		String loginPage = "";
		try {
			InputStreamReader inR = new FileReader(new File("webApp/views/index.html"));
			BufferedReader bfR = new BufferedReader(inR);
			String line = bfR.readLine();
			while(line != null){
				loginPage+= line;
				line = bfR.readLine();
			}
			return loginPage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginPage;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET, produces = "text/html")
	public String errorPage(){
		String errorPage = "";
		try {
			InputStreamReader inR = new FileReader(new File("webApp/error.html"));
			BufferedReader bfR = new BufferedReader(inR);
			String line = bfR.readLine();
			while(line != null){
				errorPage+= line;
				line = bfR.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errorPage;
	}
}
