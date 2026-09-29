package com.Playlist.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	
	    private Long id;
	    private String name;
	    private List<String> songTitles = new ArrayList<>();

	    public Playlist() {
	    }

	    public Playlist(Long id, String name, List<String> songTitles) {
	        this.id = id;
	        this.name = name;
	        this.songTitles = songTitles;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public List<String> getSongTitles() { return songTitles; }
	    public void setSongTitles(List<String> songTitles) { this.songTitles = songTitles; }
	

}
