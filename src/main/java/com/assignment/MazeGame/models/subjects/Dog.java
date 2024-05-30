package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.BlockableSubject;
import com.assignment.MazeGame.models.enums.Direction;

public class Dog extends BlockableSubject {

    private boolean isHungry = true;

    public Dog(String description, Direction direction) {
        super("Dog", description,direction);
    }
//todo need to remove isHungry
    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
