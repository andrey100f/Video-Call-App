package com.andrei.videocall;

import com.andrei.videocall.domain.User;
import com.andrei.videocall.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(IUserService service) {
		return args -> {
			service.register(User.builder()
							.username("Ali")
							.email("ali@mail.com")
							.password("aaa")
					.build());

			service.register(User.builder()
					.username("John")
					.email("john@mail.com")
					.password("aaa")
					.build());

			service.register(User.builder()
					.username("Anna")
					.email("anna@mail.com")
					.password("aaa")
					.build());
		};
	}

}
