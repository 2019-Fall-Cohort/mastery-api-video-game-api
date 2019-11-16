package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Game;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.entities.System;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.entities.Comment;
import org.wcci.apimastery.services.CategoryService;
import org.wcci.apimastery.services.GameService;
import org.wcci.apimastery.services.PublisherService;
import org.wcci.apimastery.services.SystemService;

@CrossOrigin
@RequestMapping("api/game")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private SystemService systemService;

	@GetMapping({ "", "/", "/all" })
	public List<Game> retrieveAllGames() {
		return gameService.retrieveAllGames();
	}

	@GetMapping("/{gameId}")
	public Game retrieveGameById(@PathVariable Long gameId) {
		return gameService.findGameById(gameId);
	}

	@PatchMapping("/comment/{gameId}")
	public Game addComment(@PathVariable Long gameId, @RequestBody Comment comment) {
		Game game = gameService.findGameById(gameId);
		return gameService.addCommentToGame(game, comment);
	}

	@PatchMapping("/{gameId}/{commentContent}")
	public Game addAnnonymousComment(@PathVariable Long gameId, @PathVariable String commentContent) {
		Comment comment = new Comment(commentContent, "Annoymous");
		Game game = gameService.findGameById(gameId);
		return gameService.addCommentToGame(game, comment);
	}

	@PostMapping("/new")
	public Game addGameByRequestBody(@RequestBody Game game) {
		return gameService.addGame(game);
	}

	@PostMapping("/new/{gameTitle}")
	public Game addGameByTitle(@PathVariable String gameTitle) {
		Game game = new Game(gameTitle);
		return gameService.addGame(game);
	}

	@PostMapping("/new/{gameTitle}/{releaseDate}/{categoryId}/{imageUrl}/{publisherId}/{systemId}")
	public Game addGameAllAttributes(@PathVariable String gameTitle, @PathVariable String releaseDate,
			@PathVariable Long categoryId, @PathVariable String imageUrl, @PathVariable Long publisherId,
			@PathVariable Long systemId) {
		Category category = categoryService.findCategoryById(categoryId);
		Publisher publisher = publisherService.findPublisherById(publisherId);
		System system = systemService.findSystemById(systemId);
		Game game = new Game(gameTitle, releaseDate, category, imageUrl, publisher, system);
		return gameService.addGame(game);
	}

	@PostMapping("/edit/{gameId}/{gameTitle}/{releaseDate}/{categoryId}/{imageUrl}/{publisherId}/{systemId}")
	public Game updateGameAllAttributes(@PathVariable Long gameId, @PathVariable String gameTitle,
			@PathVariable String releaseDate, @PathVariable Long categoryId, @PathVariable String imageUrl,
			@PathVariable Long publisherId, @PathVariable Long systemId) {
		Category category = categoryService.findCategoryById(categoryId);
		Publisher publisher = publisherService.findPublisherById(publisherId);
		System system = systemService.findSystemById(systemId);
		return gameService.updateGame(gameId, gameTitle, releaseDate, category, imageUrl, publisher, system);
	}

	@DeleteMapping("/remove/{gameId}")
	public void removeGameById(@PathVariable Long gameId) {
		Game game = gameService.findGameById(gameId);
		gameService.deleteGame(game);
	}

}
