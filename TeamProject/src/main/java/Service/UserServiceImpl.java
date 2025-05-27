package Service;

import java.sql.SQLException;

import DAO.UserDAO;
import DTO.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDao = new UserDAO();

    // 회원가입 처리
    @Override
    public void registerUser(User user) {
        userDao.insertUser((DTO.User) user);
    }

    // 로그인 처리
    @Override
    public boolean login(String userId, String password) throws SQLException {
        User user = userDao.findByUserId(userId);
        return user != null && user.getUserPw().equals(password);  // 비밀번호 비교
    }

    // 비밀번호 변경
    @Override
    public boolean changePassword(String userId, String newPassword) {
        return userDao.updatePassword(userId, newPassword);
    }

    // 전화번호 변경
    @Override
    public boolean changePhone(String userId, String newPhone) {
        return userDao.updatePhone(userId, newPhone);
    }

    // 주소 변경
    @Override
    public boolean changeAddress(String userId, String newAddress) {
        return userDao.updateAddress(userId, newAddress);
    }

    // 회원 탈퇴
    @Override
    public boolean withdrawUser(String userId) {
        return userDao.deleteUser(userId);
    }

    // 아이디 중복 확인
    @Override
    public boolean isUserIdDuplicate(String userId) {
        try {
			return userDao.findByUserId(userId) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("이미 존재하는 아이디 입니다.");
			e.printStackTrace();
		}
		return false;
    }
    
    // 아이디 존재여부 확인
    @Override
    public boolean isUserIdExists(String id) {
        return userDao.existsById(id); // DAO에서 실제 DB 확인
    }

	
}

