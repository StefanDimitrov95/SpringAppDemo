package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.dto.UserDto;

public class MatchingPasswordValidator implements ConstraintValidator<PasswordMatch, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		UserDto user = (UserDto)value;
		
		return user.getPassword().equals(user.getConfirmPassword());
	}

}
