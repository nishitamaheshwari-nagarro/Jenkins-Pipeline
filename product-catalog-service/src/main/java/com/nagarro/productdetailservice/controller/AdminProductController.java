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
import org.springframework.web.client.RestTemplate;

import com.nagarro.productdetailservice.entity.Product;
import com.nagarro.productdetailservice.model.ProductResponse;
import com.nagarro.productdetailservice.service.ProductService;

@RestController
@RequestMapping("/catalog/admin")
public class AdminProductController {
	
    @Autowired
    private ProductService productService;
    
    @Autowired
    private RestTemplate restTemplate;
    

    @PostMapping(value = "/products")
    private ResponseEntity<ProductResponse> addProduct(@RequestBody ProductResponse productResponse){
    	if(productResponse != null) {
    		try {
    			productService.addProduct(productResponse);
    	        return new ResponseEntity<ProductResponse>(
    	        		productResponse,
    	        		HttpStatus.CREATED);
    		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ProductResponse>(
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<ProductResponse>(
    			HttpStatus.BAD_REQUEST);       
    }
    
    @DeleteMapping(value = "/products/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
    	Product product = productService.getProductByProductId(id);
    	if(product != null) {
    		try {
    			productService.deleteProduct(id); 			
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.OK);
    		}catch (Exception e) {
				e.printStackTrace();
    	        return new ResponseEntity<Void>(
    	        		HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);      
    }

}
