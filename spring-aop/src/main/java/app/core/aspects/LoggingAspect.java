package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	// advice is a method that runs once the joinpoint was called
	// pointcut expression - connects advice (aspect method) to joinpoint (businnes
	// method)
	@Before("execution(public void app.core.clients.Administrator.greet())")
//	@Before("execution(* *(..))")
	public void beforeGreet() {
		System.out.println(">>> beforeGreet");
	}

	// all methods accepting Manager or String argument
	@Before("managerArg() || StringArg()")
	public void anyMethodWithManagerOrStringArg(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("************ method " + methodName + " acccepts Manager argument");
	}

	@Before("clientsPackage()")
	public void clients(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("-------- method " + methodName + " is in clients package");
	}

	// pointcut declarations

	// all methods in package: app.core.clients
	@Pointcut("execution(* app.core.clients.*.*(..))")
	public void clientsPackage() {

	}

	@Pointcut("execution(* *(.., app.core.clients.Manager, ..))")
	public void managerArg() {

	}

	@Pointcut("execution(* *(.., java.lang.String, ..))")
	public void StringArg() {

	}

	public static final String STRINGARG2 = "execution(* *(.., java.lang.String, ..))";

	@Before(STRINGARG2)
	public void anyMethodWithString(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("method " + methodName + " acccepts String argument");
	}

}
