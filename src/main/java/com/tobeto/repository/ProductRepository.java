package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductNameAndUnitInStock(String productName, int unitInStock);

	Optional<Product> findByProductDescription(String productDescription);
}
