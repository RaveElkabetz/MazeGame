package com.assignment.MazeGame.Exceptions;

public class EndingGameExecption extends Exception {

    public EndingGameExecption() {
        super("Exiting the game...");
    }

    public EndingGameExecption(String message) {
        super(message);
        System.out.println(message);
    }
}
