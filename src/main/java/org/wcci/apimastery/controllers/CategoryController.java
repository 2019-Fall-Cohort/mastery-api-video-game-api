package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.services.CategoryService;
import org.wcci.apimastery.entities.Category;

@RequestMapping("api/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping({ "", "/", "/all" })
	public List<Category> retrieveAllCategories() {
		return categoryService.fetchAllCategories();
	}
	
	@GetMapping("/{categoryId}")
	public Category retrieveCategoryById(@PathVariable Long categoryId) {
		return categoryService.findCategoryById(categoryId);
	}
	
	@PostMapping("/{categoryName}")
	public Category addCategory (@PathVariable String categoryName) {
		Category category = new Category(categoryName);
		return categoryService.addCategory(category);		
	}
	
	@DeleteMapping("/{categoryId}")
	public List<Category> removeCategoryById(@PathVariable Long categoryId) {
		Category category = categoryService.findCategoryById(categoryId);
		categoryService.deleteCategory(category);
		return categoryService.fetchAllCategories();
	}

}
