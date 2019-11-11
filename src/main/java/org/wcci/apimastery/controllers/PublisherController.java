package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
