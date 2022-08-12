package com.yeshua.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeshua.products.models.Category;
import com.yeshua.products.models.Product;
import com.yeshua.products.repositories.CategoryRepository;
import com.yeshua.products.repositories.ProductRepository;

@Service
public class CategoryServices {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Category updateCategory(Category category) {
		Category categoryInDB = categoryRepository.findById(category.getId()).get();
    	categoryInDB.setName(category.getName());
    	return categoryRepository.save(categoryInDB);
    }
	
	public Category addProduct(Long categoryId, Long productId) {
		System.out.println(categoryId);
		// retrieve an instance of a category using another method in the service.
	    Category thisCategory = findCategory(categoryId);
	    
	    // retrieve an instance of a product using another method in the service.
	    Product thisProduct = findProduct(productId);
	    
	    // add the product to this category's list of products
	    thisCategory.getProducts().add(thisProduct);
	    
	    // Save thisCategory, since you made changes to its product list.
	    return categoryRepository.save(thisCategory);
	}
	
	
//	Fetches products
	public List<Category> findAllCategories(Product product) {
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> categoriesNotIncluded(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
}
