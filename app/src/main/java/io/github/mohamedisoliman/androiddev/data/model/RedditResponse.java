package io.github.mohamedisoliman.androiddev.data.model;

import com.google.gson.annotations.Expose;

public class RedditResponse {

  @Expose
  private Data data;
  @Expose
  private String kind;

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }
}
