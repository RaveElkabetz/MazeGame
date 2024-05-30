package com.assignment.MazeGame.datastores;

import com.assignment.MazeGame.intefaces.datastoreInterfaces.MazeRoomDataStore;
import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.models.maze.MazeRoom;

import java.util.HashMap;
import java.util.Map;

public class HashMapMazeRoomDataStore implements MazeRoomDataStore {

    private final Map<String, MazeRoom> rooms = new HashMap<String, MazeRoom>();

    @Override
    public MazeRoom get(String key) {
        return rooms.get(key);
    }

    @Override
    public void put(String key, Room value) {
        rooms.put(key, (MazeRoom) value);
    }

}
