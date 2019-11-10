package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Category;
import org.wcci.apimastery.repositories.CategoryRepository;

import exceptions.CategoryNotFoundException;

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
	
	public List<Category> fetchAllCategories() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}

}
