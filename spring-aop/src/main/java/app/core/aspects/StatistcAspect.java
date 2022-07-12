package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatistcAspect {

	private int counter;

	public int getCounter() {
		return counter;
	}

//	() - no parameters
//	(type1, type1) – specific parameters
//	(.) – one parameter of any type
//	(..) – 0 or more parameters of any type

	// 1. modifiers - any if not specified
	// 2. return type - * = any [mandatory]
	// 3. declaring type (package.class.) - any if not specified
	// 4. method pattern [mandatory]
	// 5. parameter pattern [mandatory]
	// 6. throw pattern
	@Before("execution(* add*(..))")
	public void countAddMethodsCall() {
		counter++;
	}
}
