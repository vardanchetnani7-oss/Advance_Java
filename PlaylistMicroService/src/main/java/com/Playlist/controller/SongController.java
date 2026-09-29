package com.Playlist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Playlist.feign.SongFeignClient;
import com.Playlist.model.dtos.SongDto;

@RestController
public class SongController {

	private final SongFeignClient songClient;
	public SongController(SongFeignClient songClient) {
        this.songClient = songClient;
    }

    @GetMapping("/songs")
    public List<SongDto> getSongs() {
        return songClient.getAllSongs();
    }
}
