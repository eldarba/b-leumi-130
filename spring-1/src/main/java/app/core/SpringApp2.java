package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
public class SpringApp2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp2.class);) {

			Vehicle vehicle = ctx.getBean(Vehicle.class);
			vehicle.move();
			vehicle.stop();

			Vehicle carTurbo = ctx.getBean("turboCar", Vehicle.class);
			carTurbo.move();
			carTurbo.stop();

		}

	}

	@Bean
	public Car turboCar() {
		Car car = new Car(new TurboEngine());
		return car;
	}

}
