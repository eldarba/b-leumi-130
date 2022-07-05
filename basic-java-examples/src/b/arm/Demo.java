package b.arm;

public class Demo {

	public static void main(String[] args) {
		
		
		// ARM - Auto Resource Management (try with resources)
		try (Window window = new Window();) {
			window.use();
			window.use();
			if (Math.random() < 0.5) {
				throw new RuntimeException("ERROR");
			}
			window.use();
		}

	}
}

class Window implements AutoCloseable {

	int c;

	{
		System.out.println("window opened");

	}

	@Override
	public void close() {
		System.out.println("window closed");

	}

	public void use() {
		System.out.println("uning window: " + ++c);
	}

}
