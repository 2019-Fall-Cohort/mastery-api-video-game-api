package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.objects.Game;

import services.GameService;

@RequestMapping("api/games/")
@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("")
	public List<Game> retrieveAllGames() {
	return gameService.retrieveAllGames();
			
	}
	
	

}
