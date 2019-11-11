package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.exceptions.CategoryNotFoundException;
import org.wcci.apimastery.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Category findCategoryById(Long id) {
		Optional<Category> retrievedCategoryOptional = categoryRepo.findById(id);
		if (!retrievedCategoryOptional.isPresent()) {
			throw new CategoryNotFoundException("Category not found.");
		}
		return retrievedCategoryOptional.get();
	}

	public Category findCategoryByName(String name) {
		Category retrievedCategory;

		try {
			retrievedCategory = categoryRepo.findCategoryByName(name);
		} catch (Exception e) {
			throw new CategoryNotFoundException("Category not found.");
		}

		return retrievedCategory;
	}

	public List<Category> fetchAllCategories() {
		return (List<Category>) categoryRepo.findAll();
	}

	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}

}
