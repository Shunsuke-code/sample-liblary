package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface AccountRepository extends JpaRepository<User, Integer>{
	User findByNameAndPassword(String name, String password);
	List<User> findByName(String name);
}
