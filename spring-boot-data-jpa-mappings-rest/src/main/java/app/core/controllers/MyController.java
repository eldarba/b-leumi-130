package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.School;
import app.core.services.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService service;

	@PostMapping
	public int createSchool(@RequestBody School school) {
		return this.service.createSchool(school);
	}

}
