package dev.marlon.sb_exercises.controllers;

import dev.marlon.sb_exercises.models.Product;
import dev.marlon.sb_exercises.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public @ResponseBody Product createProduct(@Valid Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody @Valid Product product) {
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }


}
