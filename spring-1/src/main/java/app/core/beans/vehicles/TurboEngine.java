package app.core.beans.vehicles;

public class TurboEngine implements Engine {

	@Override
	public void start() {
		System.out.println("TurboEngine started");

	}

	@Override
	public void stop() {
		System.out.println("TurboEngine stopped");

	}

}
