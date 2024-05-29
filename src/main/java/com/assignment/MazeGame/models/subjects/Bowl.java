package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.CanBeExaminedSubjectInteface;

public class Bowl extends ExaminableSubject implements CanBeExaminedSubjectInteface {
    private Bonzo bonzo;

    public Bowl(String description,Subject bonzo) {
        super("Bowl", description,bonzo);
    }


}
