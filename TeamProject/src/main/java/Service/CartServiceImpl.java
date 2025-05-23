package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.CartDAO;
import DAO.ProductDAO;
import DTO.Cart;
import DTO.Product;

public class CartServiceImpl extends BaseServiceImpl<CartDAO, Cart> implements CartService {

	ProductDAO productDAO = new ProductDAO();
	
	CartDAO cartDAO = new CartDAO();
	
	public CartServiceImpl(CartDAO dao) {
		super(dao);
	}

	@Override
	public List<Cart> listByUserNo(int userNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		List<Cart> list = null;
		try {
			list = dao.listBy(map);

			// ★★★ cart join product
			for (Cart cart : list) {
				int productNo = cart.getProductNo();
				Product product = productDAO.select(productNo);
				cart.setProduct(product);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean remove(int cartNo) {
		int result = 0;
		try {
			result = cartDAO.delete(cartNo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result > 0;
	}

	 
}
