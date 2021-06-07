package com.login.login.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.login.login.entity.Stock;
import com.login.login.entity.User;

public interface UserDAO extends JpaRepository<User, Long>{
//	@Query("SELECT u FROM User u WHERE u.email = ?1")
	
    public User findByEmail(String email);

	


}
