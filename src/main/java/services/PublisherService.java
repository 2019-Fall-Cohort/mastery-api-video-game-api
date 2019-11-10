package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Publisher;
import org.wcci.apimastery.repositories.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepo;
	
	public Publisher addPublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	public Optional<Publisher> findCategoryById(Long id) {
		return publisherRepo.findById(id);
	}
	
	public List<Publisher> fetchAllCategories() {
		return (List<Publisher>) publisherRepo.findAll();
	}
	
	public void deletePublisher(Publisher publisher) {
		publisherRepo.delete(publisher);
	}
	
}
