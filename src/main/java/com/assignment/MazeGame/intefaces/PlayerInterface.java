package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Direction;
import com.assignment.MazeGame.models.Subject;

public interface PlayerInterface {
    public void examineSubject(Subject subject);
    public void move(Direction direction);
    public void openSubject(Subject subject);
    public void whereIAm();
}
