package com.example.shinya_takahashi.androidsample.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shinya_takahashi.androidsample.R;
import com.example.shinya_takahashi.androidsample.entities.Article;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {
    private LayoutInflater mInflater;

    public ArticleAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.list_article, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        Article article = getItem(position);
        holder.title.setText(article.getTitle());
        holder.body.setText(article.getBody());
        return view;
    }

    static class ViewHolder {
        @InjectView(R.id.title) TextView title;
        @InjectView(R.id.body) TextView body;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }

    }
}
