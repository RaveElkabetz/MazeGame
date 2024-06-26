package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.ExaminableSubject;
import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.intefaces.behaviorInterfaces.CanBeExaminedSubject;

public class Bowl extends ExaminableSubject implements CanBeExaminedSubject {
    private Bonzo bonzo;

    public Bowl(String description, Subject bonzo) {
        super("Bowl", description, bonzo);
    }
}
