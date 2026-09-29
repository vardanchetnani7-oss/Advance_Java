package com.Songs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Songs.models.PlayList;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping("/{id}")
    public PlayList getPlaylist(@PathVariable Long id) {

        return new PlayList(
                id,
                "My Favorite Songs",
                "Vardan"
        );
    }
}