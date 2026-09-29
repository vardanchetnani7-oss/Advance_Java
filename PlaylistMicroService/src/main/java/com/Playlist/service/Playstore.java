package com.Playlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.Playlist.model.Playlist;

@Component
public class Playstore {

	private final Map<Long , Playlist> playlists  = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);
	
	public Playlist save (Playlist playlist) {
		
		playlist.setId(idGenerator.getAndIncrement());
		playlists.put(playlist.getId(), playlist);
		return playlist;
		
	}

	public List<Playlist>findAll(){
		return new ArrayList<>(playlists.values());
	}
	
	public boolean delete(Long id) {
		return playlists.remove(id) != null;
	}
	
	public Optional<Playlist>findById(Long id){
		return Optional.ofNullable(playlists.get(id));
	}
	
	public Optional<Playlist>update(Long id , Playlist updated){
		
		return findById(id).map(existing -> {
			
				existing.setName(updated.getName());
				existing.setSongTitles(updated.getSongTitles());
				return existing;
		});
		
	}
		
}
