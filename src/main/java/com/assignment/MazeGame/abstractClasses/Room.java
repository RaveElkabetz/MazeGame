package com.assignment.MazeGame.abstractClasses;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.utils.InputOutputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Room /*implements com.assignment.MazeGame.intefaces.Room*/ {

   // private static int roomCount = 0;

    private final String description;

    private Map<Direction, Door> doors = new HashMap<Direction, Door>();

    private ArrayList<Subject> subjectsInTheRoom = new ArrayList<>();



    public Room(String description) {
        //this.roomCount++;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Map<Direction, Door> getDoors() {
        return doors;
    }

    public void setDoors(Map<Direction, Door> doors) {
        this.doors = doors;
    }


    public ArrayList<Subject> getRoomSubjects() {
        return this.subjectsInTheRoom;
    }

    public void setSubjectsInTheRoom(ArrayList<Subject> subjectsInTheRoom) {
        this.subjectsInTheRoom = subjectsInTheRoom;
    }

    public void printAvailableSubjects() throws NoSuchSubjectException {
        if (!subjectsInTheRoom.isEmpty()) {
            InputOutputUtils.printAvailableObjects(subjectsInTheRoom);
        } else {
            throw new NoSuchSubjectException("There isn't any subjects in this room!");
        }
    }

    @Override
    public String toString() {
        return description;
    }
}
