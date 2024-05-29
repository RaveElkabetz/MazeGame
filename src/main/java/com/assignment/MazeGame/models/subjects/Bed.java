package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.CanBeExaminedSubjectInteface;


public class Bed extends ExaminableSubject implements CanBeExaminedSubjectInteface {

    public Bed( String description,Subject subject) {
        super("Bed", description,subject);
    }


}
