package Service;

import DAO.OrderDAO;
import DTO.Order;

public class OrderServiceImpl extends BaseServiceImpl<OrderDAO, Order> implements OrderService  {

	public OrderServiceImpl(OrderDAO dao) {
		super(dao);
	}

}
