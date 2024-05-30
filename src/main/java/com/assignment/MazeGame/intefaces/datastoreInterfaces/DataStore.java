package com.assignment.MazeGame.intefaces.datastoreInterfaces;

public interface DataStore<T> {
    T get(String key);
    void put(String key, T value);
}
