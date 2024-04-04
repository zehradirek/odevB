package com.tobeto.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "product")
@EqualsAndHashCode(exclude = "product")
public class Rack implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rack_count")
	private int rackCount;

	@Column(name = "rack_capacity")
	private int rackCapacity;

	@OneToMany(mappedBy = "rack")
	private List<Product> products;

}
