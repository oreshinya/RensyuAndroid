package com.example.shinya_takahashi.androidsample.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shinya_takahashi.androidsample.R;
import com.example.shinya_takahashi.androidsample.entities.Article;
import com.example.shinya_takahashi.androidsample.models.ArticleModel;
import com.example.shinya_takahashi.androidsample.models.core.LocatorConst;
import com.example.shinya_takahashi.androidsample.models.core.ModelMultiton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ArticleDetailActivity extends ActionBarActivity {

    private ArticleModel mArticleModel;
    private Article mArticle;

    @InjectView(R.id.id) TextView mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.inject(this);

        mArticleModel = (ArticleModel) ModelMultiton.getModel(LocatorConst.Article);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        if (id != -1) {
            mArticle = (Article) mArticleModel.find(id);
            mId.setText(String.valueOf(mArticle.getId()));
        } else {
            finish();
        }
    }

    @OnClick(R.id.id)
    public void onIdClick() {
        mArticleModel.updateDummy(mArticle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
