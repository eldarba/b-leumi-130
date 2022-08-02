package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.School;
import app.core.services.MyService;

@RestController
@RequestMapping("/api/school")
public class MyController {

	@Autowired
	private MyService service;

	@PostMapping
	public int createSchool(@RequestBody School school) {
		return this.service.createSchool(school);
	}

	// http://localhost:8080/api/school?id=101
	@GetMapping
	public School getSchool(@RequestParam int id) {
		try {
			return this.service.getSchoole(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
