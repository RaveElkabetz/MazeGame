package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.Exceptions.DoorUnPassableException;
import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.intefaces.Player;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.subjects.Bars;
import com.assignment.MazeGame.models.subjects.Dog;
import com.assignment.MazeGame.models.subjects.Guard;

import java.util.ArrayList;

import static com.assignment.MazeGame.utils.Constant.LAST_ROOM_DESCRIPTION;


public class MazePlayer implements Player {
    private String nickname;
    private MazeRoom currentLocation;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();
    private final OutputProvider outputProvider;

    public MazePlayer(String nickname, MazeRoom startRoom, OutputProvider outputProvider) {
        this.nickname = nickname;
        this.currentLocation = startRoom;
        this.outputProvider = outputProvider;
    }


    @Override
    public void examineSubject(Subject subject) {
        outputProvider.stringOutputToUser("examining subject...");
    }

    @Override
    public void move(Direction direction) throws DoorUnPassableException, EndingGameExecption {
        if (currentLocation.getDoors().get(direction) != null) {
            checkIfThereIsADogBlocking(direction);
            checkIfRoomHasBarsThatAreLocked(direction);

            //moving to next room by updating the current location after checking if the bars are open
            currentLocation = (MazeRoom) currentLocation.getDoors().get(direction).getConnectedRoom();
            checkIfRoomContainsAGuard();
            checkIfItsTheFinalRoom();
            outputProvider.stringOutputToUser("You have moved rooms! ");
        } else {//in case the user chose door direction that doesn't exist in this room.
            outputProvider.stringOutputToUser("There isn't any door in this direction!");
        }
    }

    private void checkIfItsTheFinalRoom() throws EndingGameExecption {
        if (currentLocation.getDescription().equals(LAST_ROOM_DESCRIPTION)) {
            outputProvider.stringOutputToUser(LAST_ROOM_DESCRIPTION);
            throw new EndingGameExecption();

        }
    }

    private void checkIfRoomContainsAGuard() throws EndingGameExecption {
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Guard) {
                throw new EndingGameExecption(subject.getDescription());
            }
        }
    }

    private void checkIfThereIsADogBlocking(Direction direction) throws DoorUnPassableException {
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Dog) {
                if (((Dog) subject).isBlocking() && ((Dog) subject).getWhichDirectionIsBlocked() == direction)
                    throw new DoorUnPassableException("The dog is hungry and angry and wont move from this door!");
            }
        }
    }

    private void checkIfRoomHasBarsThatAreLocked(Direction direction) throws DoorUnPassableException {
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Bars) {
                if (((Bars) subject).isBlocking() && ((Bars) subject).getWhichDirectionIsBlocked() == direction)

                    throw new DoorUnPassableException("These Bars are locked, and it blocking the way!");
            }
        }
    }



    @Override
    public void addSubjectToInventory(Subject subject) {
        this.inventory.add(subject);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Room getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Room currentLocation) {
        this.currentLocation = (MazeRoom) currentLocation;
    }

    public ArrayList<Subject> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Subject> inventory) {
        this.inventory = inventory;
    }
}
