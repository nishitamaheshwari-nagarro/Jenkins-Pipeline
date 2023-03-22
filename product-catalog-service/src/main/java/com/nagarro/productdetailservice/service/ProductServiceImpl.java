package com.nagarro.productdetailservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.productdetailservice.entity.Product;
import com.nagarro.productdetailservice.model.ProductDetail;
import com.nagarro.productdetailservice.model.ProductResponse;
import com.nagarro.productdetailservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProductResponse> getAllProduct() {
    	String getProductDetailsUrl = "http://PRODUCT-DETAIL-SERVICE/products/product-details";
    	List<ProductResponse> listOfProductResponse = new ArrayList<>();
    	
    	ProductDetail[] forNow = restTemplate.getForObject(getProductDetailsUrl, ProductDetail[].class);
    	List<ProductDetail> productDetails = Arrays.asList(forNow);
    	List<Product> product = productRepository.findAll();
    	
    	for (Product p: product) {
    		for (ProductDetail pd: productDetails) {
    			if(p.getId().equals(pd.getProductId())) {
    				ProductResponse pr = new ProductResponse();
    				pr.setProduct(p);
    				pr.setProductDetail(pd);
    				listOfProductResponse.add(pr);
    			}
    		}
    	}
    	 	
    	return listOfProductResponse;    	
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
    
    @Override
    public Product getProductByProductId(Long id) {
    	return productRepository.getReferenceById(id);
    }

    @Override
    public ProductResponse getProductById(Long id) {
    	
    	String getproductDetailUrl = "http://PRODUCT-DETAIL-SERVICE/products/product-details/?productId="+id;
    	ProductResponse response = new ProductResponse();
    	
    	Product product = productRepository.getReferenceById(id);
    	ProductDetail productDetail = restTemplate.getForObject(getproductDetailUrl, ProductDetail.class);
    	
    	response.setProduct(product);
    	response.setProductDetail(productDetail);
    	
        return response;
    }

    @Override
    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllByProductName(name);
    }

    @Override
    public ProductResponse addProduct(ProductResponse productResponse) {
    	
    	String addproductDetailUrl = "http://PRODUCT-DETAIL-SERVICE//products/admin/product-details";
    	ProductResponse response = new ProductResponse();
    	
    	Product product = productRepository.save(productResponse.getProduct());
    	
    	ProductDetail productDetailToSave = productResponse.getProductDetail();
    	productDetailToSave.setProductId(product.getId());
    	ProductDetail productDetail = restTemplate.postForObject(addproductDetailUrl, productDetailToSave,ProductDetail.class);
    	
    	response.setProduct(product);
    	response.setProductDetail(productDetail);
        return response;
    }

    @Override
    public void deleteProduct(Long productId) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("productId", productId.toString());
    	String deleteproductDetailUrl = "http://PRODUCT-DETAIL-SERVICE//products/admin/product-details/{productId}";
		restTemplate.delete(deleteproductDetailUrl,params);
        productRepository.deleteById(productId);
    }
}
