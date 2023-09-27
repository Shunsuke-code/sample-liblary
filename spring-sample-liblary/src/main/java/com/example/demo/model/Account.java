package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
@Data
@Component
@SessionScope
public class Account {
	
	private String name;
	private String password;
	
	public Account() {
		
	}
	
	public Account(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}


	
	
	
}
