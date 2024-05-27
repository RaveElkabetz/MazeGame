package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.OpenableInterface;
import com.assignment.MazeGame.intefaces.UseOnInteface;

public class Bars extends Subject implements UseOnInteface , OpenableInterface {
    private boolean open;

    public Bars(String description) {
        super("Bars", description);
    }

    @Override
    public String useOn(Subject subject) {
        if (subject.getName().equals("Pin")) {
            this.open();
            return  "The Bars are now open!";
        }
        return "This is not the right subject to use on the bars...";
    }

    @Override
    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }


}
