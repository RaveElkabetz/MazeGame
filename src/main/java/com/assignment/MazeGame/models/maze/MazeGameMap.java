package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.intefaces.GameMapInterface;
import com.assignment.MazeGame.intefaces.RoomInterface;
import com.assignment.MazeGame.models.NPC.Dog;
import com.assignment.MazeGame.models.NPC.Guard;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.subjects.*;

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
        this.mazeRooms.put("B", new MazeRoom("This room has only one door."));
        this.mazeRooms.put("C", new MazeRoom("This room has 2 doors."));
        this.mazeRooms.put("D", new MazeRoom("This room has 3 doors."));
        this.mazeRooms.put("E", new MazeRoom("This room has 2 doors."));
        this.mazeRooms.put("F", new MazeRoom("This room has 2 doors."));
        this.mazeRooms.put("G", new MazeRoom("This room has 4 doors, in all 4 directions. choose wisely..."));
        this.mazeRooms.put("H", new MazeRoom("This room has one door only."));
        this.mazeRooms.put("I", new MazeRoom("Congratulations! you have successfully completed the MAZE."));

        //initializing the doors for all the rooms
        mazeRooms.get("A").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("B")));
        }});

        mazeRooms.get("B").setDoors(new HashMap<Direction, Door>() {{
            put(NORTH, new Door(mazeRooms.get("C")));
            put(EAST, new Door(mazeRooms.get("A")));
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
                                "you found a pin! its been added to your inventory.",
                                new Pin("Long ,thin and very strong pin.")
                ),
                        new Bars("This bars must be unlocked in order to get out!",WEST))));

        mazeRooms.get("G").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Dog("There is a giant and scary dog! it looks like he is blocking the Northen door..." )

                        )));

        mazeRooms.get("F").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Bowl("This is a bowl. It looks like there is some Bonzo in it! ", new Bonzo("Wonder what we can do with this dog food?") )

                )));

        mazeRooms.get("F").setSubjectsInTheRoom(new ArrayList<Subject>(
                Arrays.asList(new Guard("The guard has found and caught you! you have lost the game ") )
                ));

//



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
