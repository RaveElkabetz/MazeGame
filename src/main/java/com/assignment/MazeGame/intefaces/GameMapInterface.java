package com.assignment.MazeGame.intefaces;

public interface GameMapInterface {
    public void initMap();
    public void addRoom(String key, RoomInterface room);
    public RoomInterface getRoom(String key);
}
