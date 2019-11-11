package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.exceptions.CategoryNotFoundException;
import org.wcci.apimastery.repositories.CategoryRepository;

import java.sql.*;
import org.h2.tools.Csv;
import org.h2.tools.SimpleResultSet;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;	
	private String categoriesDataFile = "src/main/resources/data/categories.csv";

	public Category addCategory(Category category) {
		Category savedCategory = categoryRepo.save(category);
		updateCSV();
		return savedCategory;
	}

	public List<Category> fetchAllCategories() {
		return categoryRepo.findAllByOrderByName();
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

	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
		updateCSV();
	}

	private void updateCSV() {
		SimpleResultSet rs = new SimpleResultSet();
		rs.addColumn("NAME", Types.VARCHAR, 255, 0);

		List<Category> categoryList = fetchAllCategories();
		for (Category category : categoryList) {
			rs.addRow(category.getName());
		}

		try {
			new Csv().write(categoriesDataFile, rs, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void loadCSV() {

		try {

			ResultSet rs = new Csv().read(categoriesDataFile, null, null);

			while (rs.next()) {
				String categoryName = rs.getString("NAME");
				java.lang.System.out.println(categoryName);
				Category category = new Category(categoryName);
				addCategory(category);
			}

			rs.close();
			updateCSV();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
