package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.services.StudentServcie;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentServcie studentServcie;

	@PostMapping
	public int addStudent() {
		return studentServcie.addStudent();
	}

	@GetMapping
	public String getStudent() {
		return studentServcie.getStudent(101);
	}

	@PutMapping
	public String updateStudent() {
		return studentServcie.updateStudent();
	}

	@DeleteMapping
	public String deleteStudent() {
		return studentServcie.deleteStudent();
	}

}
