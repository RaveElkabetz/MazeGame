package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.Exceptions.NoSuchDirectionException;
import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.intefaces.CanBeExaminedSubjectInteface;
import com.assignment.MazeGame.intefaces.GameInterface;
import com.assignment.MazeGame.models.*;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.subjects.Subject;
import com.assignment.MazeGame.utils.InputOutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static com.assignment.MazeGame.models.enums.Direction.*;


public class MazeGame implements GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    private final StringBuilder userInput = new StringBuilder();

    private final HashMap<String, MazeWalkerPlayer> players = new HashMap<>();

    private MazeGameMap mazeGameMap = new MazeGameMap();


    @Override
    public void start() {
        try {
            printGreatingsToUser();

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

    private static void printGreatingsToUser() throws InterruptedException {
        System.out.println
                ("████████╗██╗  ██╗███████╗    ███╗   ███╗ █████╗ ███████╗███████╗\n" +
                "╚══██╔══╝██║  ██║██╔════╝    ████╗ ████║██╔══██╗╚══███╔╝██╔════╝\n" +
                "   ██║   ███████║█████╗█████╗██╔████╔██║███████║  ███╔╝ █████╗  \n" +
                "   ██║   ██╔══██║██╔══╝╚════╝██║╚██╔╝██║██╔══██║ ███╔╝  ██╔══╝  \n" +
                "   ██║   ██║  ██║███████╗    ██║ ╚═╝ ██║██║  ██║███████╗███████╗\n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝"
                );
        Thread.sleep(1000);
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Enter EXIT command in every stage to close the game.");
    }

    private String addNewPlayerToTheMaze() throws EndingGameExecption {
        String input = InputOutputUtils.userDialogWithInput(
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
        MazeWalkerPlayer player = players.get(playerNickName);
        while (true) {
             try {
                 Thread.sleep(1500);
                 System.out.println("Current location:");
                 printCurrentLocationAndSubjectsInRoom(player);
                 switch (scanner.nextLine()) {
                    case "EXIT":
                        throw new EndingGameExecption();
                    case "H":
                        System.out.println("press H for help, EXIT to exit, W to know where you are.");
                        break;
                    case "M":
                        movePlayer(player);
                        break;
                    case "E":
                        examineSubject(player);
                        break;
                    case "I":
                        showcaseInventory(player);
                        break;
                    case "U":
                        useAvailableSubject(player);
                        break;







                    default:
                        System.out.println("No valid input! Enter `H` for help");


                }
                //TODO if i have an object that can be used its need to be got from the inventory but its need to be started
                //TODO progrematocally via the examined objects
            } catch (NoSuchDirectionException | NoSuchSubjectException e) {
                 System.out.println(e.getMessage());
                 continue;
             } catch (EndingGameExecption e) {
                 this.closeGame();
             } catch (Exception e) {
                 System.out.println("Error: try again");
             }
        }

    }

    private void useAvailableSubject(MazeWalkerPlayer player) throws EndingGameExecption, NoSuchSubjectException {
        //We're allowing using only inventory subjects on other subjects
        System.out.println("With which subject from your inventory you wish to use?");
        showcaseInventory(player);

        //but we can use the inventory subject on all subjects. both inventory and inventory and room subjects
        Subject inventorySubject = getSubjectToUseOnFromInventory(player);
        ArrayList<Subject> inventoryAndRoomSubjectList = new ArrayList<>(player.getInventory());
        inventoryAndRoomSubjectList.addAll(player.getCurrentLocation().getRoomSubjects());
        //todo debug here!!!
        InputOutputUtils.printAvailableObjects(inventoryAndRoomSubjectList);
        String subjectToUseOn = InputOutputUtils.userDialogWithInput("on which subject to use it: ",
                inventoryAndRoomSubjectList,
                "Please insert valid subject",
                scanner);
        for (Subject subject : inventoryAndRoomSubjectList) {
            if (subject.toString().equals(subjectToUseOn))
                inventorySubject.useOn(subject);
        }





    }

    private void examineSubject(MazeWalkerPlayer player) throws NoSuchSubjectException, EndingGameExecption {
        System.out.println("choose the the subject in this room you want to examine:");
        player.getCurrentLocation().printAvailableSubjects();
        Subject subject = getSubjectInTheRoomToExamine(player.getCurrentLocation().getRoomSubjects());
        if (subject instanceof CanBeExaminedSubjectInteface subjectToExamine) {
            player.addSubjectToInventory(subjectToExamine.examine());
        } else {
            System.out.println(subject.getDescription());
        }
    }

    private void movePlayer(MazeWalkerPlayer player) throws EndingGameExecption, NoSuchDirectionException {
        System.out.println("in which of the following directions you want to move?");
        showPossibleDirections(player);
        Direction direction = getDirectionFromPlayer();
        player.move(direction);
    }

    private void printCurrentLocationAndSubjectsInRoom(MazeWalkerPlayer player) {
        Room currentLocation = player.getCurrentLocation();
        System.out.println(currentLocation);
        System.out.println("The objects in this room are: "+player.getCurrentLocation().getRoomSubjects());
    }

    private void showcaseInventory(MazeWalkerPlayer player) throws NoSuchSubjectException {
        if (player.getInventory().isEmpty()) {
            throw new NoSuchSubjectException("No items in your inventory.");
        } else {
            System.out.println("Your inventory:");
            InputOutputUtils.printAvailableObjects(player.getInventory());
        }
    }

    private Subject getSubjectInTheRoomToExamine(ArrayList<Subject> roomSubjects) throws EndingGameExecption, NoSuchSubjectException {
        String userInput =  InputOutputUtils.userDialogWithInput(
                "Which subject you wish to examine?",
                 roomSubjects,
                "no such subject in this room.",
                scanner
        );
        for (Subject subject : roomSubjects) {
            if (subject.getName().equals(userInput))
                return subject;
        }
        throw new NoSuchSubjectException("No such subject in this room!");
    }

    private Subject getSubjectToUseOnFromInventory(MazeWalkerPlayer player) throws EndingGameExecption, NoSuchSubjectException {
        // TODO maybe ask for which subject you want? inventory or room subject?
        ArrayList<Subject> inventory = player.getInventory();
        String userInput =  InputOutputUtils.userDialogWithInput(
                "Which subject from the inventory you wish to use on/with?",
                inventory,
                "no valid input.",
                scanner
        );
        for (Subject subject : inventory) {
            if (subject.getName().equals(userInput))
                return subject;
        }
        throw new NoSuchSubjectException("No such subject in your inventory!");
    }


    private void showPossibleSubjectsToExamine() {
    }

    private Direction getDirectionFromPlayer() throws EndingGameExecption, NoSuchDirectionException {
        String direction = InputOutputUtils.userDialogWithInput(
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
                throw new NoSuchDirectionException();
        }
    }

    private void showPossibleDirections(MazeWalkerPlayer player) {
        player.getCurrentLocation().getDoors().forEach(((direction, door) ->  System.out.println(direction)));
    }


}
