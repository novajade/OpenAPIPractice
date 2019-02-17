package com.example.zzong.openapipractice;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class MovieData {

    @SerializedName("lastBuildDate")
    public String lastdate;

    @SerializedName("total")
    public Integer total;

    @SerializedName("start")
    public Integer start;

    @SerializedName("display")
    public Integer display;

    @SerializedName("items")
    public List<items> items;

    class items{
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

        public String getTitle(){
            return title;
        }

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

    public String getLastdate() {
        return lastdate;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getDisplay() {
        return display;
    }

    public List<MovieData.items> getItems() {
        return items;
    }

}
