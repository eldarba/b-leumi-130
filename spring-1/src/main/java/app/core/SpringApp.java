package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Point;

public class SpringApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("up");

		Point p1 = ctx.getBean("point", Point.class);
		Point p2 = ctx.getBean("point", Point.class);
		p1.setX(100);
		System.out.println(p1);
		System.out.println(p2);
		
		Integer r1 = ctx.getBean(Integer.class);
		Integer r2 = ctx.getBean(Integer.class);
		Integer r3 = ctx.getBean(Integer.class);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);

		ctx.close();
		System.out.println("down");
	}

}
