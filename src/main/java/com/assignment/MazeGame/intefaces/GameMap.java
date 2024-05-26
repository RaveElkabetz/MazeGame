package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.models.Room;

public interface GameMap {
    public void initMap();
    public void addRoom(String key, RoomInterface room);
    public RoomInterface getRoom(String key);
}
