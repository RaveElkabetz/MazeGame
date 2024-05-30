package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.BlockableSubject;
import com.assignment.MazeGame.models.enums.Direction;

public class Bars extends BlockableSubject {

    public Bars(String description, Direction direction) {
        super("Bars", description, direction);
    }

/*    @Override
    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }*/

/*    public Direction getDirection() {
        return direction;
    }*/
}
