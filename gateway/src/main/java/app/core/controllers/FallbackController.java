package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/fallback/serviceA")
	public String fallbackA() {
		return "gateway fallback - cannot call service A";
	}
	@GetMapping("/fallback/serviceB")
	public String fallbackB() {
		return "gateway fallback - cannot call service B";
	}

}
