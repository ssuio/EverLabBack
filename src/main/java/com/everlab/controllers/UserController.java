		package com.everlab.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everlab.EverLabConfiguration;
import com.everlab.EverLabUtils;
import com.everlab.domain.User;
import com.everlab.model.UserDAO;
import com.everlab.response.Response;
import com.everlab.test.HelloWorld;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDao;
	User user = new User();
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Response create(String email, String pwd, String country, String name){
		try{
			User user = userDao.findByEmail(email);
			if(user == null){
				user = new User(email, pwd);
				
				if(country != null && country != "")
					user.setCountry(country);
				if(name != null && name != "")
					user.setName(name);
				
				userDao.save(user);
				return new Response(Response.RESPONSE_SUCCESS);
			}else{
				EverLabUtils.writeLog(2, "User already exist.");
				return new Response("error", "User exist!");
			}
		}catch(Exception ex){
			EverLabUtils.writeLog(2, "Register user error :" + ex);
			return new Response(Response.RESPONSE_ERROR, ex.toString());
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	  public Response delete(String email) {
	    try {
//	      User user = new User(email);
//	      userDao.delete(user);
	      
	      return new Response(Response.RESPONSE_SUCCESS);
	    }
	    catch (Exception ex) {
	      return new Response(Response.RESPONSE_ERROR, ex.toString());
	    }
	  }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	  public String updateUser(long id, String email, String name, String country, String age) {
	    try {
	      User user = userDao.findByEmail(email);
	      if(name != null && name != "")
	    	  user.setName(name);
	      if(country != null && country != "")
	    	  user.setCountry(country);
	      if(age != null && age != "")
	    	  user.setAge(age);
	      userDao.save(user);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }
	
	@RequestMapping("/hello")
	  public String sayHello(HttpServletRequest request) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EverLabConfiguration.class);
		HelloWorld hello = (HelloWorld)ctx.getBean(HelloWorld.class);
	    return hello.getMessage() + request.getRemoteAddr();
	  }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public User createJSONEmailByUser(@PathVariable String name){
		user.setName(name);
		user.setEmail(name+"@everlab.com");
		
		return user;
	}
	
	
}
