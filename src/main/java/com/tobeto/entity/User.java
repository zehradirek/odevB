package com.tobeto.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;

	    @Column(name = "user_name")
	    private String userame;
	    
	    @Column(name = "password")
	    private String password;

	    @Column(name = "email")
	    private String email;
	    
	    @OneToMany(mappedBy = "users")
	    private List<Role> roles;
	
}
