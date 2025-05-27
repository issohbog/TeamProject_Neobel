package Service;

import DAO.ProductDAO;
import DTO.Product;

public class ProductServiceImpl extends BaseServiceImpl<ProductDAO, Product> implements ProductService {

	
	ProductDAO productDAO = new ProductDAO();
	
	
	public ProductServiceImpl(ProductDAO dao) {
		super(dao);
	}

	@Override
	public Product get(int productNo) {
		Product product = null;
		try {
			product = productDAO.select(productNo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return product;
	}

	
	
}
