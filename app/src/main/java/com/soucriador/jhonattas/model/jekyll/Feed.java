package com.soucriador.jhonattas.model.jekyll;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("version")
    private String version;
    @SerializedName("title")
    private String title;
    @SerializedName("home_page_url")
    private String homePageUrl;
    @SerializedName("feed_url")
    private String feedUrl;
    @SerializedName("description")
    private String description;
    @SerializedName("author")
    private Author author;
    @SerializedName("items")
    private List<Post> items;

    public Feed() {
        setVersion("");
        setTitle("");
        setHomePageUrl("");
        setFeedUrl("");
        setDescription("");
        setAuthor(new Author());
        setItems(null);
    }

    public Feed(
            String version,
            String title,
            String homePageUrl,
            String feedUrl,
            String description,
            Author author,
            List<Post> items
    ){
        setVersion(version);
        setTitle(title);
        setHomePageUrl(homePageUrl);
        setFeedUrl(feedUrl);
        setDescription(description);
        setAuthor(author);
        setItems(items);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getItems() {
        return items;
    }

    public void setItems(List<Post> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "version='" + version + '\'' +
                ", title='" + title + '\'' +
                ", homePageUrl='" + homePageUrl + '\'' +
                ", feedUrl='" + feedUrl + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", items=" + items +
                '}';
    }
}
