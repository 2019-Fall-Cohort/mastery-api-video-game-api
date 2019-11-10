package org.wcci.apimastery.objects;

import javax.persistence.Embeddable;

@Embeddable 
public class Comments {
	private String content;
	private String author;

	protected Comments() {}

	public Comments(String content, String author) {
		this.content = content;
		this.author = author;
	}
	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	
}
