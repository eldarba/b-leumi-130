package app.core.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle {
	// DI - Dependency Injection
	// @Resource
	// @Autowired
	// @Qualifier("turboEngine")
	private Engine engine;

	
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

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
