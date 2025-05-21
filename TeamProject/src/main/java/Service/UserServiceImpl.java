package Service;

import com.alohaclass.jdbc.dto.PageInfo;
import com.alohaclass.test.DTO.Board;
import com.alohaclass.test.Service.BoardService;

import DAO.UserDAO;
import DTO.User;

public class UserServiceImpl extends BaseServiceImpl<UserDAO, User> implements  UserService{

	public UserServiceImpl(UserDAO dao) {
		super(dao);
	}

	

} 
