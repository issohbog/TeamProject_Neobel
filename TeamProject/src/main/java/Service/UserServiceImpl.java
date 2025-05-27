package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.UserDAO;
import DTO.User;

public class UserServiceImpl extends BaseServiceImpl<UserDAO, User> implements  UserService{

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
	
	

	

} 
