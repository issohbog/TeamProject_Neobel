package Service;

import java.util.List;

import DTO.Cart;

public interface CartService extends BaseService<Cart> {
	
	// 회원별 장바구니 목록
	public List<Cart> listByUserNo(int userNo);

	// 장바구니 단일 항목 삭제 
	public boolean remove(int cartNo);

	
	// 장바구니 전체 항목 삭제 
	public boolean clearCart(int userNo);
	
	
	// 장바구니 수량 업데이트 
	public boolean updateQuantity(int cartNo, int quantity);
	
}
