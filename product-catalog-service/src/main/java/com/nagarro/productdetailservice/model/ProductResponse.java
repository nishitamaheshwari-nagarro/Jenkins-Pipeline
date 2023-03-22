package com.nagarro.productdetailservice.model;

import com.nagarro.productdetailservice.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private Product product;
	private ProductDetail productDetail;
}
