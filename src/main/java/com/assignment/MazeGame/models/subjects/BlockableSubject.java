package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.models.enums.Direction;

public class BlockableSubject extends Subject{
    private Direction whichDirectionIsBlocked;
    private boolean blocking = true;

    public BlockableSubject(String name, String description, Direction direction) {
        super(name, description);
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlockage(boolean blocking) {
        this.blocking = blocking;
    }

    public Direction getWhichDirectionIsBlocked() {
        return whichDirectionIsBlocked;
    }

    public void setWhichDirectionIsBlocked(Direction whichDirectionIsBlocked) {
        this.whichDirectionIsBlocked = whichDirectionIsBlocked;
    }
}
