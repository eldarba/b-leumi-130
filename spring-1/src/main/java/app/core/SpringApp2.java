package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class SpringApp2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp2.class);) {

			Car vehicle = ctx.getBean(Car.class);
			vehicle.move();
			vehicle.stop();
			System.out.println(vehicle.getMaxSpeed());
			
			System.out.println("=================");

			Car carTurbo = ctx.getBean("turboCar", Car.class);
			carTurbo.move();
			carTurbo.stop();
			System.out.println(carTurbo.getMaxSpeed());

		}

	}

	@Bean
	public Car turboCar() {
		Car car = new Car(new TurboEngine(), 0);
		return car;
	}

}
