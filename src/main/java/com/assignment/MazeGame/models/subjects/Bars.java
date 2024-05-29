package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.OpenableInterface;
import com.assignment.MazeGame.models.Door;

public class Bars extends Subject implements OpenableInterface {
    private boolean open;
    private Door onWhichDoorInstalled;

    public Bars(String description) {
        super("Bars", description, true);
    }

    @Override
    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Door getOnWhichDoorInstalled() {
        return onWhichDoorInstalled;
    }

    public void setOnWhichDoorInstalled(Door onWhichDoorInstalled) {
        this.onWhichDoorInstalled = onWhichDoorInstalled;
    }
}
