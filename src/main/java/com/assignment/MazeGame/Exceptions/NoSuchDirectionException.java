package com.assignment.MazeGame.Exceptions;

public class NoSuchDirectionException extends Exception {

    public NoSuchDirectionException() {
        super("Unknown direction");
    }
}
