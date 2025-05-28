package Servlet;

import java.io.IOException;

import DAO.UserDAO;
import DTO.User;
import Service.UserService;
import Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	UserService userService;
	
    public LoginServlet() {
        super();
        this.userDAO = new UserDAO();
        this.userService = new UserServiceImpl(userDAO);
    }
       

    // 로그인 페이지 출력 (GET 요청 시)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("login 페이지");
    	String page = "/page/user/login.jsp";
    	// 로그인 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    // 로그인 처리 (POST 요청 시)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String root = request.getContextPath();
        // 요청 파라미터 받아오기
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        
        // 입력된 사용자 정보가 유효한지 확인
        User loginUser = userService.login(userId, userPw);

        if (loginUser != null) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);

            // 마이페이지로 리다이렉트
            response.sendRedirect(root + "");
        } else {
            // 로그인 실패 시, 경고 메시지 설정
            request.setAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            String page = "/page/user/login.jsp?error=true";
            // 로그인 페이지로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }

}
