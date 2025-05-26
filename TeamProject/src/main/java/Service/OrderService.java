package Service;

import java.util.List;

import DTO.Order;
import DTO.OrderDetail;

public interface OrderService extends BaseService<Order> {
	
	// 주문 생성 
	public int insert(Order order);
	
	// 주문 생성 - AUTO_INCREMENT 로 생성된 PK 가져옴
	public Order insertKey(Order order);
	
	// 주문 상세 생성 
	public Order getOrderByOrderNo(int orderNo);
	
}
