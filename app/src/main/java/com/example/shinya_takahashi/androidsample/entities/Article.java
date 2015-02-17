package com.example.shinya_takahashi.androidsample.entities;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class Article implements Entity {

    private int mId;
    private String mTitle;
    private String mBody;

    public Article() {

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }
}
