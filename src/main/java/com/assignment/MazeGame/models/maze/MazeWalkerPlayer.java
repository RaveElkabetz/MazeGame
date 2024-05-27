package com.assignment.MazeGame.models.maze;

import com.assignment.MazeGame.intefaces.PlayerInterface;
import com.assignment.MazeGame.models.Direction;
import com.assignment.MazeGame.models.Room;
import com.assignment.MazeGame.models.subjects.Subject;

import java.util.ArrayList;

public class MazeWalkerPlayer implements PlayerInterface {
    private String nickname;
    private MazeRoom currentLocation;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();

    public MazeWalkerPlayer(String nickname, MazeRoom startRoom) {
        this.nickname = nickname;
        this.currentLocation = startRoom;
    }



    @Override
    public void examineSubject(Subject subject) {
        System.out.println("examining subject...");
    }

    @Override
    public void move(Direction direction) {
        if (currentLocation.getDoors().get(direction) != null) {
            if (currentLocation.getDoors().get(direction).isOpen()){
                currentLocation = (MazeRoom) currentLocation.getDoors().get(direction).getConnectedRoom();
                System.out.println("You have moved rooms! ");
            } else {
                System.out.println("This " + direction + " directed door is locked!");
            }
        } else { //in case the user chose door direction that doesnt exist in this room.
            System.out.println("There isnt any door for this direction, in this room!");
        }
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
