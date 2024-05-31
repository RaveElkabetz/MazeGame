package com.assignment.MazeGame.providers;

import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;

import java.util.List;

public class SystemOutputProvider implements OutputProvider {

    @Override
    public void stringOutputToUser(String output) {
        System.out.println(output);
    }

    @Override
    public <T> void printAvailableObjects(List<T> objects) {
        objects.forEach(Object-> System.out.println(Object.toString()));
    }
}
