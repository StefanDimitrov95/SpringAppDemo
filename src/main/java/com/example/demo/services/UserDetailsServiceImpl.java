package com.example.demo.services;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ApplicationUser;
import com.example.demo.repositories.ApplicationUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ApplicationUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<ApplicationUser> user = userRepo.findByUsername(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
		
		HashSet<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.get()
			.getRoles()
			.stream()
			.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
		
		return new User(user.get().getUsername(), user.get().getPassword(), authorities);
	}
	
}
