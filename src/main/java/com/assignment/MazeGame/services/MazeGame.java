package com.assignment.MazeGame.services;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.GameInterface;
import com.assignment.MazeGame.intefaces.PlayerInterface;
import com.assignment.MazeGame.models.Direction;
import com.assignment.MazeGame.models.Door;
import com.assignment.MazeGame.models.MazeWalkerPlayer;
import com.assignment.MazeGame.models.Room;
import com.assignment.MazeGame.utils.InputValidation;

import java.util.HashMap;
import java.util.Scanner;

import static com.assignment.MazeGame.models.Direction.*;


public class MazeGame implements GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    private final StringBuilder userInput = new StringBuilder();

    private final HashMap<String, MazeWalkerPlayer> players = new HashMap<>();

    private final HashMap<String, Room> mazeRooms = new HashMap<>();

    private static InputValidation inputValidation;


    @Override
    public void start() {
        try {
            boolean gameOn = true;
            initMazeMap();
            String playerName = addNewPlayerToTheMaze();
            System.out.println(playerName + ", are now entered the mysterious maze, use your objects around you wisely to finish the maze.... ");
            mainGameLoop(playerName);

        } catch (EndingGameExecption e) {
            closeGame();
        }


        closeGame();
    }

    private void initMazeMap() {
        //inserting the maze rooms to the hashmap
        this.mazeRooms.put("A", new Room("The starting room. it has a bed, and a locked door that points to East."));
        this.mazeRooms.put("B", new Room("This room has a door that points to the North."));
        this.mazeRooms.put("C", new Room("This room has 2 doors, one that points to the North, and the other to south, back to the starting room."));
        this.mazeRooms.put("D", new Room("This room has 3 doors, one that points to the North, the other to south and one to the east."));
        this.mazeRooms.put("E", new Room("This room has 2 doors, one that points to the North, and the other to west."));
        this.mazeRooms.put("F", new Room("This room has 2 doors, one that points to the South, and the other to West."));
        this.mazeRooms.put("G", new Room("This room has 4 doors, in all 4 directions. choose wisely..."));
        this.mazeRooms.put("H", new Room("This room has one door only, the one that you came from"));
        this.mazeRooms.put("I", new Room("Congratulations! you have successfully completed the MAZE."));

        //initializing the doors for all the rooms
        mazeRooms.get("A").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("B"), "Hair Pin"));
        }});

        mazeRooms.get("B").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("A"), "Hair Pin"));
        }});

        mazeRooms.get("C").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRooms.get("B"), ""));
            put(NORTH, new Door(mazeRooms.get("D"), ""));
        }});

        mazeRooms.get("D").setDoors(new HashMap<Direction, Door>() {{
            put(SOUTH, new Door(mazeRooms.get("C"), ""));
            put(NORTH, new Door(mazeRooms.get("G"), ""));
            put(EAST, new Door(mazeRooms.get("E"), ""));
        }});

        mazeRooms.get("E").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("D"), ""));
            put(NORTH, new Door(mazeRooms.get("F"), ""));
        }});

        mazeRooms.get("F").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("G"), ""));
            put(SOUTH, new Door(mazeRooms.get("E"), ""));
        }});

        mazeRooms.get("G").setDoors(new HashMap<Direction, Door>() {{
            put(WEST, new Door(mazeRooms.get("H"), ""));
            put(SOUTH, new Door(mazeRooms.get("D"), ""));
            put(NORTH, new Door(mazeRooms.get("I"), ""));
            put(EAST, new Door(mazeRooms.get("F"), ""));
        }});

        mazeRooms.get("H").setDoors(new HashMap<Direction, Door>() {{
            put(EAST, new Door(mazeRooms.get("G"), ""));
        }});


    }

    public void addRoom(String key, Room room) {
        this.mazeRooms.put(key, room);
    }

    public Room getRoom(String key) {
        return this.mazeRooms.get(key);
    }

    private String addNewPlayerToTheMaze() throws EndingGameExecption {
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Enter EXIT command in every stage to close the game.");
        String input = InputValidation.userDialogWithInput(
                "please enter your nick name:",
                "your nick name is: ",
                "Please enter non empty string",
                scanner);

        this.players.put(input, new MazeWalkerPlayer(input,mazeRooms.get("A")));
        return input;

    }


    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void closeGame() {
        System.out.println("Exiting the game, see you next time!");
        scanner.close();
    }

    @Override
    public void mainGameLoop(String playerNickName) throws EndingGameExecption {
        System.out.println("At any step, press H for help, EXIT to exit, W to know where you are.");

        while (true) {
            System.out.println(players.get(playerNickName).whereIAm());
            switch (scanner.nextLine()) {
                case "EXIT":
                    throw new EndingGameExecption();
                case "H":
                    System.out.println("press H for help, EXIT to exit, W to know where you are.");
                case "M":
                    System.out.println("in which of the following directions you want to enter?");
                    showPossibleDirections(playerNickName);
                    getDirectionFromPlayerAndMove();

            }
            //TODO finish this switch case !!!

        }

    }

    private void getDirectionFromPlayerAndMove() {
    }

    private void showPossibleDirections(String playerNickName) {
        players.get(playerNickName).
                getCurrentLocation().
                getDoors().
                forEach(((direction, door) ->  System.out.println(direction)));
    }


}
