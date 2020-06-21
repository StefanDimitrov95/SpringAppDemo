package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.ApplicationUser;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.repositories.ApplicationUserRepository;
import com.example.demo.repositories.RoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ApplicationUserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void register(UserDto userDto) throws UserAlreadyExistsException {
		
		if (userAlreadyExists(userDto.getUsername())) {
			throw new UserAlreadyExistsException("An account with username '" + userDto.getUsername() + "' already exists.");
		}
		
		ApplicationUser user = new ApplicationUser(userDto.getUsername(), 
				passwordEncoder.encode(userDto.getPassword()));
		user.addRole(roleRepo.getRoleByName("USER"));
		
		userRepo.save(user);
	}
	
	private boolean userAlreadyExists(String username) {
		return userRepo.findByUsername(username).isPresent();
	}

}
