-- テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS new_books;
DROP TABLE IF EXISTS rents;
DROP TABLE IF EXISTS categories;


--ユーザーテーブル
	CREATE TABLE users
	(
		id SERIAL PRIMARY KEY,
		name TEXT,
		password TEXT
		);
		
--カテゴリーテーブル
CREATE TABLE categories
	(
		id SERIAL PRIMARY KEY,
		name TEXT
		);
		
--図書テーブル
CREATE TABLE books
	(
		id SERIAL PRIMARY KEY,
		name TEXT,
		author TEXT,
		category_id INTEGER,
		category_name TEXT
		);
		

--貸し出し詳細テーブル
CREATE TABLE rents
	(
		id SERIAL PRIMARY KEY,
		user_name TEXT,
		user_passwrd TEXT,
		book_name TEXT,
		rent_on DATE,
		deadline DATE
		);
	
--新規入荷著書テーブル
CREATE TABLE new_books
	(
		id SERIAL PRIMARY KEY,
		category_id INTEGER,
		category_name TEXT,
		name TEXT,
		author TEXT,
		new_book_on DATE
		);