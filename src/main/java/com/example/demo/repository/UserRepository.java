package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
//	@Query("from User u where u.username = :username")
//    public Optional<User> findByUsername(@Param("username") String username);
	
//	@Query("from User u where u.email = :email")
//    public Optional<User> findByEmail(@Param("email") String email);
	Optional<User> findByEmail(String email);
	
	@Query("from User u where u.email = :email and u.password = :password")
	Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
