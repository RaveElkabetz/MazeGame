package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.models.subjects.Subject;

public interface CanBeExaminedSubjectInteface {
    public Subject examine() throws NoSuchSubjectException;
}
