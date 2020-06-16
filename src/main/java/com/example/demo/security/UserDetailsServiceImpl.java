package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.data.UserRepository;
import com.example.demo.model.ApplicationUser;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<ApplicationUser> user = userRepo.findByUsername(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
		
		return user.get();
	}
	
}
