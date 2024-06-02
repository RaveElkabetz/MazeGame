package com.assignment.MazeGame.abstractClasses;

import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Room  {


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


    public void setSubjectsInTheRoom(ArrayList<Subject> subjectsInTheRoom) {
        this.subjectsInTheRoom = subjectsInTheRoom;
    }

    public ArrayList<Subject> getRoomSubjectsAvilableForUsage() throws NoSuchSubjectException {
        if (!subjectsInTheRoom.isEmpty()) {
            return subjectsInTheRoom;
        } else {
            throw new NoSuchSubjectException("There isn't any subjects in this room!");
        }
       // return subjectsInTheRoom;
        }

    public ArrayList<Subject> getRoomSubjects()  {
        return subjectsInTheRoom;}



    @Override
    public String toString() {
        return description;
    }
}
