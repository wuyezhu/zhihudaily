package com.uuflow.zhihudaily.model;

import java.util.Arrays;

/**
 * @author yelin.wu 16/2/17 上午11:39.
 * @description
 */
public class News {
    private String[] images;
    private String title;
    private int type;
    private long id;
    private String ga_prefix;

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "News{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", images=" + Arrays.toString(images) +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
