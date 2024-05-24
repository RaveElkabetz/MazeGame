package com.assignment.MazeGame.models;

import com.assignment.MazeGame.intefaces.PlayerInterface;

import java.util.ArrayList;

public class MazeWalkerPlayer implements PlayerInterface {
    private String nickname;
    private Room currentRoom;
    private ArrayList<Subject> inventory = new ArrayList<Subject>();

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
