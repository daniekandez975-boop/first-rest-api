package pl.ed.vistula.firstrestapi.product.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.ed.vistula.firstrestapi.product.domain.Product;
import pl.ed.vistula.firstrestapi.product.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(String name) {
        return productRepository.save(new Product(name));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
        public Product getById(Long id) {
            return productRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        }

    public Product update(Long id, String name) {
        return null;
    }

    public void delete(Long id) {
    }
}