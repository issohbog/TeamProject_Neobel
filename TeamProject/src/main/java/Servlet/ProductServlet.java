package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.ProductDAO;  // DAO 클래스 임포트
import DTO.Product;    // DTO 클래스 임포트
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	 
		  
//		  // 제품 리스트 가져오기
//		  List<Product> productList = ProductDAO.getAllProducts();
//		
//		  // JSP에 데이터 전달
//		  request.setAttribute("productList", productList);
//		
//		  // 포워딩
//		  request.getRequestDispatcher("/webapp/page/product/productList.jsp").forward(request, response);
  }



    // POST 요청 시에도 GET 처리로 위임
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}