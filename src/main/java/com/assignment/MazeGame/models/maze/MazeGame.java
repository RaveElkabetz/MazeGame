package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.GameInterface;
import com.assignment.MazeGame.models.*;
import com.assignment.MazeGame.models.subjects.Subject;
import com.assignment.MazeGame.utils.InputValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static com.assignment.MazeGame.models.Direction.*;


public class MazeGame implements GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    private final StringBuilder userInput = new StringBuilder();

    private final HashMap<String, MazeWalkerPlayer> players = new HashMap<>();

    private static InputValidation inputValidation;

    private MazeGameMap mazeGameMap = new MazeGameMap();


    @Override
    public void start() {
        try {
            boolean gameOn = true;
            mazeGameMap.initMap();
            String playerName = addNewPlayerToTheMaze();
            System.out.println(playerName + ", are now entered the mysterious maze, use your objects around you wisely to finish the maze.... ");
            mainGameLoop(playerName);

        } catch (EndingGameExecption e) {
            closeGame();
        }catch (Exception e) {
            System.out.println("An Error occured, exiting the game. please restart.");
            closeGame();
        }
        closeGame();
    }

    private String addNewPlayerToTheMaze() throws EndingGameExecption {
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Enter EXIT command in every stage to close the game.");
        String input = InputValidation.userDialogWithInput(
                "please enter your nick name:",
                "your nick name is: ",
                "Please enter non empty string",
                scanner);

        this.players.put(input, new MazeWalkerPlayer(input, (MazeRoom) mazeGameMap.getRoom("A")));
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
        System.out.println("At any step, press H for help, EXIT to exit, W to know where you are. M to move,");

        while (true) {
            System.out.println("Current location:");
            System.out.println(players.get(playerNickName).whereIAm());
            switch (scanner.nextLine()) {
                case "EXIT":
                    throw new EndingGameExecption();
                case "H":
                    System.out.println("press H for help, EXIT to exit, W to know where you are.");
                case "M":
                    System.out.println("in which of the following directions you want to enter?");
                    showPossibleDirections(playerNickName);
                    Direction direction = getDirectionFromPlayer();
                    if (direction!=null) players.get(playerNickName).move(direction);
                    break;
                case "E":
                    System.out.println("choose the the subject in this room you want to examine:");
                    players.get(playerNickName).getCurrentLocation().printAvailableSubjects();
                    String subjectToExamine = getSubjectToExamineFromPlayer(players.get(playerNickName).getCurrentLocation().getRoomSubjects());


                default:
                    System.out.println("No valid input! Enter `H` for help");


            }
            //TODO if i have an object that can be used its need to be got from the inventory but its need to be started
            //TODO progrematocally via the examined objects

        }

    }

    private String getSubjectToExamineFromPlayer(ArrayList<Subject> roomSubjects) throws EndingGameExecption {
        return InputValidation.userDialogWithInput(
                "Which subject you wish to examine?",
                 roomSubjects,
                "no such subject in this room.",
                scanner
        );
    }

    private void showPossibleSubjectsToExamine() {
    }

    private Direction getDirectionFromPlayer() throws EndingGameExecption {
        String direction = InputValidation.userDialogWithInput(
                "",
                new ArrayList<String>(Arrays.asList("NORTH","EAST","SOUTH","WEST")),
                "Please enter a valid direction: NORTH, EAST, SOUTH, WEST",
                scanner);
        switch (direction) {
            case "NORTH":
                return NORTH;
            case "EAST":
                return EAST;
            case "SOUTH":
                return SOUTH;
            case "WEST":
                return WEST;
            default:
        }
        return null;
    }

    private void showPossibleDirections(String playerNickName) {
        players.get(playerNickName).
                getCurrentLocation().
                getDoors().
                forEach(((direction, door) ->  System.out.println(direction)));
    }


}
