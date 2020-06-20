package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Integer> {
	
	Optional<ApplicationUser> findByUsername(String username);
}
