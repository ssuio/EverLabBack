package com.everlab.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.everlab.domain.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long>{
		public User findByEmail(String email);
}
