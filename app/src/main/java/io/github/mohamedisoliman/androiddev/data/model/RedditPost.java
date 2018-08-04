package io.github.mohamedisoliman.androiddev.data.model;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class RedditPost {

  private int id;
  private String stringId;
  private String title;
  private String author;
  private String url;
  private String thumbnail;
  private long ups;
  private Double created;

  public RedditPost(String stringId, String title, String author, String url, String thumbnail,
      long ups, Double created) {
    this.stringId = stringId;
    this.title = title;
    this.author = author;
    this.url = url;
    this.thumbnail = thumbnail;
    this.ups = ups;
    this.created = created;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getUrl() {
    return url;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public long getUps() {
    return ups;
  }

  public String getStringId() {
    return stringId;
  }

  public Double getCreated() {
    return created;
  }
}
