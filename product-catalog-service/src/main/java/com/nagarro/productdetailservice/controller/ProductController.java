package com.nagarro.productdetailservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productdetailservice.entity.Product;
import com.nagarro.productdetailservice.model.ProductResponse;
import com.nagarro.productdetailservice.service.ProductService;

@RestController
@RequestMapping("/catalog")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    @GetMapping (value = "/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
    	List<ProductResponse> productResponse =  productService.getAllProduct();
        if(!productResponse.isEmpty()) {
        	return new ResponseEntity<List<ProductResponse>>(
        			productResponse,
        			HttpStatus.OK);
        }
        return new ResponseEntity<List<ProductResponse>>(
        		HttpStatus.NOT_FOUND);       
    }

//    @GetMapping(value = "/products", params = "category")
//    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam ("category") String category){
//        List<Product> products = productService.getAllProductByCategory(category);
//        if(!products.isEmpty()) {
//        	return new ResponseEntity<List<Product>>(
//        			products,
//        			HttpStatus.OK);
//        }
//        return new ResponseEntity<List<Product>>(
//        		HttpStatus.NOT_FOUND);
//    }

    @GetMapping (value = "/products/{id}")
    public ResponseEntity<ProductResponse> getOneProductById(@PathVariable ("id") long id){
    	ProductResponse productResponse =  productService.getProductById(id);
        if(productResponse != null) {
        	return new ResponseEntity<ProductResponse>(
        			productResponse,
        			HttpStatus.OK);
        }
        return new ResponseEntity<ProductResponse>(
        		HttpStatus.NOT_FOUND);
    }

//    @GetMapping (value = "/products", params = "name")
//    public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name){
//        List<Product> products =  productService.getAllProductsByName(name);
//        if(!products.isEmpty()) {
//        	return new ResponseEntity<List<Product>>(
//        			products,
//        			HttpStatus.OK);
//        }
//        return new ResponseEntity<List<Product>>(
//        		HttpStatus.NOT_FOUND);
//    }

}
