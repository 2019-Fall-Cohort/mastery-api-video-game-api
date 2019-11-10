package org.wcci.apimastery.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class People {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	protected People() {}
	
	public People (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
