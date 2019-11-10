package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Publisher;
import org.wcci.apimastery.repositories.PublisherRepository;

import exceptions.PublisherNotFoundException;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepo;
	
	public Publisher addPublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	public Publisher findPublisherById(Long id) {
		Optional<Publisher> retrievedPublisherOptional = publisherRepo.findById(id);
		if (!retrievedPublisherOptional.isPresent()) {
			throw new PublisherNotFoundException("Publisher not found.");
		}
		return retrievedPublisherOptional.get();
	}
	
	public List<Publisher> fetchAllPublishers() {
		return (List<Publisher>) publisherRepo.findAll();
	}
	
	public void deletePublisher(Publisher publisher) {
		publisherRepo.delete(publisher);
	}
	
}
