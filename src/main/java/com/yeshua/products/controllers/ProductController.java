package com.yeshua.products.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yeshua.products.models.Category;
import com.yeshua.products.models.Product;
import com.yeshua.products.services.CategoryServices;
import com.yeshua.products.services.ProductServices;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductServices productService;
	
	@Autowired
	CategoryServices categoryService;
	
	@GetMapping("")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("")
	public String createProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if (result.hasErrors()) return "newProduct.jsp";
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(
		Model model,
		@PathVariable("id") Long id,
		@ModelAttribute("notIncludedCategories") ArrayList<Category> notIncludedCategories,
		@ModelAttribute("categories") ArrayList<Category> categories
		)
		{
		Product product= productService.findProduct(id);
		categories.addAll((ArrayList<Category>) categoryService.findAllCategories(product));
		notIncludedCategories.addAll((ArrayList<Category>) categoryService.categoriesNotIncluded(product));
		model.addAttribute("product", product);
		return "showProduct.jsp";
		}
	
	@PostMapping("/{id}")
	public String addCategory(
			Model model,
			@PathVariable("id") Long productId,
			@RequestParam("category_id") Long categoryId)
	{
		categoryService.addProduct(categoryId, productId);
		return "redirect:/products/" + productId;
	}
}
