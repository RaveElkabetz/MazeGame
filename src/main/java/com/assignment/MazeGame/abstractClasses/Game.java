package com.assignment.MazeGame.abstractClasses;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.GameMap;
import com.assignment.MazeGame.intefaces.PlayerDataStore;
import com.assignment.MazeGame.intefaces.UI.UserDialog.UserDialogUtils;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.UserInputProvider;

public abstract class Game {

    protected final UserInputProvider userInputProvider;

    protected PlayerDataStore playerDataStore;

    protected final OutputProvider outputProvider;

    protected final UserDialogUtils userDialogUtils;

    protected GameMap gameMap;

    public Game(UserInputProvider userInputProvider, OutputProvider outputProvider, UserDialogUtils userDialogUtils, PlayerDataStore playerDataStore, GameMap gameMap) {
        this.userInputProvider = userInputProvider;
        this.outputProvider = outputProvider;
        this.userDialogUtils = userDialogUtils;
        this.playerDataStore = playerDataStore;
        this.gameMap = gameMap;
    }

    public abstract void start();

    public void saveGame() {}

    public void loadGame() {}

    public void closeGame() {
        // closing game logic
        outputProvider.stringOutputToUser("Exiting the game, see you next time!");

    }
    public abstract void mainGameLoop(String playerNickName) throws EndingGameExecption;


}
