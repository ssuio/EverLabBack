package com.everlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everlab.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
