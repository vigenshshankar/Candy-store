package com.cg.onlinesweetmart.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private double grandTotal;
	
	@ManyToMany
	private List<Product> listProduct;
	private int productCount;

}
