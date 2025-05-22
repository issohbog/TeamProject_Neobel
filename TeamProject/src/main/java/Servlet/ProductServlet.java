package Servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.ProductDAO;  // DAO 클래스 임포트
import DTO.Product;    // DTO 클래스 임포트

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GET 요청 처리
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 1. DB에서 제품 리스트 가져오기 (DAO 호출)
//        List<Product> productList = ProductDAO.getAllProducts();
//
//        // 2. JSP에 데이터 전달하기 위해 request에 세팅
//        request.setAttribute("productList", productList);
//
//        // 3. productList.jsp (제품 목록 출력 JSP)로 포워딩
//        request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
//    }
    
    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // DAO 객체 생성
//        ProductDAO productDAO = new ProductDAO();
//        
//        // 제품 리스트 가져오기
//        List<Product> productList = productDAO.getAllProducts();
//
//        // JSP에 데이터 전달
//        request.setAttribute("productList", productList);
//
//        // 포워딩
//        request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
//    }


    // POST 요청 시에도 GET 처리로 위임
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
