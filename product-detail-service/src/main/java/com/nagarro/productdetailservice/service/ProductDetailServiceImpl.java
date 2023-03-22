package com.nagarro.productdetailservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.productdetailservice.entity.ProductDetail;
import com.nagarro.productdetailservice.repository.ProductDetailRepository;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{
	
    @Autowired
    private ProductDetailRepository productDetailRepository;
    
    @Override
    public ProductDetail getProductDetailById(Long id) {
    	return productDetailRepository.getReferenceById(id);
    }
	
    @Override
	public List<ProductDetail> getAllProductDetails(){
		return productDetailRepository.findAll();
	}
	
	@Override
    public ProductDetail getProductDetailByProductId(Long productId) {
		return productDetailRepository.findByProductId(productId);
	}
    
    @Override
    public ProductDetail addProductDetail(ProductDetail productDetail) {
    	return productDetailRepository.save(productDetail);
    }
    
    @Override
    public void deleteProductDetail(Long id) {
    	productDetailRepository.deleteById(id);
    }
    
    @Override
    public void deleteProductDetailByProductId(ProductDetail productDetail) {
    	productDetailRepository.delete(productDetail);
    }
}
