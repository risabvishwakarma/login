package spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("spring.rest")
public class SpringRestDataJpaLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDataJpaLoginApplication.class, args);
	}

}
