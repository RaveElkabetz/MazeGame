package com.assignment.MazeGame.services;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.GameInterface;
import com.assignment.MazeGame.models.MazeWalkerPlayer;
import com.assignment.MazeGame.models.Room;
import com.assignment.MazeGame.utils.InputValidation;

import java.util.HashMap;
import java.util.Scanner;


public class MazeGame implements GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    private StringBuilder userInput = new StringBuilder();

    private HashMap<String, MazeWalkerPlayer> players = new HashMap<>();

    private HashMap<String, Room> mazeRooms = new HashMap<>();

    private static InputValidation inputValidation;



    @Override
    public void start() {
        try {
            boolean gameOn = true;
            initMazeMap();
            String playerName = addNewPlayerToTheMaze();
            System.out.println(playerName +", are now entered the mysterious maze, use your objects around you wisely to finish the maze.... ");

            while (gameOn) {





                gameOn = false;
            }
        } catch (EndingGameExecption e) {
            closeGame();
        }


        closeGame();
    }

    private void initMazeMap() {


    }

    public void addRoom(String key,Room room) {
        this.mazeRooms.put(key, room);
    }

    public Room getRoom(String key) {
        return this.mazeRooms.get(key);
    }

    private String addNewPlayerToTheMaze() throws EndingGameExecption {
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Enter EXIT command in every stage to close the game.");
       String input = inputValidation.userDialogWithInput(
               "please enter your nick name:",
               "your nick name is: ",
               "Please enter non empty string",
               scanner) ;

            this.players.put(input,new MazeWalkerPlayer(input));
            return input;

    }


    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }


    public void closeGame() {
        System.out.println("Exiting the game, see you next time!");
        scanner.close();
    }



}
