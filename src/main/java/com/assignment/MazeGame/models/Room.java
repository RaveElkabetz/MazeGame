package com.assignment.MazeGame.models;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private static int roomCount = 0;
    private final String description;
    private Map<Direction, Door> doors = new HashMap<Direction, Door>();

    public Room(String description) {
        this.description = description;
    }
}
