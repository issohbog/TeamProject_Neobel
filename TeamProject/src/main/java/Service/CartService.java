package Service;

import DTO.Cart;

public interface CartService extends BaseService<Cart> {

<<<<<<< HEAD
	// 장바구니 단일 항목 삭제 
	public boolean remove(int cartNo);

	
	// 장바구니 전체 항목 삭제 
	public boolean clearCart(int userNo);
	
	
	// 장바구니 수량 업데이트 
	public boolean updateQuantity(int cartNo, int quantity);
	
	// 장바구니에 항목 추가 
	public int insert(Cart cart);
	
	// 장바구니에서 동일한 상품 담겨있는지 조회
	public Cart selectByUserNoAndProductNo(int userNo, int productNo);
	
	
=======
>>>>>>> refs/heads/Hong
}
