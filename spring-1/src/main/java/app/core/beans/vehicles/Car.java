package app.core.beans.vehicles;

import org.springframework.beans.factory.annotation.Value;
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
	private int maxSpeed;

	public Car(Engine engine, @Value("${car.max.speed}") int maxSpeed) {
		super();
		this.engine = engine;
		this.maxSpeed = maxSpeed;
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

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	

}
