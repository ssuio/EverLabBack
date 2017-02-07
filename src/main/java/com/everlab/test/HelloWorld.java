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
	   
	   public void init(){
		   System.out.println("Hello world init!");
	   }
	   
	   public void destroy(){
		   System.out.println("Hello world destroy!");
	   }
}
