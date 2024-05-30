package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;

public interface Game {
    public void start();
    public void saveGame();
    public void loadGame();
    public void closeGame();
    public void mainGameLoop(String playerNickName) throws EndingGameExecption;


}
