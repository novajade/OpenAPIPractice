package com.example.zzong.openapipractice;

import com.google.gson.annotations.SerializedName;

public class items {

    @SerializedName("title")
    public String title;

    @SerializedName("pubDate")
    public String pubdate;

    @SerializedName("director")
    public String director;

    @SerializedName("actor")
    public String actor;

    @SerializedName("userRating")
    public Double userrating;

    public String getTitle(){ return title; }

    public String getPubdate() {
        return pubdate;
    }

    public String getDirector(){
        return director;
    }

    public String getActor() {
        return actor;
    }

    public Double getUserrating() {
        return userrating;
    }

}
