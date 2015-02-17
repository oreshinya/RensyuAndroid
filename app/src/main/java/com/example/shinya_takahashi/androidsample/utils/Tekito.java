package com.example.shinya_takahashi.androidsample.utils;

import com.example.shinya_takahashi.androidsample.entities.Article;

import java.util.ArrayList;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class Tekito {
    public static ArrayList<Article> createArticles() {
        ArrayList<Article> list = new ArrayList<Article>();
        for (int i=0; i < 10; i++) {
            Article atcl = new Article();
            atcl.setId(i);
            atcl.setTitle("タイトルでござる");
            atcl.setBody("本文本文本文本文本文本文本文本文本文本文本文本文本文あああああああああああああああああああ");
            list.add(atcl);
        }
        return list;
    }
}
