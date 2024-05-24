package com.assignment.MazeGame.services;

import com.assignment.MazeGame.intefaces.GameInterface;
import com.assignment.MazeGame.models.MazeWalkerPlayer;
import com.assignment.MazeGame.utils.InputValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Scanner;


public class MazeGame implements GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    private StringBuilder userInput = new StringBuilder();

    private HashMap<String, MazeWalkerPlayer> players = new HashMap<>();

    @Autowired
    private InputValidation inputValidation;


    @Override
    public void start() {
        boolean gameOn = true;
        getInputFromUserAndCreatePlayer();

        while (gameOn) {




            gameOn = false;
        }

        closeGame();
    }

    public void getInputFromUserAndCreatePlayer() {
        System.out.println("Welcome to the Maze Game! Please enter your nick name:");
        userInput.append(scanner.nextLine());

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }


    public void closeGame() {
        scanner.close();
    }
}
