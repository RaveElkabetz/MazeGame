package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.ExaminableSubject;
import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.intefaces.behaviorInterfaces.CanBeExaminedSubject;


public class Bed extends ExaminableSubject implements CanBeExaminedSubject {

    public Bed(String description, Subject subject) {
        super("Bed", description, subject);
    }
}
