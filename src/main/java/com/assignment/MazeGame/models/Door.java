package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.DoorInterface;
import com.assignment.MazeGame.models.subjects.Bars;
import com.assignment.MazeGame.models.subjects.Subject;

public class Door implements DoorInterface {
    private final String description;
    private final Room connectedRoom;
    private final String unlockKey = "";
    private boolean open = true;
    private Bars bars;


    public Door(Room connectedRoom) {
        this.description = "Exit to room: " + connectedRoom;
        this.connectedRoom = connectedRoom;
    }

    public Door(Room connectedRoom, Bars bars) {
        this.description = "Exit to room: " + connectedRoom;
        this.connectedRoom = connectedRoom;
        this.open = false;
        this.bars = bars;
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

    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bars) {
        this.bars = bars;
    }

    @Override
    public String toString() {
        return description;
    }
}
