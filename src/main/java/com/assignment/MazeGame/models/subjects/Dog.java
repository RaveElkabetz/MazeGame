package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.BlockableSubject;
import com.assignment.MazeGame.models.enums.Direction;

public class Dog extends BlockableSubject {

    public Dog(String description, Direction direction) {
        super("Dog", description,direction);
    }

}
