package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.System;
import org.wcci.apimastery.repositories.SystemRepository;

@Service
public class SystemService {
	
	@Autowired
	private SystemRepository systemRepo;
	
	public System addSystem(System system) {
		return systemRepo.save(system);
	}
	
	public Optional<System> findCategoryById(Long id) {
		return systemRepo.findById(id);
	}
	
	public List<System> fetchAllCategories() {
		return (List<System>) systemRepo.findAll();
	}
	
	public void deleteSystem(System system) {
		systemRepo.delete(system);
	}

}
