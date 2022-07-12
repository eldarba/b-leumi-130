package app.core.beans;

import org.springframework.stereotype.Component;

import app.core.annotations.MyLogAnnotation;

@Component("calc1")
public class CalculatorImpl implements Calculator {

	@Override
	public String divide(int a, int b) throws RuntimeException {
		String res = a + " : " + b + " = " + (a / b) + " [remainder: " + (a % b) + " ]";
		System.out.println(res);
		return res;
	}

	@MyLogAnnotation
	@Override
	public String greet() {
		return "Have a good day";
	}

}
