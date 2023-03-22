package com.nagarro.productdetailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.productdetailservice.entity.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{
	public ProductDetail findByProductId(Long productId);
}
