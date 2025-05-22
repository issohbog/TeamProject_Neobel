package DTO;

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
	
	@Pk
	private int userNo; 
	private String userId; 
	private String userPw;
	private String userName; 
	private String email;
	private String phone; 
	private String birth;
	private int isAdmin;
	private String addr; 
	private String addrDetail;
	private String postcode;
	private String req;
	
	
}
