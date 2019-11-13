package org.wcci.apimastery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcci.apimastery.entities.Comment;
import org.wcci.apimastery.entities.Category;
import org.wcci.apimastery.entities.Game;
import org.wcci.apimastery.entities.Publisher;
import org.wcci.apimastery.entities.System;
import org.wcci.apimastery.repositories.CategoryRepository;
import org.wcci.apimastery.repositories.GameRepository;
import org.wcci.apimastery.repositories.PublisherRepository;
import org.wcci.apimastery.repositories.SystemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAWiringTest {

	@Autowired
	private GameRepository gameRepo;
	@Autowired
	private PublisherRepository publisherRepo;
	@Autowired
	private SystemRepository systemRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private TestEntityManager entityManager;

	Publisher testPublisher = new Publisher("From Software");
	System testSystem = new System("ps4");
	Category testCategory = new Category("Rpg");
	Game testGame = new Game("Dark Souls", "9/22/11", testCategory, "imageUrl", testPublisher, testSystem);
	
	@Test
	public void gameWillHavePublisher() {

		testPublisher = publisherRepo.save(testPublisher);
		testSystem = systemRepo.save(testSystem);
		testCategory = categoryRepo.save(testCategory);
		testGame = gameRepo.save(testGame);

		entityManager.flush();
		entityManager.clear();

		Game retrievedGame = gameRepo.findById(testGame.getId()).get();

		assertEquals(testGame, retrievedGame);
		assertThat(retrievedGame.getPublisher(), is(testPublisher));

	}
	@Test
	public void gameWillHaveSystem() {
		
		testPublisher = publisherRepo.save(testPublisher);
		testSystem = systemRepo.save(testSystem);
		testCategory = categoryRepo.save(testCategory);
		testGame = gameRepo.save(testGame);

		entityManager.flush();
		entityManager.clear();

		Game retrievedGame = gameRepo.findById(testGame.getId()).get();

		assertEquals(testGame, retrievedGame);
		assertThat(retrievedGame.getSystem(), is(testSystem));
		
	}
	@Test
	public void gameWillHaveCategory() {
		
		testPublisher = publisherRepo.save(testPublisher);
		testSystem = systemRepo.save(testSystem);
		testCategory = categoryRepo.save(testCategory);
		testGame = gameRepo.save(testGame);

		entityManager.flush();
		entityManager.clear();

		Game retrievedGame = gameRepo.findById(testGame.getId()).get();

		assertEquals(testGame, retrievedGame);
		assertThat(retrievedGame.getCategory(), is(testCategory));
		
	}
	@Test
	public void gamesCanHaveComments() throws Exception {
		testPublisher = publisherRepo.save(testPublisher);
		testSystem = systemRepo.save(testSystem);
		testCategory = categoryRepo.save(testCategory);
		testGame = gameRepo.save(testGame);
		Comment testComment = new Comment("This is an amazing comment!", "BOB");

		testGame.addComment(testComment);
		testGame = gameRepo.save(testGame);

		entityManager.flush();
		entityManager.clear();

		Game retrievedGame = gameRepo.findById(testGame.getId()).get();
		assertThat(retrievedGame.getComments(), contains(testComment));
	}
	
}
