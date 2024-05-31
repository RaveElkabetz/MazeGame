package com.assignment.MazeGame.intefaces.UI.providerInterfaces;

import java.util.List;

public interface OutputProvider {
    public void stringOutputToUser(String output);

    public <T> void printAvailableObjects(List<T> objects);
}
