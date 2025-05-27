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

//상품 상세 or 전체 상품 리스트 처리
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
 private ProductService productService;

 @Override
 public void init() throws ServletException {
     ProductDAO productDAO = new ProductDAO();
     productService = new ProductServiceImpl(productDAO);
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
             } else {
                 response.sendRedirect(request.getContextPath() + "/product");
                 return;
             }
         } catch (NumberFormatException e) {
             response.sendRedirect(request.getContextPath() + "/product");
             return;
         }
     } else {
         List<Product> productList = productService.list();

         request.setAttribute("productList", productList);

         RequestDispatcher dispatcher = request.getRequestDispatcher("/page/product/productList.jsp");
         dispatcher.forward(request, response);
     }
 }


  



    // POST 요청 시에도 GET 처리로 위임
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}