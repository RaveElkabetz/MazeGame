package com.assignment.MazeGame.models.subjects;


import com.assignment.MazeGame.abstractClasses.Subject;

public class Pin extends Subject {
    public Pin(String description) {
        super("Pin", description);
    }

    @Override
    public void useOn(Subject subject) {
        if (subject instanceof Bars) {
            ((Bars) subject).setBlockage(false);
            System.out.println("The locked bars are now open! you can proceed to the next room.");
        } else {
            System.out.println("this subject cannot be used on other subject like that.");
        }
    }

}
