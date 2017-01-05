package br.router;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouterApplication.class, args);
	}
}
