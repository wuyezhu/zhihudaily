package com.uuflow.zhihudaily.model;

import java.util.Arrays;

/**
 * @author yelin.wu 16/2/17 下午5:00.
 * @description
 */
public class NewsDetail {
    private String body;
    private String image_resource;
    private String title;
    private String image;
    private String share_url;
    private String[] js;
    private String ga_prefix;
    private int type;
    private long id;
    private String[] css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getCss() {
        return css;
    }

    public void setCss(String[] css) {
        this.css = css;
    }

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

    public String getImage_resource() {
        return image_resource;
    }

    public void setImage_resource(String image_resource) {
        this.image_resource = image_resource;
    }

    public String[] getJs() {
        return js;
    }

    public void setJs(String[] js) {
        this.js = js;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
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
        return "NewsDetail{" +
                "body='" + body + '\'' +
                ", image_resource='" + image_resource + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", share_url='" + share_url + '\'' +
                ", js=" + Arrays.toString(js) +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", css=" + Arrays.toString(css) +
                '}';
    }
}
