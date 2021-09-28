package com.example.SystemManger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SystemManger.entity.Category;
import com.example.SystemManger.entity.Product;
import com.example.SystemManger.repository.CategoryRepository;
import com.example.SystemManger.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Product createProduct(Product product) {
		Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
		if(null == category) {
			category = new Category();
		}
		category.setId(product.getCategory().getId());
		product.setCategory(category);
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
}

