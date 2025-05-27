package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.CartDAO;
import DTO.Cart;
import DTO.User;
import Service.CartService;
import Service.CartServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl(new CartDAO());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "";
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loginUser");
//		int userNo = user.getUserNo();
		
		// 사용자 고유번호를 임시로 1로 설정 
		int userNo = 1;
		
		// CartDAO 객체를 생성, db와 연결하여 Cart 관련 쿼리 실행하는 역할(장바구니 목록조회/항목 추가/삭제) 
		CartDAO cartDao = new CartDAO();
		
		// 비지니스 로직을 담당하는 CartService 인터페이스의 구현체를 생성
		// 이 구현체에 방금 만든 cartDao 전달 -> 추후 Service가 Dao를 이용해서 실제 db작업 수행
		CartService cartService = new CartServiceImpl(cartDao);
		
		// cartService는 특정 유저번호(userNo)에 해당하는 장바구니 목록 조회
		// 내부적으로 DAO의 listBy()메서드를 호출하고 조회된 결과를 List<Cart>로 반환 
		List<Cart> cartList = cartService.listByUserNo(userNo);
		for (Cart cart : cartList) {
			System.out.println(cart);
			System.out.println(cart.getProduct());
		}
		
		// jsp에서 사용할 수 있도록 request에 데이터 저장 
		request.setAttribute("cartList", cartList);
		
		page = "/page/cart/cart.jsp";
		
		
		// jsp로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
		
		// TOOD: 나중에 지우기, 장바구니 전체 목록 테스트였음
//		CartDAO cartDao = new CartDAO();
//		CartService cartService = new CartServiceImpl(cartDao);
//		List<Cart> cartList =  cartService.list();
//		for (Cart cart : cartList) {
//			System.out.println(cart);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		
//		doGet(request, response);
//	}


	//상품상세페이지에서 장바구니로 이동
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	

}













