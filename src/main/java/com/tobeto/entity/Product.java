package com.tobeto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

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

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne

	@JoinColumn(name = "rack_id")
	private Rack rack;
	
}

