package com.yeshua.products.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yeshua.products.models.Category;
import com.yeshua.products.models.Product;
import com.yeshua.products.services.CategoryServices;
import com.yeshua.products.services.ProductServices;
@Controller
public class MainController {
	@Autowired
	ProductServices productService;
	
	@Autowired
	CategoryServices categoryService;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("products") ArrayList<Product> products,
			@ModelAttribute("categories") ArrayList<Category> categories) {
		products.addAll((ArrayList<Product>) productService.allProducts());
		categories.addAll((ArrayList<Category>) categoryService.allCategories());
		return "index.jsp";
	}
}
