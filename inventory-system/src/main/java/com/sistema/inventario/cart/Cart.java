package com.sistema.inventario.cart;

import java.util.Set;

import com.sistema.inventario.products.Product;
import com.sistema.inventario.user.Roles;
import com.sistema.inventario.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int amount;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Cart(Integer id) {
		super();
		this.id = id;
	}

	public Cart(int amount) {
		super();
		this.amount = amount;
	}

	public Cart(Product product) {
		super();
		this.product = product;
	}

	public Cart(User user) {
		super();
		this.user = user;
	}

	public Cart(int amount, Product product, User user) {
		super();
		this.amount = amount;
		this.product = product;
		this.user = user;
	}
	
	

}
