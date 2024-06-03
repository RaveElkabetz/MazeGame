package com.assignment.MazeGame.Exceptions;

public class NoSuchDirectionException extends Exception {

    public NoSuchDirectionException() {
        super("Unknown direction. make sure to use CAPITAL letters. e.g. `WEST`");
    }
}
