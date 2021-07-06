package com.savings.app.service;

import com.savings.app.models.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
}
