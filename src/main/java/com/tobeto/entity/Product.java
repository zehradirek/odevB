package com.tobeto.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

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
	
	@OneToMany(mappedBy = "product")
	private List<Rack> racks;
	
	@ManyToOne
	private Category category;
	
	
}

