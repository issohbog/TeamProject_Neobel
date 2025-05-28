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
	
	
	OrderDetailService orderDetailService = new OrderDetailServiceImpl(new OrderDetailDAO());
	
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

	
	@Override
	public List<Order> getOrderByUserNo(int userNo) {
		// UserNo 를 조건으로 전달하기 위한 파라미터 맵을 생성 
		Map<String, Object> map = new HashMap<String, Object>();
		
		// DAO에서 이 맵을 이용해 SQL에서 WHERE user_no = ? 와 같은 조건으로 사용도니다. 
		map.put("userNo", userNo);
		
		// 기본 dao에 있는 listBy()	 메서드를 사용해서, userNo 조건에 맞는 장바구니 목록 조회 
		List<Order> orderList = null; 
		
		try {
			orderList = dao.listBy(map);
			for (Order order : orderList) {
				int orderNo = order.getOrderNo();
				
				System.out.println(orderNo);
				
				// orderDetail 목록 조회 
				List<OrderDetail> detailList = orderDetailService.getOrderDetailByOrderNo(orderNo);
				
				// 대표 상품 명 
				String firstProductName = "";
				if ( !detailList.isEmpty() ) {
					Product firstProduct = detailList.get(0).getProduct();
					firstProductName = firstProduct.getProductName();
				}
				
				int count = detailList.size();
				String orderTitle = firstProductName; 
				if( count > 1 ) {
					orderTitle += " 외 " + (count -1) + "개";
				}
				
				System.out.println(orderTitle);
				
				order.setOrderTitle(orderTitle);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;
	}

	@Override
	public void updateOrderCode(Order order) {
		  
		try {
			dao.update(order); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
