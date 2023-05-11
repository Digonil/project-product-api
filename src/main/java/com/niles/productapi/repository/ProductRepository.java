package com.niles.productapi.repository;

import com.niles.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p" + "from product p" + "join category c on.category.id = c.id" + "where c.id = :category.id")
    public List<Product> getProductByCategory(@Param("categoryId") Long id);

    public Product findByProductIdentifier(String productIdentifier);
}
