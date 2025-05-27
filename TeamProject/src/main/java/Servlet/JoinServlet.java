package Servlet;


import java.io.IOException;

import DAO.UserDAO;
import Service.UserService;
import Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	UserService userService;
	
    public JoinServlet() {
        super();
        this.userDAO = new UserDAO();
        this.userService = new UserServiceImpl(userDAO);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입 페이지");
    	String page = "/page/user/join.jsp";
    	// 로그인 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userNo, userId, userPw, userName, email, phone, birth, isAdmin, addr, addrDetail, postCode, req
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3; 
		String birth1 = request.getParameter("birth1");
		String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");
		String birth = birth1 + "-" + birth2 + "-" + birth3;
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");
		String postCode = request.getParameter("postCode");
		String req = request.getParameter("req");
		
		// DTO 객체 생성
		DTO.User user = DTO.User.builder()
				.userId(userId)
				.userPw(userPw)
				.userName(userName)
				.email(email)
				.phone(phone)
				.birth(birth)
				.addr(addr)
				.addrDetail(addrDetail)
				.postCode(postCode)
				.req(req)
				.build();
		
		
		 boolean result = userService.create(user);
		 if (result) {
			 // /login 페이지로 리다이렉트
			 response.sendRedirect(request.getContextPath() + "/login");
		 }
		 else {
			 // 회원가입 실패 시 다시 회원가입 페이지로 포워딩
			 request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
			 String page = "/page/user/join.jsp?error=true";
			 RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			 dispatcher.forward(request, response);
		 }
		
	}

}


























