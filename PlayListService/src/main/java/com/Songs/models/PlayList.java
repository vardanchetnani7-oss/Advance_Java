package com.Songs.models;


public class PlayList {

    private Long id;
    private String name;
    private String creator;

    public PlayList() {
    }

    public PlayList(Long id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}