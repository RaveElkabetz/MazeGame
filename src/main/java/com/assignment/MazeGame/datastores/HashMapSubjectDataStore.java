package com.assignment.MazeGame.datastores;

import com.assignment.MazeGame.intefaces.SubjectDataStore;
import com.assignment.MazeGame.abstractClasses.Subject;

import java.util.HashMap;
import java.util.Map;

public class HashMapSubjectDataStore implements SubjectDataStore {

    private final Map<String, Subject> subjects = new HashMap<>();

    @Override
    public Subject get(String key) {
        return subjects.get(key);
    }

    @Override
    public void put(String key, Subject value) {
        subjects.put(key, value);
    }
}
