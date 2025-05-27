package Service;

import java.util.List;

import DTO.Cart;

public interface CartService extends BaseService<Cart> {
	
	// 회원별 장바구니 목록
	public List<Cart> listByUserNo(int userNo);

	// 장바구니 단일 항목 삭제 
	public boolean remove(int cartNo);

	public boolean insert(Cart cart);
	
}
