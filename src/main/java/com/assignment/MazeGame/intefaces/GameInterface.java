package com.assignment.MazeGame.intefaces;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.models.MazeWalkerPlayer;

public interface GameInterface {
    public void start();
    public void saveGame();
    public void loadGame();
    public void closeGame();
    public void mainGameLoop(String playerNickName) throws EndingGameExecption;


}
