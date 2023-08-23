package spring.log.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import spring.log.entity.Product;
import spring.log.exception.Apiresponse;

public interface ProductService {
	
	public ResponseEntity<Apiresponse> save(Product product);
	public ResponseEntity<Apiresponse> fetchProductById(Integer id);
	public ResponseEntity<Apiresponse> getAllProduct();
	public void deleteProductById(Integer id);
	public void deleteAll();
	public void updateProduct(Product product);
	public void updateProductByPatch(Map<String, Object> map , Integer id);
	

}
