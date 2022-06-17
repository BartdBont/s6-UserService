package com.bart.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableEurekaClient
public class UserServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(UserServiceApplication.class);
	private List<String> names = Arrays.asList("Donald", "Theresa", "Vladimir", "Angela", "Emmanuel", "Shinzō", "Jacinda", "Kim");

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public Supplier<UUID> userDeleted() {
		return () -> {
			UUID uuid = UUID.randomUUID();
			log.info(String.format("User with ID:%s deleted", uuid));
			return uuid;
		};
	}

}
