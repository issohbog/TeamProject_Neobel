DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
	`user_no` INT NOT NULL AUTO_INCREMENT COMMENT '회원고유번호',
	`user_id` VARCHAR(64) NOT NULL COMMENT 'UK/UNIQUE',
	`user_pw` VARCHAR(100) NOT NULL COMMENT '비밀번호',
	`user_name` VARCHAR(50) NOT NULL COMMENT '이름',
	`email` VARCHAR(200) NOT NULL COMMENT '이메일/UNIQUE',
	`phone` VARCHAR(200) NOT NULL COMMENT '휴대폰 번호',
	`birth` DATE NULL COMMENT '생년월일',
	`is_admin` TINYINT NOT NULL DEFAULT 0 COMMENT '관리자1 일반사용자0',
	`addr` VARCHAR(200) NOT NULL COMMENT '주소',
	`post_code` VARCHAR(10) NOT NULL COMMENT '우편번호',
	`req` VARCHAR(100) NULL DEFAULT '조심히 안전하게 와주세요' COMMENT '배송요청사항',
	`addr_detail` VARCHAR(100) NULL COMMENT '상세주소(동,호수)',
	PRIMARY KEY (`user_no`)
);


DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
	`product_no` INT NOT NULL AUTO_INCREMENT COMMENT '상품고유번호',
	`product_name` VARCHAR(50) NOT NULL COMMENT '상품명',
	`image_name` VARCHAR(255) NULL COMMENT '상품이미지이름',
	`image_path` VARCHAR(255) NULL COMMENT '상품이미지경로',
	`description` TEXT NULL COMMENT '상품상세설명',
	`price` INT NOT NULL COMMENT '상품가격',
	PRIMARY KEY (`product_no`)
);



DROP TABLE IF EXISTS `orders`;
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
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`) ON DELETE CASCADE,
	FOREIGN KEY (`product_no`) REFERENCES `products`(`product_no`) ON DELETE CASCADE
);




DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
	`order_item_no` INT NOT NULL AUTO_INCREMENT COMMENT '주문상세고유번호',
	`order_no` INT NOT NULL COMMENT '주문고유번호',
	`product_no` INT NOT NULL COMMENT '상품고유번호',
	`quantity` INT NOT NULL COMMENT '상품별 수량',
	`price` INT NOT NULL COMMENT '상품가격',
	PRIMARY KEY (`order_item_no`),
	FOREIGN KEY (`order_no`) REFERENCES `orders`(`order_no`),
	FOREIGN KEY (`product_no`) REFERENCES `products`(`product_no`)
);



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



DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
	`notice_no` INT NOT NULL AUTO_INCREMENT COMMENT '공지사항고유번호',
	`user_no` INT NOT NULL COMMENT '회원고유번호',
	`title` VARCHAR(100) NOT NULL COMMENT '공지사항제목',
	`content` TEXT NOT NULL COMMENT '공지사항내용',
	`created_at` TIMESTAMP NOT NULL DEFAULT now() COMMENT '공지사항작성일자',
	PRIMARY KEY (`notice_no`),
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);
