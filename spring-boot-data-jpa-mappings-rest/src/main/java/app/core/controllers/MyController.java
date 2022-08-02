package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.School;
import app.core.services.MyService;

@CrossOrigin
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
			return this.service.getSchool(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PutMapping
	public void updateSchool(@RequestBody School school) {
		try {
			this.service.updateSchool(school);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// http://localhost:8080/api/school/101
	@DeleteMapping("/{id}")
	public void deleteSchool(@PathVariable int id) {
		try {
			this.service.deletSchool(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
