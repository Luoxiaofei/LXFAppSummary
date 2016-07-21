package com.appsummary.luoxf.myappsummary.model;

import java.io.Serializable;

/**
 * Created by luoxf on 16-5-24.
 */
public class AnimationMainListItemModel implements Serializable {
    private String title;
    private String summary;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
