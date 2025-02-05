package com.cg.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
@Table (name = "sweet_orders")
public class SweetOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sweetOrderId;
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")	
	private User user;
	private Double totalCost;
	
	@OneToMany
	@JoinColumn(name = "products_list")
	private List<Product> listProduct;
 
    @PrePersist
    protected void onCreate() {
    	orderDate = LocalDate.now();
    }
}
