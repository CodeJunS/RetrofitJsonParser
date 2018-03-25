package com.junseo.comulnews;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by junse on 2018-03-26.
 */

public class RetrofitRepo {

    ArrayList<Item> items;
    private String title;
    private String description;
    private String link;
    private String imgUrl;
    private String author;
    private String pubDate;

    public ArrayList<Item> getItems() {
        return (ArrayList<Item>) items;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getLink() {
        return link;
    }


    public String getImgUrl() {
        return imgUrl;
    }


    public String getAuthor() {
        return author;
    }


    public String getPubDate() {
        return pubDate;
    }
}