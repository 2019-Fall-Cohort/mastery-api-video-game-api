package org.wcci.apimastery.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String releaseDate;	
	@ManyToOne
	private Category category;
	private String imageUrl;	
	@ManyToOne
	private Publisher publisher;	
	@ManyToOne
	private System system;	
//	private List<People> people;
	@ElementCollection
	private List<Comment> comments;
	
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
	
//	public List<People> getPeople() {
//	return people;
//}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
	
	public void updateReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void updateImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void updateCategory(Category category) {
		this.category = category;
	}
	
	public void updatePublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public void updateSystem(System system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", category=" + category
				+ ", imageUrl=" + imageUrl + ", publisher=" + publisher + ", system=" + system + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
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
}
