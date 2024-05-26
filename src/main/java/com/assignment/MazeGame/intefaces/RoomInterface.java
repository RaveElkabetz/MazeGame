package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.subjects.Subject;

import java.util.List;

public interface RoomInterface {
    public void addDoor(Door door);
    public List<Subject> getRoomSubjects();
}
