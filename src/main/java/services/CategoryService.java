package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Category;
import org.wcci.apimastery.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Optional<Category> findCategoryById(Long id) {
		return categoryRepo.findById(id);
	}
	
	public List<Category> fetchAllCategories() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}

}
