package com.sistema.inventario.category;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.brand.Brand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45, nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public Category(Integer id) {
		super();
		this.id = id;

	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(Brand brand) {
		super();
		this.brand = brand;
	}

	@Override
	public String toString() {
		return name;
	}

}
