package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.intefaces.GameMapInterface;
import com.assignment.MazeGame.intefaces.RoomInterface;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.subjects.Bars;
import com.assignment.MazeGame.models.subjects.Bed;
import com.assignment.MazeGame.models.subjects.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.assignment.MazeGame.models.enums.Direction.*;

public class MazeGameMap implements GameMapInterface {

    private final HashMap<String, MazeRoom> mazeRooms = new HashMap<>();

    @Override
    public void initMap() {
        //inserting the maze rooms to the hashmap
        this.mazeRooms.put("A", new MazeRoom("You are in the starting room."));
        this.mazeRooms.put("B", new MazeRoom("This room has a door that points to the North."));
        this.mazeRooms.put("C", new MazeRoom("This room has 2 doors, one that points to the North, and the other to south, back to the starting room."));
        this.mazeRooms.put("D", new MazeRoom("This room has 3 doors, one that points to the North, the other to south and one to the east."));
        this.mazeRooms.put("E", new MazeRoom("This room has 2 doors, one that points to the North, and the other to west."));
        this.mazeRooms.put("F", new MazeRoom("This room has 2 doors, one that points to the South, and the other to West."));
        this.mazeRooms.put("G", new MazeRoom("This room has 4 doors, in all 4 directions. choose wisely..."));
        this.mazeRooms.put("H", new MazeRoom("This room has one door only, the one that you came from"));
        this.mazeRooms.put("I", new MazeRoom("Congratulations! you have successfully completed the MAZE."));

        //initializing the doors for all the rooms
        mazeRooms.get("A").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("B")));
        }});

        mazeRooms.get("B").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("A")));
        }});

        mazeRooms.get("C").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRooms.get("B")));
            put(NORTH, new Door(mazeRooms.get("D")));
        }});

        mazeRooms.get("D").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRooms.get("C")));
            put(NORTH, new Door(mazeRooms.get("G")));
            put(EAST, new Door(mazeRooms.get("E")));
        }});

        mazeRooms.get("E").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("D")));
            put(NORTH, new Door(mazeRooms.get("F")));
        }});

        mazeRooms.get("F").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("G")));
            put(SOUTH, new Door(mazeRooms.get("E")));
        }});

        mazeRooms.get("G").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("H")));
            put(SOUTH, new Door(mazeRooms.get("D")));
            put(NORTH, new Door(mazeRooms.get("I")));
            put(EAST, new Door(mazeRooms.get("F")));
        }});

        mazeRooms.get("H").setDoors(new HashMap<Direction, Door>() {{
            put(EAST, new Door(mazeRooms.get("G")));
        }});

        mazeRooms.get("A").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Bed(
                        "This is just an old and stinky bed...wait! there is something under the bed!\n" +
                                "you found a pin! its been added to your inventory."
                ),
                        new Bars("This bars must be unlocked in order to get out!"))));




    }

    @Override
    public void addRoom(String key, RoomInterface room) {
        this.mazeRooms.put(key, (MazeRoom) room);
    }

    @Override
    public RoomInterface getRoom(String key) {
        return this.mazeRooms.get(key);
    }
}
