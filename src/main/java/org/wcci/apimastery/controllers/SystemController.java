package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.services.SystemService;
import org.wcci.apimastery.entities.System;

@RequestMapping("api/system")
@RestController
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/")
	public List<System> displayAllSystems() {
		return systemService.fetchAllSystems();
	}
	
	@PostMapping("/{name}")
	public System addNewSystem(@PathVariable String name) {
		System system = new System(name);
		return systemService.addSystem(system);
	}
	@GetMapping("/{id}")
	public System getById(@PathVariable Long id) {
		return systemService.findSystemById(id);
	}
	

}
