package productListService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import productListDTO.Product;

@Service
public interface ProductService {

	List<Product> findAll();
	Optional<Product> findById(Long id);
	Product saveProduct(Product product);
	Product updateProduct(Long id, Product productDetails);
	void deleteById(Long id);
}
