package org.wcci.apimastery.entities;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable 
public class Comment {
	
	@Lob
	private String content;
	private String author;

	protected Comment() {}

	public Comment(String content, String author) {
		this.content = content;
		this.author = author;
	}
	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Comment [content=" + content + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Comment other = (Comment) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	
}
