package com.tobeto.dto.product;

import com.tobeto.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private String productName;
    private double unitPrice;
    private int unitInStock;
    private int minStock;
    private String productDescription;
    private Category category;
}