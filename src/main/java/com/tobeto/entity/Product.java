package com.tobeto.entity;

import jakarta.persistence.*;
import com.tobeto.entity.Category;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_in_stock")
	private int unitInStock;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "min_stock")
	private int minStock;
	
	@Column(name = "product_desc")
	private String productDescription;
	
	@ManyToMany(mappedBy = "products")
	private List<Rack> racks;

}

