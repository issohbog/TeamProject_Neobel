package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alohaclass.jdbc.dao.BaseDAOImpl;

import DTO.User;

public class UserDAO extends BaseDAOImpl<User> {

	private static final Statement DBUtil = null;

	public User findByUserId(String userId) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUserPw(rs.getString("user_pw"));  // 비밀번호 설정
                user.setUserName(rs.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO users (user_id, user_pw, user_name, email, phone, birth) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getUserPw());
            stmt.setString(3, user.getUserName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setDate(6, user.getBirth());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 비밀번호 업데이트
    public boolean updatePassword(String userId, String newPassword) {
        // DB에서 비밀번호를 업데이트
        return true;
    }

    // 전화번호 업데이트
    public boolean updatePhone(String userId, String newPhone) {
        // DB에서 전화번호 업데이트
        return true;
    }

    // 주소 업데이트
    public boolean updateAddress(String userId, String newAddress) {
        // DB에서 주소 업데이트
        return true;
    }

    // 사용자 삭제
    public boolean deleteUser(String userId) {
        // DB에서 사용자 삭제
        return true;
    }

	public boolean existsByuserId(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existsById(String userId) {
		// TODO Auto-generated method stub
		return false;
	}


}
