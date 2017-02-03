		package com.everlab.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everlab.domain.User;
import com.everlab.model.UserDAO;

@RestController
public class UserController {
	User user = new User();
	
	@RequestMapping("/create")
	public String create(String email, String name){
		String userId = "";
		try{
			User user = new User(email, name);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		}catch(Exception ex){
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully create with id = " + userId;
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = "application/json")
	public Map isEmailValid(String email){
		System.out.println("!!!!");
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
	  public String sayHello() {
	    return "Gradle works!";
	  }
	
	@CrossOrigin
	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public User createJSONEmailByUser(@PathVariable String name){
		user.setName(name);
		user.setEmail(name+"@everlab.com");
		
		return user;
	}
	
	@Autowired
	  private UserDAO userDao;
}
