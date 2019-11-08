package org.wcci.apimastery.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	protected Publisher() {}
	
	public Publisher (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	

}
