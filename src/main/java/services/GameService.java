package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Game;
import org.wcci.apimastery.repositories.GameRepository;

import exceptions.GameNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;
	
	public Game addGame(Game game) {
		return gameRepo.save(game);
	}

	public Game findGameById(Long id) {
		Optional<Game> retrievedGameOptional = gameRepo.findById(id);
		if (!retrievedGameOptional.isPresent()) {
			throw new GameNotFoundException("Game not found.");
		}
		return retrievedGameOptional.get();
	}
	
	public void deleteGame(Game game) {
		gameRepo.delete(game);
	}
	
	public List<Game> retrieveAllGames() {
		return (List<Game>) gameRepo.findAll();
	}

}
