package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Product;

public class ProductDAO {
    private final String url = "jdbc:mysql://localhost:3306/your_database_name?serverTimezone=UTC";
    private final String user = "your_db_user";
    private final String password = "your_db_password";

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT product_no, product_name, image_name, image_path, description, price FROM products";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                Product p = new Product();
                p.setProductNo(rs.getInt("product_no"));
                p.setProductName(rs.getString("product_name"));
                p.setImageName(rs.getString("image_name"));
                p.setImagePath(rs.getString("image_path"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getInt("price"));
                productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
