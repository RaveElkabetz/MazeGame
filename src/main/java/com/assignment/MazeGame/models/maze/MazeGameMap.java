package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.intefaces.GameMap;
import com.assignment.MazeGame.intefaces.datastoreInterfaces.MazeRoomDataStore;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.subjects.*;
import com.assignment.MazeGame.providers.SystemOutputProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.assignment.MazeGame.models.enums.Direction.*;
import static com.assignment.MazeGame.utils.Constant.*;

public class MazeGameMap implements GameMap {


    private final MazeRoomDataStore mazeRoomDataStore;

    public MazeGameMap(MazeRoomDataStore mazeRoomDataStore) {
        this.mazeRoomDataStore = mazeRoomDataStore;
    }

    @Override
    public void initMap() {
        //inserting the maze rooms to the hashmap
        this.mazeRoomDataStore.put("A", new MazeRoom(STARTING_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("B", new MazeRoom(B_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("C", new MazeRoom(C_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("D", new MazeRoom(D_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("E", new MazeRoom(E_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("F", new MazeRoom(F_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("G", new MazeRoom(G_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("H", new MazeRoom(H_ROOM_DESCRIPTION));
        this.mazeRoomDataStore.put("I", new MazeRoom(LAST_ROOM_DESCRIPTION));

        //initializing the doors for all the rooms
        mazeRoomDataStore.get("A").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRoomDataStore.get("B")));
        }});

        mazeRoomDataStore.get("B").setDoors(new HashMap<Direction, Door>() {{
            put(NORTH, new Door(mazeRoomDataStore.get("C")));
            put(EAST, new Door(mazeRoomDataStore.get("A")));
        }});

        mazeRoomDataStore.get("C").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRoomDataStore.get("B")));
            put(NORTH, new Door(mazeRoomDataStore.get("D")));
        }});

        mazeRoomDataStore.get("D").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRoomDataStore.get("C")));
            put(NORTH, new Door(mazeRoomDataStore.get("G")));
            put(EAST, new Door(mazeRoomDataStore.get("E")));
        }});

        mazeRoomDataStore.get("E").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRoomDataStore.get("D")));
            put(NORTH, new Door(mazeRoomDataStore.get("F")));
        }});

        mazeRoomDataStore.get("F").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRoomDataStore.get("G")));
            put(SOUTH, new Door(mazeRoomDataStore.get("E")));
        }});

        mazeRoomDataStore.get("G").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRoomDataStore.get("H")));
            put(SOUTH, new Door(mazeRoomDataStore.get("D")));
            put(NORTH, new Door(mazeRoomDataStore.get("I")));
            put(EAST, new Door(mazeRoomDataStore.get("F")));
        }});

        mazeRoomDataStore.get("H").setDoors(new HashMap<Direction, Door>() {{
            put(EAST, new Door(mazeRoomDataStore.get("G")));
        }});

        mazeRoomDataStore.get("A").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Bed(BED_DESCRIPTION, new Pin(PIN_DESCRIPTION)),
                        new Bars(BARS_DESCRIPTION, WEST))));

        mazeRoomDataStore.get("G").setSubjectsInTheRoom(new ArrayList<Subject>(
                List.of(new Dog(DOG_DESCRIPTION, NORTH))));

        mazeRoomDataStore.get("F").setSubjectsInTheRoom(new ArrayList<Subject>(
                List.of(new Bowl(BOWL_DESCRIPTION, new Bonzo(BONZO_DESCRIPTION, new SystemOutputProvider()))

                )));

        mazeRoomDataStore.get("H").setSubjectsInTheRoom(new ArrayList<Subject>(
                List.of(new Guard(GUARD_DESCRIPTION))
        ));

    }

    @Override
    public Room getRoom(String key) {
        return this.mazeRoomDataStore.get(key);
    }
}
