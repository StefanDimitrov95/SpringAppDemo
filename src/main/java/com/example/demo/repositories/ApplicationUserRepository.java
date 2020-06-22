package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
	
	Optional<ApplicationUser> findByUsername(String username);
}
