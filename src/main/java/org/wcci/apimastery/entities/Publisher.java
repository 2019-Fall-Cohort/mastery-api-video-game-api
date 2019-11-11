package org.wcci.apimastery.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany
	private List<Game> games;
	
	protected Publisher() {}
	
	public Publisher (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	

}
