package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.DoorInterface;

public class Door implements DoorInterface {
    private final String description;
    private final Room connectedRoom;
    private final String unlockKey;

    public Door(Room connectedRoom, String unlockKey) {
        this.description = "Exit to room: " + connectedRoom;
        this.connectedRoom = connectedRoom;
        this.unlockKey = unlockKey;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void unlock(String key) {

    }
}
