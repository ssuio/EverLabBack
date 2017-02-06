package com.everlab.test;

public class HelloWorld {
	 private String message;

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public String getMessage(){
	      System.out.println("Your Message : " + message);
	      return this.message;
	   }
}
