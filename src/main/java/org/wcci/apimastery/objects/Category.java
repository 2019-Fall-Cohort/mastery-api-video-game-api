package org.wcci.apimastery.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	protected Category () {}
	
	public Category(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
