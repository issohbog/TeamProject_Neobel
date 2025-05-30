package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.OrderDAO;
import DTO.Order;
import DTO.User;
import Service.OrderService;
import Service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/order/history")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl(new OrderDAO());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// userNo를 세션에서 받아오기
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");	
		
		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;  
		}
		
		Integer userNo = loginUser.getUserNo();
		

		List<Order> orders = orderService.getOrderByUserNo(userNo); 
		request.setAttribute("orders", orders);
		System.out.println(orders);
        request.getRequestDispatcher("/page/order/orderHistory.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
