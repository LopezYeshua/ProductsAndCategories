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
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryService;
	@Autowired
	ProductServices productService;
	
	@GetMapping("")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("")
	public String createCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result)
	{
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(
		Model model,
		@PathVariable("id") Long id,
		@ModelAttribute("notIncludedProducts") ArrayList<Product> notIncludedProducts,
		@ModelAttribute("products") ArrayList<Product> products)
		{
		Category category = categoryService.findCategory(id);
		products.addAll((ArrayList<Product>) productService.findAllProducts(category));
		notIncludedProducts.addAll((ArrayList<Product>) productService.productsNotIncluded(category));
		model.addAttribute("category", category);
		return "showCategory.jsp";
		}
	
	@PostMapping("/{id}")
	public String addProduct(
			@PathVariable("id") Long categoryId, @RequestParam("product_id") Long productId)
	{
		categoryService.addProduct(categoryId, productId);
		return "redirect:/categories/" + categoryId;
	}
}
