package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.services.PublisherService;

@RequestMapping("api/publisher")
@RestController
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping(value = { "", "/", "/all" })
	public List<Publisher> retrieveAllPublishers() {
		return publisherService.fetchAllPublishers();
	}
	
	@GetMapping("/{id}")
	public Publisher getById(@PathVariable Long id) {
		return publisherService.findPublisherById(id);
	}
	@PostMapping("/{name}")
	public Publisher addPublisher(@PathVariable String name) {
		Publisher publisher = new Publisher(name);
		return publisherService.addPublisher(publisher);
	}

}
