package com.assignment.MazeGame.models.NPC;

import com.assignment.MazeGame.models.subjects.BlockableSubject;

public class Dog extends BlockableSubject {

    private boolean isHungry = true;

    public Dog(String description) {
        super("Dog", description);
    }
//todo need to remove isHungry
    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
