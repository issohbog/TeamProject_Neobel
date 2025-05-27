package Service;

import java.util.List;

import DTO.OrderDetail;

public interface OrderDetailService extends BaseService<OrderDetail>{
	
	// 단건 주문내역 중 개별 상품 insert
	public int insert(OrderDetail detail);
	
	// 단건 주문 중 주문한 상품들 조회 
	public List<OrderDetail> getOrderDetailByOrderNo(int orderNo);
	
}
