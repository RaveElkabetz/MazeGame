package com.assignment.MazeGame;

import com.assignment.MazeGame.providers.ScannerUserInputProvider;
import com.assignment.MazeGame.models.maze.MazeGame;
import com.assignment.MazeGame.datastores.HashMapMazePlayerDataStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MazeGameApplication {



	public static void main(String[] args) {
		SpringApplication.run(MazeGameApplication.class, args);
		MazeGame mazeGame = new MazeGame(new ScannerUserInputProvider(),new HashMapMazePlayerDataStore());
		mazeGame.start();
	}

}
