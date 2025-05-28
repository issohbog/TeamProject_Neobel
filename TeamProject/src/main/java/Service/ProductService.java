package Service;


import DAO.ProductDAO;
import DTO.Product;

public interface ProductService extends BaseService<Product> {

	

	Product get(int productNo); 

	
	
	
	

}
