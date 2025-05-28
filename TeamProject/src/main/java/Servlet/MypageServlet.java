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

@WebServlet("/mypage/*")
public class MypageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserDAO userDAO;
	UserService userService;
	
    public MypageServlet() {
        super();
        this.userDAO = new UserDAO();
        this.userService = new UserServiceImpl(userDAO);
    }

    // 사용자 정보를 보여주는 페이지
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("마이페이지 ...");
        // 세션에서 사용자 정보 가져오기 (예: 로그인된 사용자)
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loginUser");
        String root = request.getContextPath();

        if (currentUser == null) {
            response.sendRedirect(root + "/login");  // 로그인하지 않았다면 로그인 페이지로 리다이렉트
            return;
        }

        // 사용자 정보와 관련된 데이터를 모델로 받아서 JSP에 전달
        request.setAttribute("user", currentUser);

        // mypage.jsp 페이지로 포워딩
        String page = "/page/user/mypage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    // 사용자 정보를 수정하거나 탈퇴하는 기능을 처리하는 부분
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 사용자 정보 가져오기
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loginUser");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");  // 로그인하지 않았다면 로그인 페이지로 리다이렉트
            return;
        }
        
        String path = request.getPathInfo();
        
        if( path.equals("/update") ) {
        	
        	int userNo = Integer.parseInt(request.getParameter("userNo"));
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
     		User user = User.builder()
				     				.userNo(userNo)
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
     	
     		
        	boolean result = userService.update(user);
        	if (result) {
				// 업데이트 성공 시 세션에 저장된 사용자 정보 갱신
				session.setAttribute("loginUser", user);
				response.sendRedirect(request.getContextPath() + "/mypage?success=true"); // 성공 메시지와 함께 마이페이지로 리다이렉트
			} else {
				// 업데이트 실패 시 에러 메시지 출력
				response.getWriter().write("회원 정보 수정에 실패했습니다.");
			}
        	return;
        }
        
        if( path.equals("/delete") ) {
        	int userNo = Integer.parseInt(request.getParameter("userNo"));
        	
        	// 회원 탈퇴 처리
        	boolean result = userService.delete((long) userNo);
        	if (result) {
				// 탈퇴 성공 시 세션 무효화 후 로그인 페이지로 리다이렉트
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login?success=true");
			} else {
				// 탈퇴 실패 시 에러 메시지 출력
				response.getWriter().write("회원 탈퇴에 실패했습니다.");
				response.sendRedirect(request.getContextPath() + "/mypage?error=true"); // 성공 메시지와 함께 마이페이지로 리다이렉트
			}
        	return;
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
        // TODO
//        boolean success = userService.changePassword(currentUser.getUserId(), newPassword);
//
//        if (success) {
//            response.getWriter().write("비밀번호가 성공적으로 변경되었습니다.");
//        } else {
//            response.getWriter().write("비밀번호 변경에 실패했습니다.");
//        }
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
        // TODO
//        boolean success = userService.changePhone(currentUser.getUserId(), newPhone);
//
//        if (success) {
//            response.getWriter().write("전화번호가 성공적으로 변경되었습니다.");
//        } else {
//            response.getWriter().write("전화번호 변경에 실패했습니다.");
//        }
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
        // TODO
//        boolean success = userService.changeAddress(currentUser.getUserId(), newAddress);
//
//        if (success) {
//            response.getWriter().write("주소가 성공적으로 변경되었습니다.");
//        } else {
//            response.getWriter().write("주소 변경에 실패했습니다.");
//        }
    }

    // 회원 탈퇴 처리
    private void withdrawUser(HttpServletRequest request, HttpServletResponse response, User currentUser) throws IOException {
        // 회원 탈퇴 서비스 호출
    	// TODO
//        boolean success = userService.withdrawUser(currentUser.getUserId());
//
//        if (success) {
//            // 세션 무효화 후 로그인 페이지로 리다이렉트
//            request.getSession().invalidate();
//            response.sendRedirect("login.jsp");
//        } else {
//            response.getWriter().write("회원 탈퇴에 실패했습니다.");
//        }
    }
}
