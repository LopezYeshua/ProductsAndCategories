package com.yeshua.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yeshua.products.models.Category;
import com.yeshua.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product>findAll();
	
//	Retrieves a list of all products that do not belong to the category
	List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
}
