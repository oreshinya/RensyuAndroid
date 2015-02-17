package com.example.shinya_takahashi.androidsample.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.shinya_takahashi.androidsample.R;
import com.example.shinya_takahashi.androidsample.adapters.ArticleAdapter;
import com.example.shinya_takahashi.androidsample.entities.Article;
import com.example.shinya_takahashi.androidsample.entities.Entity;
import com.example.shinya_takahashi.androidsample.models.ArticleModel;
import com.example.shinya_takahashi.androidsample.models.core.LocatorConst;
import com.example.shinya_takahashi.androidsample.models.core.ModelEvent;
import com.example.shinya_takahashi.androidsample.models.core.ModelMultiton;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;


public class TopActivity extends ActionBarActivity {

    @InjectView(R.id.article_list) ListView mListView;

    ArticleModel mArticleModel;
    ArticleAdapter mArticleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        ButterKnife.inject(this);

        mArticleAdapter = new ArticleAdapter(this);
        mListView.setAdapter(mArticleAdapter);

        mArticleModel = (ArticleModel) ModelMultiton.getModel(LocatorConst.Article);
        mArticleModel.registerReceiver(this);
        mArticleModel.fetchAll();

    }

    @Subscribe
    public void onEvent(ModelEvent event) {
        Entity entity = event.getEntity();
        if (entity.getClass() == Article.class) {
            Article article = (Article) entity;

            if (event.isInsert()) {
                mArticleAdapter.add(article);
            } else {
                int pos = mArticleAdapter.getPosition(article);
                View view = mListView.getChildAt(pos);
                mArticleAdapter.getView(pos, view, mListView);
            }
        }
    }

    @OnItemClick(R.id.article_list)
    public void updateArticle(int position) {
        Article article = (Article) mListView.getAdapter().getItem(position);
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra("id", article.getId());
        startActivity(intent);
        //mArticleModel.updateDummy(article);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
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

    @Override
    protected void onDestroy() {
        mArticleModel.removeReceiver(this);
        mArticleModel = null;
        super.onDestroy();
    }
}
