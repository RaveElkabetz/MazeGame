package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.Exceptions.DoorUnPassableException;
import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.Exceptions.NoSuchDirectionException;
import com.assignment.MazeGame.Exceptions.NoSuchSubjectException;
import com.assignment.MazeGame.intefaces.*;
import com.assignment.MazeGame.datastores.HashMapMazeRoomDataStore;
import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.intefaces.UI.UserDialog.UserDialogUtils;
import com.assignment.MazeGame.intefaces.behaviorInterfaces.CanBeExaminedSubject;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.UserInputProvider;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.abstractClasses.Subject;

import java.util.ArrayList;
import java.util.Arrays;

import static com.assignment.MazeGame.models.enums.Direction.*;


public class MazeGame implements Game {


    private final UserInputProvider userInputProvider;

    private PlayerDataStore playerDataStore;

    private final OutputProvider outputProvider;

    private final UserDialogUtils userDialogUtils;

    private GameMap gameMap;


    public MazeGame(UserInputProvider userInputProvider, OutputProvider outputProvider, UserDialogUtils userDialogUtils, PlayerDataStore playerDataStore, GameMap gameMap) {
        this.userInputProvider = userInputProvider;
        this.outputProvider = outputProvider;
        this.playerDataStore = playerDataStore;
        this.userDialogUtils = userDialogUtils;
        this.gameMap = gameMap;
    }


    @Override
    public void start() {
        try {
            printGreatingsToUser();

            boolean gameOn = true;
            //gameMap = new MazeGameMap(new HashMapMazeRoomDataStore());
            gameMap.initMap();
            String playerName = addNewPlayerToTheMaze();
            outputProvider.stringOutputToUser(playerName + ", are now entered the mysterious maze, use your objects around you wisely to finish the maze.... ");
            mainGameLoop(playerName);

        } catch (EndingGameExecption e) {
            closeGame();
        }catch (Exception e) {
            outputProvider.stringOutputToUser("An Error occured, exiting the game. please restart.");
            closeGame();
        }
        closeGame();
    }

    private void printGreatingsToUser() throws InterruptedException {
        outputProvider.stringOutputToUser
                ("████████╗██╗  ██╗███████╗    ███╗   ███╗ █████╗ ███████╗███████╗\n" +
                "╚══██╔══╝██║  ██║██╔════╝    ████╗ ████║██╔══██╗╚══███╔╝██╔════╝\n" +
                "   ██║   ███████║█████╗█████╗██╔████╔██║███████║  ███╔╝ █████╗  \n" +
                "   ██║   ██╔══██║██╔══╝╚════╝██║╚██╔╝██║██╔══██║ ███╔╝  ██╔══╝  \n" +
                "   ██║   ██║  ██║███████╗    ██║ ╚═╝ ██║██║  ██║███████╗███████╗\n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝"
                );
        Thread.sleep(1000);
        outputProvider.stringOutputToUser("Welcome to the Maze Game!");
        outputProvider.stringOutputToUser("Enter EXIT command in every stage to close the game.");
    }

    public String addNewPlayerToTheMaze() throws EndingGameExecption {
        String input = userDialogUtils.userDialogWithInput(
                "please enter your nick name:",
                "your nick name is: ",
                "Please enter non empty string",
                userInputProvider);

        this.playerDataStore.put(input, new MazePlayer(input, (MazeRoom) gameMap.getRoom("A"),outputProvider));
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
        outputProvider.stringOutputToUser("Exiting the game, see you next time!");
    }

    @Override
    public void mainGameLoop(String playerNickName) throws EndingGameExecption {
        outputProvider.stringOutputToUser("At any step, press H for help, EXIT to exit, W to know where you are. M to move, U to use subject, E for examine");
        MazePlayer player = (MazePlayer) playerDataStore.get(playerNickName);
        while (true) {
             try {
                 Thread.sleep(1500);
                 outputProvider.stringOutputToUser("Current location:");
                 printCurrentLocationAndSubjectsInRoom(player);
                 switch (userInputProvider.getStringInput()) {
                    case "EXIT":
                        throw new EndingGameExecption();
                    case "H":
                        outputProvider.stringOutputToUser("press H for help, EXIT to exit, W to know where you are.");
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
                        outputProvider.stringOutputToUser("No valid input! Enter `H` for help");


                }
            } catch (DoorUnPassableException | NoSuchDirectionException | NoSuchSubjectException e) {
                 outputProvider.stringOutputToUser(e.getMessage());
             } catch (EndingGameExecption e) {
                 this.closeGame();
                 return;
             } catch (Exception e) {
                 outputProvider.stringOutputToUser("Error: try again");
             }
        }

    }

