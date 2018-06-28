package com.szalaynb.NudgeYourMind.model;

public class Link {

    private long id;
    private String name;
    private String url;

    public Link() {
    }

    public Link(String name, String url) {

        this.name = name;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
