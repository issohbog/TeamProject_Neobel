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

		List<User> list = null;
		
		try {
			 list = dao.listBy(map);
			 
			 if(list != null && !list.isEmpty()) {
				 return list.get(0);				 
			 }
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	

	

} 
