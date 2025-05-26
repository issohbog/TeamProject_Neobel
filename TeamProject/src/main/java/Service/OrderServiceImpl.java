package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DTO.Order;
import DTO.OrderDetail;
import DTO.Product;

public class OrderServiceImpl extends BaseServiceImpl<OrderDAO, Order> implements OrderService  {

	OrderDAO orderDAO = new OrderDAO();
	ProductDAO productDAO = new ProductDAO();
	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	
	public OrderServiceImpl(OrderDAO dao) {
		super(dao);
	}

	@Override
	public int insert(Order order) {
		
		int result = 0; 
		
		try {
			result = dao.insert(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order insertKey(Order order) {
		Order newOrder = null; 
		
		try {
			newOrder = dao.insertKey(order);
			System.out.println(newOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newOrder;
	}

	@Override
	public Order getOrderByOrderNo(int orderNo) {
		Order order = null;   
		try {
			
			// 1. 주문 정보 조회 
			order = orderDAO.select(orderNo); 
			
			// 2. 주문 상세 정보 조회 조건 설정 
			Map<String, Object> map = new HashMap<>();
			map.put("orderNo", order.getOrderNo());
			
			// SELECT * FROM order_detail WHERE order_no = ?
			List<OrderDetail> detailList = orderDetailDAO.listBy(map);

			// 3. 각 상세 항목에 상품 정보 추가 
			for (OrderDetail detail : detailList) {
				Product product = productDAO.select(detail.getProductNo());
				detail.setProduct(product);
			}
			// 4. 주문 객체에 상세 항목 세팅 
			order.setDetailList(detailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	

}
