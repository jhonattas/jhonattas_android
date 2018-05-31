package com.soucriador.jhonattas.model.jekyll;

public class Author {

    private String name;
    private String url;
    private String avatar;

    public Author(){
        setName("");
        setUrl("");
        setAvatar("");
    }

    public Author(
            String name,
            String url,
            String avatar
    ){
        setName(name);
        setUrl(url);
        setAvatar(avatar);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }
}
