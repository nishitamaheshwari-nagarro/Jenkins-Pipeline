package com.nagarro.productdetailservice.service;

import java.util.List;

import com.nagarro.productdetailservice.entity.ProductDetail;

public interface ProductDetailService {
	public ProductDetail getProductDetailById(Long id);
    public List<ProductDetail> getAllProductDetails();
    public ProductDetail getProductDetailByProductId(Long productId);
    public ProductDetail addProductDetail(ProductDetail productDetail);
    public void deleteProductDetailByProductId(ProductDetail productDetail);
    public void deleteProductDetail(Long Id);
}
