package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.Exceptions.DoorUnPassableException;
import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.abstractClasses.Subject;

public interface Player {
    public void examineSubject(Subject subject);
    public void move(Direction direction) throws DoorUnPassableException, EndingGameExecption;
    public void openSubject(Subject subject);
    public String whereIAm();
    public void addSubjectToInventory(Subject subject);
}
