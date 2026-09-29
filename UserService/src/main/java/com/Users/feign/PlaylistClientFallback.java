package com.Users.feign;

import org.springframework.stereotype.Component;

import com.Users.models.dtos.PlaylistDto;

@Component
public class PlaylistClientFallback implements Feignclient{

	@Override
	public PlaylistDto getPlaylist(Long id) {
		// TODO Auto-generated method stub
		PlaylistDto playlist = new PlaylistDto();
		    playlist.setId(id);
	        playlist.setName("Default Playlist");
	        playlist.setCreator("System");

	        return playlist;
	}

}
