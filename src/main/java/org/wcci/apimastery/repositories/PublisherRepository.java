package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.apimastery.entities.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	
	public Iterable<Publisher> findAllOrderByName();
	public Publisher findPublisherByName(String name);

}
