package com.assignment.MazeGame.models;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.PlayerInterface;

import java.util.ArrayList;

public class MazeWalkerPlayer implements PlayerInterface {
    private String nickname;
    private Room currentLocation;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();

    public MazeWalkerPlayer(String nickname) {
        this.nickname = nickname;

        //this.currentRoom = new Room(startRoom)
    }



    @Override
    public void examineSubject(Subject subject) {

    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void openSubject(Subject subject) {

    }

    @Override
    public void whereIAm() {

    }
}
