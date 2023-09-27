--ユーザーテーブル
INSERT INTO users(name, password) values('嶋倉駿介', 'himitu');
		
--カテゴリーテーブル
INSERT INTO categories(name) VALUES('社会科');
INSERT INTO categories(name) VALUES('思想');
INSERT INTO categories(name) VALUES('文化');
INSERT INTO categories(name) VALUES('心理');
INSERT INTO categories(name) VALUES('言語');
INSERT INTO categories(name) VALUES('IT');
		
--図書テーブル
INSERT INTO books(category_id, category_name, name, author) VALUES(1, '社会科', '現代社会', '武田信彦');
INSERT INTO books(category_id, category_name, name, author) VALUES(1, '社会科', '近代社会', '池田忍');
INSERT INTO books(category_id, category_name, name, author) VALUES(2, '思想', '優性思想', 'DaiGo');
INSERT INTO books(category_id, category_name, name, author) VALUES(2, '思想', 'バルク主義は正義か', 'balk');
INSERT INTO books(category_id, category_name, name, author) VALUES(3, '文化', '日本文化', '猫ちゃん');
INSERT INTO books(category_id, category_name, name, author) VALUES(3, '文化', 'アメリカ文化', 'B.D.ハート');
INSERT INTO books(category_id, category_name, name, author) VALUES(4, '心理', 'サイコパス', '中野信子');
INSERT INTO books(category_id, category_name, name, author) VALUES(4, '心理', '深層心理', '茂木健一郎');
INSERT INTO books(category_id, category_name, name, author) VALUES(5, '言語', '英語支配', 'English');
INSERT INTO books(category_id, category_name, name, author) VALUES(5, '言語', '日本語', 'Japanese');
INSERT INTO books(category_id, category_name, name, author) VALUES(6, 'IT', 'Javaの基本', 'ja');
INSERT INTO books(category_id, category_name, name, author) VALUES(6, 'IT', 'Pythonの基本', 'py');

--貸し出し詳細テーブル

	
--新規入荷著書テーブル
INSERT INTO new_books(category_id, category_name, name, author, new_book_on) VALUES(7, 'IT', 'Pythonの基本', 'py', '2023-08-03');












