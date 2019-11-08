package org.wcci.apimastery.objects;

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
	
	public Game(String title) {
		this.title = title;
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", category=" + category
				+ ", imageUrl=" + imageUrl + ", publisher=" + publisher + ", system=" + system + ", people=" + people
				+ ", comments=" + comments + "]";
	}
	
	

}
