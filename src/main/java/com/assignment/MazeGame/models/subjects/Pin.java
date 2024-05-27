package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.CanBeTakenInterface;
import com.assignment.MazeGame.intefaces.UseWithInterface;

public class Pin extends Subject implements CanBeTakenInterface {
    public Pin( String description) {
        super("Pin", description);
    }


    private boolean isTaken = false;
    @Override
    public boolean isTaken() {
        return isTaken;
    }
}
