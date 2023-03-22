package com.nagarro.productdetailservice.service;

import java.util.List;

import com.nagarro.productdetailservice.entity.Product;
import com.nagarro.productdetailservice.model.ProductResponse;

public interface ProductService {
	
    public List<ProductResponse> getAllProduct();
    public List<Product> getAllProductByCategory(String category);
    public Product getProductByProductId(Long id);
    public ProductResponse getProductById(Long id);
    public List<Product> getAllProductsByName(String name);
    public ProductResponse addProduct(ProductResponse productResponse);
    public void deleteProduct(Long productId);

}
