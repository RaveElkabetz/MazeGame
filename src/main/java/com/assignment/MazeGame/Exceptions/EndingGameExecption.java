package com.assignment.MazeGame.Exceptions;

public class EndingGameExecption extends Exception {
    private String message="Exiting the game...";

    @Override
    public String getMessage() {
        return message;
    }
}
