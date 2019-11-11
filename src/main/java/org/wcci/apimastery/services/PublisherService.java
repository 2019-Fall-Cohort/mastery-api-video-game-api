package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.exceptions.PublisherNotFoundException;
import org.wcci.apimastery.repositories.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepo;

	public Publisher addPublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}

	public List<Publisher> fetchAllPublishers() {
		return publisherRepo.findAllByOrderByName();
	}

	public Publisher findPublisherById(Long id) {
		Optional<Publisher> retrievedPublisherOptional = publisherRepo.findById(id);
		if (!retrievedPublisherOptional.isPresent()) {
			throw new PublisherNotFoundException("Publisher not found.");
		}
		return retrievedPublisherOptional.get();
	}

	public Publisher findPublisherByName(String name) {
		Publisher retrievedPublisher;
		try {
			retrievedPublisher = publisherRepo.findPublisherByName(name);
		} catch (Exception e) {
			throw new PublisherNotFoundException("Publisher not found.");
		}
		return retrievedPublisher;
	}

	public void deletePublisher(Publisher publisher) {
		publisherRepo.delete(publisher);
	}

}
