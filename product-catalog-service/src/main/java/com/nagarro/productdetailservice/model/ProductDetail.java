package com.nagarro.productdetailservice.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail {
	
	private Long id;

    private Long productId;

    private BigDecimal price;

    private String discription;

    private int availability;

}
