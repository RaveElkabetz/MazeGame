package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;

public class ExaminableSubject extends Subject {

    private final Subject containedSubject;

    private boolean stillContains = true;

    public ExaminableSubject(String name, String description, Subject containedSubject) {
        super(name, description);
        this.containedSubject = containedSubject;
    }

    public Subject examine() throws NoSuchSubjectException {
        if (stillContains) {
            System.out.println(super.getDescription());
            stillContains = false;
            return containedSubject;
        } else {
            throw new NoSuchSubjectException("there is nothing here in the "+super.getName());
        }
    }
}
