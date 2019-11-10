package org.wcci.apimastery;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcci.apimastery.objects.Category;
import org.wcci.apimastery.objects.Game;
import org.wcci.apimastery.objects.Publisher;
import org.wcci.apimastery.objects.System;
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
	
	@Test
	public void gameWillHavePublisher() throws Exception {
		Publisher testPublisher = new Publisher("From Software");
		System testSystem = new System("ps4");
		Category testCategory = new Category ("Rpg");
		Game testGame = new Game ("Dark Souls", "9/22/11", testCategory, "imageUrl", testPublisher, testSystem);
		
		testPublisher = publisherRepo.save(testPublisher);
		testSystem = systemRepo.save(testSystem);
		testCategory = categoryRepo.save(testCategory);
		testGame = gameRepo.save(testGame);
		
		entityManager.flush();
		entityManager.clear();
		
		Game retrievedGame = gameRepo.findById(testGame.getId()).get();
		
		assertEquals(testGame, retrievedGame);
		assertThat(retrievedGame.getPublisher(), contains(testPublisher));
		
	}
	

}
