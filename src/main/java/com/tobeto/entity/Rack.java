package com.tobeto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Entity
@Data
@ToString(exclude = "product")
@EqualsAndHashCode(exclude = "product")
public class Rack implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rack_column")
	private char rackColumn;
	
	@Column(name = "rack_row")
	private char rackRow;
	
	@Column(name = "rack_count")
	private  int rackCount;
	
	@Column(name = "rack_capacity")
	private  int rackCapacity;


	@OneToMany(mappedBy = "rack")
	private List<Product> products;

}
