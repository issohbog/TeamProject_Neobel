package Service;

import DAO.ProductDAO;
import DTO.Product;

public class ProductServiceImpl extends BaseServiceImpl<ProductDAO, Product> implements ProductService {

	public ProductServiceImpl(ProductDAO dao) {
		super(dao);
	}

}
