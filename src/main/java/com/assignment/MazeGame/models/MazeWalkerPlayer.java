package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.PlayerInterface;
import com.assignment.MazeGame.intefaces.RoomInterface;

import java.util.ArrayList;

public class MazeWalkerPlayer implements PlayerInterface {
    private String nickname;
    private Room currentLocation;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();

    public MazeWalkerPlayer(String nickname, Room startRoom) {
        this.nickname = nickname;
        this.currentLocation = startRoom;
    }



    @Override
    public String examineSubject(Subject subject) {
        return "inventory";
    }

    @Override
    public String move(Direction direction) {
        return "mooving";
    }

    @Override
    public String openSubject(Subject subject) {
        return "opening...";
    }

    @Override
    public String whereIAm() {
        return this.currentLocation.getDescription();

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
        this.currentLocation = currentLocation;
    }

    public ArrayList<Subject> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Subject> inventory) {
        this.inventory = inventory;
    }
}
