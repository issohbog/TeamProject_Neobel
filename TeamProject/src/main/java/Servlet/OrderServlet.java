package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.CartDAO;
import DTO.Cart;
import Service.CartService;
import Service.CartServiceImpl;
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
		
	}

}
