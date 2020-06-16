package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {
	
	Optional<ApplicationUser> findByUsername(String userName);
}
