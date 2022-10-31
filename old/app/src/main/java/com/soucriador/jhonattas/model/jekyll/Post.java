package com.soucriador.jhonattas.model.jekyll;

import java.util.Date;

public class Post {

    private String id;
    private String img;
    private String url;
    private String title;
    private String contentHtml;
    private Date datePublished;

    public Post(){
        setId("");
        setImg("");
        setUrl("");
        setTitle("");
        setContentHtml("");
        setDatePublished(new Date());
    }

    public Post(
            String id,
            String img,
            String url,
            String title,
            String contentHtml,
            Date datePublished
    ){
        setId(id);
        setImg(img);
        setUrl(url);
        setTitle(title);
        setContentHtml(contentHtml);
        setDatePublished(datePublished);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Date getDatePublished() {
        return datePublished;
    }
}
