package com.dev.agripocket;

import com.dev.agripocket.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class AgripocketApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgripocketApplication.class, args);
	}
}
