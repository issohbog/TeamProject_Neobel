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
	
	// 주문 목록 생성 - 모든 주문 내역 확인 용 
	public List<Order> getOrderByUserNo(int userNo);
	
	// 주문 코드 (order_code) 생성 (java에서 생성 후 db에 업데이트)
	public void updateOrderCode(Order order);
	
}
