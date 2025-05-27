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
		// userNo 를 조건으로 전달하기 위한 파라미터 맵을 생성 
		Map<String, Object> map = new HashMap<String, Object>();
		
		// DAO에서 이 맵을 이용해 SQL에서 WHERE user_no = ?와 같은 조건으로 사용된다. 
		map.put("userNo", userNo);
		
		// 기본 dao에 있는 listBy() 메서드를 사용해서, userNo 조건에 맞는 장바구니 목록 조회
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
	    try {
	        int result = dao.delete((long) cartNo);
	        return result > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}



	

	@Override
	public boolean updateQuantity(int cartNo, int quantity) {
		int result = 0; 
		try {
			Cart cart = new Cart();
			cart.setCartNo(cartNo);
			cart.setQuantity(quantity);
			result = cartDAO.update(cart);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	@Override
	public boolean clearCart(int userNo) {
		int result = 0; 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		try {
			result = cartDAO.deleteBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	
	@Override
	public int insert(Cart cart) {
		int result = 0; 
		try {
			return dao.insert(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public Cart selectByUserNoAndProductNo(int userNo, int productNo) {
		Cart cart = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_no", userNo);
		map.put("product_no", productNo);
		System.out.println(userNo);
		System.out.println(productNo);
		
		try {
			cart = dao.selectBy(map);
			System.out.println(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	
	

	 

}











