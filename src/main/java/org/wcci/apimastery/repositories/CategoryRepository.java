package org.wcci.apimastery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public List<Category> findAllByOrderByName();
	public Category findCategoryByName(String name);

}
