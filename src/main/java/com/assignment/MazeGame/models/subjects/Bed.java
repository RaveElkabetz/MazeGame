package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.intefaces.CanBeExaminedSubjectInteface;


public class Bed extends Subject implements CanBeExaminedSubjectInteface {

    private final Subject containedSubject;

    private boolean stillContains = true;

    public Bed( String description) {
        super("Bed", description);
        this.containedSubject = new Pin("Long ,thin and very strong pin.");
    }

    @Override
    public Subject examine() throws NoSuchSubjectException {
        if (stillContains) {
            System.out.println(super.getDescription());
            stillContains = false;
            return containedSubject;
        } else {
            System.out.println("This an old and stinky bed...");
            throw new NoSuchSubjectException("there is nothing under the bed");
        }
    }
}
