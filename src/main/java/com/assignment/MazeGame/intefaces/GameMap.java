package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.abstractClasses.Room;

public interface GameMap {
    public void initMap();
     Room getRoom(String key);
}
