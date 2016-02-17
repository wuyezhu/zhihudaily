package com.uuflow.zhihudaily.model;

/**
 * @author yelin.wu 16/2/17 下午1:04.
 * @description
 */
public class TopNews {
    private String image;
    private int type;
    private long id;
    private String ga_prefix;
    private String title;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "TopNews{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", image='" + image + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
