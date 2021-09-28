package com.example.SystemManger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SystemManger.entity.Category;
import com.example.SystemManger.entity.Product;
import com.example.SystemManger.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllcategories(){
		return categoryRepository.findAll();
	}
	
	public Category updateCategory(Long id) {
		return categoryRepository.findById(id).get();
	}
}
