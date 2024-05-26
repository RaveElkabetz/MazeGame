package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.DoorInterface;

public class Door implements DoorInterface {
    private final String description;
    private final Room connectedRoom;
    private final String unlockKey = "";
    private boolean open = true;

    public Door(Room connectedRoom) {
        this.description = "Exit to room: " + connectedRoom;
        this.connectedRoom = connectedRoom;
    }

    public Door(Room connectedRoom, boolean open, String unlockKey) {
        this.description = "Exit to room: " + connectedRoom;
        this.connectedRoom = connectedRoom;
        this.open = open;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void unlock(String key) {

    }

    public Room getConnectedRoom() {
        return connectedRoom;
    }
}
