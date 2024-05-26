package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface RoomInterface {
    public void addDoor(Door door);
    public List<Subject> getRoomSubjects();
}
