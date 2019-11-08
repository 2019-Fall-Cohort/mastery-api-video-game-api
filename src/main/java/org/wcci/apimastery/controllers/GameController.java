package org.wcci.apimastery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.GameService;

@RequestMapping("api/games/")
@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public void retrieveAllGames() {
	return gameService.retrieveAllGames();
			
	}
	
	

}
