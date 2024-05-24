package com.assignment.MazeGame;

import com.assignment.MazeGame.services.MazeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MazeGameApplication {



	public static void main(String[] args) {
		SpringApplication.run(MazeGameApplication.class, args);
		MazeGame mazeGame = new MazeGame();
		mazeGame.start();
	}

}
