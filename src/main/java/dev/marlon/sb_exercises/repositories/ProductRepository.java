package dev.marlon.sb_exercises.repositories;

import dev.marlon.sb_exercises.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
