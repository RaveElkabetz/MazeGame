package com.assignment.MazeGame.models;

public class Subject {
    private String name;
    public String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
