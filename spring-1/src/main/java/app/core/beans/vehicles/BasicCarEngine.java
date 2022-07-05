package app.core.beans.vehicles;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasicCarEngine implements Engine {

	@Override
	public void start() {
		System.out.println("BasicCarEngine started");

	}

	@Override
	public void stop() {
		System.out.println("BasicCarEngine stopped");
	}

}
