package com.tobeto.controller;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.product.DeleteProductRequestDTO;
import com.tobeto.dto.product.ProductRequestDTO;
import com.tobeto.dto.product.ProductResponseDTO;
import com.tobeto.dto.product.UpdateProductRequestDTO;
import com.tobeto.entity.Product;
import com.tobeto.service.ProductService;
import com.tobeto.service.RackAssignmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private RackAssignmentService rackAssignmentService;

    @Autowired
    @Qualifier("requestMapper")
    private ModelMapper requestMapper;

    @Autowired
    @Qualifier("responseMapper")
    private ModelMapper responseMapper;

    //create a product
    @PostMapping("/create")
    public SuccessResponseDTO createProduct(@RequestBody ProductRequestDTO dto) {
        Product product = requestMapper.map(dto, Product.class);
        productService.createProduct(product);

        // Call the method to assign products to racks after creating the product
        //rackAssignmentService.assignProductsToRacks();

        return new SuccessResponseDTO();
    }

    //get all products
    @GetMapping("/")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream().map(p -> responseMapper.map(p, ProductResponseDTO.class)).toList();
    }

    //delete product by id
    @PostMapping("/delete")
    public SuccessResponseDTO deleteProduct(@RequestBody DeleteProductRequestDTO dto) {
        productService.deleteProduct(dto.getId());
        return new SuccessResponseDTO();
    }

    //update product by id
    @PostMapping("/update")
    public SuccessResponseDTO updateProduct(@RequestBody UpdateProductRequestDTO dto) {
        productService.updateProduct(dto.getId(), dto.getProductName(), dto.getUnitPrice(), dto. getUnitInStock(), dto.getMinStock(), dto.getProductDescription());
        return new SuccessResponseDTO();
    }
}
