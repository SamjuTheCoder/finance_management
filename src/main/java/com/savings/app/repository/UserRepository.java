package com.savings.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.savings.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);		
}
