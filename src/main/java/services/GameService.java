package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.objects.Game;
import org.wcci.apimastery.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;
	
	public Game addGame(Game game) {
		return gameRepo.save(game);
	}

	public Optional<Game> findCategoryById(Long id) {
		return gameRepo.findById(id);
	}
	
	public void deleteGame(Game game) {
		gameRepo.delete(game);
	}
	
	public List<Game> retrieveAllGames() {
		return (List<Game>) gameRepo.findAll();
	}

}
