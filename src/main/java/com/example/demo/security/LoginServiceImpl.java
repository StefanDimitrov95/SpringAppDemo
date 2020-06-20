package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authManager;
	
	@Override
	public void autoLogin(String username, String password) {
		
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authToken = 
        		new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authManager.authenticate(authToken);
        
        if (authToken.isAuthenticated()) {
    		// auto-login the user after successful registration
        	SecurityContextHolder.getContext().setAuthentication(authToken);
        }
		
	}

	@Override
	public String findLoggedInUsername() {
		// retrieve the currently logged in user name from the authentication request
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
	}

}
