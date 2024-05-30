package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.intefaces.GameMap;
import com.assignment.MazeGame.intefaces.datastoreInterfaces.MazeRoomDataStore;
import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.models.subjects.Dog;
import com.assignment.MazeGame.models.subjects.Guard;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.subjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.assignment.MazeGame.models.enums.Direction.*;

public class MazeGameMap implements GameMap {

    //private  Map<String, MazeRoom> mazeRooms ;
    
    private final MazeRoomDataStore mazeRoomDataStore;

    public MazeGameMap(/*Map<String, MazeRoom> mazeRooms*/MazeRoomDataStore mazeRoomDataStore) {
        //this.mazeRooms = mazeRooms;
        this.mazeRoomDataStore = mazeRoomDataStore;
    }

    @Override
    public void initMap() {
        //inserting the maze rooms to the hashmap
        this.mazeRoomDataStore.put("A", new MazeRoom("You are in the starting room."));
        this.mazeRoomDataStore.put("B", new MazeRoom("This room has only one door."));
        this.mazeRoomDataStore.put("C", new MazeRoom("This room has 2 doors."));
        this.mazeRoomDataStore.put("D", new MazeRoom("This room has 3 doors."));
        this.mazeRoomDataStore.put("E", new MazeRoom("This room has 2 doors."));
        this.mazeRoomDataStore.put("F", new MazeRoom("This room has 2 doors."));
        this.mazeRoomDataStore.put("G", new MazeRoom("This room has 4 doors, in all 4 directions. choose wisely..."));
        this.mazeRoomDataStore.put("H", new MazeRoom("This room has one door only."));
        this.mazeRoomDataStore.put("I", new MazeRoom("Congratulations! you have successfully completed the MAZE."));

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
                Arrays.asList(new Bed(
                        "This is just an old and stinky bed...wait! there is something under the bed!\n" +
                                "you found a pin! its been added to your inventory.",
                                new Pin("Long ,thin and very strong pin.")
                ),
                        new Bars("This bars must be unlocked in order to get out!",WEST))));

        mazeRoomDataStore.get("G").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Dog("There is a giant and scary dog! it looks like he is blocking the Northen door..." ,NORTH)

                        )));

        mazeRoomDataStore.get("F").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Bowl("This is a bowl. It looks like there is some Bonzo in it! ", new Bonzo("Wonder what we can do with this dog food?") )

                )));

        mazeRoomDataStore.get("F").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Guard("The guard has found and caught you! you have lost the game ") )
                ));

    }

    @Override
    public Room getRoom(String key) {
        return this.mazeRoomDataStore.get(key);
    }
}
