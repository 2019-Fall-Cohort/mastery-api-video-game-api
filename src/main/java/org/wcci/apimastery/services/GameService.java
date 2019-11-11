package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.entities.Comment;
import org.wcci.apimastery.entities.Game;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.entities.System;
import org.wcci.apimastery.exceptions.GameNotFoundException;
import org.wcci.apimastery.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;

	public Game addGame(Game game) {
		return gameRepo.save(game);
	}

	public List<Game> retrieveAllGames() {
		return (List<Game>) gameRepo.findAll();
	}

	public Game findGameById(Long id) {
		Optional<Game> retrievedGameOptional = gameRepo.findById(id);
		if (!retrievedGameOptional.isPresent()) {
			throw new GameNotFoundException("Game not found.");
		}
		return retrievedGameOptional.get();
	}

	public Game addCommentToGame(Game game, Comment comment) {
		game.addComment(comment);
		return gameRepo.save(game);
	}
	
	public Game updateGame(Long gameId, String gameTitle, String releaseDate, Category category, String imageUrl,
			Publisher publisher, System system) {
		Game game = findGameById(gameId);
		game.updateTitle(gameTitle);
		game.updateReleaseDate(releaseDate);
		game.updateImageUrl(imageUrl);
		game.updateCategory(category);
		game.updatePublisher(publisher);
		game.updateSystem(system);
		return gameRepo.save(game);
	}

	public void deleteGame(Game game) {
		gameRepo.delete(game);
	}

}
