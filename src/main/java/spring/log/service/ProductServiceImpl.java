package spring.log.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring.log.entity.Product;
import spring.log.exception.Apiresponse;
import spring.log.exception.ErrorCode;
import spring.log.exception.ServiceException;
import spring.log.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository productRepository;

	@Override
	public ResponseEntity<Apiresponse> save(Product product) {
		log.info("Class => ProductServiceImpl => Method => save : Request is comming to create new  Product");
		Product saveProduc = productRepository.save(product);
		if (saveProduc != null) {
			return new ResponseEntity<Apiresponse>(new Apiresponse("Success", HttpStatus.CREATED.value(), saveProduc),
					HttpStatus.CREATED);
		} else {
			throw new ServiceException(ErrorCode.Bad_Request, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Apiresponse> fetchProductById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent())
			return new ResponseEntity<Apiresponse>(new Apiresponse("Success", HttpStatus.OK.value(), product.get()),
					HttpStatus.OK);
		throw new ServiceException(ErrorCode.DataNotFound, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Apiresponse> getAllProduct() {
		List<Product> proList = (List<Product>) productRepository.findAll();
		return new ResponseEntity<Apiresponse>(new Apiresponse("Success", HttpStatus.OK.value(), proList),
				HttpStatus.OK);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);

	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void updateProductByPatch(Map<String, Object> map, Integer id) {
		// TODO Auto-generated method stub

	}

}
