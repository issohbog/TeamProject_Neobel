package Service;

import java.sql.SQLException;

import DTO.User;

public interface UserService {
    // 사용자 등록
    void registerUser(User user);

    // 사용자 로그인
    boolean login(String userId, String password) throws SQLException;

    // 비밀번호 변경
    boolean changePassword(String userId, String newPassword);

    // 전화번호 변경
    boolean changePhone(String userId, String newPhone);

    // 주소 변경
    boolean changeAddress(String userId, String newAddress);

    // 회원 탈퇴
    boolean withdrawUser(String userId);

    // 아이디 중복 확인
    boolean isUserIdDuplicate(String userId);

    // 아이디 존재 여부 확인
	boolean isUserIdExists(String id);
}

