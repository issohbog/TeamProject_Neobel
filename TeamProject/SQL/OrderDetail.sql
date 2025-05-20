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

INSERT INTO order_detail (order_no, product_no, quantity, price)
VALUES (1, 1, 1, 99000);
