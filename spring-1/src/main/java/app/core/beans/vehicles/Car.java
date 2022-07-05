package app.core.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	// DI
	@Autowired
	private Engine engine;

	@Override
	public void move() {
		engine.start();
		System.out.println("car is moving");

	}

	@Override
	public void stop() {
		engine.stop();
		System.out.println("car stopped");
	}

}
