package com.Users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Users.feign.Feignclient;
import com.Users.models.dtos.PlaylistDto;

@RestController
@RequestMapping("/users")
public class Controller {
private final Feignclient feignclient;

public Controller(Feignclient feignclient) {
	
	this.feignclient = feignclient;
}

@GetMapping("/{userId}/playlist/{playlistId}")
public PlaylistDto getUserPlaylist(
        @PathVariable Long userId,
        @PathVariable Long playlistId) {

    return feignclient.getPlaylist(playlistId);
}
}
