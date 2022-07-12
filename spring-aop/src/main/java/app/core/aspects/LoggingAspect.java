package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	// advice is a method that runs once the joinpoint was called
	// pointcut expression - connects advice (aspect method) to joinpoint (businnes
	// method)
//	@Before("execution(public void app.core.clients.Administrator.greet())")
	@Before("execution(* *.*(..))")
	public void beforeGreet() {
		System.out.println(">>> beforeGreet");
	}

}
