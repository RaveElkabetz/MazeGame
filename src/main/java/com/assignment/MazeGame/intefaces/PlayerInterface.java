package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.subjects.Subject;

public interface PlayerInterface {
    public void examineSubject(Subject subject);
    public void move(Direction direction);
    public void openSubject(Subject subject);
    public String whereIAm();
    public void addSubjectToInventory(Subject subject);
}
