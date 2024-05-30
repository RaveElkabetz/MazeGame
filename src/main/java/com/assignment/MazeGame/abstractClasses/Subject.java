package com.assignment.MazeGame.abstractClasses;


import com.assignment.MazeGame.intefaces.behaviorInterfaces.UseOn;

public abstract class Subject implements UseOn {
    private final String name;
    private final String description;
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


    @Override
    public void useOn(Subject subject) {
        System.out.println("this subject cant be used on with like that.");;
    }
}

