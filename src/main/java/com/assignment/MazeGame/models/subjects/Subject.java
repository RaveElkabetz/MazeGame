package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.SubjectInterface;

public class Subject implements SubjectInterface {
    private String name;
    private String description;
    private boolean openable = false;

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

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void examine() {

    }

}

