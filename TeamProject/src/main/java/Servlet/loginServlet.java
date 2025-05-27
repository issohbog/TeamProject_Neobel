package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet<UserService> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// UserService 객체 생성
    private UserServiceImpl userService = new UserServiceImpl();

    // 로그인 페이지 출력 (GET 요청 시)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    // 로그인 처리 (POST 요청 시)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터 받아오기
        String userId = request.getParameter("user_id");
        String password = request.getParameter("password");

        // 입력된 사용자 정보가 유효한지 확인
        boolean isValidUser = userService.login(userId, password);

        if (isValidUser) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", userId);

            // 마이페이지로 리다이렉트
            response.sendRedirect("mypage");
        } else {
            // 로그인 실패 시, 경고 메시지 설정
            request.setAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            
            // 로그인 페이지로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

}
