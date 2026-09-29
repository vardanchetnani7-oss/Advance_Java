package com.Users.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Users.config.ErrorDeocder;
import com.Users.models.dtos.PlaylistDto;

@FeignClient(
        name = "PlaylistService",
        url = "http://localhost:8081",
        fallback = PlaylistClientFallback.class,
        configuration = ErrorDeocder.class
)
public interface Feignclient {

	@GetMapping("/playlists/{id}")
    PlaylistDto getPlaylist(@PathVariable("id") Long id);
}
