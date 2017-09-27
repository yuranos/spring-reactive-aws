package com.yuranos.architecture.aws

import org.codehaus.groovy.runtime.DefaultGroovyMethodsSupport
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//        (scanBasePackages = ["com.yuranos.architecture.aws"])
//@ComponentScan(basePackages = {"hello.hello"}, resourcePattern = "hello")
class MainApplication {

	static void main(String[] args) {
		SpringApplication.run MainApplication, args
	}

//	https://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-using-type-converters-with-spring-mvc/
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
//		registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
//	}
}
