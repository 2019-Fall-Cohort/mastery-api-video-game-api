package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.System;
import org.wcci.apimastery.repositories.SystemRepository;

import exceptions.SystemNotFoundException;

@Service
public class SystemService {
	
	@Autowired
	private SystemRepository systemRepo;
	
	public System addSystem(System system) {
		return systemRepo.save(system);
	}
	
	public System findSystemById(Long id) {
		Optional<System> retrievedSystemOptional = systemRepo.findById(id);
		if (!retrievedSystemOptional.isPresent()) {
			throw new SystemNotFoundException("System not found.");
		}
		return retrievedSystemOptional.get();
	}
	
	public List<System> fetchAllSystems() {
		return (List<System>) systemRepo.findAll();
	}
	
	public void deleteSystem(System system) {
		systemRepo.delete(system);
	}

}
