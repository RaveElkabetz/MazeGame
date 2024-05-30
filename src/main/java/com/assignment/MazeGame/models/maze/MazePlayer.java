package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.Exceptions.DoorUnPassableException;
import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.Player;
import com.assignment.MazeGame.models.subjects.Dog;
import com.assignment.MazeGame.models.subjects.Guard;
import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.abstractClasses.Room;
import com.assignment.MazeGame.models.subjects.Bars;
import com.assignment.MazeGame.abstractClasses.Subject;

import java.util.ArrayList;
import java.util.Optional;


public class MazePlayer implements Player {
    private String nickname;
    private MazeRoom currentLocation;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();

    public MazePlayer(String nickname, MazeRoom startRoom) {
        this.nickname = nickname;
        this.currentLocation = startRoom;
    }



    @Override
    public void examineSubject(Subject subject) {
        System.out.println("examining subject...");
    }

    @Override
    public void move(Direction direction) throws DoorUnPassableException, EndingGameExecption {
        if (currentLocation.getDoors().get(direction) != null) {
            checkIfThereIsADogBlocking(direction);
            checkIfRoomHasBarsThatAreLocked(direction);

            //moving to next room by updating the current location after checking if the bars are open
            currentLocation = (MazeRoom) currentLocation.getDoors().get(direction).getConnectedRoom();
            checkIfRoomContainsAGuard();
            System.out.println("You have moved rooms! ");
        } else {//in case the user chose door direction that doesn't exist in this room.
            System.out.println("There isn't any door in this direction!");
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
                if (((Dog) subject).isHungry() && ((Dog) subject).getWhichDirectionIsBlocked() == direction)
                    throw new DoorUnPassableException("The dog is hungry and angry and wont move!");
            }
        }
    }

    private void checkIfRoomHasBarsThatAreLocked(Direction direction) throws DoorUnPassableException {
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Bars) {
                if (((Bars) subject).isBlocking() && ((Bars) subject).getWhichDirectionIsBlocked() == direction)
                    throw new DoorUnPassableException("These Bars are locked, and it blocking the pass way!");
            }
        }
    }

    private Optional<Bars> checkIfRoomHasBars(Direction direction) {
       Optional<Bars> bars = Optional.empty();
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Bars) {
                if (/*((Bars) subject).isOpen() &&*/ ((Bars) subject).getWhichDirectionIsBlocked() == direction)
                    bars = Optional.of((Bars) subject);
            }
        }
        return bars;
    }

    private boolean checkIfBarsAreOpen(Direction direction) {
        for (Subject subject : currentLocation.getRoomSubjects()) {
            if (subject instanceof Bars) {
                //((Bars) subject).
                if (!((Bars) subject).isBlocking() && ((Bars) subject).getWhichDirectionIsBlocked() == direction)
                    return true;
            }
        }
        return false;
    }

    @Override
    public void openSubject(Subject subject) {
        System.out.println("opened a subject");
    }

    @Override
    public String whereIAm() {
        return this.currentLocation.getDescription();

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
