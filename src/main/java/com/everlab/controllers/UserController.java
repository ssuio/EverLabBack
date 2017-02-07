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
			}else{
				
			}
		}catch(Exception ex){
			EverLabUtils.writeLog(2, "Register user error :" + ex);
			return new Response("error");
		}
		return new Response("success");
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = "application/json")
	public Map isEmailValid(String email){
		Map map = new HashMap();
		User user = userDao.findByEmail(email);
		if(user == null){
			map.put("isEmailValid", true);
		}else{
			map.put("isEmailValid", false);
		}
		return map;
	}
	
	@RequestMapping("/delete")
	  public String delete(long id) {
	    try {
	      User user = new User(id);
	      userDao.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	
	@RequestMapping("/get-by-email")
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	      User user = userDao.findByEmail(email);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	
	@RequestMapping("/update")
	  public String updateUser(long id, String email, String name) {
	    try {
	      User user = userDao.findOne(id);
	      user.setEmail(email);
	      user.setName(name);
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
