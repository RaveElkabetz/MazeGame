package com.assignment.MazeGame.models;

import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.models.subjects.Bars;

public class Door implements com.assignment.MazeGame.intefaces.Door {
    private final String description;
    private final Room connectedRoom;
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
