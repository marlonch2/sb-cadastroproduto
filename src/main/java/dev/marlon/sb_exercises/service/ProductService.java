package dev.marlon.sb_exercises.service;

import dev.marlon.sb_exercises.models.Product;
import dev.marlon.sb_exercises.repositories.ProductRepository;
import dev.marlon.sb_exercises.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com o ID: " + id)));
    }

    public Product updateProductById(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com o ID: " + id));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com o ID: " + id));

        productRepository.delete(product);
    }

}
