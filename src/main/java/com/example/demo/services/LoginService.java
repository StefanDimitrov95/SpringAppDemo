package com.example.demo.services;

public interface LoginService {
	
	void autoLogin(String username, String password);
	String findLoggedInUsername();
}
