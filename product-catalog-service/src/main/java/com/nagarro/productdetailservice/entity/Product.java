package com.nagarro.productdetailservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column (name = "product_name")
    private String productName;
    
    @Column (name = "company")
    private String company;
    
    @Column (name = "category")
    private String category;

}
