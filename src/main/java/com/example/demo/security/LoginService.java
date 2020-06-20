package com.example.demo.security;

public interface LoginService {
	
	void autoLogin(String username, String password);
	String findLoggedInUsername();
}
