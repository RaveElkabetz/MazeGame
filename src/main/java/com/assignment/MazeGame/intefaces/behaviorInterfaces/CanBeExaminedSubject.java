package com.assignment.MazeGame.intefaces.behaviorInterfaces;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.abstractClasses.Subject;

public interface CanBeExaminedSubject {
    public Subject examine() throws NoSuchSubjectException;
}
