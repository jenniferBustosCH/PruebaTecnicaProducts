package productListRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import productListDTO.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
