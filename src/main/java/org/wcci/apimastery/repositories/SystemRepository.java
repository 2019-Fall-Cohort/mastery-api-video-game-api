package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.entities.System;

@Repository
public interface SystemRepository extends CrudRepository<System, Long> {

	public Iterable<System> findAllByOrderByName();
	public System findSystemByName(String name);
	
}
