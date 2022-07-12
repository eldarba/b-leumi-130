package app.core.beans;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {

	@Override
	public String divide(int a, int b) throws RuntimeException {
		return a + " : " + b + " = " + (a / b) + " [remainder: " + (a % b) + "]";
	}

}
