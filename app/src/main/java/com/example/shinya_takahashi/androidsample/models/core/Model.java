package com.example.shinya_takahashi.androidsample.models.core;

import com.example.shinya_takahashi.androidsample.entities.Entity;
import com.squareup.otto.Bus;

import java.util.ArrayList;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public abstract class Model {
    private MemoryStore mStore;
    private Bus mBus;

    public Model() {
        initBus();
        initStore();
    }

    private void initBus() {
        mBus = new Bus();
    }

    public void initStore() {
        mStore = new MemoryStore();
    }

    public void registerReceiver(Object obj) {
        mBus.register(obj);
    }

    public void removeReceiver(Object obj) {
        mBus.unregister(obj);
    }

    public void notifyReceiver(ModelEvent event) {
        mBus.post(event);
    }

    public Entity find(int id) {
        return mStore.get(id);
    }

    public ArrayList<Entity> getAll() {
        return mStore.getAll();
    }

    public void save(Entity entity) {

        ModelEventConst eventType;
        int id = entity.getId();

        if (mStore.get(id) == null) {
            eventType = ModelEventConst.insertType;
        } else {
            eventType = ModelEventConst.updateType;
        }

        mStore.set(id, entity);

        ModelEvent event = new ModelEvent(eventType, entity);
        notifyReceiver(event);
    }
}
