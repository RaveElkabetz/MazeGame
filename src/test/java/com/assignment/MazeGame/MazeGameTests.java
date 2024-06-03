package com.assignment.MazeGame;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.Exceptions.GoBackException;
import com.assignment.MazeGame.datastores.HashMapMazeRoomDataStore;
import com.assignment.MazeGame.intefaces.GameMap;
import com.assignment.MazeGame.intefaces.PlayerDataStore;
import com.assignment.MazeGame.intefaces.UI.UserDialog.UserDialogUtils;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.UserInputProvider;
import com.assignment.MazeGame.intefaces.datastoreInterfaces.MazeRoomDataStore;
import com.assignment.MazeGame.models.maze.MazeGame;
import com.assignment.MazeGame.models.maze.MazeGameMap;
import com.assignment.MazeGame.models.maze.MazePlayer;
import com.assignment.MazeGame.models.maze.MazeRoom;
import com.assignment.MazeGame.providers.ScannerUserInputProvider;
import com.assignment.MazeGame.utils.UserDialogSystemOutputUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest(classes= MazeGameApplication.class)
public class MazeGameTests {

    // Mock dependencies
    @Mock
    private UserInputProvider userInputProvider;

    private GameMap gameMap;
    @Mock
    private PlayerDataStore playerDataStore;

    private MazeGame mazeGame;
    @Mock
    UserDialogUtils userDialogUtils;
    @Mock
    OutputProvider outputProvider;


    MazeRoom mazeRoom;

    MazePlayer mazePlayer;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        // given
        gameMap = new MazeGameMap(new HashMapMazeRoomDataStore());
        gameMap.initMap();
        mazeGame = new MazeGame(userInputProvider,outputProvider,userDialogUtils,playerDataStore,gameMap);


    }

    @Test
    public void testAddNewPlayerToTheMaze() throws EndingGameExecption {
        String nickname = "test_nickname";
        // setting the mocks
        when(userDialogUtils.userDialogWithInput(anyString(), anyString(), anyString(),any())).thenReturn(nickname);
        when(userInputProvider.getStringInput()).thenReturn(nickname);

        // when we're calling addNewPlayerToTheMaze
        String result = mazeGame.addNewPlayerToTheMaze();

        // then it should returns the nickname the user has entered
        assertEquals(nickname, result);

    }





}

