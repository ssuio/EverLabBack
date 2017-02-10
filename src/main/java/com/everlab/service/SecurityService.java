package com.everlab.service;

public interface SecurityService {
	String findLoggedInUsername();
	void autologin(String name, String pwd);
}
