package com.assignment.MazeGame.abstractClasses;

import com.assignment.MazeGame.models.enums.Direction;

public abstract class BlockableSubject extends Subject {
    private Direction whichDirectionIsBlocked;
    private boolean blocking = true;

    public BlockableSubject(String name, String description, Direction direction) {
        super(name, description);
        this.whichDirectionIsBlocked = direction;
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
