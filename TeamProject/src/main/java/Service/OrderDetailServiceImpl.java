package Service;

import DAO.OrderDetailDAO;
import DTO.OrderDetail;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetailDAO, OrderDetail> implements OrderDetailService {

	public OrderDetailServiceImpl(OrderDetailDAO dao) {
		super(dao);
	}

}
