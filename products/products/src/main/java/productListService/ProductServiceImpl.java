package productListService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productListDTO.Product;
import productListNotFound.ResourceNotFoundException;
import productListRepository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(Long id){
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product productDetails) {
		return productRepository.findById(id).map(product ->{
			product.setName(productDetails.getName());
			product.setDescription(productDetails.getDescription());
			product.setPrice(productDetails.getPrice());
			product.setSku(productDetails.getSku());
			return productRepository.save(product);
		}).orElseThrow(()-> new ResourceNotFoundException("No se ha encontrado el producto con el id "+id));
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	

}