    private void useAvailableSubject(MazePlayer player) throws EndingGameExecption, NoSuchSubjectException {

        //We're allowing using only inventory subjects on other subjects
        //but we can use the inventory subject on all subjects. both inventory and inventory and room subjects
        outputProvider.stringOutputToUser("With which subject from your inventory you wish to use?");
        showcaseInventory(player);
        Subject inventorySubject = getSubjectToUseWithFromInventory(player);

        //creating new list of subjects that is combined with inventory and room subjects
        ArrayList<Subject> inventoryAndRoomSubjectList = new ArrayList<>(player.getInventory());
        inventoryAndRoomSubjectList.addAll(player.getCurrentLocation().getRoomSubjects());

        // use the inventory subject on other subject
        outputProvider.stringOutputToUser("On which subject to use it?:");
        outputProvider.printAvailableObjects(inventoryAndRoomSubjectList);
        getSubjectAndUseOn(inventoryAndRoomSubjectList, inventorySubject);


    }

    private void getSubjectAndUseOn(ArrayList<Subject> inventoryAndRoomSubjectList, Subject inventorySubject) throws EndingGameExecption {
        String subjectToUseOn = userDialogUtils.userDialogWithInput(
                inventoryAndRoomSubjectList,
                "Please insert valid subject",
                userInputProvider);
        //InputOutputUtils.printAvailableObjects(inventoryAndRoomSubjectList);

        for (Subject subject : inventoryAndRoomSubjectList) {
            if (subject.toString().equalsIgnoreCase(subjectToUseOn))
                inventorySubject.useOn(subject);
        }
    }

    private void examineSubject(MazePlayer player) throws NoSuchSubjectException, EndingGameExecption {
        outputProvider.stringOutputToUser("choose the the subject in this room you want to examine:");
        player.getCurrentLocation().printAvailableSubjects();
        Subject subject = getSubjectInTheRoomToExamine(player.getCurrentLocation().getRoomSubjects());
        if (subject instanceof CanBeExaminedSubject subjectToExamine) {
            player.addSubjectToInventory(subjectToExamine.examine());
        } else {
            outputProvider.stringOutputToUser(subject.getDescription());
        }
    }

    private void movePlayer(MazePlayer player) throws EndingGameExecption, NoSuchDirectionException, DoorUnPassableException {
        outputProvider.stringOutputToUser("in which of the following directions you want to move?");
        showPossibleDirections(player);
        Direction direction = getDirectionFromPlayer();
        player.move(direction);
    }

    private void printCurrentLocationAndSubjectsInRoom(MazePlayer player) {
        Room currentLocation = player.getCurrentLocation();
        outputProvider.stringOutputToUser(currentLocation.getDescription());
        if (!currentLocation.getRoomSubjects().isEmpty()) {
            outputProvider.stringOutputToUser("The objects in this room are: " );
            outputProvider.printAvailableObjects(player.getCurrentLocation().getRoomSubjects());
        }

    }

    private void showcaseInventory(MazePlayer player) throws NoSuchSubjectException {
        if (player.getInventory().isEmpty()) {
            throw new NoSuchSubjectException("No items in your inventory.");
        } else {
            outputProvider.stringOutputToUser("Your inventory:");
            outputProvider.printAvailableObjects(player.getInventory());
        }
    }

    private Subject getSubjectInTheRoomToExamine(ArrayList<Subject> roomSubjects) throws EndingGameExecption, NoSuchSubjectException {
        String userInput =  userDialogUtils.userDialogWithInput(
                "Which subject you wish to examine?",
                 roomSubjects,
                "no such subject in this room.",
                userInputProvider
        );
        for (Subject subject : roomSubjects) {
            if (subject.getName().equalsIgnoreCase(userInput))
                return subject;
        }
        throw new NoSuchSubjectException("No such subject in this room!");
    }

    private Subject getSubjectToUseWithFromInventory(MazePlayer player) throws EndingGameExecption, NoSuchSubjectException {
        ArrayList<Subject> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            throw new NoSuchSubjectException("Your inventory is empty!");
        }
        String userInput =  userDialogUtils.userDialogWithInput(
                inventory,
                "no valid input.",
                userInputProvider
        );
        for (Subject subject : inventory) {
            if (subject.getName().equalsIgnoreCase(userInput))
                return subject;
        }
        throw new NoSuchSubjectException("No such subject in your inventory!");
    }

    private Direction getDirectionFromPlayer() throws EndingGameExecption, NoSuchDirectionException {
        String direction = userDialogUtils.userDialogWithInput(
                "",
                new ArrayList<String>(Arrays.asList("NORTH","EAST","SOUTH","WEST")),
                "Please enter a valid direction: NORTH, EAST, SOUTH, WEST",
                userInputProvider);
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

    private void showPossibleDirections(MazePlayer player) {
        player.getCurrentLocation().getDoors().forEach(((direction, door) ->  outputProvider.stringOutputToUser(direction.toString())));
    }


}
