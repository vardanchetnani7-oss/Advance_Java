package com.Songs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Songs.models.Songs;

@RestController
public class SongController {

	private final List<Songs> songs = List.of(
            new Songs(1L, "Shape of You", "Ed Sheeran", 234),
            new Songs(2L, "Tum Hi Ho", "Arijit Singh", 262),
            new Songs(3L, "Kesariya", "Arijit Singh", 268),
            new Songs(4L, "Blinding Lights", "The Weeknd", 200)
    );
	@GetMapping("/songs")
    public List<Songs> getAllSongs() {
        return songs;
    }
}
