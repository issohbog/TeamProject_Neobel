package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.CartDAO;
import DTO.Cart;
import Service.CartService;
import Service.CartServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CartDAO cartDao = new CartDAO();
		CartService cartService = new CartServiceImpl(cartDao);
		List<Cart> cartList =  cartService.list();
		for (Cart cart : cartList) {
			System.out.println(cart);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("dopost 실행");

		System.out.println("getServletPath = " + request.getServletPath());
		System.out.println("getPathInfo = " + request.getPathInfo());
		System.out.println("requestURI = " + request.getRequestURI());
		System.out.println("requestURL = " + request.getRequestURL());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		String path = request.getPathInfo();
		
		
		if("/updateQuantity".equals(path)) {
			ServletInputStream sis = request.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(sis, new HashMap().getClass());
		
			
			int cartNo = (Integer)(map.get("cartNo"));
			int quantity = (Integer)(map.get("quantity"));
			
			Cart updateCart = new Cart();
			updateCart.setCartNo(cartNo);
			updateCart.setQuantity(quantity);

			
			System.out.println("cartNo: " + updateCart.getCartNo());
			System.out.println("quantity: " + updateCart.getQuantity());
			
			
			// 수량 업데이트 서비스 호출 
			boolean result = cartService.updateQuantity(updateCart.getCartNo(), updateCart.getQuantity());
			
			String jsonString = mapper.writeValueAsString(updateCart);
			PrintWriter writer = response.getWriter();
			writer.println(jsonString);
			
		}
		
		if("/insert".equals(path)) {
			
			int result = 1; 
			
			// 1. 파라미터 받기 
			// 로그인 구현시 userNo  변경 
			int userNo = 1; 
			int productNo = Integer.parseInt(request.getParameter("productNo"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			
			// 2. 기존 장바구니에 있는지 확인 
			Cart existing = cartService.selectByUserNoAndProductNo(userNo, productNo);
			
			if(existing != null) {
				// 3. 이미 있다면 -> 수량만 증가시켜 update 
				int newQuantity = existing.getQuantity() + quantity; 
				existing.setQuantity(newQuantity);
				boolean updated = cartService.updateQuantity(existing.getCartNo(), newQuantity);
				result = updated ? 1 : 0; 
				System.out.println("수량만 업데이트");
			} else {
				// 4. 없으면 -> 새로 insert 
				// 4-1. Cart 객체 생성 
				Cart cart = Cart.builder()
								.userNo(userNo)
								.productNo(productNo)
								.quantity(quantity)
								.build();
				
				// 4-2. DB에 insert
				result = cartService.insert(cart);
				
				
			}
			
			
			
			// 4. 결과 처리 (장바구니 페이지로 이동) 
			if( result > 0 ) {
				response.sendRedirect(request.getContextPath() + "/cart");
			} else {
				response.sendRedirect(request.getContextPath() + "/product/productNo=" + productNo);

			}
			
		}
		
		
	}



	
	// TODO: 
	// 1. doDelete 오버라이딩
	// 2. cartNo 파라미터 가져오기
	// 3. cartService.delete( cartNo )
	// ...
	// 4. 성공 :
	// response.setStatus(200);
	// out.print("SUCCESS")
	// 5. 실패 :
	// response.setStatus(500);
	// out.print("FAIL")
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String cartNoParm = request.getParameter("cartNo");
	    System.out.println("cartNoParm = " + cartNoParm);
	    
	    String path = request.getPathInfo(); 
	    
	    
	    if ("/clear".equals(path)) {
//			HttpSession session = request.getSession();
//			User user = (User) session.getAttribute("loginUser");
//			int userNo = user.getUserNo();
			
			// 사용자 고유번호를 임시로 1로 설정 
			int userNo = 1;

	        boolean result = cartService.clearCart(userNo);

	        if (result) {
	            response.setStatus(200);
	            response.getWriter().print("SUCCESS");
	        } else {
	            response.setStatus(500);
	            response.getWriter().print("FAIL");
	        }
	        return;
	    }
	    
	    
	    

	    if (cartNoParm == null || cartNoParm.isEmpty()) {
	        response.setStatus(400); // Bad request
	        response.getWriter().print("NO_PARAM");
	        return;
	    } 

	    // 선택 삭제 (콤마가 포함되어 있을 때)
	    if (cartNoParm.contains(",")) {
	        String[] cartNoArr = cartNoParm.split(",");
	        boolean allSuccess = true;

	        for (String cartNoStr : cartNoArr) {
	            try {
	                Long cartNo = Long.parseLong(cartNoStr.trim());
	                boolean deleted = cartService.delete(cartNo);
	                if (!deleted) {
	                    allSuccess = false;
	                    break;
	                }
	            } catch (NumberFormatException e) {
	                allSuccess = false;
	                break;
	            }
	        }

	        if (allSuccess) {
	            response.setStatus(200);
	            response.getWriter().print("SUCCESS");
	        } else {
	            response.setStatus(500);
	            response.getWriter().print("FAIL");
	        }

	    // 개별 삭제
	    } else {
	        try {
	            Long cartNo = Long.parseLong(cartNoParm);
	            boolean result = cartService.delete(cartNo);

	            if (result) {
	                response.setStatus(200);
	                response.getWriter().print("SUCCESS");
	            } else {
	                response.setStatus(500);
	                response.getWriter().print("FAIL");
	            }

	        } catch (NumberFormatException e) {
	            response.setStatus(400);
	            response.getWriter().print("INVALID_ID");
	        }
	    }
	}

//	@Override
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doput 실행");
//
//		System.out.println("getServletPath = " + request.getServletPath());
//		System.out.println("getPathInfo = " + request.getPathInfo());
//		System.out.println("requestURI = " + request.getRequestURI());
//		System.out.println("requestURL = " + request.getRequestURL());
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=UTF-8");
//		
//		String path = request.getPathInfo();
//		
//		
//		if("/updateQuantity".equals(path)) {
//			ServletInputStream sis = request.getInputStream();
//			ObjectMapper mapper = new ObjectMapper();
//			Cart cart = mapper.readValue(sis, Cart.class);
//			
//			System.out.println("cartNo: " + cart.getCartNo());
//			System.out.println("quantity: " + cart.getQuantity());
//		}
//		
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("🔥 service() 실행 - method: " + request.getMethod());
		super.service(request, response);
	}
	
	
	
	

	
	

}
