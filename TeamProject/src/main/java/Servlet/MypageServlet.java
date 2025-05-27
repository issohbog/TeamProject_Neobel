package Servlet;

import java.io.IOException;

import DTO.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MypageServlet<UserService> extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // UserService나 관련 서비스 클래스 인스턴스 생성
    private UserServiceImpl userService = new UserServiceImpl();

    // 사용자 정보를 보여주는 페이지
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 사용자 정보 가져오기 (예: 로그인된 사용자)
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loggedInUser");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");  // 로그인하지 않았다면 로그인 페이지로 리다이렉트
            return;
        }

        // 사용자 정보와 관련된 데이터를 모델로 받아서 JSP에 전달
        request.setAttribute("user", currentUser);

        // mypage.jsp 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mypage.jsp");
        dispatcher.forward(request, response);
    }

    // 사용자 정보를 수정하거나 탈퇴하는 기능을 처리하는 부분
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 사용자 정보 가져오기
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loggedInUser");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");  // 로그인하지 않았다면 로그인 페이지로 리다이렉트
            return;
        }

        // 파라미터에 따라 적절한 처리 실행
        String action = request.getParameter("action");

        if ("changePassword".equals(action)) {
            changePassword(request, response, currentUser);
        } else if ("changePhone".equals(action)) {
            changePhone(request, response, currentUser);
        } else if ("changeAddress".equals(action)) {
            changeAddress(request, response, currentUser);
        } else if ("withdraw".equals(action)) {
            withdrawUser(request, response, currentUser);
        }
    }

    // 비밀번호 변경 처리
    private void changePassword(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {
        String newPassword = request.getParameter("newPassword");

        // 비밀번호 유효성 체크
        if (newPassword == null || newPassword.isEmpty()) {
            response.getWriter().write("비밀번호를 입력해주세요.");
            return;
        }

        // 비밀번호 변경 서비스 호출
        boolean success = userService.changePassword(currentUser.getUserId(), newPassword);

        if (success) {
            response.getWriter().write("비밀번호가 성공적으로 변경되었습니다.");
        } else {
            response.getWriter().write("비밀번호 변경에 실패했습니다.");
        }
    }

    // 전화번호 변경 처리
    private void changePhone(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {
        String newPhone = request.getParameter("newPhone");

        // 전화번호 유효성 체크
        if (newPhone == null || newPhone.isEmpty()) {
            response.getWriter().write("전화번호를 입력해주세요.");
            return;
        }

        // 전화번호 변경 서비스 호출
        boolean success = userService.changePhone(currentUser.getUserId(), newPhone);

        if (success) {
            response.getWriter().write("전화번호가 성공적으로 변경되었습니다.");
        } else {
            response.getWriter().write("전화번호 변경에 실패했습니다.");
        }
    }

    // 주소 변경 처리
    private void changeAddress(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {
        String newAddress = request.getParameter("newAddress");

        // 주소 유효성 체크
        if (newAddress == null || newAddress.isEmpty()) {
            response.getWriter().write("주소를 입력해주세요.");
            return;
        }

        // 주소 변경 서비스 호출
        boolean success = userService.changeAddress(currentUser.getUserId(), newAddress);

        if (success) {
            response.getWriter().write("주소가 성공적으로 변경되었습니다.");
        } else {
            response.getWriter().write("주소 변경에 실패했습니다.");
        }
    }

    // 회원 탈퇴 처리
    private void withdrawUser(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {
        // 회원 탈퇴 서비스 호출
        boolean success = userService.withdrawUser(currentUser.getUserId());

        if (success) {
            // 세션 무효화 후 로그인 페이지로 리다이렉트
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().write("회원 탈퇴에 실패했습니다.");
        }
    }
}
