package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;



@Controller
public class BookController {

	@Autowired
	Account account;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	
	//本一覧表示
	@GetMapping("/book")
	public String index(@RequestParam(name = "categoryId", defaultValue = "")Integer categoryId,
			
			Model model) {
		
		
		//カテゴリー一覧
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);
		
		//本一覧
		List<Book> bookList = null;
		if(categoryId == null) {
			bookList = bookRepository.findAll();
		} else {
			bookList = bookRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("books", bookList);
		
		return "book";
	}

}
