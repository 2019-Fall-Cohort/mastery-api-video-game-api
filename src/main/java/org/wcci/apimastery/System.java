package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class System {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	protected System() {}
	
	public System (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
