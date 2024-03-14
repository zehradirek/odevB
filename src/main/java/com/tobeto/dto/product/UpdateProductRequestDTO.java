package com.tobeto.dto.product;

import com.tobeto.entity.Category;
import lombok.Data;

@Data
public class UpdateProductRequestDTO {
    private int id;
    private String productName;
    private double unitPrice;
    private int unitInStock;
    private int minStock;
    private String productDescription;
    private Category category;
}
