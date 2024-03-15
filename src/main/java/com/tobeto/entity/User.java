package com.tobeto.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;

	    @Column(name = "user_name")
	    private String userName;
	    
	    @Column(name = "password")
	    private String password;

	    @Column(name = "email")
	    private String email;

	    @ManyToOne
		@JoinColumn(name = "role_id")
		private Role role;
	
}
