CREATE TABLE `orders` (
	`order_no` INT NOT NULL AUTO_INCREMENT COMMENT '주문고유번호',
	`product_no` INT NOT NULL COMMENT '상품고유번호',
	`user_no` INT NOT NULL COMMENT '회원고유번호',
	`total_price` INT NOT NULL COMMENT '총 결재 금액',
	`order_date` TIMESTAMP NOT NULL COMMENT '주문일자',
	`payment` VARCHAR(50) NOT NULL COMMENT '무통장입금/신용카드',
	`name` VARCHAR(15) NOT NULL COMMENT '받는분성함',
	`post_code` VARCHAR(10) NOT NULL COMMENT '우편번호',
	`addr` VARCHAR(200) NOT NULL COMMENT '주소',
	`phone` VARCHAR(200) NOT NULL COMMENT '휴대폰 번호',
	`req` VARCHAR(100) NULL DEFAULT '조심히 안전하게 와주세요' COMMENT '배송요청사항',
	PRIMARY KEY (`order_no`),
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`),
	FOREIGN KEY (`product_no`) REFERENCES `products`(`product_no`)
);

INSERT INTO orders (product_no, user_no, total_price, order_date, payment, name, post_code, addr, phone, req)
VALUES (1, 1, 99000, NOW(), '신용카드', 'John Doe', '06100', '서울시 강남구 테헤란로 123', '010-1234-5678', '경비실에 맡겨주세요');
