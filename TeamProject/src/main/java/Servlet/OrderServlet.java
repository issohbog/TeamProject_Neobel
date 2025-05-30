package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "";
		
		String path = request.getPathInfo();
		String root = request.getContextPath();
		
		HttpSession session = request.getSession();
		Object loginUserObj = session.getAttribute("loginUser");
		System.out.println(loginUserObj + "############");
		User user = loginUserObj != null ? (User) loginUserObj : null;
		
		if( user == null ) {
			System.out.println("로그인 해야 장바구니에 담을 수 있습니다.");
			response.sendRedirect(root + "/login");
			return;
		}
		// 사용자 번호 
		int userNo = user.getUserNo();
		
		// 1. 파라미터 확인 
		String productNoParam = request.getParameter("productNo");
		String quantityParam = request.getParameter("quantity");
		
		// 단일 구매
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
		// 장바구니 구매
		else {
			CartDAO cartDao = new CartDAO();
			
			CartService cartService = new CartServiceImpl(cartDao);
			
			List<Cart> cartList = cartService.listByUserNo(userNo);	
			for(Cart cart : cartList) {
				System.out.println(cart);
				System.out.println(cart.getProduct());
			}
			String isCart = request.getParameter("isCart");
			request.setAttribute("isCart", isCart);
			request.setAttribute("cartList", cartList);
		}
		
		page = "/page/order/orderForm.jsp";
		
		
		if( path == null || "/".equals(path)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		// userNo를 세션에서 받아오기
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");	
		
		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;  
		}
		
		Integer userNo = loginUser.getUserNo();
		System.out.println("주문서userNo: " + userNo);
		

		// 1. form에서 전송된 데이터 받기 
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		String payment = request.getParameter("payment");
		
		// 2. 사용자 정보 조회
		UserDAO userDao = new UserDAO();
		UserService userService = new UserServiceImpl(userDao);
		
		
		User user = userService.selectbyUserNo(userNo);
		
		System.out.println("user = " + user);
		
		// 3. Order 객체 생성 
		Order order = Order.builder()
						   .userNo(userNo)
						   .totalPrice(totalPrice)
						   .payment(payment)
						   .name(user.getUserName())
						   .postCode(user.getPostCode())
						   .addr(user.getAddr())
						   .addrDetail(user.getAddrDetail())
						   .phone(user.getPhone())
						   .req(user.getReq())
						   .build();
		
		
		// 4. order insert
		OrderDAO orderDao = new OrderDAO();
		OrderService orderService = new OrderServiceImpl(orderDao);
		
		// insertKey는 insert후 auto_increment 된 orderNo까지 포함시켜 Order객체로 반환해줄 수 있다. 
		Order orderResult = orderService.insertKey(order);
		System.out.println(orderResult.getOrderNo());
		
		// 4-1. 주문코드 생성 (yyyyMMdd-000001 형식)
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String orderCode = today + "-" + String.format("%07d", orderResult.getOrderNo());

		// 4-2. 주문 객체에 세팅
		orderResult.setOrderCode(orderCode);
		
		// 4-3. DB에 order_code 업데이트
		orderService.updateOrderCode(orderResult); // update 문 실행
 
		if( orderResult != null ) {
			System.out.println("주문 성공 : " + orderResult.getOrderNo());
			
			System.out.println("order 객체의 주문코드 " + orderResult.getOrderCode());
			
			// ----- TODO: 제거--- 5. 장바구니 목록 조회 
			// 5. 주문 상품 상세 목록
			// - 상품번호
			String[] productNoStringList = request.getParameterValues("productNo");
			List<Integer> productNoList = new ArrayList<Integer>();
			for (String productNoStr : productNoStringList) {
				Integer productNo = Integer.parseInt(productNoStr);
				productNoList.add(productNo);
			}
			// - 수량
			String[] quantityStringList = request.getParameterValues("quantity");
			List<Integer> quantityList = new ArrayList<Integer>();
			for (String quantityStr : quantityStringList) {
				Integer quantity = Integer.parseInt(quantityStr);
				quantityList.add(quantity);
			}
			// - 가격
			String[] priceStringList = request.getParameterValues("price");
			List<Integer> priceList = new ArrayList<Integer>();
			for (String priceStr : priceStringList) {
				Integer price = Integer.parseInt(priceStr);
				priceList.add(price);
			}
			
			

			
			// 6. order_detail insert
			OrderDetailService orderDetailService = new OrderDetailServiceImpl(new OrderDetailDAO());
			
			System.out.println(order.getOrderNo());
			
			
			for( int i = 0 ; i < productNoList.size() ; i++) {
				OrderDetail detail = OrderDetail.builder()
												.orderNo(orderResult.getOrderNo())
												.productNo(productNoList.get(i))
												.quantity(quantityList.get(i))
												.price(priceList.get(i))
												.build();
				
				orderDetailService.insert(detail); 
			}
			
			// 7. 장바구니 비우기 (구현 완료후 주석 해제)
			String isCart = request.getParameter("isCart");
			System.out.println("장바구니주문 : isCart - " + isCart);
			if( isCart != null && Boolean.parseBoolean(isCart) ) {
				CartService cartService = new CartServiceImpl(new CartDAO());
//				List<Cart> cartList = cartService.listByUserNo(userNo);
				cartService.clearCart(userNo);
			}
			
			
			// 8. 주문 완료 페이지로 이동
			// 리다이렉트 방식 
			response.sendRedirect(request.getContextPath() + "/order/result?orderNo=" + orderResult.getOrderNo() + "&showModal=true"  );
			return;
			
		} 
		
		
		
		
		// 포워드 방식 
//			request.setAttribute("order", order);
//			request.setAttribute("showModal", true);
//			request.getRequestDispatcher("/page/order/orderResult.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
