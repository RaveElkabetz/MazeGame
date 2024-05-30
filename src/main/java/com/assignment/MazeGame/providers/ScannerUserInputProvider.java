package com.assignment.MazeGame.providers;

import com.assignment.MazeGame.intefaces.providerInterfaces.UserInputProvider;
import jakarta.annotation.PreDestroy;

import java.util.Scanner;


public class ScannerUserInputProvider implements UserInputProvider {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getStringInput() {
        return scanner.nextLine();
    }

    @PreDestroy
    private void closeScanner() {
        scanner.close();
    }
}
