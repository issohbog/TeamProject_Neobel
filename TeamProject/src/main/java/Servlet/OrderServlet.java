package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.CartDAO;
import DAO.UserDAO;
import DTO.Cart;
import DTO.Order;
import DTO.User;
import Service.CartService;
import Service.CartServiceImpl;
import Service.UserService;
import Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "";
		
		String path = request.getPathInfo();
		
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loginUser");
//		int userNo = user.getUserNo();
		
		// 사용자 고유번호를 임시로 1로 설정 
		int userNo = 1;
		
		CartDAO cartDao = new CartDAO();
		
		CartService cartService = new CartServiceImpl(cartDao);
		
		List<Cart> cartList = cartService.listByUserNo(userNo);
		for(Cart cart : cartList) {
			System.out.println(cart);
			System.out.println(cart.getProduct());
		}
		
		request.setAttribute("cartList", cartList);
		
		page = "/page/order/orderForm.jsp";
		
		
		if( path == null || "/".equals(path)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. form에서 전송된 데이터 받기 
		// user구현 완료되면 주석 해제하고, 세션에서 받아오기
		// int userNo = Integer.parseInt(request.getParameter("userNo"));
		int userNo = 1; 
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		String payment = request.getParameter("payment");
		
		// 2. 사용자 정보 조회
		UserDAO userDao = new UserDAO();
		UserService userService = new UserServiceImpl(userDao);
		
		User user = userService.selectbyUserNo(userNo);
		
		// 3. Order 객체 생성 
		Order order = Order.builder()
						   .userNo(userNo)
						   .totalPrice(totalPrice)
						   .payment(payment)
						   .name(user.getUserName())
						   .postCode(user.getPostcode())
						   .addr(user.getAddr())
						   .addrDetail(user.getAddrDetail())
						   .req(user.getReq())
						   .build();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
