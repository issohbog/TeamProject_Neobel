-- Active: 1745889698386@@127.0.0.1@3306@neobel

DROP TABLE IF EXISTS `carts`;

CREATE TABLE `carts` (
	`cart_no` INT NOT NULL AUTO_INCREMENT COMMENT '장바구니고유번호',
	`user_no` INT NOT NULL COMMENT '회원고유번호',
	`product_no` INT NOT NULL COMMENT '상품고유번호',
	`quantity` INT NOT NULL COMMENT '상품 수량',
	PRIMARY KEY (`cart_no`),
	UNIQUE KEY `UK_user_product` (`user_no`, `product_no`),
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)  ON DELETE CASCADE,
	FOREIGN KEY (`product_no`) REFERENCES `products`(`product_no`)  ON DELETE CASCADE
);

INSERT INTO carts (user_no, product_no, quantity)
VALUES (1, 1, 2);