package Servlet;

<<<<<<< HEAD
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.CartDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.Cart;
import DTO.Order;
import DTO.OrderDetail;
import DTO.Product;
import DTO.User;
import Service.CartService;
import Service.CartServiceImpl;
import Service.OrderDetailService;
import Service.OrderDetailServiceImpl;
import Service.OrderService;
import Service.OrderServiceImpl;
import Service.ProductService;
import Service.ProductServiceImpl;
import Service.UserService;
import Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
=======
>>>>>>> refs/heads/Hong
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		String page = "";
		
		String path = request.getPathInfo();
		
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loginUser");
//		int userNo = user.getUserNo();
		
		// 사용자 고유번호를 임시로 1로 설정 
		int userNo = 1;
		
		// 1. 파라미터 확인 
		String productNoParam = request.getParameter("productNo");
		String quantityParam = request.getParameter("quantity");
		
		if(productNoParam != null &&  quantityParam != null) {
			// 단일 상품 바로 구매 
			int productNo = Integer.parseInt(productNoParam);
			int quantity = Integer.parseInt(quantityParam);
			
			ProductService productService = new ProductServiceImpl(new ProductDAO());
			Product product = productService.get(productNo);
			
			// 상품 하나만 담긴 임시 cart 객체 생성 
			Cart singleCart = Cart.builder()
								  .userNo(userNo)
								  .productNo(productNo)
								  .quantity(quantity)
								  .product(product)
								  .build();
			
			System.out.println("단일 상품 구매중 ");
			request.setAttribute("cartList", List.of(singleCart));
		} 
		else {
			CartDAO cartDao = new CartDAO();
			
			CartService cartService = new CartServiceImpl(cartDao);
			
			List<Cart> cartList = cartService.listByUserNo(userNo);	
			for(Cart cart : cartList) {
				System.out.println(cart);
				System.out.println(cart.getProduct());
			}
			
			request.setAttribute("cartList", cartList);
		}
		
		page = "/page/order/orderForm.jsp";
		
		
		if( path == null || "/".equals(path)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
		
		
	
=======
		response.getWriter().append("Served at: ").append(request.getContextPath());
>>>>>>> refs/heads/Hong
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
