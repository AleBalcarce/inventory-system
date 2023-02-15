package com.sistema.inventario.products;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.category.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String name;

	private float price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductDetails> details = new ArrayList<>();

	public Product(String name) {
		super();
		this.name = name;
	}

	public Product(String name, float price, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public void addDetails(String name, String value) {
		this.details.add(new ProductDetails(name, value, this));

	}

	public void setDetails(Integer id, String name, String value) {
		this.details.add(new ProductDetails(id, name, value, this));

	}

}
