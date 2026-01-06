package pl.ed.vistula.firstrestapi.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ed.vistula.firstrestapi.product.domain.Product;
import pl.ed.vistula.firstrestapi.product.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product.getName());

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product.getName());
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // This gives you the "204 No Content" required for the task
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}