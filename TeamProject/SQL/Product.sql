
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


INSERT INTO products (product_name, image_name, image_path, description, price)
VALUES ('무선 이어폰', 'earbuds.jpg', '/images/products/earbuds.jpg', '노이즈 캔슬링 기능이 탑재된 고급 무선 이어폰입니다.', 99000);
