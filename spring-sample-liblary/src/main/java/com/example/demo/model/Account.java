package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Component
@SessionScope
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	private String name;
	private String password;
	
	
	
}
