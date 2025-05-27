package Service;

import com.alohaclass.test.Service.BoardService;

import DAO.CartDAO;
import DTO.Cart;

public class CartServiceImpl extends BaseServiceImpl<CartDAO, Cart> implements CartService {

	public CartServiceImpl(CartDAO dao) {
		super(dao);
	}

	 
}
