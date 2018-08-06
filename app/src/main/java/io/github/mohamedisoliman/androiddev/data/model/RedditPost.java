package io.github.mohamedisoliman.androiddev.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class RedditPost implements Parcelable {

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

  public String getCreatedDate() {
    Date date = new Date(created.longValue());
    String format = "dd/MM, hh:mm a";
    DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
    return dateFormat.format(date);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.stringId);
    dest.writeString(this.title);
    dest.writeString(this.author);
    dest.writeString(this.url);
    dest.writeString(this.thumbnail);
    dest.writeLong(this.ups);
    dest.writeValue(this.created);
  }

  protected RedditPost(Parcel in) {
    this.id = in.readInt();
    this.stringId = in.readString();
    this.title = in.readString();
    this.author = in.readString();
    this.url = in.readString();
    this.thumbnail = in.readString();
    this.ups = in.readLong();
    this.created = (Double) in.readValue(Double.class.getClassLoader());
  }

  public static final Creator<RedditPost> CREATOR = new Creator<RedditPost>() {
    @Override
    public RedditPost createFromParcel(Parcel source) {
      return new RedditPost(source);
    }

    @Override
    public RedditPost[] newArray(int size) {
      return new RedditPost[size];
    }
  };
}
