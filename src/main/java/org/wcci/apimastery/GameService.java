package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Category;
import org.wcci.apimastery.objects.Game;
import org.wcci.apimastery.objects.Publisher;
import org.wcci.apimastery.objects.System;
import org.wcci.apimastery.repositories.CategoryRepository;
import org.wcci.apimastery.repositories.GameRepository;
import org.wcci.apimastery.repositories.PublisherRepository;
import org.wcci.apimastery.repositories.SystemRepository;

@Service
public class GameService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private GameRepository gameRepo;
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Autowired
	private SystemRepository systemRepo;

	public Game addGame(Game game) {
		return gameRepo.save(game);
	}

	public Game findGameByTitle(String title) {
		return (Game) gameRepo.findGameByTitle(title);
	}
	
	public void deleteGame(Game game) {
		gameRepo.delete(game);
	}
	
	public Publisher addPublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public System addSystem(System system) {
		return systemRepo.save(system);
	}

	public Iterable<Game> retrieveAllGames() {
		return gameRepo.findAll();
	}

}
