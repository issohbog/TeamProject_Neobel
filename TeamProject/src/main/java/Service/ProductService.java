package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ProductDAO;
import DTO.Product;

public class ProductService {
    private ProductDAO productDAO;

//    public ProductService(Connection conn) {
//        productDAO = new ProductDAO(conn);
//    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

//    public Product getProductById(int id) throws SQLException {
//        return productDAO.getProductById(id);
//    }
}
