package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.entities.Game;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.entities.System;
import org.wcci.apimastery.services.CategoryService;
import org.wcci.apimastery.services.GameService;
import org.wcci.apimastery.services.PublisherService;
import org.wcci.apimastery.services.SystemService;

@Component
public class DataPopulator implements CommandLineRunner {

	@Autowired
	private GameService gameService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private SystemService systemService;

	private String[] categories = { "Action", 
									"Adventure", 
									"Horror",
									"Role Playing", 
									"Shooter", 
									"Simulation",
									"Strategy",
									"Survival"};
	
	private String[] systems = { "Wii U",
								 "Wii",								 
								 "Nintendo", 
								 "Super Nintendo",
								 "Nintendo 64",
								 "Nintendo Switch", 
								 "PlayStation", 
								 "PlayStation 2",
								 "PlayStation 3", 
								 "PlayStation 4",
								 "Sega Genesis",
								 "Dreamcast",
								 "PC",
								 "Mobile",								 
								 "Xbox One",
								 "Xbox 360"};
	
	private String[] publishers = { "Apple", 
								    "Microsoft",
								    "Sony Interactive Entertainment",
								    "Tencent Games",
								    "Activision Blizzard",
								    "NetEase",
								    "Electronic Arts",
								    "Google",
								    "Nintendo",
								    "Bandai Namco",
								    "Netmarble Games",
								    "Ubisoft"};								    
							

	@Override
	public void run(String... args) throws Exception {
				
		for (String categoryName : categories) {
			Category category = new Category(categoryName);
			categoryService.addCategory(category);
		}
		
		for (String publisherName : publishers) {
			Publisher publisher = new Publisher(publisherName);
			publisherService.addPublisher(publisher);
		}
		
		for (String systemName : systems) {
			System system = new System(systemName);
			systemService.addSystem(system);
		}		
		
		gameService.addGame(new Game("Generic Mobile Game", 
									 "August 2014", 
									 categoryService.findCategoryByName("Action"),
									 "https://picsum.photos/200/300",
									 publisherService.findPublisherByName("Ubisoft"),
									 systemService.findSystemByName("Mobile")));	
		
		gameService.addGame(new Game("SIMS Phoney", 
				 				     "Dec 10, 2018", 
									 categoryService.findCategoryByName("Simulation"),
									 "https://picsum.photos/200/300",
									 publisherService.findPublisherByName("NetEase"),
									 systemService.findSystemByName("PC")));	
		
	}
}
