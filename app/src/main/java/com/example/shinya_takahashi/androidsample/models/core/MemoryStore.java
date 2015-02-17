package com.example.shinya_takahashi.androidsample.models.core;

import com.example.shinya_takahashi.androidsample.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shinya_takahashi on 2014/12/26.
 */
public class MemoryStore {
    private HashMap<Integer, Entity> mStore;

    public MemoryStore() {
        mStore = new HashMap<Integer, Entity>();
    }

    public void set(int id, Entity obj) {
        mStore.put(id, obj);
    }

    public Entity get(int id) {
        return mStore.get(id);
    }

    public ArrayList<Entity> getAll() {
        ArrayList<Entity> list = new ArrayList<Entity>();
        for (Map.Entry<Integer, Entity> entry : mStore.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
