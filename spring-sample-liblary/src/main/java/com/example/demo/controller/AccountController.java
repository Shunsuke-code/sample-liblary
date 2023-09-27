package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	Account account;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	HttpSession session;
	
	//ログイン画面
	@GetMapping({"/", "login", "/logout"})
		public String index() {
		
		//ログアウト
		session.invalidate();
		
		return "login";
	}
	
	//新規ユーザー登録画面
		@GetMapping("/user")
			public String user() {
			return "user";
		}
		
	//新規ユーザー登録処理
		
		@PostMapping("/user")
		public String add(
				@RequestParam(name = "name")String name,
				@RequestParam(name = "password")String password,
				Model model
				) {
			
			User users = accountRepository.findByNameAndPassword(name, password);
			if(users != null) {
				model.addAttribute("error", "既に登録されています");
				return "user";
			}
			
			//名前とパスワードエラーチェック
			if(name == null || name.length() == 0) {
				model.addAttribute("name", "名前を入力してください。");
				return "user";
			}
			
			if(password == null ||password.length() == 0) {
				model.addAttribute("password", "パスワードを入力してください。");
				return "user";
			}	else {
			
			//データベースに登録	
			User user = new User(name, password);
			accountRepository.save(user);
			
			
				return "redirect:/login";
				
			}
		}
	
	//ログイン実行
	
		@PostMapping("/login")
			public String login(
					@RequestParam(name = "name")String name,
					@RequestParam(name = "password")String password,
					Model model) {
			
			User users = accountRepository.findByNameAndPassword(name, password);
			
			if(name == null || name.length() == 0) {
				model.addAttribute("name", "名前を入力してください。");
				return "login";
			}
			
			if(password == null ||password.length() == 0) {
				model.addAttribute("password", "パスワードを入力してください。");
				return "login";
			}
			
			
			if(users == null) {
				model.addAttribute("newUser", "ユーザー登録がされていません。");
				return "login";
			}
				
			else {
			//データベースに保存したアカウント情報の取得
			User user = accountRepository.findByName(name).get(0);
			
			
			account.setName(user.getName());
		
			
			return "redirect:/book";
		}
	
			
		}
	
}
