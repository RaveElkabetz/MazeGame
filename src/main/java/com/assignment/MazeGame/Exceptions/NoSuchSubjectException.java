package com.assignment.MazeGame.Exceptions;

public class NoSuchSubjectException extends Exception{
    private String message = "No such subject!";


    public NoSuchSubjectException() {

    }

    public NoSuchSubjectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
