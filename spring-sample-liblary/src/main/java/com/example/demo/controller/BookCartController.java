package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.model.BookCart;
import com.example.demo.repository.BookRepository;

@Controller
public class BookCartController {

	@Autowired
	BookCart bookCart;
	
	@Autowired
	BookRepository bookRepository;
	
	//カート内容を表示	
		@GetMapping("/bookCart")
		public String index() {
			return "BookCart";
		}
		
		// 指定した商品をカートに追加する
		//数量が未指定の場合は1とする
		@PostMapping("/book/add")
		public String addCart(
				@RequestParam("bookId") int bookId) {
			
			//商品コードをキーに商品情報を取得する
			Book book = bookRepository.findById(bookId).get();
			
			//カートに追加
			bookCart.add(book);
			return "redirect:/bookCart";
		}
		
		//指定した商品をカートから削除
		@PostMapping("/book/delete")
		public String deleteCart(@RequestParam("bookId")int bookId) {
			bookCart.delete(bookId);
			return "redirect:/BookCart";
		}
}
