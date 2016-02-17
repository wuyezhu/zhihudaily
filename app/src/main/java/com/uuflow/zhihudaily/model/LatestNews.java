package com.uuflow.zhihudaily.model;

import java.util.List;

/**
 * @author yelin.wu 16/2/17 下午1:03.
 * @description
 */
public class LatestNews {
    private String date;
    private List<News> stories;
    private List<TopNews> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<News> getStories() {
        return stories;
    }

    public void setStories(List<News> stories) {
        this.stories = stories;
    }

    public List<TopNews> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopNews> top_stories) {
        this.top_stories = top_stories;
    }

    @Override
    public String toString() {
        return "LatestNews{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
