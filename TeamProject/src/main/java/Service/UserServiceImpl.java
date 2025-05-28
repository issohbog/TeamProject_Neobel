package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.UserDAO;
import DTO.User;

public class UserServiceImpl extends BaseServiceImpl<UserDAO, User> implements  UserService {

	public UserServiceImpl(UserDAO dao) {
		super(dao);
	}

	@Override
	public User selectbyUserNo(int userNo) {
		
		Map<String , Object> map = new HashMap<>();
		map.put("userNo", userNo);

		User user = null;
		
		try {
			user = dao.select( userNo );			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User login(String userId, String userPw) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("user_id", userId);
		User user = null;
		try {
			user = dao.selectBy(map);
			
			if (user != null && user.getUserPw().equals(userPw)) {
				return user; // 로그인 성공
			} else {
				return null; // 로그인 실패
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	

} 















