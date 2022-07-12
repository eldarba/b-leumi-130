package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LogAspect {

	// advices
	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println(">>> @Before: " + jp.getSignature().getName());
	}

	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println(">>> @After: " + jp.getSignature().getName());
	}

	@AfterReturning("div()")
	public void afterDivReturns(JoinPoint jp) {
		System.out.println(">>> @AfterReturning: " + jp.getSignature().getName());
	}

	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterDivThrows(JoinPoint jp, Throwable e) {
		System.out.println(">>> @AfterThrowing: " + jp.getSignature().getName() + " ERROR: " + e.getMessage());
	}

	@Around("div()")
	public Object aroundDiv(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around: before jp: " + pjp.getSignature().getName());
		// invoke the jp
		try {
			Object res = pjp.proceed();
			return res;
//			return "result is 10000";
		} catch (Exception e) {
			// in case of exception we can return alternative result
//			return "TEN";
			// in case of exception we can propagate it to JP
			throw e;
		} finally {
			System.out.println("@Around: after jp: " + pjp.getSignature().getName());
		}
	}

	// pointcut definitions:
	@Pointcut("execution(String divide(int, int) )")
	public void div() {

	}

}
