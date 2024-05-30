package com.assignment.MazeGame.datastores;

import com.assignment.MazeGame.intefaces.datastoreInterfaces.MazePlayerDataStore;
import com.assignment.MazeGame.intefaces.Player;
import com.assignment.MazeGame.models.maze.MazePlayer;

import java.util.HashMap;
import java.util.Map;

public class HashMapMazePlayerDataStore implements MazePlayerDataStore {

    private final Map<String, MazePlayer> players = new HashMap<>();

    @Override
    public Player get(String key) {
        return players.get(key);
    }

    @Override
    public void put(String key, Player value) {
        this.players.put(key, (MazePlayer) value);
    }
}
