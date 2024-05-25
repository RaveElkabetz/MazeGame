package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.RoomInterface;

import java.util.HashMap;
import java.util.Map;

public class Room implements RoomInterface {
    private static int roomCount = 0;
    private final String description;
    private Map<Direction, Door> doors = new HashMap<Direction, Door>();

    public Room(String description) {
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

    @Override
    public void addDoor(Door door) {

    }
}
