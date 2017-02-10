package com.everlab.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.everlab.domain.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long>{
		public User findByEmail(String email);
		
//		@Modifying
//		@Transactional
//		@Query(value="delete from User where email = ?1")
//		void deleteByEmail(String emailAddress);
		@Transactional
		Integer deleteByEmailAddress(String emailAddress);
}
