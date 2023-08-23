package spring.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.log.entity.Product;
import spring.log.exception.Apiresponse;
import spring.log.service.ProductService;


@RestController
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	ProductService productService;
	
	
	@PostMapping(value = "/createProduct",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Apiresponse>createProduct(@RequestBody Product product) throws JsonProcessingException{
		 log.info("Class => ProductController => Method => createProduct : Request is comming to create new product Product {}",objectMapper.writeValueAsString(product));
		return productService.save(product);
	}
	
	@GetMapping(value = "/getById/{id}",produces = "application/json")
	public ResponseEntity<Apiresponse>getById(@PathVariable("id") int id){
		 log.info("Class => ProductController => Method => getById : Request is Get Product by id {}",id);
		return productService.fetchProductById(id);
	}
	
	@GetMapping(value = "/fetchAllProducts",produces = "application/json")
	public ResponseEntity<Apiresponse>fetchAllProducts(){
		 log.info("Class => ProductController => Method => getById : Request is fetchAllProducts {}");
		return productService.getAllProduct();
	}
	
}
