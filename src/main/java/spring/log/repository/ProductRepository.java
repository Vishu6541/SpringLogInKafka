package spring.log.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.log.entity.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {


}
