package com.tobeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.product.ProductRequestDTO;
import com.tobeto.dto.product.ProductResponseDTO;
import com.tobeto.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/get")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		List<ProductResponseDTO> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable int productId) {
		ProductResponseDTO product = productService.getProductById(productId);
		return ResponseEntity.ok(product);
	}

	@PostMapping("/create")
	public ResponseEntity<ProductResponseDTO> createProduct(
			@RequestBody ProductRequestDTO productRequestDTO) {
		ProductResponseDTO createdProduct = productService.createProduct(productRequestDTO);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable int productId,
			@RequestBody ProductRequestDTO productRequestDTO) {
		productService.updateProduct(productId, productRequestDTO);
		return ResponseEntity.ok("Product updated successfully");
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.ok("Product deleted successfully");
	}

	@GetMapping("/checkStockLevels")
	public String checkStockLevels() {
		return productService.checkStockLevels();
	}
}
