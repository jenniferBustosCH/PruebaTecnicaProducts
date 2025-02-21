package productListController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import productListDTO.Product;
import productListService.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Optional<Product> product = productService.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		Product productDetails = new Product();
		productDetails.setName(product.getName());
		productDetails.setDescription(product.getDescription());
		productDetails.setPrice(product.getPrice());
		productDetails.setSku(product.getSku());
		return productService.saveProduct(productDetails);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	}
