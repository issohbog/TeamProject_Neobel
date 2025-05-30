package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.OrderDAO;
import DTO.Order;
import Service.OrderService;
import Service.OrderServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/order/history")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl(new OrderDAO());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Integer userNo = (Integer) session.getAttribute("loginUserNo");	
//		if (userNo == null) {
//			response.sendRedirect(request.getContextPath() + "/login.jsp");
//			return;  
//		}
		
		
		int userNo = 5;
		List<Order> orders = orderService.getOrderByUserNo(userNo); 
		request.setAttribute("orders", orders);
		System.out.println(orders);
        request.getRequestDispatcher("/page/order/orderHistory.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
