package com.assignment.MazeGame;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.PlayerDataStore;
import com.assignment.MazeGame.models.maze.MazeGame;
import com.assignment.MazeGame.models.maze.MazeGameMap;
import com.assignment.MazeGame.models.maze.MazeRoom;
import com.assignment.MazeGame.providers.ScannerUserInputProvider;
import com.assignment.MazeGame.utils.UserDialogSystemOutputUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MazeGameTests {

    // Mock dependencies
    @Mock
    private ScannerUserInputProvider userInputProvider;
    @Mock
    private MazeGameMap mazeGameMap;
    @Mock
    private PlayerDataStore playerDataStore;
    @InjectMocks
    private MazeGame mazeGame;
    @Mock
    UserDialogSystemOutputUtils inputOutputUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        // Initialize the mocks
/*        userInputProvider = Mockito.mock(ScannerUserInputProvider.class);
        mazeGameMap = Mockito.mock(MazeGameMap.class);
        playerDataStore = Mockito.mock(PlayerDataStore.class);*/

        // Initialize the class under test
       // mazeGame = new MazeGame(userInputProvider,playerDataStore); // adjust constructor based on actual class
    }

    @Test
    void testAddNewPlayerToTheMaze() throws EndingGameExecption {
        String nickname = "test_nickname";
        MazeRoom mazeRoom = new MazeRoom("the starting room"); // replace with actual MazeRoom instantiation
        when(inputOutputUtils.userDialogWithInput(anyString(), anyString(), anyString(),userInputProvider)).thenReturn(nickname);
        when(userInputProvider.getStringInput()).thenReturn(nickname);
        when(mazeGameMap.getRoom(anyString())).thenReturn(mazeRoom);

        String result = mazeGame.addNewPlayerToTheMaze();

        assertEquals(nickname, result);

    }


 /*
        // Mock dependencies
        UserInputProvider mockUserInputProvider = mock(UserInputProvider.class);
        MazePlayerDataStore mockPlayerDataStore = mock(MazePlayerDataStore.class);
        MazeGame mazeGame = new MazeGame(mockUserInputProvider, mockPlayerDataStore);
        MazeRoom startingRoom = mock(new MazeRoom("A"));

        // Mock user input
        String playerName = "Yossi";
        when(mockUserInputProvider.getStringInput()).thenReturn(playerName);

        // Mock MazeGameMap behavior (optional)
        when((MazePlayer)mockPlayerDataStore.get(playerName).).thenReturn(startingRoom);*/


    }

