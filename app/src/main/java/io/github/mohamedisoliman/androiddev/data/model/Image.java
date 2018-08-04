package io.github.mohamedisoliman.androiddev.data.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class Image {

  @Expose
  private String id;
  @Expose
  private List<Resolution> resolutions;
  @Expose
  private Source source;
  @Expose
  private Variants variants;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Resolution> getResolutions() {
    return resolutions;
  }

  public void setResolutions(List<Resolution> resolutions) {
    this.resolutions = resolutions;
  }

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public Variants getVariants() {
    return variants;
  }

  public void setVariants(Variants variants) {
    this.variants = variants;
  }
}
