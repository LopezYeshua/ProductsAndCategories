package com.yeshua.products.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeshua.products.models.Category;
import com.yeshua.products.models.Product;
import com.yeshua.products.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Product updateProduct(Product product) {
    	Product productInDB = productRepository.findById(product.getId()).get();
    	productInDB.setName(product.getName());
    	productInDB.setCategories(product.getCategories());
    	productInDB.setPrice(product.getPrice());
    	return productRepository.save(productInDB);
    }
	
//	Fetch products
	public List<Product> findAllProducts(Category category) {
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> productsNotIncluded(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
}
