package com.tobeto.service;

import com.tobeto.config.ModelMapperConfig;
import com.tobeto.dto.product.ProductRequestDTO;
import com.tobeto.dto.product.ProductResponseDTO;
import com.tobeto.entity.Product;
import com.tobeto.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapperConfig modelMapperConfig;

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTO = products.stream()
                .map(product -> this.modelMapperConfig.forResponse().map(product, ProductResponseDTO.class)).toList();
        return responseDTO;
    }

    public ProductResponseDTO getProductById(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        ProductResponseDTO responseDTO = this.modelMapperConfig.forResponse().map(product, ProductResponseDTO.class);
        return responseDTO;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = this.modelMapperConfig.forRequest().map(productRequestDTO, Product.class);
        productRepository.save(newProduct);

        return this.modelMapperConfig.forResponse().map(newProduct, ProductResponseDTO.class);
    }

    public void updateProduct(int productId, ProductRequestDTO productRequestDTO) {
        Product productToUpdate = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        this.modelMapperConfig.forRequest().map(productRequestDTO, productToUpdate);
        productRepository.save(productToUpdate);

    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }


    public String checkStockLevels() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getUnitInStock() < product.getMinStock()) {
                return "Low stock for product: " + product.getProductName();
            }
        }
        return null;
    }

}


