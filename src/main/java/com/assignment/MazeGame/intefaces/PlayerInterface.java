package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Direction;
import com.assignment.MazeGame.models.Subject;

public interface PlayerInterface {
    public String examineSubject(Subject subject);
    public String move(Direction direction);
    public String openSubject(Subject subject);
    public String whereIAm();
}
