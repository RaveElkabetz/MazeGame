package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.DoorInterface;

public class Door implements DoorInterface {

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void unlock(String key) {

    }
}
