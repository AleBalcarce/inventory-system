package com.sistema.inventario.products;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String name;

	@Column(length = 45, nullable = false)
	private String value;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public ProductDetails(String name, String value, Product product) {
		super();
		this.name = name;
		this.value = value;
		this.product = product;
	}

	@Override
	public String toString() {
		return name + "-" + value;
	}

}
