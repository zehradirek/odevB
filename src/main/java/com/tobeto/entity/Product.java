package com.tobeto.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Products")
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
