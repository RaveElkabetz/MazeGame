package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.intefaces.ContainsInterface;

public class Bed extends Subject implements ContainsInterface {
    public Bed( String description) {
        super("Bed", description);
        this.contains = new Pin("Long ,thin and very strong pin.");
    }
    private Subject contains;

    @Override
    public void examine() {
        if (!this.contains.toString().equals("empty")) {
            System.out.println("This an old and stinky bed...wait! there is something under the bed!");
        } else {
            System.out.println("This an old and stinky bed...");
        }
    }

    @Override
    public Subject getContainedSubject() {
        Subject ret = this.contains;
        this.contains = new Subject("empty","empty");
        return ret;
    }
}
