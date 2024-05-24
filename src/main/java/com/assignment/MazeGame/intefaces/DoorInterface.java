package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Room;

public interface DoorInterface {
    boolean isOpen();
    void unlock(String key);
}
