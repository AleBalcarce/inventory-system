package com.sistema.inventario.user;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45, nullable = false, unique = true)
	private String email;
	@Column(length = 15, nullable = false, unique = false)
	private String password;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	// inverseJoinColumns= @JoinColumn(name = "role_id"));
	private Set<Roles> roles = new HashSet<>();

	public void addRole(Roles role) {

		this.roles.add(role);
	}

	public void removeRole(Roles role) {

		this.roles.remove(role);
	}

	public User(String email) {
		super();
		this.email = email;

	}

	public User(String email, String password, Set<Roles> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(Set<Roles> roles) {
		super();
		this.roles = roles;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
