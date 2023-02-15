package com.sistema.inventario.brand;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.category.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String name;

	@OneToMany
	@JoinColumn(name = "brand_id")
	private List<Category> categories = new ArrayList<>();

	public Brand(String name) {
		super();
		this.name = name;
	}

	public Brand(String name, List<Category> categories) {
		super();
		this.name = name;
		this.categories = categories;
	}

}
