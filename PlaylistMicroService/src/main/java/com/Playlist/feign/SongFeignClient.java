package com.Playlist.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.Playlist.model.dtos.SongDto;

@FeignClient(name = "song-service",url = "${song-service.url}")
public interface SongFeignClient {

	@GetMapping("/songs")
	List<SongDto>getAllSongs();
}
