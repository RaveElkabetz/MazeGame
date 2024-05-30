package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.Subject;

public class Bonzo extends Subject {
    public Bonzo(String description) {
        super("Bonzo", description);
    }

    @Override
    public void useOn(Subject subject) {
        if (subject instanceof Dog) {
            ((Dog) subject).isHungry();
            System.out.println("The dog ");
        } else {
            System.out.println("this subject cannot be used on other subject like that.");
        }
    }
}
