package app.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.beans.Calculator;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

	// @Bean
	public Calculator calc2(Calculator calculator) {
		return calculator;
	}

}
