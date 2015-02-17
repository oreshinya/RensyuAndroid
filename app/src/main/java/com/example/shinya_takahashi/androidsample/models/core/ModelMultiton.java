package com.example.shinya_takahashi.androidsample.models.core;

import com.example.shinya_takahashi.androidsample.models.ArticleModel;

import java.util.HashMap;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class ModelMultiton {
    private static ModelMultiton ourInstance = new ModelMultiton();

    private HashMap<LocatorConst, Model> mModels = new HashMap<LocatorConst, Model>();

    private static ModelMultiton getInstance() {
        return ourInstance;
    }

    private ModelMultiton() {
        // initialize models
        mModels.put(LocatorConst.Article, new ArticleModel());
    }

    public static Model getModel(LocatorConst key) {
        return getInstance().mModels.get(key);
    }
}
