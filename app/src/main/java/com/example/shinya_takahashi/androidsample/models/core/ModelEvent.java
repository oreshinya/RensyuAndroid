package com.example.shinya_takahashi.androidsample.models.core;

import com.example.shinya_takahashi.androidsample.entities.Entity;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class ModelEvent {
    private Entity mEntity;
    private ModelEventConst mType;

    public ModelEvent(ModelEventConst type, Entity entity) {
        mEntity = entity;
        mType = type;
    }

    public boolean isInsert() {
        return mType == ModelEventConst.insertType;
    }

    public boolean isUpdate() {
        return mType == ModelEventConst.updateType;
    }

    public Entity getEntity() {
        return mEntity;
    }

}
