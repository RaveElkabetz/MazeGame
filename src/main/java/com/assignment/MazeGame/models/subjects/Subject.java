package com.assignment.MazeGame.models.subjects;


public class Subject {
    private String name;
    private String description;
    private boolean openable = false;
    private boolean examined = false;

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

    public boolean isExamined() {
        return examined;
    }


}

