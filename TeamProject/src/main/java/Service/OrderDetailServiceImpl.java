package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.OrderDetail;
import DTO.Product;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetailDAO, OrderDetail> implements OrderDetailService {

	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	
	ProductDAO productDAO = new ProductDAO();
	
	UserDAO userDAO = new UserDAO();
	
	public OrderDetailServiceImpl(OrderDetailDAO dao) {
		super(dao);
	}

	@Override
	public int insert(OrderDetail detail) {
		
		int result = 0; 
		try {
			result = orderDetailDAO.insert(detail); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderNo(int orderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		List<OrderDetail> list = null;
		try {
			list = dao.listBy(map);
			
			for (OrderDetail orderDetail : list) {
				int productNo = orderDetail.getProductNo();
				Product product = productDAO.select(productNo);
				orderDetail.setProduct(product);
	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
