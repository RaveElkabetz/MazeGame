package com.assignment.MazeGame.models.NPC;

import com.assignment.MazeGame.models.enums.Direction;
import com.assignment.MazeGame.models.subjects.BlockableSubject;

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
