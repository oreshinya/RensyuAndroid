package com.example.shinya_takahashi.androidsample.models;

import com.example.shinya_takahashi.androidsample.entities.Article;
import com.example.shinya_takahashi.androidsample.models.core.Model;
import com.example.shinya_takahashi.androidsample.utils.Tekito;

import java.util.ArrayList;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class ArticleModel extends Model {
    public void fetchAll() {
        ArrayList<Article> articles = Tekito.createArticles();
        for (Article atcl : articles) {
            save(atcl);
        }
    }

    public void updateDummy(Article article) {
        article.setTitle("うほうほ");
        article.setBody("うんこうんこうんんこおおおおおおおおおおおおおおおおおおおおおおおおおお");
        save(article);
    }
}
