package DTO;

import java.sql.Date;

import com.alohaclass.jdbc.annotation.Pk;
import com.alohaclass.jdbc.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
//	public User(String userId, String string) {
//		// TODO Auto-generated constructor stub
//	}
	@Pk
	private int userNo; 
	private String userId; 
	private String userPw;
	private String userName; 
	private String email;
	private String phone; 
	private Date birth;
	private int isAdmin;
	private String addr; 
	private String addrDetail;
	private String postcode;
	private String req;
	public String getUserPw() {
		// TODO Auto-generated method stub
		return userPw;
	}
	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}
	
	
}
