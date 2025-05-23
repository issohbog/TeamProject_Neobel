package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.ProductDAO;  // DAO 클래스 임포트
import DTO.Product;
import Service.ProductService;
import Service.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  	System.out.println("상품............................");

	  	// 1. DAO 만들기
		ProductDAO productDAO = new ProductDAO();
		// 2. 서비스 만들기
		ProductService productService = new ProductServiceImpl(productDAO);
		
		
		//4-1 상품상세페이지 서블릿
		String productNoStr = request.getParameter("productNo");

	    if (productNoStr != null && !productNoStr.isEmpty()) {
	        try {
	            int productNo = Integer.parseInt(productNoStr);
	            Product productDetail = productService.get(productNo);

	            if (productDetail != null) {
	                request.setAttribute("product", productDetail);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/page/product/productDetail.jsp");
	                dispatcher.forward(request, response);
	                return;
	            } 
	            else {
	                response.sendRedirect(request.getContextPath() + "/product");
	                return;
	            }
	            
	        } 
	        catch (NumberFormatException e) {
	            response.sendRedirect(request.getContextPath() + "/product");
	            return;
	        }
	    }
	    // 상품 목록
	    else {

				
			// 3. 서비스 기능 호출하기 (목록)
			List<Product> productList = productService.list();
			
			// 4. 데이터를 요청 객체에 등록하기 
			request.setAttribute("productList", productList);
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/page/product/productList.jsp");
	    	dispatcher.forward(request, response);
	    }
	    
	    
		
		
  }
		
		
		
		
//		// 5. JSP 페이직 경로 지정하기
//		String page = "";
//		page = "/page/product/productList.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//		dispatcher.forward(request, response);
	 
  



    // POST 요청 시에도 GET 처리로 위임
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}