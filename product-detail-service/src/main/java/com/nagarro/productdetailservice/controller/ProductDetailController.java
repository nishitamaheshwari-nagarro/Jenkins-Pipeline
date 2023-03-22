package com.nagarro.productdetailservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productdetailservice.entity.ProductDetail;
import com.nagarro.productdetailservice.service.ProductDetailService;

@RestController
@RequestMapping("/products")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;
    
    @GetMapping (value = "/product-details")
    public ResponseEntity<List<ProductDetail>> getAllProductDetails(){
        List<ProductDetail> productDetails =  productDetailService.getAllProductDetails();
        if(!productDetails.isEmpty()) {
        	return new ResponseEntity<List<ProductDetail>>(
        			productDetails,
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<ProductDetail>>(
        		HttpStatus.NOT_FOUND);       
    }

    @GetMapping(value = "/product-details", params = "productId")
    public ResponseEntity<ProductDetail> getProductDetailByProductId(@RequestParam ("productId") Long productId){
        ProductDetail productDetail = productDetailService.getProductDetailByProductId(productId);
        if(productDetail != null) {
        	return new ResponseEntity<ProductDetail>(
        			productDetail,
        			HttpStatus.OK);
        }
        return new ResponseEntity<ProductDetail>(
        		HttpStatus.NOT_FOUND);
    }
}
