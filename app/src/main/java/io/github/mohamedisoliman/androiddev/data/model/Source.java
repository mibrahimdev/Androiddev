
package io.github.mohamedisoliman.androiddev.data.model;

import com.google.gson.annotations.Expose;


public class Source {

    @Expose
    private Long height;
    @Expose
    private String url;
    @Expose
    private Long width;

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

}
