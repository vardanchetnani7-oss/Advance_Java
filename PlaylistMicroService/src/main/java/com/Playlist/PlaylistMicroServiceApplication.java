package com.Playlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PlaylistMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistMicroServiceApplication.class, args);
	}

}
