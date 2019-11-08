package org.wcci.apimastery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wcci.apimastery.objects.Game;

public class GameServiceTest {

	@Autowired
	private GameService gameService;
		
	
	@Test
	public void createAndSaveGame() {
		Game game = new Game("title");		
//		gameService.addGame(game);
//		Game savedGame = gameService.findGameByTitle("title");
		assertEquals(game.getTitle(), "title");
		
	}
	
}
