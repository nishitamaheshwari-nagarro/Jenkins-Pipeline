package com.nagarro.productdetailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productdetailservice.entity.ProductDetail;
import com.nagarro.productdetailservice.service.ProductDetailService;

@RestController
@RequestMapping("/products/admin")
public class AdminProductDetailController {
	
    @Autowired
    private ProductDetailService productDetailService;
    
    @PostMapping(value = "/product-details")
    private ResponseEntity<ProductDetail> addProductDetail(@RequestBody ProductDetail productDetail){
    	if(productDetail != null) {
    		try {
    			productDetailService.addProductDetail(productDetail);
    	        return new ResponseEntity<ProductDetail>(
    	        		productDetail,
    	        		HttpStatus.CREATED);
    		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ProductDetail>(
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<ProductDetail>(
    			HttpStatus.BAD_REQUEST);       
    }
    
    @DeleteMapping(value = "/product-detail/{id}")
    private ResponseEntity<Void> deleteProductDetail(@PathVariable("id") Long id){
    	ProductDetail productDetail = productDetailService.getProductDetailById(id);
    	if(productDetail != null) {
    		try {
    			productDetailService.deleteProductDetail(id);
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.OK);
    		}catch (Exception e) {
				e.printStackTrace();
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);      
    }
    
    @DeleteMapping(value = "/product-details/{productId}")
    private ResponseEntity<Void> deleteProductDetailByProductId(@PathVariable("productId") Long productId){
    	ProductDetail productDetail = productDetailService.getProductDetailByProductId(productId);
    	if(productDetail != null) {
    		try {
    			productDetailService.deleteProductDetailByProductId(productDetail);
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.OK);
    		}catch (Exception e) {
				e.printStackTrace();
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);      
    }
}
