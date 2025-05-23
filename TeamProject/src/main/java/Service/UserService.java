package Service;

import java.util.List;

import DTO.Cart;
import DTO.User;

public interface UserService extends BaseService<User> {

	// userNo로 User정보 조회 
	User selectbyUserNo(int userNo);
}
