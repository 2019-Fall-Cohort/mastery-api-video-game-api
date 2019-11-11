package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.services.CategoryService;
import org.wcci.apimastery.entities.Category;

@RequestMapping("api/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = { "", "/", "/all" })
	public List<Category> retrieveAllCategories() {
		return categoryService.fetchAllCategories();
	}

}
