package com.example.SystemManger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SystemManger.entity.Category;
import com.example.SystemManger.entity.Product;
import com.example.SystemManger.repository.CategoryRepository;
import com.example.SystemManger.repository.ProductRepository;
import com.example.SystemManger.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.getAllProducts();
		model.addAttribute("listProducts", listProducts);
	
		return "index";
	} 
	
	@RequestMapping("/addproduct")
	public String showAddProduct(Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		Product product = new Product();
		model.addAttribute("product", product);
		return "addproduct";
	}
	
	//save product to DB
	@PostMapping("/createproduct")
	public String createProduct(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@PostMapping("/psave")
	public String saveditedproduct(Product product) {
		
		
//		Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
//		
//		category.setId(product.getCategory().getId());
//		product.setCategory(category);
		
		productRepository.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/editproduct/{id}")
	public String editProduct(@PathVariable(name = "id") long id,Model model) {
//		ModelAndView mav = new ModelAndView("edit_product");
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		
		productRepository.findById(id).get();
		model.addAttribute("product",product);
		
		return  "edit_product";
		
//		mav.addObject("product", product);
//		return mav;
	}
	
	@RequestMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable(name = "id") long id) {
		productService.deleteProduct(id);
		
		return "redirect:/";
	}
}
