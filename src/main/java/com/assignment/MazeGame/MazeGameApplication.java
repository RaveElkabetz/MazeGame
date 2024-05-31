package com.assignment.MazeGame;

import com.assignment.MazeGame.providers.ScannerUserInputProvider;
import com.assignment.MazeGame.models.maze.MazeGame;
import com.assignment.MazeGame.datastores.HashMapMazePlayerDataStore;
import com.assignment.MazeGame.providers.SystemOutputProvider;
import com.assignment.MazeGame.utils.UserDialogSystemOutputUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MazeGameApplication {



	public static void main(String[] args) {
		SpringApplication.run(MazeGameApplication.class, args);
		MazeGame mazeGame = new MazeGame(new ScannerUserInputProvider(),new SystemOutputProvider(),new UserDialogSystemOutputUtils(),new HashMapMazePlayerDataStore() );
		mazeGame.start();
	}

}
