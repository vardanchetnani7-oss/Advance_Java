package com.Playlist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Playlist.model.Playlist;
import com.Playlist.service.Playstore;

@RestController
@RequestMapping("/playlists")
public class PlayListController {

private final Playstore store;

public PlayListController(Playstore store) {
    this.store = store;
}


@PostMapping
public ResponseEntity<Playlist>create(@RequestBody Playlist playlist){
	return ResponseEntity.status(HttpStatus.CREATED).body(store.save(playlist));
}

@GetMapping
public List<Playlist>getAll(){
	return store.findAll();
}
@GetMapping("/{id}")
public ResponseEntity<Playlist> update(@PathVariable Long id, @RequestBody Playlist playlist){
	return store.update(id, playlist)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void>delete(@PathVariable Long id){
	return store.delete(id)
			? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
}
}
