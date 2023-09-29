package com.example.demo.model;


	
	import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Book;

	@Component
	@SessionScope
	public class BookCart {

		//商品リスト
		private List<Book> bookList = new ArrayList<>();

		public List<Book> getItems() {
			return bookList;
		}
		
		public int getTotal() {
			int total = 0;
			for(Book book : bookList) {
				total += book.getQuantity();
			}
			
			return total;
		}
		
		//カートに追加
		public void add(Book newBook) {
			Book existBook = null;
			//現在のカートの商品から同一のIDを探す
			for(Book book : bookList) {
				if(book.getId() == newBook.getId()) {
					existBook = book;
					break;
				}
			}
			
			//カート内に商品が存在しなかった場合はカートに追加
			//存在した場合は、戸数の更新をする
			if(existBook == null) {
				bookList.add(newBook);
			} else {
				existBook.setQuantity(existBook.getQuantity() + newBook.getQuantity());
			}
		}
		
		//カートから商品を削除
		public void delete(int bookId) {
			//現在の商品から同一のIDを探す
			for(Book book : bookList) {
				//対象の商品IDが見つかった場合削除する
				if(book.getId() == bookId) {
					bookList.remove(book);
					break;
				}
				
			
			}
		}
			//カートの中身を全てクリア
			public void clear() {
				bookList = new ArrayList<>();
			
		}
}
