package com.tobeto.service;

import com.tobeto.entity.Category;
import com.tobeto.entity.Product;
import com.tobeto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //method for creating a product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    //method for listing all the products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //method for deleting a product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    //method for saving product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //method for updating product by id
    public void updateProduct(int id, String productName, double unitPrice, int unitInStock, int minStock, String productDescription, Category category) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            product.setProductName(productName);
            product.setUnitPrice(unitPrice);
            product.setUnitInStock(unitInStock);
            product.setMinStock(minStock);
            product.setProductDescription(productDescription);
            product.setCategory(category);
            productRepository.save(product);
        }
    }
}
