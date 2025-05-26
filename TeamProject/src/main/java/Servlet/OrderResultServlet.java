package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DTO.Order;
import DTO.OrderDetail;
import DTO.Product;
import Service.OrderDetailService;
import Service.OrderDetailServiceImpl;
import Service.OrderService;
import Service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderResultServlet
 */
@WebServlet("/order/result")
public class OrderResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl(new OrderDAO());
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl(new OrderDetailDAO());
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. orderNo 파라미터 받아오기 
		String orderNoStr = request.getParameter("orderNo");
		if(orderNoStr != null && !orderNoStr.isEmpty()) {
			int orderNo = Integer.parseInt(orderNoStr);
			
			// 2. Order 정보 조회 
			Order order = orderService.getOrderByOrderNo(orderNo);		// detailList, product까지 포함 
			
			if (order != null) {
			    System.out.println("====== 주문 정보 ======");
			    System.out.println("주문 번호: " + order.getOrderNo());
			    System.out.println("총 결제 금액: " + order.getTotalPrice());
			    System.out.println("받는 분: " + order.getName());

			    System.out.println("====== 주문 상세 ======");
			    for (OrderDetail detail : order.getDetailList()) {
			        Product product = detail.getProduct();
			        System.out.println("상품명: " + product.getProductName());
			        System.out.println("상품 가격: " + product.getPrice());
			        System.out.println("수량: " + detail.getQuantity());
			        System.out.println("소계: " + detail.getPrice());
			        System.out.println("-------------------------");
			    }
			 
			
			
				
				request.setAttribute("order", order);
				request.setAttribute("showModal", true);
				
				// 5. 주문 결과 화면으로 포워딩 
				request.getRequestDispatcher("/page/order/orderResult.jsp").forward(request, response);
			} else {
				// 주문이 존재하지 않으면 실패 처리 
				response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
			} 
		} else {
			// orderNo가 없으면 잘못된 접근 처리 
			response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
