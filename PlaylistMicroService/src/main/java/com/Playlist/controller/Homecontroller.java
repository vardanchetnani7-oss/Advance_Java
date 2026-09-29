package com.Playlist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

	@GetMapping("/")
	public String home() {
		return "playlist service is running";
	}

}
