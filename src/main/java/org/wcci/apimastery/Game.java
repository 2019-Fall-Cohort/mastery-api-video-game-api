package org.wcci.apimastery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String releaseDate;
	private Category category;
	private String imageUrl;
	private Publisher publisher;
	private System system;
	private List<People> people;
	private List<Comments> comments;
	
	protected Game() {}
	
	public Game(String title, String releaseDate, Category category,
			String imageUrl, Publisher publisher, System system) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.category = category;
		this.imageUrl = imageUrl;
		this.publisher = publisher;
		this.system = system;
		comments = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public System getSystem() {
		return system;
	}

	public List<People> getPeople() {
		return people;
	}

	public List<Comments> getComments() {
		return comments;
	}
	
	

}
